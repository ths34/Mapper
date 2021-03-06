package is.hi.hbv501g.mapper.Mapper.Repositories;

import is.hi.hbv501g.mapper.Mapper.Entities.Image;
import is.hi.hbv501g.mapper.Mapper.Entities.Location;
import is.hi.hbv501g.mapper.Mapper.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image save(Image image);

    default void delete(Image image) {

    }
    List<Image> findAll();

    List<Image> findAllByUserID(long UserID);

    Optional<Image> findById(long id);

    List<Image> findByLocationID(Location location); // ætti þetta ekki að vera í location repoinu???
}
