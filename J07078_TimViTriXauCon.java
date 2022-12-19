import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07078_TimViTriXauCon {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STRING.in"));
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int i = 0;
            while (s1.indexOf(s2,i) != -1) {
                i = s1.indexOf(s2,i);
                System.out.print((i+1) + " ");
                i++;
            }
            System.out.println();
        }
    }
}
