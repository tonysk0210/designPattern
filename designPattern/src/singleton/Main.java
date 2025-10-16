package singleton;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("main inside Singleton");

        var s1 = Singleton.getInstance();
        // 序列化
        try (var out = new java.io.ObjectOutputStream(new java.io.FileOutputStream("s.obj"))) {
            out.writeObject(s1);
        }
        // 反序列化
        Singleton s2;
        try (var in = new java.io.ObjectInputStream(new java.io.FileInputStream("s.obj"))) {
            s2 = (Singleton) in.readObject();
        }
        System.out.println(s1 == s2); // 若有 readResolve() -> true

        //singleton enum
        var s3 = EnumSingleton.INSTANCE;
        System.out.println(s3.getName());
        s3.setName("Anthony");
        System.out.println(s3.getName());

    }
}