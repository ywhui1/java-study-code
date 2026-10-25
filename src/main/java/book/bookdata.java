package book;
import java.util.*;
import java.io.*;
public class bookdata {
    private static final String books_file = "books.dat";
    public static void save(Map<String, book> books){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(books_file))){
            oos.writeObject(books);//把book类字节化存入book_file里
        }catch (IOException e){
            throw new RuntimeException("出现异常", e);
        }
    }
    @SuppressWarnings("unchecked")
    public static Map<String,book> loadbooks(){
        File file = new File(books_file);
        if (!file.exists()||file.length()==0) {
            return new HashMap<>();
        }
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file))){
             return (Map<String, book>)ois.readObject();
        }catch (Exception e){
            throw new RuntimeException("出现异常", e);
        }
    }
}
