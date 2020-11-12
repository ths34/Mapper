package is.hi.hbv501g.mapper.Mapper.Repositories;

import is.hi.hbv501g.mapper.Mapper.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
