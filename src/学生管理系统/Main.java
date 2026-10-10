package 学生管理系统;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManger studentManger = new StudentManger();
        System.out.println("学生管理系统");
        while(true){
            System.out.println("1,添加学生");
            System.out.println("2,删除学生");
            System.out.println("3,查找学生");
            System.out.println("4,显示全部");
            System.out.println("0,退出");
            System.out.println("请输入要进行的操作:");
            int choice = sc.nextInt();
            String name;
            switch (choice){
                case 1:
                    System.out.println("请输入姓名:");
                    name = sc.next();
                    System.out.println("请输入年龄");
                    int age = sc.nextInt();
                    Student student = new Student(name,age);
                    if(studentManger.addStudent(student)){
                        System.out.println("添加成功");
                    }
                    else System.out.println("学生已存在");
                    break;
                case 2:
                    System.out.println("请输入姓名:");
                    name = sc.next();
                    if (studentManger.DeleteStudent(name)){
                        System.out.println("删除成功");
                    }
                    else System.out.println("学生不存在");
                    break;
                case 3:
                    System.out.println("请输入姓名:");
                    name = sc.next();
                    System.out.println(studentManger.FindStudent(name));
                    break;
                case 4:
                    System.out.println(studentManger.FindAllStudents());
                case 0:
                    studentManger.saveToFile();
                    sc.close();
                    return;
                default:
                    System.out.println("请按规矩输入");
            }
        }
    }
}
