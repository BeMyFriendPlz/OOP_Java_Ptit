import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07073_DangKyHinhThucGiangDay {
    public static class MonHoc {
        private String maMH, tenMH, lyThuyet, thucHanh;
        private int tinChi;

        public MonHoc(String maMH, String tenMH,int tinChi, String lyThuyet, String thucHanh) {
            this.maMH = maMH;
            this.tenMH = tenMH;
            this.tinChi = tinChi;
            this.lyThuyet = lyThuyet;
            this.thucHanh = thucHanh;
        }

        public String getMaMH() {
            return maMH;
        }

        public String getThucHanh() {
            return thucHanh;
        }

        @Override
        public String toString() {
            return maMH + " " + tenMH + " " + tinChi + " " + lyThuyet + " " + thucHanh;
        }
    }

    public static boolean KiemTraThucHanh(String hinhThuc) {
        if(hinhThuc.equals("Truc tuyen")) {
            return true;
        } else if(hinhThuc.length() > 12) {
            String s = hinhThuc.substring(hinhThuc.length() - 12 ,hinhThuc.length());
            if(s.equals(".ptit.edu.vn")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        MonHoc[] mh = new MonHoc[n];
        for (int i = 0; i < n; i++) {
            mh[i] = new MonHoc(sc.nextLine(), sc.nextLine(),
                    Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(mh, new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                return o1.getMaMH().compareTo(o2.getMaMH());
            }
        });
        for (int i = 0; i < n; i++) {
            if(KiemTraThucHanh(mh[i].getThucHanh())) {
                System.out.println(mh[i]);
            }
        }
    }
}
