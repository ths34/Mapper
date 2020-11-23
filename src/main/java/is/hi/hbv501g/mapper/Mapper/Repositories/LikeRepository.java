package is.hi.hbv501g.mapper.Mapper.Repositories;


import is.hi.hbv501g.mapper.Mapper.Entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {

    Likes save(Likes comment);

    default void delete(Likes comment) {

    }

    List<Likes> findByImage(long imageID);

    List<Likes> findByUser(long userID);

    Optional<Likes> findById(long id);

}