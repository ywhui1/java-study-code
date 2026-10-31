package book;
public class bookmanage {
    BookDao bookDao=new BookDaoImpI();
    //添加
    public void addBook(String bookname,String author){
        book b=new book(bookname,author);
        if (bookDao.getBook(b) != null) {
            System.out.println("添加失败,该书已存在");
        }
        else {
            if (bookDao.addBook(b)) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        }
    }
    //删除
    public void deleteBook(String bookname){
        book b=new  book();
        b.setName(bookname);
        if (bookDao.deleteBook(b)) {
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }
    // 修改
    public void changeBook(String name, String author) {
        book b = new book();
        b.setName(name);
        // 先查出原来的书（为了拿到原来的库存）
        book existBook = bookDao.getBook(b);
        if (existBook == null) {
            System.out.println("修改失败，书不存在");
        } else {
            existBook.setAuthor(author);
            if (bookDao.changeBook(existBook)) {
                System.out.println("修改成功");
            }
        }
    }

    // 查询
    public void getBook(String name) {
        book b = new book();
        b.setName(name);
        book result = bookDao.getBook(b);
        if (result == null) {
            System.out.println("查询失败，书不存在");
        } else {
            System.out.println(result);
        }
    }

    // 借书
    public void borrowBook(String name) {
        book b = new book();
        b.setName(name);
        if (bookDao.borrowBook(b)) {
            System.out.println("借书成功");
        } else {
            System.out.println("借书失败，库存不足或书不存在");
        }
    }

    // 还书
    public void returnBook(String name) {
        book b = new book();
        b.setName(name);
        if (bookDao.returnBook(b)) {
            System.out.println("还书成功");
        } else {
            System.out.println("还书失败，书不存在");
        }
    }
}
