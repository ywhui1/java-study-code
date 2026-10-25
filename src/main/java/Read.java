import book.book;
import book.userdate;
import book.bookdata;
import book.user;
import java.util.HashMap;
import java.util.Map;

public class Read {
    public static void main(String[] args) {
        Map<String,book>books=bookdata.loadbooks();
        for(Map.Entry<String, book>entry:books.entrySet()){
            System.out.println(entry.getValue()+" "+entry.getValue().getStock());
        }
        Map<String, user>users=userdate.loadusers();
        System.out.println(users.keySet());
    }
}
