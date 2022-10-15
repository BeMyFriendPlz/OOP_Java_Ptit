import java.util.Scanner;

public class J03007_SoDep2 {
    public static boolean KTra(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        if(!s.startsWith("8") || !s.endsWith("8")) return false;
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.charAt(i)+"");
        }
        if(sum%10 != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String s = sc.nextLine();
            if(KTra(s)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
