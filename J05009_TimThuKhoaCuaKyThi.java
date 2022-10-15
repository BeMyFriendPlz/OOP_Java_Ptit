import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05009_TimThuKhoaCuaKyThi {
    public static class ThiSinh {
        private String ma, name, birth;
        private double d1, d2, d3;

        public ThiSinh(String ma, String name, String birth, double d1, double d2, double d3) {
            this.ma = ma;
            this.name = name;
            this.birth = birth;
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
        }

        public String getMa() {
            return ma;
        }

        public String getDiem(){
            return String.format("%.1f", d1 + d2 + d3);
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + birth + " " + getDiem();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ThiSinh[] ts = new ThiSinh[n];
        for (int i = 0; i < n; i++) {
            ts[i] = new ThiSinh(String.valueOf(i+1), sc.nextLine(), sc.nextLine(),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()));
        }
        Arrays.sort(ts, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if(o1.getDiem().equals(o2.getDiem())) {
                    return o1.getMa().compareTo(o2.getMa());
                }else {
                    return -o1.getDiem().compareTo(o2.getDiem());
                }
            }
        });
        System.out.println(ts[0]);
        for (int i = 1; i < n; i++) {
            if(ts[i].getDiem().equals(ts[i-1].getDiem())) {
                System.out.println(ts[i]);
            } else {
                break;
            }
        }
    }
}
