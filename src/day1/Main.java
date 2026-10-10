package day1;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(23);
        s1.setStuID("01");
        Student s2 = new Student("李四",18,"02");//有参赋值
        Student s3 = new Student();
        System.out.println(s1.getName()+" "+s1.getAge()+" "+s1.getStuID());
        System.out.println(s2.getName()+" "+s2.getAge()+" "+s2.getStuID());
        System.out.println(s3.getName()+" "+s3.getAge()+" "+s3.getStuID());
    }
}
class Student {
    String name;
    int age;
    String stuID;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getStuID() {
        return stuID;
    }
    public void setStuID(String stuID) {
        this.stuID = stuID;
    }
    public Student() {}
    public Student(String name, int age, String stuID) {
        this.name = name;
        this.age = age;
        this.stuID = stuID;
    }
}
