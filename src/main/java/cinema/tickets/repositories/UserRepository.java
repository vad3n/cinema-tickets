package cinema.tickets.repositories;

import java.util.List;

import cinema.tickets.repositories.models.UserDAO;

public interface UserRepository {
    UserDAO getUser(int id);

    List<UserDAO> getUsers();

    UserDAO createUser(String username, String password, String email);

    void deleteUser(int id);
}
