import java.util.Scanner;

public class J03040_BienSoDep {
    public static boolean TangDan(String s){
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) >= s.charAt(i+1)) return false;
        }
        return true;
    }

    public static boolean BangNhau(String s){
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) != s.charAt(i+1)) return false;
        }
        return true;
    }

    public static boolean BangNhau32(String s){
        for (int i = 0; i < 2; i++) {
            if(s.charAt(i) != s.charAt(i+1)) return false;
        }
        if(s.charAt(3) != s.charAt(4)) return false;
        return true;
    }

    public static boolean LocPhat(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '6' && s.charAt(i) != '8') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String s = sc.nextLine();
            String a = s.substring(5,8) + s.substring(9,11);
            if(TangDan(a) || BangNhau(a) || BangNhau32(a) || LocPhat(a)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
