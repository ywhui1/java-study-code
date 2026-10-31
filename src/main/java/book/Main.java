package book;
import java.util.Scanner;
//项目目标： 不连数据库，用 ArrayList/HashMap 存数据，控制台菜单实现：
//用户登录校验（内存里写死或存集合）
//图书增删改查
//按书名/作者查询
//借书、还书（先不做库存事务，只改状态）
//---------------------------------------------------------
//第2周 10.14-10.20;
//文件持久化版 + Maven/Linux;
//多线程基础、IO、Maven、Git进阶、Linux;
//讲清线程5状态；Maven建项目打jar；
//Linux装JDK运行jar；IO持久化重启不丢；
//synchronized示例；LeetCode累计25道
public class Main {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        bookmanage manager = new bookmanage();
        Scanner sc = new Scanner(System.in);
        System.out.println("图书管理系统");
        usermanager um=new usermanager();
        int k;
        while (true){
            System.out.println("1,登录");
            System.out.println("2,注册");
            try {
                k = Integer.parseInt(sc.nextLine().trim()); //nextInt()读完会把回车符留在缓冲区，影响后续键盘读取
            } catch (NumberFormatException e) {
                System.out.println("输入错误");
                continue;
            }
            if(k==1){
                while(true){
                    System.out.println("用户名:");
                    String username = sc.nextLine().trim();
                    System.out.println("密码:");
                    String password = sc.nextLine().trim();
                    if(um.login(username, password)){
                        System.out.println("登录成功");
                        break;
                    }
                    System.out.println("登录失败");
                }
                break;
            }
            else if(k==2){
                System.out.println("用户名");
                String username = sc.nextLine().trim();
                System.out.println("密码:");
                String password = sc.nextLine().trim();
                if(um.register(username,password)){
                    System.out.println("注册成功，请登录");
                }
                else System.out.println("注册失败");
            }
            else{System.out.println("输入错误");}
        }
        while(true){
            System.out.println("1，添加");
            System.out.println("2，删除");
            System.out.println("3，修改");
            System.out.println("4，查询");
            System.out.println("5，借书");
            System.out.println("6，还书");
            System.out.println("0，关闭");
            System.out.println("请输入操作:");

            int a;
            try {
                a = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("输入错误");
                continue;
            }
            if(a==0) {
                break;
            }
            switch (a){
                case 1:
                    System.out.println("请输入书名:");
                    String bookname = sc.nextLine().trim();
                    System.out.println("请输入作者名:");
                    String author = sc.nextLine().trim();
                    manager.addBook(bookname, author);
                    break;
                case 2:
                    System.out.println("请输入书名:");
                    manager.deleteBook(sc.nextLine().trim());
                    break;
                case 3:
                    System.out.println("请输入书名:");
                    bookname = sc.nextLine().trim();
                    System.out.println("请输入作者名:");
                    author = sc.nextLine().trim();
                    manager.changeBook(bookname, author);
                    break;
                case 4:
                    System.out.println("请输入书名:");
                    manager.getBook(sc.nextLine().trim());
                    break;
                case 5:
                    System.out.println("请输入书名:");
                    manager.borrowBook(sc.nextLine().trim());
                    break;
                case 6:
                    System.out.println("请输入书名:");
                    manager.returnBook(sc.nextLine().trim());
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }

    }
}
