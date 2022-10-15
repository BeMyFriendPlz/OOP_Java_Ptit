import java.util.Scanner;

public class J01016_ChuSo4VaChuSo7 {
    public static boolean Ktra(String s){
        if(!s.contains("7") || !s.contains("4")) return false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '4' || s.charAt(i) == '7'){
                count++;
            }
        }
        if (count == 4 || count == 7) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(Ktra(s)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
