import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07033_DanhSachSinhVienTrongFile_1 {
    public static class SinhVien {
        private String maSV;
        private String name;
        private String lop;
        private String email;

        public SinhVien(String maSV, String name, String lop, String email) {
            this.maSV = maSV;
            this.name = name;
            this.lop = lop;
            this.email = email;
        }

        public String getMaSV() {
            return maSV;
        }

        public String getName() {
            String[] temp = name.toLowerCase().trim().split("[^a-zA-Z]+");
            String ans = "";
            for (int i = 0; i < temp.length; i++) {
                ans += temp[i].substring(0,1).toUpperCase() + temp[i].substring(1,temp[i].length()) + " ";
            }
            ans = ans.substring(0,ans.length());
            return ans;
        }

        public String getLop() {
            return this.lop;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return getMaSV() + " " + getName() + " " + getLop() + " " + getEmail();
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
                return o1.getMaSV().compareTo(o2.getMaSV());
            }
        });
        for (int i = 0; i < sv.length; i++) {
            System.out.println(sv[i]);
        }
    }
}