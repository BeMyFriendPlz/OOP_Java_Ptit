import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07054_TinhDiemTrungBinh {
    public static class SinhVien {
        private String name, ma;
        private double m1, m2, m3;

        public SinhVien(String ma, String name, double m1, double m2, double m3) {
            this.name = name;
            this.ma = ma;
            this.m1 = m1;
            this.m2 = m2;
            this.m3 = m3;
        }

        public String getName() {
            String[] s = name.trim().toLowerCase().split("[^a-zA-Z]+");
            String ans = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                ans += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            return ans;
        }

        public String getMa() {
            while (ma.length() < 2) ma = "0" + ma;
            return "SV" + ma;
        }

        public double getDiemTB() {
            double diemTB = (m1*3 + m2*3 + m3*2) / 8;
            return diemTB;
        }

        @Override
        public String toString() {
            return getMa() + " " + getName() + " " + String.format("%.2f",getDiemTB());
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
                if(o1.getDiemTB() > o2.getDiemTB()){
                    return -1;
                } else if (o1.getDiemTB() < o2.getDiemTB()){
                    return 1;
                } else {
                    return o1.getMa().compareTo(o2.getMa());
                }
            }
        });
        int xepHang = 1, nho = 1;
        for (int i = 0; i < n; i++) {
            if(i == 0){
                System.out.println(sv[i] + " " + xepHang);
            } else {
                if(sv[i].getDiemTB() == sv[i-1].getDiemTB()){
                    System.out.println(sv[i] + " " + xepHang);
                    nho++;
                }else {
                    xepHang += nho;
                    nho = 1;
                    System.out.println(sv[i] + " " + xepHang);
                }
            }
        }
    }
}
