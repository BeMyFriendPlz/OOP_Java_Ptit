import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J03010_DiaChiEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        Set<String> set = new HashSet<>();
        while (t-->0){
            String[] s = sc.nextLine().toLowerCase().trim().split("[^a-zA-Z]+");
            String ans = s[s.length-1];
            for (int i = 0; i < s.length-1; i++) {
                ans += s[i].charAt(0);
            }
            int num = 2;
            String temp = ans;
            while (set.contains(temp)){
                temp = ans + String.valueOf(num);
                num++;
            }
            ans = temp;
            if(!set.contains(ans)){
               set.add(ans);
            }
            System.out.println(ans + "@ptit.edu.vn");
        }
    }
}
