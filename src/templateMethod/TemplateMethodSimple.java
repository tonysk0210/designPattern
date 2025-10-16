package templateMethod;

// 儲存為 TemplateMethodSimple.java
abstract class Game {
    // 模板方法：定義遊戲的固定流程
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    protected abstract void initialize();

    protected abstract void startPlay();

    protected abstract void endPlay();
}

// 具體子類 1
class Football extends Game {
    protected void initialize() {
        System.out.println("Football Game Initialized!");
    }

    protected void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    protected void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

// 具體子類 2
class Basketball extends Game {
    protected void initialize() {
        System.out.println("Basketball Game Initialized!");
    }

    protected void startPlay() {
        System.out.println("Basketball Game Started. Have fun!");
    }

    protected void endPlay() {
        System.out.println("Basketball Game Finished!");
    }
}

// 測試主程式
public class TemplateMethodSimple {
    public static void main(String[] args) {
        Game game1 = new Football();
        game1.play();

        System.out.println();

        Game game2 = new Basketball();
        game2.play();
    }
}
