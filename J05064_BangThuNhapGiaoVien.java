import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05064_BangThuNhapGiaoVien {
    public static class NhanSu {
        private String ma, name;
        private long luongCB;

        public NhanSu(String ma, String name, long luongCB) {
            this.ma = ma;
            this.name = name;
            this.luongCB = luongCB;
        }

        public String getBac() {
            return ma.substring(0,2);
        }

        public int getHeSo() {
            return Integer.parseInt(ma.substring(2,4));
        }

        public long getPhuCap() {
            String bac = ma.substring(0,2);
            switch (bac) {
                case "HT" : {
                    return 2000000;
                }
                case "HP" : {
                    return 900000;
                }
                default: {
                    return 500000;
                }
            }
        }

        public long getLuong() {
            return luongCB * getHeSo() + getPhuCap();
        }

        @Override
        public String toString() {
            return ma + " " + name + " " + getHeSo() + " "
                    + getPhuCap() + " " + getLuong();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<NhanSu> list = new ArrayList<>();
        int ht = 0, hp = 0;
        for (int i = 0; i < n; i++) {
            NhanSu ns = new NhanSu(sc.nextLine(), sc.nextLine(),
                    Long.parseLong(sc.nextLine()));
            if(ns.getBac().equals("HT") && ht < 1) {
                ht++;
                list.add(ns);
            }
            if(ns.getBac().equals("HP") && hp < 2) {
                hp++;
                list.add(ns);
            }
            if(ns.getBac().equals("GV")) {
                list.add(ns);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
