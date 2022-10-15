import java.util.Scanner;

public class J03004_ChuanHoaXauHoTen_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0){
            String s = sc.nextLine();
            s = s.trim();
            s = s.toLowerCase();
            String[] a = s.split("[^A-Za-z]+");
            for (int i = 0; i < a.length; i++) {
                String first = a[i].substring(0,1);
                String last = a[i].substring(1,a[i].length());
                first = first.toUpperCase();
                System.out.print(first + last + " ");
            }
            System.out.println();
        }
    }
}
