import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07052_DanhSachTrungTuyen {
    public static class ThiSinh {
        private String maTS, tenTS;
        private double toan, ly, hoa;

        public ThiSinh(String maTS, String tenTS, double toan, double ly, double hoa) {
            this.maTS = maTS.trim();
            this.tenTS = tenTS.trim().toLowerCase();
            this.toan = toan;
            this.ly = ly;
            this.hoa = hoa;
        }

        public String getMaTS() {
            return maTS;
        }

        public String getTenTS() {
            String[] s = tenTS.split("[^a-zA-Z]+");
            String ans = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                ans += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            return ans;
        }

        public float getDiemCong() {
            String s = maTS.substring(0,3);
            if(s.equals("KV1")) {
                return 0.5f;
            } else if (s.equals("KV2")) {
                return 1.0f;
            } else {
                return 2.5f;
            }
        }

        public double getDiemTong() {
            return toan*2 + ly + hoa + getDiemCong();
        }

        @Override
        public String toString() {
            int x = (int) getDiemCong();
            int y = (int) getDiemTong();
            if(x < getDiemCong() && y < getDiemTong()){
                return String.format("%s %s %.1f %.1f", maTS, getTenTS(), getDiemCong(), getDiemTong());
            } else if (x == getDiemCong() && y < getDiemTong()) {
                return String.format("%s %s %.0f %.1f", maTS, getTenTS(), getDiemCong(), getDiemTong());
            } else if (x < getDiemCong() && y == getDiemTong()) {
                return String.format("%s %s %.1f %.0f", maTS, getTenTS(), getDiemCong(), getDiemTong());
            } else {
                return String.format("%s %s %.0f %.0f", maTS, getTenTS(), getDiemCong(), getDiemTong());
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<ThiSinh> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ThiSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        int chiTieu = Integer.parseInt(sc.nextLine());
        Collections.sort(list ,new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if(o1.getDiemTong() > o2.getDiemTong()){
                    return -1;
                } else if (o1.getDiemTong() < o2.getDiemTong()) {
                    return 1;
                } else {
                    return o1.getMaTS().compareTo(o2.getMaTS());
                }
            }
        });
        double diemChuan = list.get(chiTieu-1).getDiemTong();
        System.out.printf("%.1f\n", diemChuan);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getDiemTong() >= diemChuan){
                System.out.println(list.get(i) + " TRUNG TUYEN");
            }else {
                System.out.println(list.get(i) + " TRUOT");
            }
        }
    }
}
