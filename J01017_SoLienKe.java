import java.util.Scanner;

public class J01017_SoLienKe {
    public static boolean Ktra(String s){
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if(Math.abs(s.charAt(i) - s.charAt(i+1)) != 2){
                return false;
            }
            sum += Integer.valueOf(s.charAt(i)-48);
        }
        sum += Integer.valueOf(s.charAt(s.length()-1)-48);
        if(sum%10==0) return true;
        return false;
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