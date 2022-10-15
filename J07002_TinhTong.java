import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07002_TinhTong {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            int sum = 0;
            while (sc.hasNext()){
                try {
                    int x = Integer.parseInt(sc.next());
                    sum += x;
                } catch (Exception e){
                    continue;
                }
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
