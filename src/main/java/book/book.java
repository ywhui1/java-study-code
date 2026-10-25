package book;
import java.io.Serializable;
public class book implements Serializable{
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    private int stock=10;
    private static final long serialVersionUID = 1L;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String author;
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
            public String toString(){
        return "书名:"+this.getName()+" 作者名:"+this.getAuthor();
    }
    public synchronized Boolean borrow(){
        if(this.getStock()>0){
            this.setStock(this.getStock()-1);
            System.out.println("借书成功,剩余"+this.getStock()+"本");
            return true;
        } else if (this.getStock()==0) {
            System.out.println("库存不足");
        }
        return false;
    }
    public synchronized void returnbook(){
        if(this.getStock()<10){
            this.setStock(this.getStock()+1);
            System.out.println("还书成功");
        }
        else System.out.println("还书失败,不是该图书馆的书");
    }
    public book(String a,String b){
        this.name=a;
        this.author=b;
    }
    public book(){}
}
