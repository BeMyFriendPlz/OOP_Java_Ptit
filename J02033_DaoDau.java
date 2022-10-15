import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class J02033_DaoDau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> Q = new PriorityQueue<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Q.add(sc.nextInt());
        }
        while (k-- > 0){
            int x = -Q.poll();
            Q.add(x);
        }
        long sum = 0;
        while (!Q.isEmpty()){
            sum += Q.poll();
        }
        System.out.println(sum);
    }
}
