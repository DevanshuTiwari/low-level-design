public class Main {
    public static void main(String[] args) {
        Pizza order = new Margherita();
        System.out.println(order.getDescription() + " " + order.getCost());

        order = new ExtraCheese(order);
        System.out.println(order.getDescription() + " " + order.getCost());
    }
}