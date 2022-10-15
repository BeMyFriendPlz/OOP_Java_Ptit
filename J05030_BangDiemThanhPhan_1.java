import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05030_BangDiemThanhPhan_1 {
    public static class SinhVien {
        private String ma, name, lop;
        private double d1,d2,d3;

        public SinhVien(String ma, String name, String lop, double d1, double d2, double d3) {
            this.ma = ma;
            this.name = name;
            this.lop = lop;
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
        }

        public String getMa() {
            return ma;
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + lop + " " + String.format("%.1f %.1f %.1f", d1, d2, d3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        }
        Arrays.sort(sv, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getMa().compareTo(o2.getMa());
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + " " + sv[i]);
        }
    }
}
