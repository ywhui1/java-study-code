package book;

public class usermanager {
    UserDao userDao = new UserDaoImpl();

    // 登录：传用户名和密码
    public Boolean login(String username, String password){
        user u = userDao.findByUsername(username);
        if(u != null && u.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    // 注册：不需要传 id，数据库会自动生成
    public boolean register(String username, String password){
        // 1. 查重：看用户名是不是已经有人用了
        if(userDao.findByUsername(username) != null){
            System.out.println("该用户名已被注册！");
            return false;
        }
        // 2. 插入
        return userDao.insert(new user(username, password));
    }
}