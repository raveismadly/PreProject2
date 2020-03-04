//package dao;
//
//import model.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserJdbcDAO implements UserDAO {
//    Connection connection;
//
//    public UserJdbcDAO(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void addUser(User user) {
//        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name, surname, age)" +
//                "values(?,?,?)")) {
//            connection.setAutoCommit(false);
//            preparedStatement.setString(1, "name");
//            preparedStatement.setString(2, "surname");
//            preparedStatement.setString(3, "age");
//            preparedStatement.executeUpdate();
//            connection.commit();
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                connection.rollback();
//                connection.setAutoCommit(true);
//            } catch (SQLException ignore) {
//
//            }
//        }
//
//    }
//
//    public boolean deleteUser(Long id) {
//        boolean deleted = false;
//        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?")) {
//            connection.setAutoCommit(false);
//            preparedStatement.setLong(1, id);
//            if (preparedStatement.executeUpdate() > 0) {
//                deleted = preparedStatement.executeUpdate() > 0;
//                connection.commit();
//            } else {
//                connection.rollback();
//            }
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return deleted;
//    }
//
//    public List<User> getAllUsers() {
//        List<User> list = new ArrayList<>();
//        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from users")) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Long id = resultSet.getLong(1);
//                String name = resultSet.getString(2);
//                String surname = resultSet.getString(3);
//                int age = resultSet.getInt(4);
//                list.add(new User(id, name, surname, age));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public boolean updateUser(User user) {
//        boolean updated = false;
//        try (PreparedStatement preparedStatement = connection.prepareStatement("update users set name=?,surname=?,age=?" +
//                "where id=?")) {
//            connection.setAutoCommit(false);
//            preparedStatement.setString(1, user.getName());
//            preparedStatement.setString(2, user.getSurname());
//            preparedStatement.setInt(3, user.getAge());
//            preparedStatement.setLong(4, user.getId());
//            if (preparedStatement.executeUpdate() > 0) {
//                updated = true;
//                connection.commit();
//            } else {
//                connection.rollback();
//            }
//            connection.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return updated;
//    }
//
//    public User getUserById(Long id) {
//        User user = null;
//        try (PreparedStatement preparedStatement = connection.prepareStatement("select id,name,surname,age from users where id=?")) {
//            preparedStatement.setLong(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String surname = resultSet.getString("surname");
//                int age = resultSet.getInt("age");
//                user = new User(id, name, surname, age);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
//}
