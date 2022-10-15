import java.util.Scanner;
import java.util.Stack;

public class J08020_KiemTraDayNgoacDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            Stack<Character> st = new Stack<>();
            boolean check = true;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    st.push(s.charAt(i));
                } else {
                    if(st.empty()) {
                        check = false;
                        break;
                    } else if(s.charAt(i) == ')' && st.peek() == '('){
                        st.pop();
                    } else if(s.charAt(i) == ']' && st.peek() == '['){
                        st.pop();
                    } else if(s.charAt(i) == '}' && st.peek() == '{'){
                        st.pop();
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            if(!st.empty()) check = false;
            if(check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
