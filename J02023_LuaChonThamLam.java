import java.util.Map;
import java.util.Scanner;

public class J02023_LuaChonThamLam {
    public static String Min(int n, int s) {
        String ans = "";
        while (s > 9) {
            ans = "9" + ans;
            s -= 9;
        }
        if(s > 0) {
            if(ans.length() == n-1) {
                ans = String.valueOf(s) + ans;
            } else {
                ans = String.valueOf(s-1) + ans;
                while (ans.length() < n-1) ans = "0" + ans;
                ans = "1" + ans;
            }
        }
        return ans;
    }

    public static String Max(int n, int s){
        String ans = "";
        while (s > 9) {
            ans = ans + "9";
            s -= 9;
        }
        if(s > 0) {
            ans = ans + String.valueOf(s);
            while (ans.length() < n) ans = ans + "0";
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        if(n*9 < s || s == 0) {
            System.out.println("-1 -1");
        } else {
            System.out.println(Min(n,s) + " " + Max(n,s));
        }
    }
}
