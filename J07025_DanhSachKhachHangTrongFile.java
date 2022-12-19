import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07025_DanhSachKhachHangTrongFile {
    private static class KhachHang {
        private String maKH, tenKH, sex, birth, address;

        public KhachHang(String maKH, String tenKH, String sex, String birth, String address) {
            this.maKH = maKH;
            this.tenKH = tenKH;
            this.sex = sex;
            this.birth = birth;
            this.address = address;
        }

        public String getMaKH() {
            while (maKH.length() < 3) maKH = "0" + maKH;
            return "KH" + maKH;
        }

        public String getTenKH() {
            String[] s = tenKH.trim().toLowerCase().split("\\s+");
            String name = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                name += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            return name;
        }

        public String getBirth() {
            String[] s = birth.split("/");
            while (s[0].length() < 2) s[0] = "0" + s[0];
            while (s[1].length() < 2) s[1] = "0" + s[1];
            while (s[2].length() < 4) s[2] = "0" + s[2];
            return s[0] + "/" + s[1] + "/" + s[2];
        }

        @Override
        public String toString() {
            return getMaKH() + " " + getTenKH() + " " + sex + " " + address + " " + getBirth();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        KhachHang[] kh = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            kh[i] = new KhachHang(String.valueOf(i+1), sc.nextLine(),
                    sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(kh, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                String[] date1 = o1.getBirth().split("/");
                String[] date2 = o2.getBirth().split("/");
                if(date1[2].equals(date2[2])) {
                    if(date1[1].equals(date2[1])) {
                        return date1[0].compareTo(date2[0]);
                    } else {
                        return date1[1].compareTo(date2[1]);
                    }
                } else {
                    return date1[2].compareTo(date2[2]);
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(kh[i]);
        }
    }
}
