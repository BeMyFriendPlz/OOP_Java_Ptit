import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class J07072_ChuanHoaVaSapXep {
    public static class DanhSach {
        private String name, ho, dem, ten;

        public DanhSach(String name) {
            setName(name);
            String[] s = this.name.split("[^a-zA-Z]+");
            this.ho = s[0];
            for (int i = 1; i < s.length-1; i++) {
                this.dem += s[i] + " ";
            }
            this.ten = s[s.length-1];
        }

        public void setName(String name) {
            String[] s = name.trim().toLowerCase().split("[^a-zA-Z]+");
            String ans = s[0].substring(0,1).toUpperCase() + s[0].substring(1,s[0].length());
            for (int i = 1; i < s.length; i++) {
                ans += " " + s[i].substring(0,1).toUpperCase() + s[i].substring(1,s[i].length());
            }
            this.name = ans;
        }

        public String getName() {
            return name;
        }

        public String getHo() {
            return ho;
        }

        public String getDem() {
            return dem;
        }

        public String getTen() {
            return ten;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        List<DanhSach> list = new ArrayList<>();
        while(sc.hasNextLine()) {
            list.add(new DanhSach(sc.nextLine()));
        }
        Collections.sort(list, new Comparator<DanhSach>() {
            @Override
            public int compare(DanhSach o1, DanhSach o2) {
                if(o1.getTen().compareTo(o2.getTen()) != 0) {
                    return o1.getTen().compareTo(o2.getTen());
                } else {
                    if(o1.getHo().compareTo(o2.getHo()) != 0) {
                        return o1.getHo().compareTo(o2.getHo());
                    } else {
                        return o1.getDem().compareTo(o2.getDem());
                    }
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }
}

