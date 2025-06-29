package maquina;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVaso {

    @Test
    public void deberiaDevolverVerdaderoSiHaySuficientesVasos() {
        Vaso vaso = new Vaso(2, 10);
        assertTrue(vaso.hasVasos(1));
    }

    @Test
    public void deberiaDevolverFalsoSiNoHayVasosSuficientes() {
        Vaso vaso = new Vaso(1, 10);
        assertFalse(vaso.hasVasos(2));
    }

    @Test
    public void deberiaRestarCantidadDeVasos() {
        Vaso vaso = new Vaso(5, 10);
        vaso.giveVasos(1);
        assertEquals(4, vaso.getCantidadVasos());
    }
}
