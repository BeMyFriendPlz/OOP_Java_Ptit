import java.util.Scanner;

public class ThucHanh_SoLienKe {
    public static boolean Ktra(String s){
        for (int i = 0; i < s.length()-1; i++) {
            if(Math.abs(s.charAt(i) - s.charAt(i+1)) != 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            String s = sc.next();
            if(Ktra(s)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
