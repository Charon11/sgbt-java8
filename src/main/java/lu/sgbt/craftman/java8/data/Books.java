package lu.sgbt.craftman.java8.data;

import lombok.extern.log4j.Log4j;
import lu.sgbt.craftman.java8.domain.Author;
import lu.sgbt.craftman.java8.domain.Book;
import lu.sgbt.craftman.java8.utils.RestProcess;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Log4j
@Component
public class Books extends RestProcess {

    @Value("${books.url}")
    private String url;

    @Value("${books.isbn}") String isbn;

    public List<Book> loadBooks() {
        List<Book> result = new ArrayList<>();
        for (String i : isbn.split(",")) {
            {

                try {
                    Map book = restTemplate.getForObject(this.url.replace("[ISBN]", i), Map.class);
                    book.entrySet().stream().forEach((Object b) -> {
                        Map bookInfo = (Map) ((Entry)b).getValue();
                        Author author = new Author();
                        author.setName(((List<Map>) bookInfo.get("authors")).get(0).get("name").toString());
                        result.add(new Book((String) bookInfo.get("title"),
                                (String) ((Entry)b).getKey(),author, new Date()));
                    });
                } catch (Exception e) {
                    log.error(e);
                }
            }

        }
        return result;
    }
}
