import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07018_ChuanHoaDanhSachSinhVien {
    private static class SinhVien {
        private String maSV, tenSV, lopSV, birth;
        private float GPA;

        public SinhVien(String maSV, String tenSV, String lopSV, String birth, float GPA) {
            while(maSV.length() < 3) maSV = "0" + maSV;
            this.maSV = "B20DCCN" + maSV;
            this.tenSV = tenSV.toLowerCase().trim();
            this.lopSV = lopSV;
            this.birth = birth;
            this.GPA = GPA;
        }

        public String getTenSV() {
            String[] temp = tenSV.split("\\s+");
            String name = temp[0].substring(0,1).toUpperCase() + temp[0].substring(1,temp[0].length());
            for (int i = 1; i < temp.length; i++) {
                name += " " + temp[i].substring(0,1).toUpperCase() + temp[i].substring(1,temp[i].length());
            }
            return name;
        }

        public String getBirth() {
            String[] temp = birth.split("/");
            while(temp[0].length() < 2) temp[0] = "0" + temp[0];
            while(temp[1].length() < 2) temp[1] = "0" + temp[1];
            while(temp[2].length() < 4) temp[2] = "0" + temp[2];
            return temp[0] + "/" + temp[1] + "/" + temp[2];
        }

        public String getGPA() {
            return String.format("%.2f", GPA);
        }

        @Override
        public String toString() {
            return maSV + " " + getTenSV() + " " + lopSV + " " + getBirth() + " " + getGPA();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        SinhVien[] sv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien(String.valueOf(i+1), sc.nextLine(), sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(sv[i]);
        }
    }
}
