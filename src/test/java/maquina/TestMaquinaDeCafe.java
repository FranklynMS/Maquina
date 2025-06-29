package maquina;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMaquinaDeCafe {

    private Cafetera cafetera;
    private Vaso vasosPequeno;
    private Vaso vasosMediano;
    private Vaso vasosGrande;
    private Azucarero azucarero;
    private MaquinaDeCafe maquinaDeCafe;

    @BeforeEach
    public void setup() {
        cafetera = new Cafetera(50);
        vasosPequeno = new Vaso(5, 10);
        vasosMediano = new Vaso(5, 20);
        vasosGrande = new Vaso(5, 30);
        azucarero = new Azucarero(20);

        maquinaDeCafe = new MaquinaDeCafe();
        maquinaDeCafe.setCafetera(cafetera);
        maquinaDeCafe.setVasosPequeno(vasosPequeno);
        maquinaDeCafe.setVasosMediano(vasosMediano);
        maquinaDeCafe.setVasosGrande(vasosGrande);
        maquinaDeCafe.setAzucarero(azucarero);
    }

    @Test
    public void deberiaDevolverVasoPequeno() {
        assertEquals(vasosPequeno, maquinaDeCafe.getTipoVaso("pequeno"));
    }

    @Test
    public void deberiaDevolverVasoMediano() {
        assertEquals(vasosMediano, maquinaDeCafe.getTipoVaso("mediano"));
    }

    @Test
    public void deberiaDevolverVasoGrande() {
        assertEquals(vasosGrande, maquinaDeCafe.getTipoVaso("grande"));
    }

    @Test
    public void deberiaMostrarMensajeCuandoNoHayVasos() {
        vasosPequeno = new Vaso(0, 10);
        maquinaDeCafe.setVasosPequeno(vasosPequeno);
        String resultado = maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 2);
        assertEquals("No hay Vasos", resultado);
    }

    @Test
    public void deberiaMostrarMensajeCuandoNoHayCafe() {
        maquinaDeCafe.setCafetera(new Cafetera(5));
        String resultado = maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 2);
        assertEquals("No hay Cafe", resultado);
    }

    @Test
    public void deberiaMostrarMensajeCuandoNoHayAzucar() {
        maquinaDeCafe.setAzucarero(new Azucarero(2));
        String resultado = maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 3);
        assertEquals("No hay Azucar", resultado);
    }

    @Test
    public void deberiaRestarCafeCorrectamente() {
        maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 3);
        assertEquals(40, cafetera.getCantidadCafe());
    }

    @Test
    public void deberiaRestarVasosCorrectamente() {
        maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 3);
        assertEquals(4, vasosPequeno.getCantidadVasos());
    }

    @Test
    public void deberiaRestarAzucarCorrectamente() {
        maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 3);
        assertEquals(17, azucarero.getCantidadAzucar());
    }

    @Test
    public void deberiaDevolverMensajeFelicitaciones() {
        String resultado = maquinaDeCafe.getVasoDeCafe(vasosPequeno, 1, 3);
        assertEquals("Felicitaciones", resultado);
    }
}
