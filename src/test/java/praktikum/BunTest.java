package praktikum;
import praktikum.Bun;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class BunTest {
    String name = "Булочка с кунжутом";
    float price = 50;
    @Test
    public void testGetName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(bun.getPrice(), price, 0);
    }

}
