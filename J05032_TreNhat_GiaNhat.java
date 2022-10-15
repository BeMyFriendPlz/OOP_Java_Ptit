import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05032_TreNhat_GiaNhat {
    public static class Nguoi {
        private String name, birth;

        public Nguoi(String name, String birth) {
            this.name = name;
            this.birth = birth;
        }

        public String getName() {
            return name;
        }

        public String getYear() {
            return birth.substring(6,10);
        }

        public String getMonth() {
            return birth.substring(3,5);
        }

        public String getDay() {
            return birth.substring(0,2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Nguoi[] nguoi = new Nguoi[n];
        for (int i = 0; i < n; i++) {
            nguoi[i] = new Nguoi(sc.next(), sc.next());
        }
        Arrays.sort(nguoi, new Comparator<Nguoi>() {
            @Override
            public int compare(Nguoi o1, Nguoi o2) {
                if(o1.getYear().equals(o2.getYear())) {
                    if(o1.getMonth().equals(o2.getMonth())) {
                        return o1.getDay().compareTo(o2.getDay());
                    } else {
                        return o1.getMonth().compareTo(o2.getMonth());
                    }
                } else {
                    return o1.getYear().compareTo(o2.getYear());
                }
            }
        });
        System.out.println(nguoi[n-1].getName());
        System.out.println(nguoi[0].getName());
    }
}
