import java.util.Scanner;

public class J05057_BangDiemTuyenSinh {
    private static class ThiSinh {
        private String ma, name;
        private double dt, dl, dh;

        public ThiSinh(String ma, String name, double dt, double dl, double dh) {
            this.ma = ma;
            this.name = name;
            this.dt = dt;
            this.dl = dl;
            this.dh = dh;
        }

        public double getDiemUuTien() {
            switch(ma.substring(0,3)) {
                case "KV1": {
                    return 0.5f;
                }
                case "KV2": {
                    return 1;
                }
                default: {
                    return 2.5f;
                }
            }
        }

        public double getTongDiem() {
            return dt * 2 + dl + dh;
        }

        public String getTrangThai() {
            if(getDiemUuTien() + getTongDiem() >= 24) {
                return "TRUNG TUYEN";
            } else {
                return "TRUOT";
            }
        }

        @Override
        public String toString() {
            return ma + " " + name + " ";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ThiSinh[] ts = new ThiSinh[n];
        for (int i = 0; i < n; i++) {
            ts[i] = new ThiSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ts[i]);
            if((int) ts[i].getDiemUuTien() != ts[i].getDiemUuTien()) {
                System.out.printf("%.1f ", ts[i].getDiemUuTien());
            } else {
                System.out.printf("%.0f ", ts[i].getDiemUuTien());
            }
            if((int) ts[i].getTongDiem() != ts[i].getTongDiem()) {
                System.out.printf("%.1f ", ts[i].getTongDiem());
            } else {
                System.out.printf("%.0f ", ts[i].getTongDiem());
            }
            System.out.println(ts[i].getTrangThai());
        }
    }
}
