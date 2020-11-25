package is.hi.hbv501g.mapper.Mapper.Services;


import is.hi.hbv501g.mapper.Mapper.Entities.Image;
import is.hi.hbv501g.mapper.Mapper.Entities.Location;

import java.util.List;

public interface LocationService {
    Location save(Location prufa);
    List<Location> findAll();
    // List<Image> findByLocation(Location location);
}
