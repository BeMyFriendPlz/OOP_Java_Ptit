import java.util.Map;
import java.util.Scanner;

public class J02022_SoXaCach {
    public static int[] a = null;
    public static boolean[] chuaxet = null;
    public static int n;

    public static void In(){
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static boolean KiemTra(){
        for (int i = 1; i <= n-1; i++) {
            if(Math.abs(a[i]-a[i+1]) == 1){
                return false;
            }
        }
        return true;
    }

    public static void Try(int i){
        for (int j = 1; j <= n; j++) {
            if(chuaxet[j]){
                a[i] = j;
                chuaxet[j] = false;
                if(i == n && KiemTra()) In();
                else Try(i+1);
                chuaxet[j] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            n = sc.nextInt();
            a = new int[n+5];
            chuaxet = new boolean[n+5];
            for (int i = 1; i <= n; i++) {
                chuaxet[i] = true;
            }
            Try(1);
            System.out.println();
        }
    }
}
