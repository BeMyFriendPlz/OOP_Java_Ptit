import java.util.Scanner;

public class J01001_HinhChuNhat {
    public static void main(String[] args) {
        int a,b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        if(a<=0 || b<=0){
            System.out.println(0);
        }else{
            System.out.println(((a+b)*2) + " " + (a*b));
        }
    }
}
