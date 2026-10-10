package 学生管理系统;

import java.io.*;
import java.util.*;

public class StudentManger {
    Map<String,Student> map=new HashMap<>();
    public Boolean addStudent(Student student){
        map.put(student.getName(),student);
        return true;
    }
    public Boolean DeleteStudent(String name){
        if(map.containsKey(name)){
            map.remove(name);
            return true;
        }
        else     return false;
    }
    public Student FindStudent(String name){
        return map.get(name);
    }
    public Collection<Student> FindAllStudents(){
        return map.values();
    }
    public void loadFromFile(){
        File file = new File("students.txt");
        if(!file.exists()){
            return;
        }
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=br.readLine())!=null){
                String[] str=line.split(",");
                if(str.length!=2) continue;
                String name=str[0];
                int age=Integer.parseInt(str[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void saveToFile(){
        try (BufferedWriter bw=new BufferedWriter(new FileWriter("students.txt"))) {
            for(Map.Entry<String,Student> entry:map.entrySet()){
                bw.write(entry.getKey()+","+entry.getValue());
                bw.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据保存失败");
        }
    }
    StudentManger(){
        //启动时读取硬盘存储到内存里
        loadFromFile();
    }

}
