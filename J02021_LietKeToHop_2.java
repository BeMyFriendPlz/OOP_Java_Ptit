import java.util.Scanner;

public class J02021_LietKeToHop_2 {
    public static int n, k, dem = 0;
    public static int[] a = null;

    public static void In(){
        for (int i = 1; i <= k; i++) {
            System.out.print(a[i]);
        }
        System.out.print(" ");
    }

    public static void Try(int i){
        for (int j = a[i-1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if(i == k){
                In();
                dem++;
            }else Try(i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[k+5];
        Try(1);
        System.out.println("\nTong cong co " + dem + " to hop");
    }
}
