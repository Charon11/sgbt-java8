package lu.sgbt.craftman.java8.domain;

import lu.sgbt.craftman.java8.data.Authors;
import lu.sgbt.craftman.java8.data.Books;
import lu.sgbt.craftman.java8.data.Users;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
        if (this.myBooks == null || this.myBooks.size() == 0)
            this.myBooks = this.books.loadBooks();
        if (this.authorList == null || this.authorList.size() == 0)
            this.authorList = this.authors.loadAuthors();
        if (this.userList == null || this.userList.size() == 0)
            this.userList = this.users.loadUsers();
        if (library == null)
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
    }

    @Test
    public void getBookOnBirthdayLambda1() throws Exception {
    }

    @Test
    public void getBookOnBirthdayLambda2() throws Exception {
    }

    @Test
    public void groupByAuthorOld() throws Exception {
        Map group = this.library.groupByAuthorOld(this.myBooks);
        assertTrue(!group.isEmpty());
    }

    @Test
    public void groupByAuthorLambda() throws Exception {
        Map group = this.library.groupByAuthorLambda(this.myBooks);
        assertTrue(!group.isEmpty());
    }

    @Test
    public void groupTitleByAuthorLambda() throws Exception {
    }

    @Test
    public void getListOfTitleOld() throws Exception {
    }

    @Test
    public void getListOfTitleOld2() throws Exception {
    }

    @Test
    public void getListOfTitleLambda() throws Exception {
    }

    @Test
    public void getListOfTitleLambda2() throws Exception {
    }

    @Test
    public void getListOfTitleLambda3() throws Exception {
    }

}