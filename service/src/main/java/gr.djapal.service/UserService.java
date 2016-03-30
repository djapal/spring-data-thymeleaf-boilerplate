package gr.djapal.service;

import gr.djapal.core.persistence.model.User;
import gr.djapal.core.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author djapal
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(String id) {
        return userRepository.findOne(Long.valueOf(id));
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
