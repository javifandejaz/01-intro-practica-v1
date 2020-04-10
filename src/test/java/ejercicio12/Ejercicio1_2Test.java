package ejercicio12;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Ejercicio1_2Test {

    @Test
    public void testMostrarA() {
        Ejercicio1_2 lolo = new Ejercicio1_2();
        Assert.assertEquals(lolo.mostrarA(),200);

    }


    @Test
    public void testMostrarB() {

        Ejercicio1_2 lolo = new Ejercicio1_2();
        Assert.assertEquals(lolo.mostrarB(), new int[]{10, 4, 411, 100, 58, 62, 87, 233, 75, 90, 11, 56, 33, 68, 110, 8055, 905, 18, 500, 736});
    }

    @Test
    public void testMostrarMayoresQueA() {

        Ejercicio1_2 lolo = new Ejercicio1_2();
        Assert.assertEquals(lolo.mostrarC(), new int[]{411, 233, 8055, 905, 500, 736});
    }
}