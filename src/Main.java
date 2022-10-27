import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int oklid(int a,int b) {
        if(b > a) {
            return 0;
        }
        if(a <0 || b <=0) {
            return 0;
        }
        int kalan = a % b ;
        System.out.println(a+" = " +(a/b)+"x"+b+" + "+(a%b));
        if(kalan == 0 ) {
            System.out.println("kalan = 0 ");
            return b;
        } else {

            a = b;
            b = kalan;
            System.out.println(a+" = " +(a/b)+"x"+b+" + "+(a%b));
            return (oklid (a,b));
        }
    }
    public  static int extendedeuclid(int a, int b, int x,int y){
        if(oklid(a,b) == 0) {
            System.out.println("tersi yok!");
            return 0;
        }else if(oklid(a,b) > 1) {
            System.out.println(x+" ile "+ y +" aralarında asal değil");
            return 0;
        } else if (a == 0) {
            x = 0;
            y = 1;
            return b;
        } else {
            int x1 = 1;
            int y1 = 1;
            int gcd = extendedeuclid(b %a,a,x1,y1);

            x = y1 - (b/a)*x1;
            y = x1;
            return gcd;
        }
    }
    public static List<Integer> exteuclid2 (int a, int b) {
        List<Integer> exitcode = new ArrayList<>();
        if(b ==0 ) {
            exitcode.add(0,a);
            exitcode.add(1,1);
            exitcode.add(2,0);
            return exitcode;
        }else {
            int d1,s1,t1;
            List<Integer> exitcode1 =new ArrayList<>();
            exitcode1 = exteuclid2(b,a%b);
            d1 = exitcode1.get(0);
            s1 = exitcode1.get(1);
            t1 = exitcode1.get(2);
            int d,s,t;
            d = d1;
            s = t1;
            t = s1 -(a/b) *t1;
            exitcode.add(0,d);
            exitcode.add(1,s);
            exitcode.add(2,t);
            return exitcode;
        }

    }
    public static void main(String[] args) {
        //Öklid algoritmasi
        System.out.println("gcd"+"(a,b) = "+oklid(32,3));
        List<Integer> exteuclid = new ArrayList<>();
        exteuclid = exteuclid2(99,78);
        for(int a:exteuclid) {
            System.out.println(a);
        }
    }
}