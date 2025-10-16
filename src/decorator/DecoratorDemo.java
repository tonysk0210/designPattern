package decorator;

// Component：定義共同介面
interface Coffee {
    String getDescription();

    double cost();
}

// ConcreteComponent：基本咖啡
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "黑咖啡";
    }

    public double cost() {
        return 50;
    }
}

// Decorator：抽象裝飾者
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee coffee; // 被裝飾的對象

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// 具體裝飾者：加奶
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + 牛奶";
    }

    public double cost() {
        return coffee.cost() + 10;
    }
}

// 具體裝飾者：加糖
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + 糖";
    }

    public double cost() {
        return coffee.cost() + 5;
    }
}

// 測試
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();              // 黑咖啡
        System.out.println(coffee.getDescription() + "：" + coffee.cost() + "元");

        coffee = new MilkDecorator(coffee);              // 加奶
        System.out.println(coffee.getDescription() + "：" + coffee.cost() + "元");

        coffee = new SugarDecorator(coffee);             // 再加糖
        System.out.println(coffee.getDescription() + "：" + coffee.cost() + "元");
    }
}

/*
          ┌─────────────────────────┐
          │       <<interface>>     │
          │         Coffee          │
          │────────────────────────│
          │ + getDescription():String│
          │ + cost(): double         │
          └──────────▲──────────────┘
                     │
        ┌────────────┼────────────┐
        │                           │
┌──────────────────────┐  ┌─────────────────────────┐
│   SimpleCoffee        │  │   CoffeeDecorator (abstract) │
│──────────────────────│  │────────────────────────│
│ + getDescription()    │  │ - coffee: Coffee       │
│ + cost()              │  │────────────────────────│
│ (基本黑咖啡功能)      │  │ + getDescription():String│
└──────────────────────┘  │ + cost(): double        │
                          └──────────▲─────────────┘
                                     │
                   ┌─────────────────┴─────────────────┐
                   │                                   │
       ┌────────────────────────┐         ┌────────────────────────┐
       │   MilkDecorator         │         │   SugarDecorator        │
       │────────────────────────│         │────────────────────────│
       │ + getDescription()      │         │ + getDescription()      │
       │ + cost()                │         │ + cost()                │
       │ (在原咖啡上加牛奶)      │         │ (在原咖啡上加糖)        │
       └────────────────────────┘         └────────────────────────┘
* */