import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class J07059_DanhSachCaThi {
    public static class CaThi {
        private String maThi;
        private Date time;
        private String phongThi;
        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        public CaThi(String maThi, String date, String time, String phongThi) throws ParseException {
            this.maThi = maThi;
            this.time = dateFormat.parse(date + " " + time);
            this.phongThi = phongThi;
        }

        public String getMaThi() {
            while (maThi.length() < 3) maThi = "0" + maThi;
            return "C" + maThi;
        }

        public Date getTime() {
            return time;
        }

        @Override
        public String toString() {
            return getMaThi() + " " + dateFormat.format(time) + " " + phongThi;
        }
    }

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        int n = Integer.parseInt(sc.nextLine());
        CaThi[] ct = new CaThi[n];
        for (int i = 0; i < n; i++) {
            ct[i] = new CaThi(String.valueOf(i+1), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        Arrays.sort(ct, new Comparator<CaThi>() {
            @Override
            public int compare(CaThi o1, CaThi o2) {
                if(o1.getTime().compareTo(o2.getTime()) == 0){
                    return o1.getMaThi().compareTo(o2.getMaThi());
                } else {
                    return o1.getTime().compareTo(o2.getTime());
                }
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(ct[i]);
        }
    }
}
