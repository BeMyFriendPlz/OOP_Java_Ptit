import java.util.Scanner;

public class J01011_BoiSoChung_UocSoChung {
    public static long USC(long a, long b){
        if(b==0) return a;
        return USC(b, a%b);
    }

    public static long BSC(long a, long b){
        return (a*b)/USC(a,b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            long a = sc.nextInt();
            long b = sc.nextInt();
            System.out.println(BSC(a,b) + " " + USC(a,b));
        }
    }
}
