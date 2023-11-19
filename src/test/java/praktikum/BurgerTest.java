package praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredient1Mock;
    @Mock
    Ingredient ingredient2Mock;

    @Test
    public void
    testSetBuns() {
        Burger burger = new Burger();
        Bun bun = new Bun("Булочка с кунжутом", 50);
        burger.setBuns(bun);
    }

    @Test
    public void
    testAddIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "варенье", 20);
        burger.addIngredient(ingredient);
    }

    @Test
    public void
    testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1Mock);
        burger.removeIngredient(0);
    }

    @Test
    public void
    testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1Mock);
        burger.addIngredient(ingredient2Mock);
        burger.moveIngredient(0, 1);
    }

    @Test
    public void
    testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient1Mock);
        burger.addIngredient(ingredient2Mock);
        Mockito.when(bunMock.getPrice()).thenReturn(50F);
        Mockito.when(ingredient1Mock.getPrice()).thenReturn(20F);
        Mockito.when(ingredient2Mock.getPrice()).thenReturn(10F);
        Assert.assertEquals(130F,  burger.getPrice(), 0);
    }

    @Test
    public void
    testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient1Mock);
        burger.addIngredient(ingredient2Mock);

        Mockito.when(bunMock.getName()).thenReturn("Булочка московская");
        Mockito.when(ingredient1Mock.getName()).thenReturn("Варенье");
        Mockito.when(ingredient1Mock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2Mock.getName()).thenReturn("Тар-тар");
        Mockito.when(ingredient2Mock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bunMock.getPrice()).thenReturn(50F);
        Mockito.when(ingredient1Mock.getPrice()).thenReturn(20F);
        Mockito.when(ingredient2Mock.getPrice()).thenReturn(10F);
        Assert.assertEquals(String.format("(==== Булочка московская ====)%n" +
                "= filling Варенье =%n" +
                "= sauce Тар-тар =%n" +
                "(==== Булочка московская ====)%n" +
                "%n" +
                "Price: 130,000000%n"), burger.getReceipt());
    }


}
