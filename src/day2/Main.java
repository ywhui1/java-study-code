package day2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k;
        String m,n;
        List<Contract> a=new ArrayList<>();
        Map<String,Contract> b=new HashMap<>();
        Contract ch;
        while(true){
            System.out.println("1.添加联系人");
            System.out.println("2.显示所有联系人");
            System.out.println("3.根据姓名查找");
            System.out.println("4.删除联系人");
            System.out.println("5.修改联系人信息");
            System.out.println("0.退出");
            k=sc.nextInt();
            if(k==0)break;
            switch(k){
                case 1:
                    System.out.println("请输入姓名");
                    n=sc.next();
                    System.out.println("请输入电话号码");
                    m=sc.next();
                    ch=new Contract(n,m);
                    a.add(ch);
                    b.put(n,ch);
                    System.out.println("添加成功");
                    break;
                case 2:
                    if(a.size()==0){System.out.println("无联系人");}
                    else{
                        for(Contract c:a){
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:
                    System.out.println("请输入姓名:");
                    n=sc.next();
                    if(!b.containsKey(n)){System.out.println("不存在该联系人");}
                    else{
                        System.out.println(b.get(n));
                    }
                    break;
                case 4:
                    System.out.println("请输入姓名:");
                    n=sc.next();
                    if(!b.containsKey(n)){System.out.println("不存在该联系人");}
                    else{
                        a.remove(b.get(n));//用Map通过姓名获取对象
                        b.remove(n);
                        System.out.println("删除成功");
                    }
                    break;
                //case 5:
                default:
                    System.out.println("请按照要求输入!");
            }
        }
    }
}
class Contract{
    String name;
    String phone;
    @Override
    public String toString(){
      return  "姓名:"+name+",电话号:"+phone;
    }
    Contract(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
}
