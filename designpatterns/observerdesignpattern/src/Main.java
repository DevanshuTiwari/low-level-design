public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.registerObserver(new EmailNotificationObserver("abc@example.com"));

        System.out.println("-----Placing Order-----");
        orderService.placeOrder("1", 499.73);

        System.out.println("-----Shipping Order-----");
        orderService.shipOrder("1");
    }
}