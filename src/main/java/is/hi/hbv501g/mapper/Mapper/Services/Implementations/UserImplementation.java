package is.hi.hbv501g.mapper.Mapper.Services.Implementations;

import is.hi.hbv501g.mapper.Mapper.Entities.User;
import is.hi.hbv501g.mapper.Mapper.Repositories.UserRepository;
import is.hi.hbv501g.mapper.Mapper.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplementation implements UserService {

    UserRepository theUserRepository;

    @Autowired
    public UserImplementation(UserRepository userRepository){this.theUserRepository = userRepository;}

    @Override
    public User save(User user) {
        return theUserRepository.save(user);
    }

    @Override
    public void delete(User user) {
       theUserRepository.delete(user);
    }

    @Override
    public List<User> findAllUsers() {
        return theUserRepository.findAllUsers();
    }

    @Override
    public List<User> findByName(String UserName) {
        return theUserRepository.findByName(UserName);
    }

    @Override
    public Optional<User> findById(long id) {
        return theUserRepository.findById(id);
    }
}