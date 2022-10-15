import java.util.Scanner;

public class J01024_SoTamPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String s = sc.next();
            if(s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6")
                    || s.contains("7") || s.contains("8") || s.contains("9")){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
