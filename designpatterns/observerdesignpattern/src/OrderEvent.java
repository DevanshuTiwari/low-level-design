import java.time.LocalDateTime;

public class OrderEvent {
    private final String orderId;
    private final double amount;
    private final String status;
    private final LocalDateTime timestamp;

    public OrderEvent(String orderId, double amount, String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "OrderEvent{orderId='" + orderId + "', status='" + status +
                "', amount=" + amount + ", at=" + timestamp + "}";
    }
}