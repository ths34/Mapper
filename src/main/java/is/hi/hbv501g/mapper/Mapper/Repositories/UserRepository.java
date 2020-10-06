package is.hi.hbv501g.mapper.Mapper.Repositories;

import is.hi.hbv501g.mapper.Mapper.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    void delete(User user);
    List<User> findAllUsers();
    List<User> findByName(String UserName);
    Optional<User> findById(long id);

}
