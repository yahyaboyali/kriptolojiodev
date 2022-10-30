import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static List<Integer> bolenler(int x) {
        List<Integer> xBolenler = new ArrayList<>();
        for(int i = 0 ; i <= x ; i++ ) {
            if(x % i == 0) {
                xBolenler.add(i);
            }
        }
        return xBolenler;
    }
    public static boolean aralarindaAsal(int x,int y) {
        int buyuk = 0;
        int kucuk = 0;
        if(x < y ) {
            buyuk = y;
            kucuk = x;
        }else {
            buyuk = x;
            buyuk = y;
        }
        for(int i = 2 ; i <= kucuk ; i++) {
            if(buyuk % i == 0) {
                return false;
            }
        }

        return true;
    }
    public static List<Integer> exteuclid2 (int kalanAlani, int modTarafi) {
        List<Integer> exitcode = new ArrayList<>();
        if(modTarafi == 0) {
            exitcode.add(0,kalanAlani);
            exitcode.add(1,1);
            exitcode.add(2,0);
            return exitcode;
        }else {
            int d1,s1,t1;
            List<Integer> exitcode1;
            exitcode1 = exteuclid2(modTarafi,kalanAlani%modTarafi);
            d1 = exitcode1.get(0);
            s1 = exitcode1.get(1);
            t1 = exitcode1.get(2);
            int d,s,t;
            d = d1;
            s = t1;
            t = s1 -(kalanAlani/modTarafi) *t1;
            exitcode.add(0,d);
            exitcode.add(1,s);
            exitcode.add(2,t);
            return exitcode;
        }

    }
    public static class Mod {
        public int deger;
        public int mod;
        public Mod(int deger,int mod){
            this.mod = mod;
            if(deger > mod) {
                this.deger = mod -1;
            } else {
                this.deger = deger;
            }
        }
    }
    public static int cinliKalanlar(List<Mod> mods) {
        int sonuc = 0;
        int M = 1;
        for (Mod m : mods) {
            M = m.mod * M;
        }
        System.out.println("M degeri: "+ M);
        for(Mod m : mods) {
            int y = 0;
            List<Integer> sonuclar;
            sonuclar = exteuclid2(m.mod,M/m.mod);
            if(sonuclar.get(2)<0) {
                sonuclar.add(2,m.mod+sonuclar.get(2));
            }
            y = sonuclar.get(2);
            sonuc += y*(M/m.mod)*m.deger;
        }
        if(sonuc> M) {
            sonuc = sonuc%M;
        }
        return sonuc;
    }
    public static void main(String[] args) {
        System.out.println("---------------------- \n* euclid algorithm * \n" +
                "----------------------");
        System.out.println("gcd"+"(a,b) = "+oklid(32,3));
        List<Integer> exteuclid ;
        int a ,b;
        a= 13;
        b = 77;
        exteuclid = exteuclid2(a,b);
        System.out.println("---------------------- \n* extended euclid algorithm * \n" +
                "----------------------");
        if(exteuclid.get(2)<0) {
            exteuclid.add(2,a+exteuclid.get(2));
        }
        System.out.println(exteuclid.get(2));
        System.out.println("---------------------- \n* cinli kalanlar  algorithm * \n" +
                "----------------------");
        List<Mod> mods = new ArrayList<>();
        mods.add(0,new Mod(3,7));
        mods.add(1,new Mod(9,17));
        mods.add(2,new Mod(8,13));
        mods.add(3,new Mod(21,41));
        System.out.println(cinliKalanlar(mods));
    }
}