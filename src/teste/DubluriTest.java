package teste;

import dubluri.BancaDummy;
import dubluri.BancaFake;
import dubluri.BancaSpy;
import dubluri.BancaStub;
import interfete.IBanca;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DubluriTest {

    private IBanca bancaDummy;
    private IBanca bancaStub;
    private IBanca bancaFake;

    @Before
    public void setup() {
        bancaDummy = new BancaDummy();
        bancaStub = new BancaStub();
        bancaFake = new BancaFake();
    }

    @Test
    public void testDummy() {
        assertFalse(bancaDummy.getStare());
    }

    @Test
    public void testStub() {
        assertEquals(1, bancaStub.getNumar());
    }

    @Test
    public void testFake() {
        ((BancaFake) bancaFake).setValoaredeReturnNume("Banca fake");
        assertEquals("Banca fake", bancaFake.getNume());
    }

    @Test
    public void testCardinalityZero() {
        ArrayList<BancaSpy> list = new ArrayList<>();
        for (BancaSpy bancaSpy : list) {
            bancaSpy.getNumar();
            assertEquals(0, bancaSpy.getCtGetNumar());
        }
    }

    @Test
    public void testCardinalityOne() {
        ArrayList<BancaSpy> list = new ArrayList<>();
        list.add(new BancaSpy());
        for (BancaSpy bancaSpy : list) {
            bancaSpy.getNumar();
            assertEquals(1, bancaSpy.getCtGetNumar());
        }
    }

    @Test
    public void testCardinalityMany() {
        ArrayList<BancaSpy> list = new ArrayList<>();
        list.add(new BancaSpy());
        list.add(new BancaSpy());
        list.add(new BancaSpy());
        for (BancaSpy bancaSpy : list) {
            bancaSpy.getNumar();
            bancaSpy.getNumar();
            bancaSpy.getNumar();
            assertEquals(3, bancaSpy.getCtGetNumar());
        }
    }
}
