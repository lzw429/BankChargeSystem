package dao;

import model.User;

public interface UserDao {
    /**
     * 用户注册
     * 用户信息插入数据库，注册成功后跳转到登录页
     *
     * @param username 用户名
     * @param nickname 昵称
     * @param password 密码
     * @return 若用户名存在将注册失败 false
     */
    boolean register(String username, String nickname, String password);

    /**
     * 判断用户是否存在
     *
     * @param username 用户名
     * @return 存在true，不存在false
     */
    boolean exist(String username);

    /**
     * 查找用户
     *
     * @param username 用户名
     * @return 用户名对应的用户
     */
    User find(String username);

    /**
     * @param username 用户名
     * @return 余额
     */
    String balanceByCustomerID(String username);
}
