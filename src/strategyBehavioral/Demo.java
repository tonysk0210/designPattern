package strategyBehavioral;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("使用信用卡付款：" + amount + " 元");
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("使用現金付款：" + amount + " 元");
    }
}

class ShoppingCart {
    void checkout(PaymentStrategy strategy) {
        strategy.pay(100);
    }
}

public class Demo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.checkout(new CreditCardPayment());
        cart.checkout(new CashPayment());
    }
}
