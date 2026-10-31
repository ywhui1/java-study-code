package book;

public interface UserDao {
    // 登录查询和注册查重，都根据用户名来查
    user findByUsername(String username);
    // 注册
    Boolean insert(user u);
}