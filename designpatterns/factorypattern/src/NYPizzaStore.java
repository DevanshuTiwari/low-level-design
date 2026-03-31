public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza() {
        return new NYCheesePizza();
    }
}
