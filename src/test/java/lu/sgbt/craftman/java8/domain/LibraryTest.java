package lu.sgbt.craftman.java8.domain;

import lu.sgbt.craftman.java8.data.Authors;
import lu.sgbt.craftman.java8.data.Books;
import lu.sgbt.craftman.java8.data.Users;
import org.assertj.core.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class LibraryTest {

    private List<Book> myBooks;
    private List<Author> authorList;
    private List<User> userList;
    private Library library;

    @Autowired
    private Books books;

    @Autowired
    private Authors authors;

    @Autowired
    private Users users;

    @Before
    public void setUp() throws Exception {
        this.myBooks = this.books.loadBooksJson();
        this.authorList = this.authors.loadAuthors();
        this.userList = this.users.loadUsers();
        this.library = new Library("SGBT Library", myBooks);

    }

    @Test
    public void getFromAuthorOld() throws Exception {
        List<Book> books = this.library.getFromAuthorOld(this.authorList.get(0));
        assertTrue(books.size() == 7);
    }

    @Test
    public void getFromAuthorLambda() throws Exception {
        List<Book> books = this.library.getFromAuthorLambda(this.authorList.get(0));
        assertTrue(books.size() == 7);
    }

    @Test
    public void getBookOnBirthdayOld() throws Exception {
        List<Book> books = this.library.getBookOnBirthdayOld(this.userList);
        assertTrue(books.size() == 5);
    }

    @Test
    public void getBookOnBirthdayLambda() throws Exception {
        List<Book> books = this.library.getBookOnBirthdayLambda(this.userList);
        assertTrue(books.size() == 5);
    }


    @Test
    public void groupByAuthorOld() throws Exception {
        Map group = this.library.groupByAuthorOld();
        assertTrue(!group.isEmpty());
        assertTrue(group.size() == 6);
    }

    @Test
    public void groupByAuthorLambda() throws Exception {
        Map group = this.library.groupByAuthorLambda();
        assertTrue(!group.isEmpty());
        assertTrue(group.size() == 6);
    }

    @Test
    public void groupTitleByAuthorLambda() throws Exception {
        Map group = this.library.groupTitleByAuthorLambda();
        assertTrue(!group.isEmpty());
        assertTrue(group.size() == 6);
    }

    @Test
    public void getListOfTitleOld() throws Exception {
        String title = this.library.getListOfTitleOld(this.authorList.get(0));
        System.out.println("getListOfTitleOld");
        System.out.println(title);
        assertTrue(!Strings.isNullOrEmpty(title));
    }

    @Test
    public void getListOfTitleOld2() throws Exception {
        String title = this.library.getListOfTitleOld2(this.authorList.get(0));
        System.out.println("getListOfTitleOld2");
        System.out.println(title);
        assertTrue(!Strings.isNullOrEmpty(title));
    }

    @Test
    public void getListOfTitleLambda() throws Exception {
        String title = this.library.getListOfTitleLambda(this.authorList.get(0));
        System.out.println("getListOfTitleLambda");
        System.out.println(title);
        assertTrue(!Strings.isNullOrEmpty(title));
    }

    @Test
    public void getListOfTitleLambda2() throws Exception {
        String title = this.library.getListOfTitleLambda2(this.authorList.get(0));
        System.out.println("getListOfTitleLambda2");
        System.out.println(title);
        assertTrue(!Strings.isNullOrEmpty(title));
    }

    @Test
    public void getListOfTitleLambda3() throws Exception {
        String title = this.library.getListOfTitleLambda3(this.authorList.get(0));
        System.out.println("getListOfTitleLambda3");
        System.out.println(title);
        assertTrue(!Strings.isNullOrEmpty(title));
    }

}