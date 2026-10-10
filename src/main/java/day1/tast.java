package day1;

public class tast {
    public static void main(String[] args) {
        int[]a={7,-4,1,-5};
        //tast.A(a);
        //tast.B(a);
        int b=9;
        tast.C(b);
    }
    public int sum(int a,int b){
        return a+b;
    }
    public static void A(int[]a){//根据输入的整数数组，输出它平方且正序排好的数组
        int[]b=new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=a[i]*a[i];
        }
        int k;
        for(int i=0;i<b.length-1;i++){
            for(int j=0;j<b.length-1-i;j++){
                if(b[j]>b[j+1]){
                    k=b[j+1];
                    b[j+1]=b[j];
                    b[j]=k;
                }
            }
        }
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
    }
    public static void B(int[]a){
        int k;
        for(int j=0;j<a.length/2;j++){
            k=a[j];
            a[j]=a[a.length-1-j];
            a[a.length-1-j]=k;
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void C(int b){
        if(b<10) {System.out.println("不是回文数");}
        else {
            int aa=b,k=0;
            Boolean cc=true;
            while(aa>0){
                aa=aa/10;
                k++;
            }
            int[] a=new int[k];
            for(int i=0;i<k;i++){
                a[i]=b%10;
                b=b/10;
            }
            for(int i=0;i<k/2;i++){
                if(a[i]!=a[a.length-1-i]){
                    cc=false;
                }
            }
            if(cc){
                System.out.println("是回文数");

            }
            else{
                System.out.println("不是回文数");
            }
        }
    }
}
