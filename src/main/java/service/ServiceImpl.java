package service;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.DBHelper;
import java.util.List;

public class ServiceImpl  implements Service{
    private static ServiceImpl service;
    private static UserDAO userDAO;
//    private static SessionFactory sessionFactory;

    public ServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public static ServiceImpl getInstance(){
        if (service==null){
            service= new ServiceImpl(new UserHibernateDAO(DBHelper.getSessionFactory()));
        }
        return service;
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public boolean deleteUser(Long id) {
        return userDAO.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }
}
