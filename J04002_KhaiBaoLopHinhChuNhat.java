import java.util.Scanner;

public class J04002_KhaiBaoLopHinhChuNhat {
    public static class Rectangle {
        private double width;
        private double height;
        private String color;

        public Rectangle() {
            this.width = 1;
            this.height = 1;
        }

        public Rectangle(double width, double height, String color) {
            this.width = width;
            this.height = height;
            this.color = color;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public String getColor() {
            String temp = color.toLowerCase();
            temp = temp.substring(0,1).toUpperCase() + temp.substring(1,temp.length());
            return temp;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double findArea(){
            return this.height * this.width;
        }

        public double findPerimeter(){
            return (this.height + this.width) * 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        String color = sc.next();
        if(width <= 0 || height <= 0){
            System.out.print("INVALID");
        }else {
            Rectangle rectangle = new Rectangle(width, height, color);
            System.out.printf("%d %d %s",(int) rectangle.findPerimeter(),(int) rectangle.findArea(), rectangle.getColor());
        }
    }
}
