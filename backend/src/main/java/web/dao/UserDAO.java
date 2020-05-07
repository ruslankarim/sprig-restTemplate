package web.dao;


import web.model.User;

import java.util.List;

public interface UserDAO {
  List<User> getAllUsers();
  User findUserByEmail(String email);
  User findUserByID(Long id);
  void addUser(User user);
  void updateUser(User user);
  void deleteUser(Long id);
}
