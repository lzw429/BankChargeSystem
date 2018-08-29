package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(String username, String nickname, String password) {
        return false;
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.find(username);
        if (user != null && user.getPassword().equals(password)) {
            // 用户名与密码匹配
            System.out.println("UserService: 【用户登录】用户名与密码匹配");
            return user;
        }
        // 用户名或密码错误
        System.out.println("UserService: 【用户登录】用户名或密码错误");
        System.out.println("login as " + username + " " + password);
        return null;
    }

    @Override
    public String balanceByCustomerID(String username) {
        return userDao.balanceByCustomerID(username);
    }
}
