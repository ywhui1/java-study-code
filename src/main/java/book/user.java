package book;
import java.util.HashMap;
import java.util.Map;

public class user {
    String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private Map<String, user> users = new HashMap<>();
    user() {
        users.put("admin", new user("admin", "123456")); // 预置一个
    }
    user(String id, String password) {
        this.id = id;
        this.password = password;
    }
    public boolean login(String username, String password) {
        user u = users.get(username);
        return u != null && u.getPassword().equals(password);
    }
}