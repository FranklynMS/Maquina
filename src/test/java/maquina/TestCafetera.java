package maquina;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCafetera {

    @Test
    public void deberiaDevolverVerdaderoSiHayCafe() {
        Cafetera cafetera = new Cafetera(10);
        assertTrue(cafetera.hasCafe(5));
    }

    @Test
    public void deberiaDevolverFalsoSiNoHaySuficienteCafe() {
        Cafetera cafetera = new Cafetera(10);
        assertFalse(cafetera.hasCafe(11));
    }

    @Test
    public void deberiaRestarCantidadDeCafe() {
        Cafetera cafetera = new Cafetera(10);
        cafetera.giveCafe(7);
        assertEquals(3, cafetera.getCantidadCafe());
    }
}
