import com.sun.source.tree.TryTree;

import java.util.Scanner;

public class J04013_BaiToanTuyenSinh {
    public static class ThiSinh {
        private String maTS, name;
        private double toan, ly, hoa;

        public ThiSinh(String maTS, String name, double toan, double ly, double hoa) {
            this.maTS = maTS;
            this.name = name;
            this.toan = toan;
            this.ly = ly;
            this.hoa = hoa;
        }

        public String getMaTS() {
            return maTS;
        }

        public String getName() {
            return name;
        }

        public double getToan() {
            return toan;
        }

        public double getLy() {
            return ly;
        }

        public double getHoa() {
            return hoa;
        }

        public double getDiemUuTien() {
            String kv = maTS.substring(0,3).toUpperCase();
            switch (kv) {
                case "KV1": {
                    return 0.5f;
                }
                case "KV2": {
                    return 1.0f;
                }
                default: {
                    return 2.5f;
                }
            }
        }

        public double getTongDiem() {
            return toan*2 + ly + hoa;
        }

        public String getTrangThai() {
            if(getDiemUuTien() + getTongDiem() >= 24.0f) {
                return "TRUNG TUYEN";
            }else {
                return "TRUOT";
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThiSinh ts = new ThiSinh(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        int x = (int) ts.getDiemUuTien();
        int y = (int) ts.getTongDiem();
        if(x < ts.getDiemUuTien() && y < ts.getTongDiem()){
            System.out.printf("%s %s %.1f %.1f %s",ts.getMaTS(), ts.getName(), ts.getDiemUuTien(), ts.getTongDiem(), ts.getTrangThai());
        }else if(x == ts.getDiemUuTien() && y < ts.getTongDiem()){
            System.out.printf("%s %s %.0f %.1f %s",ts.getMaTS(), ts.getName(), ts.getDiemUuTien(), ts.getTongDiem(), ts.getTrangThai());
        }else if(x < ts.getDiemUuTien() && y == ts.getTongDiem()){
            System.out.printf("%s %s %.1f %.0f %s",ts.getMaTS(), ts.getName(), ts.getDiemUuTien(), ts.getTongDiem(), ts.getTrangThai());
        }else{
            System.out.printf("%s %s %.0f %.0f %s",ts.getMaTS(), ts.getName(), ts.getDiemUuTien(), ts.getTongDiem(), ts.getTrangThai());
        }
    }
}
