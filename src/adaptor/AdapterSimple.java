package adaptor;

// 儲存為 AdapterSimple.java
interface Printer {                      // Target：新系統期望的介面
    void print(String msg);
}

class LegacyPrinter {                    // Adaptee：舊類別，介面不相容
    void oldPrint(String text) {
        System.out.println("[Legacy] " + text);
    }
}

class PrinterAdapter implements Printer { // Adapter：轉接頭
    private final LegacyPrinter legacy = new LegacyPrinter();

    @Override
    public void print(String msg) {
        legacy.oldPrint(msg);            // 把新介面的呼叫轉到舊方法
    }
}

public class AdapterSimple {             // Client：只面向新介面
    public static void main(String[] args) {
        Printer printer = new PrinterAdapter();
        printer.print("Hello Adapter!");
    }
}

