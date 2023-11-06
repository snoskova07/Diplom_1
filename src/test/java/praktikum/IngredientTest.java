package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


public class IngredientTest {
    IngredientType type = IngredientType.FILLING;
    String name = "булочка с кунжутом";
    float price = 100;

    @Test
    public void testGetIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.getName(), name);
    }

    @Test
    public void testGetIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(ingredient.getPrice(), price, 0);
    }

}
