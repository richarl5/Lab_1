import com.eetakemon.controller.EetakemonController;
import com.eetakemon.entity.Eetakemon;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 08/03/2017.
 */
public class EetakemonControllerTest extends TestCase {
    private EetakemonController con;
    private Eetakemon e;
    private List lista = new ArrayList();

    protected void setUp() throws Exception {
        super.setUp();
        e = new Eetakemon("Paco",1,1);
        con = new EetakemonController();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        // Fin de test. Aqui liberar recursos o borrar rastros del test
    }

    public void testAddEetakemon() throws Exception {
        assertEquals(true, con.addEetakemon(e));
    }

    public void testDelbyID() throws  Exception {
        con.addEetakemon(e);
        assertEquals(true,con.delById(1));
    }

    public void testSearchByName() throws  Exception {
        con.addEetakemon(e);
        lista = con.searchByName("Paco");
        assertTrue(lista != null);
    }

    public void testListEetakemon() throws  Exception {
        con.addEetakemon(e);
        lista = con.listEetakemon();
        e = (Eetakemon) lista.get(0);
        assertEquals("Paco",e.getName());
    }
}
