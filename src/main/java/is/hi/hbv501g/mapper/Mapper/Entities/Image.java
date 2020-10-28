package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Image {

    private Location imagelocation;
    private String imageTitle;
    private Date releaseDate;
    private String description;
    private User owner; // á þetta vera userId??

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /*
    TODO
    Vantar tengingar við usertöflu og location

     */
    public Image(Location imagelocation, String imageTitle, Date releaseDate, String description, User owner) {
        this.imagelocation = imagelocation;
        this.imageTitle = imageTitle;
        this.releaseDate = releaseDate;
        this.description = description;
        this.owner = owner;
    }

    public Image() {

    }

    public Location getImagelocation() {
        return imagelocation;
    }

    public void setImagelocation(Location imagelocation) {
        this.imagelocation = imagelocation;
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
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
