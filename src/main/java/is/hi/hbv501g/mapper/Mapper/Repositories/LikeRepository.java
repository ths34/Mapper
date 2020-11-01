package is.hi.hbv501g.mapper.Mapper.Repositories;


import is.hi.hbv501g.mapper.Mapper.Entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Like save(Like comment);

    default void delete(Like comment) {

    }

    default List<Like> findAllForImage(long imageID) {
        return null;
    }

    default List<Like> findAllForUser(long userID) {
        return null;
    }

    default Optional<Like> findById(long id) {
        return null;
    }

}