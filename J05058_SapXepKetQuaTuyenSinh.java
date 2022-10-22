import java.util.*;

public class J05058_SapXepKetQuaTuyenSinh {
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

        public String getMa() {
            return ma;
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

        public double getDiemXetTuyen() {
            return dt * 2 + dl + dh + getDiemUuTien();
        }

        public String getTrangThai() {
            if(getDiemXetTuyen() >= 24) {
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
        List<ThiSinh> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ThiSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()),
                    Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }
        Collections.sort(list, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if(o1.getDiemXetTuyen() < o2.getDiemXetTuyen()) {
                    return 1;
                } else if (o1.getDiemXetTuyen() > o2.getDiemXetTuyen()){
                    return -1;
                } else {
                    return o1.getMa().compareTo(o2.getMa());
                }
            }
        });
        for(ThiSinh x:list){
            System.out.print(x);
            if((int)x.getDiemUuTien()==x.getDiemUuTien()){
                System.out.printf("%.0f ",x.getDiemUuTien());
            }
            else System.out.printf("%.1f ",x.getDiemUuTien());
            if((int)x.getDiemXetTuyen()==x.getDiemXetTuyen()){
                System.out.printf("%.0f ",x.getDiemXetTuyen());
            }
            else {
                System.out.printf("%.1f ",x.getDiemXetTuyen());
            }
            System.out.println(x.getTrangThai());
        }
    }
}