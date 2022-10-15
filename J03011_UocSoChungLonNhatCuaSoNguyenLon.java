import java.util.Scanner;

public class J03011_UocSoChungLonNhatCuaSoNguyenLon {
    public static long UCLN(long a, long b){
        if(b==0) return a;
        return UCLN(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-->0){
            long a = Long.parseLong(sc.nextLine());
            String b = sc.nextLine();
            long n = 0;
            for (int i = 0; i < b.length(); i++) {
                n = n*10 + (b.charAt(i) - '0');
                n %= a;
            }
            System.out.println(UCLN(a,n));
        }
    }
}
