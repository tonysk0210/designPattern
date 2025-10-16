package command;

// 命令介面
interface Command {
    void execute();
}

// 接收者：真正做事的對象
class Light {
    public void on() {
        System.out.println("💡 燈打開了");
    }

    public void off() {
        System.out.println("💡 燈關掉了");
    }
}

// 具體命令類別
class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

// Invoker：遙控器
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// 測試
public class CommandDemo {
    public static void main(String[] args) {
        Light light = new Light();                   // Receiver
        Command lightOn = new LightOnCommand(light); // Command
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();  // Invoker
        remote.setCommand(lightOn);
        remote.pressButton();   // 💡 燈打開了

        remote.setCommand(lightOff);
        remote.pressButton();   // 💡 燈關掉了
    }
}
