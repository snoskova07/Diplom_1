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
        float bunPrice = 50F;
        float expectedPrice = 100F;
        Burger burger = new Burger();
        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        burger.setBuns(bunMock);
        Assert.assertEquals(expectedPrice,  burger.getPrice(), 0);
    }

    @Test
    public void
    testGetPrice() {
        float bunPrice = 50F;
        float ingredient1Price = 20F;
        float ingredient2Price = 10F;
        float expectedPrice = 130F;
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient1Mock);
        burger.addIngredient(ingredient2Mock);
        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient1Mock.getPrice()).thenReturn(ingredient1Price);
        Mockito.when(ingredient2Mock.getPrice()).thenReturn(ingredient2Price);
        Assert.assertEquals(expectedPrice,  burger.getPrice(), 0);
    }

    @Test
    public void
    testGetReceipt() {
        float bunPrice = 50F;
        float ingredient1Price = 20F;
        float ingredient2Price = 10F;
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredient1Mock);
        burger.addIngredient(ingredient2Mock);

        Mockito.when(bunMock.getName()).thenReturn("Булочка московская");
        Mockito.when(ingredient1Mock.getName()).thenReturn("Варенье");
        Mockito.when(ingredient1Mock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2Mock.getName()).thenReturn("Тар-тар");
        Mockito.when(ingredient2Mock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient1Mock.getPrice()).thenReturn(ingredient1Price);
        Mockito.when(ingredient2Mock.getPrice()).thenReturn(ingredient2Price);
        Assert.assertEquals(String.format("(==== Булочка московская ====)%n" +
                "= filling Варенье =%n" +
                "= sauce Тар-тар =%n" +
                "(==== Булочка московская ====)%n" +
                "%n" +
                "Price: 130,000000%n"), burger.getReceipt());
    }

}
