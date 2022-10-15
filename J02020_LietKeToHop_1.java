import java.util.Scanner;

public class J02020_LietKeToHop_1 {
    public static int n,k;
    public static int[] a = null;
    public static boolean ok = false;

    public static void Sinh(){
        int i = k;
        while (a[i] == n-k+i){
            i--;
        }
        if(i==0) ok = true;
        else {
            a[i]++;
            for (int j = i+1; j <= k; j++) {
                a[j] = a[j-1]+1;
            }
        }
    }

    public static void In(){
        for (int i = 1; i <= k; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[k+5];
        for (int i = 1; i <= k; i++) {
            a[i] = i;
        }
        int count = 0;
        while (!ok){
            In();
            Sinh();
            count++;
        }
        System.out.println("Tong cong co " + count + " to hop");
    }
}
