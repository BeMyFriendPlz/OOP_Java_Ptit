import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class J07051_TinhTienPhong {
    public static class KhachHang {
        private String maKH, name, soP;
        private Date nhanP, traP;
        private int dichVu;

        public KhachHang(String maKH, String name, String soP, Date nhanP, Date traP, int dichVu) {
            this.maKH = maKH;
            this.name = name.trim().toLowerCase();
            this.soP = soP.trim();
            this.nhanP = nhanP;
            this.traP = traP;
            this.dichVu = dichVu;
        }

        public String getMaKH() {
            while(maKH.length() < 2) maKH = "0" + maKH;
            return "KH" + maKH;
        }

        public String getName(){
            String[] s = name.split("[^a-zA-Z]+");
            String ans = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                ans += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            return ans;
        }

        public int getSoNgay() {
            return (int) (TimeUnit.MILLISECONDS.toDays(traP.getTime() - nhanP.getTime()) + 1);
        }

        public int getThanhTien() {
            int gia = 0;
            switch (soP.charAt(0)) {
                case '1': {
                    gia = 25;
                    break;
                }
                case '2': {
                    gia = 34;
                    break;
                }
                case '3': {
                    gia = 50;
                    break;
                }
                default: {
                    gia = 80;
                    break;
                }
            }
            return gia * getSoNgay() + dichVu;
        }

        @Override
        public String toString() {
            return getMaKH() + " " + getName() + " " + soP +
                    " " + getSoNgay() + " " + getThanhTien();
        }
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        KhachHang[] kh = new KhachHang[n];
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < n; i++) {
            kh[i] = new KhachHang(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    format.parse(sc.nextLine()), format.parse(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        }
        Arrays.sort(kh, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o1.getThanhTien() > o2.getThanhTien() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(kh[i]);
        }
    }
}
