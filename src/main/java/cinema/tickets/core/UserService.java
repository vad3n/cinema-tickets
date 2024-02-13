package cinema.tickets.core;

import java.util.List;
import java.util.stream.Collectors;

import cinema.tickets.core.models.User;
import cinema.tickets.repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(int id) {
        return Mappers.fromUserDAO(userRepository.getUser(id));
    }

    public List<User> getUsers() {
        return userRepository.getUsers()
                .stream()
                .map(Mappers::fromUserDAO)
                .collect(Collectors.toList());
    }

    public User createUser(String username, String password, String email) {
        return Mappers.fromUserDAO(userRepository.createUser(username, password, email));
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }
}
