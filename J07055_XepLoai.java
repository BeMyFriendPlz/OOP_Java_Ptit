import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07055_XepLoai {
    public static class SinhVien {
        private String msv, name;
        private double lt, tt, t;

        public SinhVien(String msv, String name, double lt, double tt, double t) {
            this.msv = msv;
            this.name = name;
            this.lt = lt;
            this.tt = tt;
            this.t = t;
        }

        public String getMsv() {
            while (msv.length() < 2) msv = "0" + msv;
            return "SV" + msv;
        }

        public String getName() {
            String[] s = name.trim().toLowerCase().split("[^a-zA-Z]+");
            String ans = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                ans += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            return ans;
        }

        public double getDiemTB() {
            return (lt * 25 + tt * 35 + t * 40)/100;
        }

        public String getXepLoai() {
            if(getDiemTB() < 5){
                return "KEM";
            } else if (getDiemTB() < 6.5f) {
                return "TRUNG BINH";
            } else if (getDiemTB() < 8) {
                return "KHA";
            } else {
                return "GIOI";
            }
        }

        @Override
        public String toString() {
            return getMsv() + " " + getName() + " " +
                    String.format("%.2f", getDiemTB()) + " " + getXepLoai();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(String.valueOf(i+1), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        }
        Arrays.sort(sv, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getDiemTB() > o2.getDiemTB() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(sv[i]);
        }
    }
}
