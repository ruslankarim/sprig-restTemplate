package web.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDAO {

  private EntityManager entityManager;

  @Autowired
  public UserDaoImp(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<User> getAllUsers() {
    Session session = entityManager.unwrap(Session.class);
    Query<User> query = session.createQuery("from User", User.class);
    List<User> users = query.getResultList();
    return users;
  }

  @Override
  public User findUserByEmail(String email) {
    Session session = entityManager.unwrap(Session.class);
    Query<User> query = session.createQuery( "select u From User u where u.email=:email", User.class);
    query.setParameter("email", email);
    User user = query.getSingleResult();
    return user;
  }

  @Override
  public User findUserByID(Long id) {
    Session session = entityManager.unwrap(Session.class);
    User user = session.get(User.class, id);
    return user;
  }

  @Override
  public void addUser(User user) {
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(user);
  }

  @Override
  public void updateUser(User user) {
    entityManager.merge(user);
  }

  @Override
  public void deleteUser(Long id) {
    Session session = entityManager.unwrap(Session.class);
    Query query = session.createQuery("delete from User where id=:id");
    query.setParameter("id", id);
    query.executeUpdate();
  }
}
