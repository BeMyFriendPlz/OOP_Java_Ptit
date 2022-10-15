import java.math.BigInteger;
import java.util.Scanner;

public class J03039_ChiaHet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            BigInteger n1 = new BigInteger(sc.next());
            BigInteger n2 = new BigInteger(sc.next());
            BigInteger s1 = n1.divide(n2);
            BigInteger s2 = n2.divide(n1);
            if(n1.equals(n2.multiply(s1)) || n2.equals(n1.multiply(s2))){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
