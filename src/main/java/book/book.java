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
    public book(String a,String b){
        this.name=a;
        this.author=b;
    }
    public book(){}
}
