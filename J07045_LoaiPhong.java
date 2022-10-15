import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J07045_LoaiPhong {
    public static class LoaiPhong implements Comparable{
        private String kyHieu, tenPhong, donGia, phiPV;

        public LoaiPhong(String loaiPhong) {
            String[] temp = loaiPhong.split(" ");
            kyHieu = temp[0];
            tenPhong = temp[1];
            donGia = temp[2];
            phiPV = temp[3];
        }

        public String getTenPhong() {
            return tenPhong;
        }

        @Override
        public String toString() {
            return kyHieu + " " + tenPhong + " " + donGia + " " + phiPV;
        }

        @Override
        public int compareTo(Object obj) {
            LoaiPhong phong = (LoaiPhong) obj;
            return tenPhong.compareTo(phong.getTenPhong());
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}
