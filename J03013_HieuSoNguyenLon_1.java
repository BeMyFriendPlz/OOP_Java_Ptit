import java.util.Scanner;

public class J03013_HieuSoNguyenLon_1 {
    public static String Tru(String a, String b){
        while(a.length() < b.length()) a = "0" + a;
        while(b.length() < a.length()) b = "0" + b;
        if(a.compareTo(b) < 0){
            String temp = a;
            a = b;
            b = temp;
        }
        String ans = "";
        int nho = 0;
        for (int i = a.length()-1; i >= 0; i--) {
            int num1 = (a.charAt(i)-'0');
            int num2 = (b.charAt(i)-'0') + nho;
            if(num1 < num2){
                num1 = num1 + 10;
                nho = 1;
                ans = String.valueOf(num1 - num2) + ans;
            }else{
                nho = 0;
                ans = String.valueOf(num1 - num2) + ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            String a = sc.next();
            String b = sc.next();
            System.out.println(Tru(a,b));
        }
    }
}
