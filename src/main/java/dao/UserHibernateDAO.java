package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

//import org.hibernate.SessionFactory;

public class UserHibernateDAO implements UserDAO {
    private SessionFactory sessionFactory;
//    private Transaction transaction;

    public UserHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        boolean deleted = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Query query = session.createQuery("delete User where id = :paramId");
            query.setParameter("paramId", id);
            deleted = query.executeUpdate() > 0;
            transaction.commit();
        }
        return deleted;
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            List<User> list = session.createQuery("FROM User").list();
            transaction.commit();
            return list;
        }

    }

    @Override
    public boolean updateUser(User user) {
        boolean updated= false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(user);
            transaction.commit();
            return true;
        }
    }

    @Override
    public User getUserById(Long id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Query query = session.createQuery("from User where id = :paramId");
             user = (User) query.setParameter("paramId", id).uniqueResult();
//            for (User u : userList) {
//                if (u.getId() == id) {
//                    user = u;
//                }
//            }
            transaction.commit();
            return user;
        }
    }
}
