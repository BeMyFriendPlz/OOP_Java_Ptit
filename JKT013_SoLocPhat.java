import java.util.*;

public class JKT013_SoLocPhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Queue<String> q = new LinkedList<>();
            q.add("6");
            q.add("8");
            Stack<String> st = new Stack<>();
            while (q.peek().length() < n) {
                String x = q.peek();
                st.push(x);
                q.add(x + "6");
                q.add(x + "8");
                q.poll();
            }
            while (!q.isEmpty()) {
                st.push(q.poll());
            }
            System.out.println(st.size());
            while (!st.empty()) {
                System.out.print(st.pop() + " ");
            }
            System.out.println();
        }
    }
}
