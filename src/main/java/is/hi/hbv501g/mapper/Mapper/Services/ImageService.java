package is.hi.hbv501g.mapper.Mapper.Services;


import is.hi.hbv501g.mapper.Mapper.Entities.Comment;
import is.hi.hbv501g.mapper.Mapper.Entities.Image;
import is.hi.hbv501g.mapper.Mapper.Entities.Location;
import is.hi.hbv501g.mapper.Mapper.Entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ImageService {
    Image save(Image image);
    List<Image> findAll();
    List<Image> findByLocationID(Location location);
    List<Image> findByUsername(String userName);
    void delete(Image image);
    List<User> getLikes(Integer imageID);
    List<Comment> getComments(Integer imageID);
    Image findOne(Integer imageID);

    List<Image> findAllByUserID(long UserID);

    Optional<Image> findById(long id);
}
