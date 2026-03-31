public class Main {

    public static void buildPizza(PizzaIngredientFactory ingredientFactory) {
        String dough = ingredientFactory.createDough();
        String sauce = ingredientFactory.createSauce();
        String cheese = ingredientFactory.createCheese();

        System.out.println("Assembled pizza with: " + dough + ", " + sauce + ", " + cheese);
    }

    public static void main(String[] args) {
        PizzaIngredientFactory nyFactory = new NYIngredientFactory();
        buildPizza(nyFactory);
    }
}