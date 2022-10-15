import java.util.Scanner;

public class J03008_SoDep3 {
    public static boolean Ngto(int n){
        if(n==2 || n==3 || n==5 || n==7) return true;
        return false;
    }

    public static boolean KTra(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
            int a = Integer.parseInt(s.charAt(i) + "");
            if(!Ngto(a)){
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
