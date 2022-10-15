import java.util.Arrays;
import java.util.Scanner;

public class J03032_DaoTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                for (int j = s[i].length()-1; j >= 0; j--) {
                    System.out.print(s[i].charAt(j));
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
