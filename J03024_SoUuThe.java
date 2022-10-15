import java.util.Scanner;

public class J03024_SoUuThe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String s = sc.next();
            boolean ok = true;
            int chan = 0, le = 0;
            if(s.charAt(0) == '0') ok = false;
            for (int i = 0; i < s.length(); i++) {
                if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || ok == false){
                    ok = false;
                    break;
                }
                if((s.charAt(i)-'0')%2==0){
                    chan++;
                }else {
                    le++;
                }
            }
            if(ok == false){
                System.out.println("INVALID");
            }else if (chan > le && s.length()%2 == 0){
                System.out.println("YES");
            }else if (le > chan && s.length()%2 == 1) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
