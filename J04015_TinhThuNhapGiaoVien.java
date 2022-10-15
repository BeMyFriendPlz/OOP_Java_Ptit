import java.util.Scanner;

public class J04015_TinhThuNhapGiaoVien {
    public static class GiaoVien {
        private String maNgach;
        private String name;
        private String chuVu;
        private long coBan;
        private int heSo;
        private long bonus;

        public GiaoVien(String maNgach, String name, long coBan) {
            this.maNgach = maNgach;
            this.name = name;
            this.chuVu = maNgach.substring(0,2);
            switch (this.chuVu){
                case "HT": {
                    this.bonus = 2000000;
                    break;
                }
                case "HP": {
                    this.bonus = 900000;
                    break;
                }
                default: {
                    this.bonus = 500000;
                    break;
                }
            }
            this.heSo = Integer.parseInt(maNgach.substring(2,4));
            this.coBan = coBan;
        }

        public long Luong() {
            return this.coBan * this.heSo + this.bonus;
        }

        @Override
        public String toString() {
            return maNgach + " " + name + " " + heSo + " " +
                    bonus + " " + Luong();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GiaoVien gv = new GiaoVien(sc.nextLine(), sc.nextLine(), sc.nextLong());
        System.out.println(gv);
    }
}
