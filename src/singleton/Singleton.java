package singleton;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {
    // volatile 防止指令重排序（確保建立物件的可見性與完整性）
    private static volatile Singleton instance;

    private Singleton() {
        // 私有建構子，防止外部 new
    }

    public static Singleton getInstance() {
        if (instance == null) { // 第一次檢查（不用鎖）
            synchronized (Singleton.class) { // 加鎖確保執行緒安全
                if (instance == null) { // 第二次檢查（防止重複建立）
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 核心：反序列化時改回傳既有單例，避免產生新物件
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}

enum EnumSingleton {
    INSTANCE;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

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
