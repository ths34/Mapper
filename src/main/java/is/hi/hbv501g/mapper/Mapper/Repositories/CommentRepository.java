package is.hi.hbv501g.mapper.Mapper.Repositories;

import is.hi.hbv501g.mapper.Mapper.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment save(Comment comment);

    default void delete(Comment comment) {

    }

    default List<Comment> findAllForImage(long imageID) {
        return null;
    }

    default List<Comment> findAllForUser(long userID) {
        return null;
    }

    default Optional<Comment> findById(long id) {
        return null;
    }

}
