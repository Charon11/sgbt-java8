package lu.sgbt.craftman.java8;

import lu.sgbt.craftman.java8.data.Authors;
import lu.sgbt.craftman.java8.data.Books;
import lu.sgbt.craftman.java8.domain.Author;
import lu.sgbt.craftman.java8.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Java8ApplicationTests {

    @Autowired
    private Books books;

    @Autowired
    private Authors authors;

	@Test
	public void contextLoads() {
	}

	@Test
    public void loadBooks(){
        List<Book> myBooks = this.books.loadBooks();
    }

    @Test
    public void loadAuthors() throws IOException {
        List<Author> authorList = this.authors.loadAuthors();
    }

}
