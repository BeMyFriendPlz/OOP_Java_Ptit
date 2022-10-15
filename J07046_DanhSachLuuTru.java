import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class J07046_DanhSachLuuTru {
    public static class KhachHang {
        private String maKH, tenKH, maPhong;
        private Date date1, date2;

        public KhachHang(String maKH, String tenKH, String maPhong, Date date1, Date date2) {
            this.maKH = maKH;
            this.tenKH = tenKH;
            this.maPhong = maPhong;
            this.date1 = date1;
            this.date2 = date2;
        }

        public long soNgay() {
            return TimeUnit.MILLISECONDS.toDays(date2.getTime() - date1.getTime());
        }

        @Override
        public String toString() {
            return maKH + " " + tenKH + " " + maPhong + " " + soNgay();
        }
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int n = Integer.parseInt(sc.nextLine());
        KhachHang[] kh = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            String maKH = String.valueOf(i+1);
            while (maKH.length() < 2) maKH = "0" + maKH;
            maKH = "KH" + maKH;
            String tenKH = sc.nextLine();
            String maPhong = sc.nextLine();
            Date date1 = dateFormat.parse(sc.nextLine());
            Date date2 = dateFormat.parse(sc.nextLine());
            kh[i] = new KhachHang(maKH, tenKH, maPhong, date1, date2);
        }
        Arrays.sort(kh, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o1.soNgay() > o2.soNgay() ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(kh[i]);
        }
    }
}
