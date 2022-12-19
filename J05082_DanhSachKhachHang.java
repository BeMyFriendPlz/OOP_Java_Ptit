import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05082_DanhSachKhachHang {
    public static class KhachHang {
        private String maKH, tenKH, gioiTinh, ngaySinh, diaChi;

        public KhachHang(String maKH, String tenKH, String gioiTinh, String ngaySinh, String diaChi) {
            while (maKH.length() < 3) maKH = "0" + maKH;
            this.maKH = "KH" + maKH;
            this.tenKH = tenKH.toLowerCase().trim();
            this.gioiTinh = gioiTinh;
            this.ngaySinh = ngaySinh;
            this.diaChi = diaChi;
        }

        public String getTenKH() {
            String[] temp = tenKH.split("[^a-zA-z]+");
            String name = temp[0].substring(0,1).toUpperCase() + temp[0].substring(1,temp[0].length());
            for (int i = 1; i < temp.length; i++) {
                name += " " + temp[i].substring(0,1).toUpperCase() + temp[i].substring(1,temp[i].length());
            }
            return name;
        }

        public String getNgaySinh() {
            String[] temp = ngaySinh.split("/");
            while(temp[0].length() < 2) temp[0] = "0" + temp[0];
            while(temp[1].length() < 2) temp[1] = "0" + temp[1];
            while(temp[2].length() < 4) temp[2] = "0" + temp[2];
            return temp[0] + "/" + temp[1] + "/" + temp[2];
        }

        @Override
        public String toString() {
            return maKH + " " + getTenKH() + " " + gioiTinh + " " + diaChi + " " + getNgaySinh();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        KhachHang[] kh = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            kh[i] = new KhachHang(String.valueOf(i+1), sc.nextLine(),
                    sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(kh, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                String[] s1 = o1.getNgaySinh().split("/");
                String[] s2 = o2.getNgaySinh().split("/");
                for (int i = 2; i >= 0; i--) {
                    if(s1[i].equals(s2[i])) continue;
                    else return s1[i].compareTo(s2[i]);
                }
                return 0;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(kh[i]);
        }
    }
}