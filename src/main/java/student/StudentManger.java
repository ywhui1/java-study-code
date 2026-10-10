package student;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while((line=br.readLine())!=null){
                String[] str=line.split(",");
                if(str.length<2) continue;
                String name=str[0].trim();
                String ageStr=str[1].trim();
                // 容错：从字符串里提取纯数字部分，兼容带前缀的脏数据
                String numStr = ageStr.replaceAll("[^0-9]", "");
                if(numStr.isEmpty()) continue;
                int age=Integer.parseInt(numStr);
                // 之前漏了这步：把读到的学生对象存进内存map
                Student stu = new Student(name, age);
                map.put(name, stu);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void saveToFile(){
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("students.txt"), StandardCharsets.UTF_8))) {
            for(Map.Entry<String,Student> entry:map.entrySet()){
                bw.write(entry.getKey()+","+entry.getValue().getAge());
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
