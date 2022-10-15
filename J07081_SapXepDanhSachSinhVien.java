import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07081_SapXepDanhSachSinhVien {
    public static class SinhVien {
        private String maSV, tenSV, sdt, email;
        private String ho, dem, ten;

        public SinhVien(String maSV, String tenSV, String sdt, String email) {
            this.maSV = maSV;
            this.tenSV = tenSV;
            this.sdt = sdt;
            this.email = email;
            String[] s = tenSV.split(" ");
            this.ho = s[0];
            this.dem = "";
            for (int i = 1; i < s.length-1; i++){
                this.dem += s[i] + " ";
            }
            this.ten = s[s.length-1];
        }

        public String getHo() {
            return ho;
        }

        public String getDem() {
            return dem;
        }

        public String getTen() {
            return ten;
        }

        public String getMaSV() {
            return maSV;
        }

        @Override
        public String toString() {
            return maSV + " " + tenSV + " " + sdt + " " + email;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(sv, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                if(o1.getTen().equals(o2.getTen())) {
                    if(o1.getHo().equals(o2.getHo())) {
                        if(o1.getDem().equals(o2.getDem())) {
                            return o1.getMaSV().compareTo(o2.getMaSV());
                        } else {
                            return o1.getDem().compareTo(o2.getDem());
                        }
                    } else {
                        return o1.getHo().compareTo(o2.getHo());
                    }
                } else {
                    return o1.getTen().compareTo(o2.getTen());
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(sv[i]);
        }
    }
}
