import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05037_TinhGiaBan_2 {
    public static class MatHang {
        private String ma, name, donvi;
        private double giaNhap, soLuong;

        public MatHang(String ma, String name, String donvi, double giaNhap, double soLuong) {
            while (ma.length() < 2) ma = "0" + ma;
            this.ma = "MH" + ma;
            this.name = name;
            this.donvi = donvi;
            this.giaNhap = giaNhap;
            this.soLuong = soLuong;
        }

        public double getPhiVanChuyen() {
            return (giaNhap * soLuong) * 5 / 100;
        }

        public double getThanhTien() {
            return giaNhap * soLuong + getPhiVanChuyen();
        }

        public double getGiaBan() {
            return Math.ceil(getThanhTien()*102 / (100 * soLuong * 100)) * 100;
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + donvi + " " + String.format("%.0f %.0f %.0f", getPhiVanChuyen(), getThanhTien(), getGiaBan());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        MatHang[] mh = new MatHang[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MatHang(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        }
        Arrays.sort(mh, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                return o1.getGiaBan() > o2.getGiaBan() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(mh[i]);
        }
    }
}
