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
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name="userID")
    private User user;

    @ManyToOne
    @JoinColumn(name="imageID")
    private Image image;

    public Comment(String Text) {
        this.text = Text;
    }

    public Comment() {

    }
    @PrePersist
    private void cDate(){
        this.releaseDate = new Date();
    }
    public Date getDate() {
        return releaseDate;
    }

    public void changeDate(Date newDate) {
        this.releaseDate = newDate;
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
