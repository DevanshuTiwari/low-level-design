public class ChicagoIngredientFactory implements PizzaIngredientFactory {
    @Override
    public String createDough() {
        return "Thick Crust Dough";
    }

    @Override
    public String createSauce() {
        return "Plum Tomato Sauce";
    }

    @Override
    public String createCheese() {
        return "Mozzarella Cheese";
    }
}
