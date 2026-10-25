package book;
import java.util.HashMap;
import java.util.Map;

public class bookmanage {
    public Map<String, book> getMap() {
        return map;
    }
    public void setMap(Map<String, book> map) {
        this.map = map;
    }
    private Map<String, book> map = new HashMap<String, book>();
    //添加
    public void addBook(String name,String author){
        if(map.containsKey(name)){
            System.out.println("添加失败,该书已存在");
        }
        else {
            map.put(name, new book(name, author));
            System.out.println("添加成功");
        }
    }
    //删除
    public void deleteBook(String name){
        if(map.containsKey(name)){
            map.remove(name);
            System.out.println("删除成功");
        }
        else {System.out.println("删除失败，书不存在");}
    }
    //修改
    public void changeBook(String name,String author){
        book b = map.get(name);
        if(b==null){
            System.out.println("修改失败，书不存在");
        }
        else {
            b.setAuthor(author);
            System.out.println("修改成功");
        }
    }
    //查询
    public void getBook(String name){
        book b = map.get(name);
        if(b == null){
            System.out.println("查询失败，书不存在");
        } else {
            System.out.println(b);
        }
    }
    //借书
    public void borrowBook(String name){
        book b = map.get(name);
        if(b == null){ System.out.println("书不存在"); return; }
        b.borrow();
    }
    //还书
    public void returnBook(String name) {
        book b = map.get(name);
        if(b== null){ System.out.println("还书失败，书不存在");  }
        b.returnbook();
    }
}
