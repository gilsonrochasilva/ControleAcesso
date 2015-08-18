import br.ufpa.tap.controle.acesso.dao.UsuariosDAO;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.Query;
import java.util.logging.Logger;

/**
 * Created by gilson on 12/08/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BancoDadosTest {

    private static Logger log = Logger.getLogger(BancoDadosTest.class.getName());

    private UsuariosDAO usuariosDAO;

    @Before
    public void setUp() throws Exception {
        usuariosDAO = new UsuariosDAO();
    }

    @Test
    public void listar() {
        Query query = usuariosDAO.getQuery("Usuarios.listar");
    }
}
