import java.util.Scanner;

public class J02013_SapXepNoiBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int j = 1; j < n - i; j++) {
                if(a[j-1] > a[j]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    ok = false;
                }
            }
            if(ok) break;
            System.out.print("Buoc " + (i+1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.print(" " + a[j]);
            }
            System.out.println();
        }
    }
}
