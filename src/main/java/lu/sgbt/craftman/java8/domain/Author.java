package lu.sgbt.craftman.java8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by renaudchardin on 06/11/2015.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String reference;
    private String name;

}
