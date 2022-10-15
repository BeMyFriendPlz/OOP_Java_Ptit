import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J01008_PhanTichThuaSoNguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            ArrayList<Long> list = new ArrayList<>();
            Long n = sc.nextLong();
            int count = 0;
            System.out.print("Test " + i + ": ");
            int j = 2;
            while (n > 1) {
                if (n % j == 0) {
                    n = n / j;
                    count++;
                } else {
                    if(count > 0){
                        System.out.print(j + "(" + count + ") ");
                    }
                    count = 0;
                    j++;
                }
            }
            if(count > 0){
                System.out.print(j + "(" + count + ")");
            }
            System.out.println();
        }
    }
}
