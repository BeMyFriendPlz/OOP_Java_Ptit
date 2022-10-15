import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J05025_SapXepDanhSachGiangVien {
    public static class GiangVien {
        private String ma, name, nganh;

        public GiangVien(String ma, String name, String nganh) {
            while (ma.length() < 2) ma = "0" + ma;
            this.ma = "GV" + ma;
            this.name = name;
            this.nganh = "";
            String[] s = nganh.toUpperCase().split(" ");
            for (int i = 0; i < s.length; i++) {
                this.nganh += s[i].charAt(0);
            }
        }

        public String getMa() {
            return ma;
        }

        public String getTen() {
            String[] s = name.split(" ");
            return s[s.length-1];
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + nganh;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        GiangVien[] gv = new GiangVien[n];
        for (int i = 0; i < n; i++) {
            gv[i] = new GiangVien(String.valueOf(i+1), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(gv, new Comparator<GiangVien>() {
            @Override
            public int compare(GiangVien o1, GiangVien o2) {
                if(o1.getTen().equals(o2.getTen())){
                    return o1.getMa().compareTo(o2.getMa());
                } else {
                    return o1.getTen().compareTo(o2.getTen());
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(gv[i]);
        }
    }
}
