package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "likes")  // ath verður víst að vera likes sem table name like er reserved for mySQL. samkvæmt google :)
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "imageID")
    private Image image;

    private Date createdOn;

    public Likes() {
        this.createdOn = new Date();
    }
}
