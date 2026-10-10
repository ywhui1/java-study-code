package 学生管理系统;

public class Student {
    public String name;
    public int age;
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
    @Override
    public String toString(){
        return "姓名:"+this.getName()+" 年龄:"+this.getAge();
    }
    Student (){}
    Student (String name, int age){
        this.name = name;
        this.age = age;
    }
}
