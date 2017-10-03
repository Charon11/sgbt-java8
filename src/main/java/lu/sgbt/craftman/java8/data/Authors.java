package lu.sgbt.craftman.java8.data;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import lu.sgbt.craftman.java8.domain.Author;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Log4j
@Component
public class Authors {

    public List<Author> loadAuthors() throws IOException {
        String fileName = "authors.json";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

//File is found
        System.out.println("File Found : " + file.exists());

//Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        Author[] authors = new Gson().fromJson(content,Author[].class);
        return Arrays.asList(authors);
    }
}
