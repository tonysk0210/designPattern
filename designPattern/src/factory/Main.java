package factory;

public class Main {
    public static void main(String[] args) {
        Shape s = ShapeFactory.create("circle"); // 不直接 new Circle()
        s.draw();

        ShapeFactory s2 = new ShapeFactory();

        System.out.println(s);
        System.out.println(s2);

        var x = new Circle();
    }
}
