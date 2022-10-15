import java.math.BigInteger;
import java.util.Scanner;

public class J03033_BoiSoChungNhoNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            BigInteger n1 = new BigInteger(sc.next());
            BigInteger n2 = new BigInteger(sc.next());
            System.out.println(n1.divide(n1.gcd(n2)).multiply(n2));
        }
    }
}
