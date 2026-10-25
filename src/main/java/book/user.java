package book;
import java.io.Serializable;
public class user implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    user() {}
    user(String id, String password) {
        this.id = id;
        this.password = password;
    }
}