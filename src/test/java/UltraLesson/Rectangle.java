package UltraLesson;


public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
       this.length = length;
       this.width = width;
    }
    public int calculateArea() {
        int area = length * width;
        return area;
    }
    public int getLength()
    {
        return length;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2,3);
        Rectangle rectangle1 = new Rectangle(4,5);
        System.out.println(rectangle1.calculateArea());
        System.out.println(rectangle1.getLength());
    }
}
