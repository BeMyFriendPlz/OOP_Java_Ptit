import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07056_TinhTienDien {
    public static class KhachHang {
        private String ma, name, hoGiaDinh;
        private int dau, cuoi;

        public KhachHang(String ma, String name, String khachHang) {
            this.ma = ma;
            this.name = name;
            String[] s = khachHang.split(" ");
            this.hoGiaDinh = s[0];
            this.dau = Integer.parseInt(s[1]);
            this.cuoi = Integer.parseInt(s[2]);
        }

        public String getMa() {
            while (ma.length() < 2) ma = "0" + ma;
            return "KH" + ma;
        }

        public String getName() {
            String[] s = name.trim().toLowerCase().split("[^a-zA-Z]+");
            String ans = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                ans += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            return ans;
        }

        public int getDinhMuc() {
            switch (hoGiaDinh) {
                case "A": {
                    return 100;
                }
                case "B": {
                    return 500;
                }
                default: {
                    return 200;
                }
            }
        }

        public int getTienTrong() {
            return Math.min(cuoi - dau, getDinhMuc()) * 450;
        }

        public int getTienVuot() {
            if(cuoi-dau > getDinhMuc()){
                return (cuoi-dau-getDinhMuc()) * 1000;
            } else {
                return 0;
            }
        }

        public int getThueVAT() {
            return getTienVuot()*5/100;
        }

        public int getTongTien() {
            return getTienTrong() + getTienVuot() + getThueVAT();
        }

        @Override
        public String toString() {
            return getMa() + " " + getName() + " " + getTienTrong() + " " +
                    getTienVuot() + " " + getThueVAT() + " " + getTongTien();
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        KhachHang[] kh = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            kh[i] = new KhachHang(String.valueOf(i+1), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(kh, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o1.getTongTien() > o2.getTongTien() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(kh[i]);
        }
    }
}
