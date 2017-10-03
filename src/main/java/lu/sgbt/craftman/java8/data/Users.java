package lu.sgbt.craftman.java8.data;


import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import lu.sgbt.craftman.java8.domain.User;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Log4j
@Component
public class Users {
    public List<User> loadUsers() throws IOException {
        String fileName = "users.json";
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        //File is found
        System.out.println("File Found : " + file.exists());

        //Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        User[] users = new Gson().fromJson(content,User[].class);
        return Arrays.asList(users);
    }
}
