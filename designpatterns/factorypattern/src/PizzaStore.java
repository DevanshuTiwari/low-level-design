public abstract class PizzaStore {

    public Pizza orderPizza() {
        Pizza pizza = createPizza();
        pizza.prepare();
        return pizza;
    }

    protected abstract Pizza createPizza();
}
