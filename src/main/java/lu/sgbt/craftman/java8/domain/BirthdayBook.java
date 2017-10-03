package lu.sgbt.craftman.java8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by renaudchardin on 23/01/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirthdayBook {

    private String lastname;
    private String firstname;
    private String title;
    private Author author;

}
