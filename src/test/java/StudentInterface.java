
import java.sql.SQLException;

interface StudentInterface {

    public void add(StudentData cat) throws ClassNotFoundException, SQLException;
    public StudentData edit(StudentData cat, String ccat) throws SQLException, ClassNotFoundException;
    public void delete(String catcode) throws SQLException;
    public void display() throws ClassNotFoundException, SQLException;
}
