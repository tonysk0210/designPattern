package factory;

public class Main {
    static void main(String[] args) {
        Shape s = ShapeFactory.create("circle"); // 不直接 new Circle()
        s.draw();
    }
}
