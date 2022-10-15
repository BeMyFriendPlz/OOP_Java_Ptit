import java.util.Scanner;

public class J02037_DayUuThe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String temp = sc.nextLine();
            String[] s = temp.split(" ");
            int chan = 0, le = 0;
            for (int i = 0; i < s.length; i++) {
                if(Integer.parseInt(s[i]) % 2 == 0) {
                    chan++;
                } else {
                    le++;
                }
            }
            if(chan > le && s.length % 2 == 0) {
                System.out.println("YES");
            } else if (le > chan && s.length % 2 == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
