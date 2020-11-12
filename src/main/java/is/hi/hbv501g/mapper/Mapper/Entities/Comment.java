package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;

    @ManyToOne
    @JoinColumn(name="imageID")
    private Image image;

    public Comment(String Text) {
        this.text = Text;
        this.createdOn = new Date();
    }

    public Comment() {

    }

    public Date getDate() {
        return createdOn;
    }

    public void changeDate(Date newDate) {
        this.createdOn = newDate;
    }

    public User getAuthor() {
        return user;
    }

    public void changeAuthor(User newUser) {
        this.user = newUser;
    }

    public String getComment() {
        return text;
    }

    public void editComment(String newComment) {
        this.text = newComment;
    }
}
