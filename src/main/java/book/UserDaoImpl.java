package book;
import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public user findByUsername(String username) { // <--- 改这里
        // SQL 改成按 username 查
        String sql = "select * from user where username = ?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, username); // <--- 改成 setString
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    user u = new user();
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    return u;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean insert(user u) {
        // 插入语句不用改，因为你本来就只插 username 和 password
        String sql = "insert into user (username, password) values (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}