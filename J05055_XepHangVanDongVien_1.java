import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class J05055_XepHangVanDongVien_1 {
    public static class ThiSinh {
        private String ma, name, birth;
        private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        private Date start, end;
        private int xepHang;

        public ThiSinh(String ma, String name, String birth, String start, String end) throws ParseException {
            if(ma.length() < 2) ma = "0" + ma;
            this.ma = "VDV" + ma;
            this.name = name;
            this.birth = birth;
            this.start = format.parse(start);
            this.end = format.parse(end);
            this.xepHang = 0;
        }

        public void setXepHang(int xepHang) {
            this.xepHang = xepHang;
        }

        public int getXepHang() {
            return xepHang;
        }

        public int getTuoi() {
            return 2022 - Integer.parseInt(birth.substring(6,10)) - 1;
        }

        public Date getThucTe() throws ParseException {
            long secs = (end.getTime() - start.getTime()) / 1000;
            return format.parse(String.format("%02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, (secs % 60)));
        }

        public Date getUuTien() throws ParseException {
            if(getTuoi() < 18) {
                return format.parse("00:00:00");
            } else if (getTuoi() < 25) {
                return format.parse("00:00:01");
            } else if (getTuoi() < 32) {
                return format.parse("00:00:02");
            } else {
                return format.parse("00:00:03");
            }
        }

        public Date getThanhTich() throws ParseException {
            long secs = (getThucTe().getTime() - getUuTien().getTime()) / 1000;
            return format.parse(String.format("%02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, (secs % 60)));
        }

        @Override
        public String toString() {
            try {
                return ma + " " + name + " " + format.format(getThucTe()) + " " +
                        format.format(getUuTien()) + " " + format.format(getThanhTich()) + " " + xepHang;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ThiSinh[] ts = new ThiSinh[n];
        for (int i = 0; i < n; i++) {
            ts[i] = new ThiSinh(String.valueOf(i+1), sc.nextLine(),
                    sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        List<ThiSinh> list = new ArrayList<>(Arrays.asList(ts));
        Collections.sort(list, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                try {
                    return o1.getThanhTich().getTime() > o2.getThanhTich().getTime() ? 1:-1;
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        int xepHang = 1;
        list.get(0).setXepHang(1);
        for (int i = 1; i < n; i++) {
            while (i < n && list.get(i).getThanhTich().getTime() == list.get(i-1).getThanhTich().getTime()) {
                list.get(i).setXepHang(list.get(i-1).getXepHang());
                i++;
                xepHang++;
            }
            if(i == n) break;
            xepHang++;
            list.get(i).setXepHang(xepHang);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ts[i]);
        }
    }
}
