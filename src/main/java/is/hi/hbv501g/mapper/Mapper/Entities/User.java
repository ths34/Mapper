package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String firstName;
    private String lastName;
    private  String userName;
    private  String passWord;
    private  Date regDate;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> likes;
    public User() {

    }

    public User(String FirstName, String LastName, String UserName, String PassWord) {
        firstName = FirstName;
        lastName = LastName;
        userName = UserName;
        passWord = PassWord;

    }
    @PrePersist
    private void cDate(){
        this.regDate = new Date();
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        firstName = FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        lastName = LastName;
    }

    public long getId() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String UserName) {
        userName = UserName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String PassWord) {
        passWord = PassWord;
    }
}
