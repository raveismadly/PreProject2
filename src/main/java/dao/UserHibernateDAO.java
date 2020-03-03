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
    private Transaction transaction;

    public UserHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        boolean deleted = false;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            Query query = session.createQuery("delete User where id = :paramId");
            query.setParameter("paramId", id);
            deleted = query.executeUpdate() > 0;
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return deleted;
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            List<User> list = session.createQuery("FROM User").list();
            transaction.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public User getUserById(Long id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            Query query = session.createQuery("from User where id = :paramId");
            List<User> userList = query.setParameter("paramId", id).list();
            for (User u : userList) {
                if (u.getId() == id) {
                    user = u;
                }
            }
            transaction.commit();
            return user;
        } catch (Exception e) {
            transaction.rollback();
            return null;
        }
    }
}
