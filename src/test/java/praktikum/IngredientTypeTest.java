package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType type;

    public IngredientTypeTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getFood() {
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE}
        };
    }
    @Test
    public void testGetIngredientType() {
        Ingredient ingredient = new Ingredient(type, "name", 120);
        assertEquals(ingredient.getType(), type);
    }

}
