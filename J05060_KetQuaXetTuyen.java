import java.util.Scanner;

public class J05060_KetQuaXetTuyen {
    public static class ThiSinh {
        private String ma, name, birth;
        private double diemlt, diemth;

        public ThiSinh(String ma, String name, String birth, double diemlt, double diemth) {
            if(ma.length() < 2) ma ="0" + ma;
            this.ma = "PH" + ma;
            this.name = name;
            this.birth = birth;
            this.diemlt = diemlt;
            this.diemth = diemth;
        }

        public double getDiemThuong() {
            if(diemlt >= 8 && diemth >= 8) {
                return 1;
            } else if (diemlt >= 7.5f && diemth >= 7.5f) {
                return 0.5f;
            } else {
                return 0;
            }
        }

        public int getTongDiem() {
            double diem = Math.round(((diemlt + diemth)/ 2) + getDiemThuong());
            if(diem > 10) {
                return 10;
            } else {
                return (int) diem;
            }
        }

        public String getXepLoai() {
            if(getTongDiem() < 5) {
                return "Truot";
            } else if (getTongDiem() <= 6) {
                return "Trung binh";
            } else if (getTongDiem() == 7) {
                return "Kha";
            } else if (getTongDiem() == 8) {
                return "Gioi";
            } else {
                return "Xuat sac";
            }
        }

        public int getTuoi() {
            int nam = Integer.parseInt(birth.substring(6,10));
            return 2022 - nam - 1;
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + getTuoi() + " " +
                    getTongDiem() + " " + getXepLoai();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
