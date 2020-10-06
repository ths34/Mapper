package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String FirstName;
    private String LastName;
    private String UserName;

    public User() {

    }

    public String getFirstName() {
        return FirstName;
    }

    public User(String firstName, String lastName, String userName) {
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
