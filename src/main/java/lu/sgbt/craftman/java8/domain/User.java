package lu.sgbt.craftman.java8.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by renaudchardin on 18/01/2017.
 */
@Data
public class User {

    private String lastname;
    private String firstname;
    private Date birthday;

}
