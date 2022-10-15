import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J07008_DayConTangDan {
    public static ArrayList<String> list = new ArrayList<>();
    public static int n,k;
    public static int[] a, b = null;

    public static boolean Ktra(){
        for (int i = 1; i <= k-1; i++) {
            if(a[b[i]] > a[b[i+1]]){
                return false;
            }
        }
        return true;
    }

    public static void In(){
        String ans = "";
        for (int i = 1; i <= k; i++) {
            ans += String.valueOf(a[b[i]]) + " ";
        }
        list.add(ans);
    }

    public static void Try(int i){
        for (int j = b[i-1]+1; j <= n-k+i; j++) {
            b[i] = j;
            if(i==k){
                if(Ktra()) In();
            }else Try(i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("DAYSO.in"));
            n = sc.nextInt();
            a = new int[n+5];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 2; i <= n; i++) {
                k = i;
                b = new int[k+5];
                for (int j = 0; j <= k; j++) {
                    b[j] = 0;
                }
                Try(1);
            }
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for (String ans : list) {
                System.out.println(ans);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
