import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05068_SapXepBangGiaXangDau {
    public static class MatHang {
        private String ma, tenHang;
        private long soLuong;
        private long donGia;
        private double thue;

        public MatHang(String ma, int soLuong) {
            this.ma = ma;
            this.soLuong = soLuong;
            phanTichMa();
        }

        public void phanTichMa() {
            char c = ma.charAt(0);
            if(c == 'X') {
                donGia = 128000;
                thue = 3;
            } else if (c == 'D') {
                donGia = 11200;
                thue = 3.5f;
            } else {
                donGia = 9700;
                thue = 2;
            }
            String s = ma.substring(3,5);
            if(s.equals("BP")) {
                tenHang = "British Petro";
            } else if (s.equals("ES")) {
                tenHang = "Esso";
            } else if (s.equals("SH")) {
                tenHang = "Shell";
            } else if (s.equals("CA")) {
                tenHang = "Castrol";
            } else if (s.equals("MO")){
                tenHang = "Mobil";
            } else {
                tenHang = "Trong Nuoc";
                thue = 0;
            }
        }

        public long getThue() {
            return (long) (soLuong * donGia * thue) / 100;
        }

        public long getThanhTien() {
            return soLuong * donGia + getThue();
        }


        @Override
        public String toString() {
            return ma + " " + tenHang + " " + donGia + " " +
                    getThue() + " " + getThanhTien();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MatHang[] mh = new MatHang[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MatHang(sc.next(), sc.nextInt());
        }
        Arrays.sort(mh, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                return o1.getThanhTien() > o2.getThanhTien() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(mh[i]);
        }
    }
}
