package book;

import java.sql.*;

public class BookDaoImpI implements BookDao {
    @Override
    public boolean addBook(book book) {
        String sql ="insert into book(bookname,author,stock) values(?,?,?)";
        int i=0;
        try (Connection conn=DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
             ps.setString(1, book.getName());
             ps.setString(2, book.getAuthor());
             ps.setInt(3, book.getStock());
             i=ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return (i>0);
    }

    @Override
    public boolean deleteBook(book book) {
        String sql ="delete from book where bookname=?";
        try (Connection conn=DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,book.getName());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean changeBook(book book) {
        String sql="update book set author=?,stock=? where bookname=?";
        try (Connection conn=DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
             ps.setString(1,book.getAuthor());
             ps.setInt(2, book.getStock());
             ps.setString(3,book.getName());
             return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public book getBook(book  book) {
        String sql ="select * from book where bookname=?";
        try (Connection conn=DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql);){
             ps.setString(1,book.getName());
             try (ResultSet rs=ps.executeQuery()){
                 if (rs.next()) {
                     book resultBook = new book();
                     resultBook.setName(rs.getString("bookname"));
                     resultBook.setAuthor(rs.getString("author"));
                     resultBook.setStock(rs.getInt("stock"));
                     return resultBook; // 查到了，返回对象
                 }
                 rs.next();
             }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean borrowBook(book book) {
        String sql="update book set stock=stock-1 where bookname=? and stock>0";
        try (Connection conn=DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
             ps.setString(1,book.getName());
             return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean returnBook(book book) {
        String sql="update book set stock=stock+1 where bookname=?";
        try (Connection conn=DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
             ps.setString(1,book.getName());
             return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
