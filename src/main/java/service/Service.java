package service;

import model.User;

import java.util.List;

public interface Service {
    void addUser(User user);

    boolean deleteUser(Long id);

    List<User> getAllUsers();

    boolean updateUser(User user);

    User getUserById(Long id);
}
