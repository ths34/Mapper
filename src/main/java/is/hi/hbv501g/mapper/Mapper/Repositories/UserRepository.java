package is.hi.hbv501g.mapper.Mapper.Repositories;

import is.hi.hbv501g.mapper.Mapper.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    default void delete(User user) {

    }

    default List<User> findAllUsers() {
        return null;
    }

    default User findByName(String UserName) {
        return null;
    }

    default Optional<User> findById(long id) {
        return null;
    }

}

