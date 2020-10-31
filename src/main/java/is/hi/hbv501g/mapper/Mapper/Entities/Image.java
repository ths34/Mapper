package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "locationID")
    private Location locationID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User userID;

    private String imageTitle;
    private Date releaseDate;
    private String description;

    public Image(Location location, String imageTitle, Date releaseDate, String description, User UserID) {
        this.locationID = location;
        this.imageTitle = imageTitle;
        this.releaseDate = releaseDate;
        this.description = description;
        this.userID = UserID;
    }

    public Image() {

    }

    public Location getImagelocation() {
        return locationID;
    }

    public void setImagelocation(Location imagelocation) {
        this.locationID = imagelocation;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return userID;
    }

    public void setOwner(User UserID) {
        this.userID = UserID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
