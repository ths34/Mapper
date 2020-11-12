package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String FirstName;
    private String LastName;
    private String UserName;
    private String PassWord;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> likes;
    public User() {

    }

    public User(String firstName, String lastName, String userName, String passWord) {
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        PassWord = passWord;

    }
    public String getFirstName() {
        return FirstName;
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

    public long getId() {
        return ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
