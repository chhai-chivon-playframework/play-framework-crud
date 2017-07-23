package entities;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by limit on 7/23/2017.
 */
@Entity
public class User extends Model {

    @Id
    public Long id;

    public String email;

    public String password;

    public static Finder<Long, User> finder = new Finder<Long, User>(User.class);
}
