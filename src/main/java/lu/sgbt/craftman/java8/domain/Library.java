package lu.sgbt.craftman.java8.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by renaudchardin on 06/11/2015.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {

    private String name;
    private List<Book> books;

    public List<Book> getFromAuthorOld(Author author) {

        List<Book> result = new ArrayList<>();
        for (Book b : books)
            if (b.getAuthor().equals(author)) {
                result.add(b);
            }
        return result;
    }

    public List<Book> getFromAuthorLambda(Author author) {
        return books.stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
    }

    public List<Book> getBookOnBirthdayOld(List<User> users) {
        List<Book> result = new ArrayList<>();
        for (User user : users)
            for (Book book : books)
                if (book.getPublicationDate().equals(user.getBirthday()))
                    result.add(book);

        return result;
    }

    public List<Book> getBookOnBirthdayLambda1(List<User> users) {
        return books.stream().filter(book -> users.stream().map(user -> user.getBirthday()).collect(Collectors.toList())
                .contains(book.getPublicationDate())).collect(Collectors.toList());
    }

    public List<Book> getBookOnBirthdayLambda2(List<User> users) {
        return users.stream().flatMap(user -> books.stream().filter(book -> book.getPublicationDate().equals(user.getBirthday()))).collect(Collectors.toList());
    }

    public List<BirthdayBook> getMyBirthdayBooks(User user) {
        List<BirthdayBook> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublicationDate().equals(user.getBirthday())) {
                result.add(new BirthdayBook(
                        user.getLastname(),
                        user.getFirstname(),
                        book.getTitle(),
                        book.getAuthor()));
            }
        }
        return result;
    }

    public List<BirthdayBook> getMyBirthdayBooksLambda(User user) {
        return books.stream().filter(b -> b.getPublicationDate().equals(user.getBirthday()))
                .map(book -> new BirthdayBook(
                        user.getLastname(),
                        user.getFirstname(),
                        book.getTitle(),
                        book.getAuthor())).collect(Collectors.toList());
    }

    public Map<Author, List<Book>> groupByAuthorOld(List<Book> books) {
        Map<Author, List<Book>> authorBooks = new HashMap<>();
        for (Book book : books) {
            if (authorBooks.containsKey(book.getAuthor()))
                authorBooks.get(book.getAuthor()).add(book);
            else
                authorBooks.put(book.getAuthor(), Arrays.asList(book));
        }
        return authorBooks;
    }

    public Map<Author, List<Book>> groupByAuthorLambda(List<Book> books) {
        return books.stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    public Map<Author, List<String>> groupTitleByAuthorLambda(List<Book> books) {
        return books.stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.mapping(Book::getTitle, Collectors.toList())));
    }

    public String getListOfTitleOld(Author author) {
        String result = "";
        for (Book book : this.getFromAuthorOld(author)) {
            result += book.getTitle();
        }
        return result.substring(0, result.lastIndexOf(",") - 1);
    }

    public String getListOfTitleOld2(Author author) {
        List<String> result = new ArrayList<>();
        for (Book book : this.getFromAuthorOld(author)) {
            result.add(book.getTitle());
        }
        return String.join(",", result);
    }

    public String getListOfTitleLambda(Author author) {
        return String.join(",", this.getFromAuthorLambda(author).stream().map(Book::getTitle).collect(Collectors.toList()));
    }

    public String getListOfTitleLambda2(Author author) {
        return this.getFromAuthorLambda(author).stream().reduce("", (s, book) -> s += book.getTitle(), (s, s2) -> s + "," + s2);
    }

    public String getListOfTitleLambda3(Author author) {
        return this.getFromAuthorLambda(author).stream().map(book -> book.getTitle()).reduce((s, s2) -> s + "," + s2).orElse("");
    }


}
