import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J07058_DanhSachMonThi {
    public static class MonThi {
        private String maMon, tenMon, hinhThuc;

        public MonThi(String maMon, String tenMon, String hinhThuc) {
            this.maMon = maMon;
            this.tenMon = tenMon;
            this.hinhThuc = hinhThuc;
        }

        public String getMaMon() {
            return maMon;
        }

        @Override
        public String toString() {
            return maMon + " " + tenMon + " " + hinhThuc;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<MonThi> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new MonThi(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        list.sort(new Comparator<MonThi>() {
            @Override
            public int compare(MonThi o1, MonThi o2) {
                return o1.getMaMon().compareTo(o2.getMaMon());
            }
        });
        for (MonThi temp : list) {
            System.out.println(temp);
        }
    }
}
