import java.util.Scanner;

public class J03006_SoDep1 {
    public static boolean KTra(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
            int a = Integer.parseInt(s.charAt(i)+"");
            int b = Integer.parseInt(s.charAt(s.length()-1-i)+"");
            if(a%2!=0 || b%2!=0){
                return false;
            }
        }
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
