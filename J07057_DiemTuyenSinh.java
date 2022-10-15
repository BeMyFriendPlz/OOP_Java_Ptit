import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J07057_DiemTuyenSinh {
    public static class ThiSinh {
        private String ma, name, danToc, khuVuc;
        private double diemThi;

        public ThiSinh(String ma, String name, double diemThi, String danToc, String khuVuc) {
            this.ma = ma;
            this.name = name;
            this.danToc = danToc;
            this.khuVuc = khuVuc;
            this.diemThi = diemThi;
        }

        public String getMa() {
            while (ma.length() < 2) ma = "0" + ma;
            return "TS" + ma;
        }

        public String getName() {
            String[] s = name.trim().toLowerCase().split("[^a-zA-Z]+");
            String ans = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                ans += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            return ans;
        }

        public double getTongDiem() {
            double diem = 0;
            switch (khuVuc){
                case "1": {
                    diem += 1.5f;
                    break;
                }
                case "2": {
                    diem += 1;
                    break;
                }
                default: {
                    break;
                }
            }
            if(!danToc.equals("Kinh")) {
                diem += 1.5f;
            }
            return diem + diemThi;
        }

        public String getTrangThai() {
            if(getTongDiem() >= 20.5f){
                return "Do";
            }else {
                return "Truot";
            }
        }

        @Override
        public String toString() {
            return getMa() + " " + getName() + " " +
                    getTongDiem() + " " + getTrangThai();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine());
        ThiSinh[] ts = new ThiSinh[n];
        for (int i = 0; i < n; i++) {
            ts[i] = new ThiSinh(String.valueOf(i+1), sc.nextLine(),
                    Double.parseDouble(sc.nextLine()), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(ts, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if(o1.getTongDiem() > o2.getTongDiem()){
                    return -1;
                }else if(o1.getTongDiem() < o2.getTongDiem()){
                    return 1;
                }else {
                    return o1.getMa().compareTo(o2.getMa());
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(ts[i]);
        }
    }
}
