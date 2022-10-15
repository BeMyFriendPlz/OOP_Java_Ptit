import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07034_DanhSachMonHoc {
    public static class MonHoc {
        private String maMH, tenMH;
        private int soTC;

        public MonHoc(String maMH, String tenMH, int soTC) {
            this.maMH = maMH;
            this.tenMH = tenMH;
            this.soTC = soTC;
        }

        public String getTenMH() {
            return tenMH;
        }

        @Override
        public String toString() {
            return maMH + " " + tenMH + " " + soTC;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        MonHoc[] mh = new MonHoc[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MonHoc(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }
        Arrays.sort(mh, new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                return o1.getTenMH().compareTo(o2.getTenMH());
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(mh[i]);
        }
    }
}
