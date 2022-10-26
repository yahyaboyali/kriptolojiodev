public class Main {
    public static int oklid(int a,int b) {
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
    public static void main(String[] args) {
        //Öklid algoritmasi
        System.out.println("gcd"+"(a,b) = "+oklid(64,36));
    }
}