import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class J07053_XetTuyen {
    public static class ThiSinh {
        private String name, birth, maTS;
        private double lyThuyet, thucHanh;

        public ThiSinh(String maTS, String name, String birth, double lyThuyet, double thucHanh) {
            this.maTS = maTS;
            this.name = name;
            this.birth = birth;
            this.lyThuyet = lyThuyet;
            this.thucHanh = thucHanh;
        }

        public String getMaTS() {
            while (maTS.length() < 2) maTS = "0" + maTS;
            return "PH" + maTS;
        }

        public String getName() {
            String[] s = name.trim().toLowerCase().split("[^a-zA-Z]+");
            String ans = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                ans += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            return ans;
        }

        public String getYear() {
            String[] s = birth.split("/");
            return s[2];
        }

        public int getTuoi() {
            int year = Integer.parseInt(getYear());
            return 2022 - year - 1;
        }

        public double getDiemThuong() {
            if(lyThuyet >= 8 && thucHanh >= 8){
                return 1.0f;
            } else if (lyThuyet >= 7.5f && thucHanh >= 7.5f) {
                return 0.5f;
            } else {
                return 0;
            }
        }

        public int getDiemTB() {
            int diem = Math.toIntExact(Math.round((lyThuyet + thucHanh) / 2 + getDiemThuong()));
            if(diem > 10) {
                return 10;
            }else {
                return diem;
            }
        }

        public String getXepLoai() {
            if(getDiemTB() < 5) {
                return "Truot";
            } else if (getDiemTB() < 7) {
                return "Trung binh";
            } else if (getDiemTB() < 8) {
                return "Kha";
            } else if (getDiemTB() < 9){
                return "Gioi";
            } else {
                return "Xuat sac";
            }
        }

        @Override
        public String toString() {
            return getMaTS() + " " + getName() + " " + getTuoi() + " " + getDiemTB() + " " + getXepLoai();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ThiSinh[] ts = new ThiSinh[n];
        for (int i = 0; i < n; i++) {
            ts[i] = new ThiSinh(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ts[i]);
        }
    }
}
