package is.hi.hbv501g.mapper.Mapper.Services;


import is.hi.hbv501g.mapper.Mapper.Entities.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByUserName(String userName);
    Optional<User> findById(long id);
    User login(User user);
}
