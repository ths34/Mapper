package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double Longitude;
    private double Latitude;
    private String LocationName;

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Image> images;
    public Location() {

    }

    public Location(double longitude, double latitude, String name) {
        this.Longitude = longitude;
        this.Latitude = latitude;
        this.LocationName = name;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }
}
