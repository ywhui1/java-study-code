package book;

import java.util.Scanner;
//项目目标： 不连数据库，用 ArrayList/HashMap 存数据，控制台菜单实现：
//用户登录校验（内存里写死或存集合）
//图书增删改查
//按书名/作者查询
//借书、还书（先不做库存事务，只改状态）
public class Main {
    public static void main(String[] args) {
        bookmanage manager = new bookmanage();
        Scanner sc = new Scanner(System.in);
        System.out.println("图书管理系统");

        user u = new user();
        while(true){
            System.out.println("ID:");
            String id = sc.nextLine().trim();
            System.out.println("密码:");
            String password = sc.nextLine().trim();
            if(u.login(id, password)){
                System.out.println("登录成功");
                break;
            }
            System.out.println("登录失败");
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
            if(a==0) break;
            switch (a){
                case 1:
                    System.out.println("请输入书名:");
                    String name = sc.nextLine().trim();
                    System.out.println("请输入作者名:");
                    String author = sc.nextLine().trim();
                    manager.addBook(name, author);
                    break;
                case 2:
                    System.out.println("请输入书名:");
                    manager.deleteBook(sc.nextLine().trim());
                    break;
                case 3:
                    System.out.println("请输入书名:");
                    name = sc.nextLine().trim();
                    System.out.println("请输入作者名:");
                    author = sc.nextLine().trim();
                    manager.changeBook(name, author);
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
