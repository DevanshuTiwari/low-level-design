import java.util.ArrayList;
import java.util.List;

public class OrderService implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String currentOrderId;
    private String currentStatus;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String eventType, Object data) {
        new ArrayList<>(observers).forEach(o -> o.update(eventType, data));
    }

    public void placeOrder(String orderId, double amount) {
        // 1. Commit the state change
        this.currentOrderId = orderId;
        this.currentStatus = "PLACED";

        System.out.println("[OrderService] Order placed: " + orderId);

        // 2. Fire the event — subject's job ends here
        notifyObservers("ORDER_PLACED", new OrderEvent(orderId, amount, currentStatus));
    }

    public void shipOrder(String orderId) {
        this.currentOrderId = orderId;
        this.currentStatus = "SHIPPED";

        System.out.println("[OrderService] Order shipped: " + orderId);
        notifyObservers("ORDER_SHIPPED", new OrderEvent(orderId, 0, currentStatus));
    }
}
