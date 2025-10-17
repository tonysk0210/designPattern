package proxy;

public class Main {
    public static void main(String[] args) {
        Image image = new ImageProxy("high-res-photo.png");

        image.display();
        System.out.println("---");
        image.display();
    }
}
