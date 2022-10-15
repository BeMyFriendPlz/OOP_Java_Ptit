import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07010_DanhSachSinhVienTrongFile_2 {
    public static class SinhVien {
        private String maSV;
        private String name;
        private String maLop;
        private String birth;
        private double GPA;

        public SinhVien(String maSV, String name, String maLop, String birth, double GPA) {
            this.maSV = maSV;
            this.name = name;
            this.maLop = maLop;
            this.birth = birth;
            this.GPA = GPA;
        }

        public String getMaSV() {
            while (maSV.length() < 3) maSV = "0" + maSV;
            maSV = "B20DCCN" + maSV;
            return maSV;
        }

        public String getName() {
            return name;
        }

        public String getMaLop() {
            return maLop;
        }

        public String getBirth() {
            String[] s = this.birth.split("/");
            while (s[0].length() < 2) s[0] = "0" + s[0];
            while (s[1].length() < 2) s[1] = "0" + s[1];
            while (s[2].length() < 4) s[2] = "0" + s[2];
            return s[0] + "/" + s[1] + "/" + s[2];
        }

        public Double getGPA() {
            return GPA;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SV.in"));
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(String.valueOf(i+1), sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%s %s %s %s %.2f\n", sv[i].getMaSV(), sv[i].getName(), sv[i].getMaLop(), sv[i].getBirth(), sv[i].getGPA());
        }
    }
}
