package book;

public class book {
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
    private boolean borrowed = false;   // 默认未借出
    public boolean isBorrowed() { return borrowed; }
    public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }
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
