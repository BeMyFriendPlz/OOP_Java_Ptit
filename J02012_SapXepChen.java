import java.util.Scanner;

public class J02012_SapXepChen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && a[j-1] > a[j]){
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                j--;
            }
            System.out.print("Buoc " + i + ":");
            for (j = 0; j <= i; j++) {
                System.out.print(" " + a[j]);
            }
            System.out.println();
        }
    }
}
