import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J08024_So0VaSo9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = sc.nextInt();
            Queue<Long> Q = new LinkedList<>();
            Q.add(9L);
            while (!Q.isEmpty()) {
                Long x = Q.peek();
                Q.poll();
                if(x % n == 0) {
                    System.out.println(x);
                    break;
                }
                Q.add(x*10);
                Q.add(x*10+9);
            }
        }
    }
}
