import java.util.Scanner;
import java.util.regex.Pattern;

public class J03021_DienThoaiCucGach {
    public static String ChuyenDoi(String s){
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if(Pattern.matches("[ABC]",String.valueOf(s.charAt(i)))){
                ans += "2";
            } else if (Pattern.matches("[DEF]",String.valueOf(s.charAt(i)))) {
                ans += 3;
            } else if (Pattern.matches("[GHI]",String.valueOf(s.charAt(i)))) {
                ans += 4;
            } else if (Pattern.matches("[JKL]",String.valueOf(s.charAt(i)))) {
                ans += 5;
            } else if (Pattern.matches("[MNO]",String.valueOf(s.charAt(i)))) {
                ans += 6;
            } else if (Pattern.matches("[PQRS]",String.valueOf(s.charAt(i)))) {
                ans += 7;
            } else if (Pattern.matches("[TUV]",String.valueOf(s.charAt(i)))) {
                ans += 8;
            } else if (Pattern.matches("[WXYZ]",String.valueOf(s.charAt(i)))) {
                ans += 9;
            }
        }
        return ans;
    }

    public static boolean ThuanNghich(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s = sc.next().toUpperCase();
            if(ThuanNghich(ChuyenDoi(s))){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
