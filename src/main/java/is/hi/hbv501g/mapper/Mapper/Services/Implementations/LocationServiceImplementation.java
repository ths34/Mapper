package is.hi.hbv501g.mapper.Mapper.Services.Implementations;

import is.hi.hbv501g.mapper.Mapper.Entities.Location;
import is.hi.hbv501g.mapper.Mapper.Repositories.LocationRepository;
import is.hi.hbv501g.mapper.Mapper.Services.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImplementation implements LocationService {
    LocationRepository locRepo;

    @Override
    public Location save(Location loc) {
        return locRepo.save(loc);
    }
}
