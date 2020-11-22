package is.hi.hbv501g.mapper.Mapper.Repositories;


import is.hi.hbv501g.mapper.Mapper.Entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {

    Likes save(Likes comment);

    default void delete(Likes comment) {

    }
/*
    List<Likes> findAllByImageId(long imageID);

    List<Likes> findAllByUserId(long userID);
*/
    Optional<Likes> findById(long id);

}