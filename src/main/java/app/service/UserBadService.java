package app.service;

import app.domain.User;
import app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserBadService {
    private static UserRepository userRepository = null;

    public UserBadService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static User getUser(String name) {
        return userRepository.findByUsername(name);
    }
}
