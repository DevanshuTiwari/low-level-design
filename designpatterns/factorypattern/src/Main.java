public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        nyStore.orderPizza();

        PizzaStore chicagoStore = new ChicagoPizzaStore();
        chicagoStore.orderPizza();
    }
}