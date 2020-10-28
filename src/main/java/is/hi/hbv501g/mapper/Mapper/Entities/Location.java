package is.hi.hbv501g.mapper.Mapper.Entities;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    //TODO
    /*
    Vantar tengingu one to one við Image og User. Spurning hvrot eigi að vera. Væntanlega verður
    tengt við location möguleikinn að user setji margar myndar frá staðsetningu og að margir user séu að
    mynda sama location?? athuga í tíma á fimmtudag 30/10.
    @OneToMany
    private Image image;
    @OneToMany
    private User user;
     */
    private double Longitude;
    private double Latitude;
    private String LocationName;

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
