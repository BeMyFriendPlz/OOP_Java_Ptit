import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05018_BangDiemHocSinh {
    public static class HocSinh {
        private String ma, name;
        private double[] d = new double[10];

        public HocSinh(String ma, Scanner sc) {
            while (ma.length() < 2) ma = "0" + ma;
            this.ma = "HS" + ma;
            sc.nextLine();
            this.name = sc.nextLine();
            for (int i = 0; i < 10; i++) {
                d[i] = sc.nextDouble();
            }
        }

        public Double diemTB() {
            double tb = 0;
            for (int i = 0; i < 2; i++) {
                tb += d[i]*2;
            }
            for (int i = 2; i < 10; i++) {
                tb += d[i];
            }
            tb = tb/12;
            tb = Math.round(tb * 10.0) / 10.0;
            return tb;
        }

        public String rank() {
            if(diemTB() < 5) {
                return "YEU";
            } else if (diemTB() < 7) {
                return "TB";
            } else if (diemTB() < 8) {
                return "KHA";
            } else if (diemTB() < 9) {
                return "GIOI";
            } else {
                return "XUAT SAC";
            }
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + diemTB() + " " + rank();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HocSinh[] hs = new HocSinh[n];
        for (int i = 0; i < n; i++) {
            hs[i] = new HocSinh(String.valueOf(i+1), sc);
        }
        Arrays.sort(hs, new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return o1.diemTB() > o2.diemTB() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(hs[i]);
        }
    }
}
