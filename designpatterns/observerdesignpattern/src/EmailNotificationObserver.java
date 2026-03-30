public class EmailNotificationObserver implements Observer {
    private final String recipientEmail;

    public EmailNotificationObserver(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    @Override
    public void update(String eventType, Object data) {
        if ("ORDER_PLACED".equals(eventType) && data instanceof OrderEvent event) {
            System.out.printf("[EmailObserver] Sending email to %s → Order %s confirmed. Amount: ₹%.2f%n",
                    recipientEmail, event.getOrderId(), event.getAmount());
        }
    }
}
