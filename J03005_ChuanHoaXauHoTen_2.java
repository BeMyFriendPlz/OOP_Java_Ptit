import java.util.Scanner;

public class J03005_ChuanHoaXauHoTen_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0){
            String s = sc.nextLine();
            s = s.trim();
            s = s.toLowerCase();
            String[] a = s.split("[^A-Za-z]+");
            for (int i = 1; i < a.length-1; i++) {
                String first = a[i].substring(0,1);
                String last = a[i].substring(1,a[i].length());
                first = first.toUpperCase();
                System.out.print(first + last + " ");
            }
            String first = a[a.length-1].substring(0,1);
            String last = a[a.length-1].substring(1,a[a.length-1].length());
            first = first.toUpperCase();
            System.out.print(first + last + ", ");
            a[0] = a[0].toUpperCase();
            System.out.print(a[0]);
            System.out.println();
        }
    }
}
