package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp{

    UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    };

    @Transactional
    public void addUser(User user){
        userDAO.addUser(user);
    };

    @Transactional
    public void updateUser(User user){
        userDAO.updateUser(user);
    };


    public User findUserByEmail(String email){
        return userDAO.findUserByEmail(email);
    };

    public User findUserByID(Long id){
        return userDAO.findUserByID(id);
    }

    @Transactional
    public void deleteUser(Long id){
        userDAO.deleteUser(id);
    };
}
