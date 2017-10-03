package lu.sgbt.craftman.java8.data;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import lu.sgbt.craftman.java8.domain.Book;
import lu.sgbt.craftman.java8.utils.RestProcess;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Log4j
@Component
public class Books extends RestProcess {


    public List<Book> loadBooksJson() throws IOException {
        String fileName = "books.json";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());


        //Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        Book[] books = new Gson().fromJson(content, Book[].class);
        return Arrays.asList(books);
    }

}
