package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDAO {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<User> getAllUsers() {
    return entityManager.createQuery("from User", User.class).getResultList();
  }

  @Override
  public User findUserByEmail(String email) {
    TypedQuery<User> query = entityManager.createQuery("select u From User u where u.email=:email", User.class);
    query.setParameter("email", email);
    return query.getSingleResult();
  }

  @Override
  public User findUserByID(Long id) {
        return entityManager.find(User.class, id);
    }

  @Override
  public void addUser(User user) {
      entityManager.persist(user);
  }

  @Override
  public void updateUser(User user) {
    entityManager.merge(user);
  }

  @Override
  public void deleteUser(User user) {
    entityManager.remove(user);
  }
}
