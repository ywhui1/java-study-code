package book;
import java.io.*;


import java.util.HashMap;
import java.util.Map;
public class userdate {
    public static final String user_file="users.dat";
    public static void save(Map<String,user>users){
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(user_file))){
            oos.writeObject(users);
        }catch (IOException e){
            e.printStackTrace();
            throw new UncheckedIOException("保存用户失败", e);
        }
    }
    @SuppressWarnings("unchecked")
    public static Map<String,user> loadusers(){
        File file = new File(user_file);
        if (!file.exists()||file.length()==0) {
            return new  HashMap<>();
        }
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(user_file))){
            return (Map<String,user>) ois.readObject();
        }catch (Exception e){
            throw new RuntimeException("读取用户失败", e);
        }
    }
}
