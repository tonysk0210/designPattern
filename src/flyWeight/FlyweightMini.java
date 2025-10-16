package flyWeight;

// 儲存為 FlyweightMini.java

import java.util.*;

class IconType {                 // 享元：可共用的、不變的狀態
    final String name;

    IconType(String name) {
        this.name = name;
    }

    void draw(int x, int y) {
        System.out.println("畫 " + name + " 在 (" + x + "," + y + ")");
    }
}

class IconFactory {              // 享元工廠：負責共用與重用
    private static final Map<String, IconType> cache = new HashMap<>();

    static IconType get(String name) {
        return cache.computeIfAbsent(name, IconType::new); // 沒有就建，有就重用
    }
}

class Icon {                     // 環境物件：保存可變狀態（位置）
    final int x, y;
    final IconType type;         // 指向共用的享元

    Icon(int x, int y, IconType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    void draw() {
        type.draw(x, y);
    }
}

public class FlyweightMini {
    public static void main(String[] args) {
        IconType file = IconFactory.get("File");
        IconType folder = IconFactory.get("Folder");

        Icon a = new Icon(1, 2, file);     // 共用 "File"
        Icon b = new Icon(3, 4, file);     // 共用 "File"
        Icon c = new Icon(5, 6, folder);   // 共用 "Folder"

        a.draw();
        b.draw();
        c.draw();
    }
}
