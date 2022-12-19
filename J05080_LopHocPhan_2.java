import java.util.*;

public class J05080_LopHocPhan_2 {
    public static class LopHoc {
        private String maMH, tenMH, nhomLop, tenGV;

        public LopHoc(String maMH, String tenMH, String nhomLop, String tenGV) {
            this.maMH = maMH;
            this.tenMH = tenMH;
            this.nhomLop = nhomLop;
            this.tenGV = tenGV;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<LopHoc> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new LopHoc(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(list, new Comparator<LopHoc>() {
            @Override
            public int compare(LopHoc o1, LopHoc o2) {
                if(o1.maMH.equals(o2.maMH)) {
                    return o1.nhomLop.compareTo(o2.nhomLop);
                } else {
                    return o1.maMH.compareTo(o2.maMH);
                }
            }
        });
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine();
            System.out.println("Danh sach cho giang vien " + s + ":");
            for (LopHoc i : list) {
                if(i.tenGV.equals(s)) {
                    System.out.println(i.maMH + " " + i.tenMH + " " + i.nhomLop);
                }
            }
        }
    }
}
