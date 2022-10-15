import java.util.Scanner;
import java.util.Stack;

public class J03027_RutGonXauKyTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.empty()) {
                stack.push(s.charAt(i));
            }else if (stack.peek() == s.charAt(i)){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.empty()){
            System.out.print("Empty String");
        }else{
            for (char c : stack) {
                System.out.print(c);
            }
        }
    }
}
