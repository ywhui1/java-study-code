package book;
import java.util.HashMap;
import java.util.Map;

public class usermanager {
    public Map<String, user> getUsers() {
        return users;
    }

    public void setUsers(Map<String, user> users) {
        this.users = users;
    }

    private Map<String,user> users= new HashMap<>();

    public usermanager() {
        users = userdate.loadusers();
        if (!users.containsKey("admin")) {
            users.put("admin", new user("admin", "123456"));
        }
    }

    public boolean login(String id, String password){
        if(users.containsKey(id)){
            user b = users.get(id);
            if(b.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean register(String id, String password){
        if(users.containsKey(id)){
            System.out.println("ID重复了");
            return false;
        }
        users.put(id,new user(id,password));
            return  true;
    }
}
