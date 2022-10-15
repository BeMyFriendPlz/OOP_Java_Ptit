import java.util.Scanner;

public class ThucHanh_LuaChonThamLam {
    public static String SoNhoNhat(int n, int k) {
        String ans = "";
        while(k > 9) {
            ans += "9";
            k -= 9;
        }
        if(k > 0 && ans.length() == n-1) {
            ans = String.valueOf(k) + ans;
        } else if(k > 0 && ans.length() < n-1) {
            ans = String.valueOf(k-1) + ans;
            while (ans.length() < n-1) ans = "0" + ans;
            ans = "1" + ans;
        }
        return ans;
    }

    public static String SoLonNhat(int n, int k) {
        String ans = "";
        while(k >= 9) {
            ans += "9";
            k -= 9;
        }
        if(k > 0) ans += String.valueOf(k);
        while (ans.length() < n) ans += "0";
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(k > 9 * n || k == 0) {
            System.out.println("-1 -1");
        } else {
            System.out.println(SoNhoNhat(n,k) + " " + SoLonNhat(n,k));
        }
    }
}
