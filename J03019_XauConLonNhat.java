import java.util.Scanner;

public class J03019_XauConLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(), ans = "";
        char k = 'a';
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) >= k){
                k = s.charAt(i);
                ans = k + ans;
            }
        }
        System.out.println(ans);
    }
}
