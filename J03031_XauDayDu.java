import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J03031_XauDayDu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            if((26 - set.size()) <= k) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
