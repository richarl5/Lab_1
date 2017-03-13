import com.eetakemon.controller.UserController;
import com.eetakemon.entity.User;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 08/03/2017.
 */
public class UserControllerTest extends TestCase {
    private UserController con;
    private User u;
    private List lista = new ArrayList();

    protected void setUp() throws Exception {
        super.setUp();
        u = new User("Paco","1234","mail");
        con = new UserController();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        // Fin de test. Aqui liberar recursos o borrar rastros del test
    }

    public void testAddUser() throws Exception {
        assertEquals(true, con.addUser(u));
    }

    public void testDelUser() throws  Exception {
        con.addUser(u);
        assertEquals(true,con.delUSer("Paco"));
    }

    public void testLogIn() throws Exception {
        con.addUser(u);
        assertEquals(true,con.LogIn("Paco","1234"));
    }

    public void testSearchUser() throws Exception {
        u = con.searchUser("Paco");
        assertEquals("Paco",u.getName());
    }
}
