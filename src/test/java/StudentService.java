import jdk.jfr.Category;

import java.sql.*;


public class StudentService implements StudentInterface {
    public Connection getCon3() {
        return con3;
    }

    public void setCon3(Connection con3) {
        this.con3 = con3;
    }

    public Connection con3;


    public StudentService(Connection con3) throws SQLException {
        this.con3 = con3;


    }

    @Override
    public void add(StudentData cat) throws ClassNotFoundException, SQLException {

        String quer1 = "INSERT INTO student VALUES ( ?, ?,? )";
        PreparedStatement query = con3.prepareStatement(quer1);


        query.setString(1, cat.getStudentName());
        query.setDouble(1, cat.getStudentGpa());
        query.setString(1, cat.getStudentNummber());

        query.executeUpdate();


        System.out.println("One record added");


    }

    @Override
    public StudentData edit(StudentData cat, String ccat) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con3.prepareStatement("Update student set sname=?, snumber=? where gpa = ?");
        query.setString(1, cat.getStudentName());
        query.setDouble(1, cat.getStudentGpa());
        query.setString(1, cat.getStudentNummber());

        query.executeUpdate();

        System.out.println("One record edited");


        return cat;
    }

    @Override
    public void delete(String catcode) throws SQLException {
        String quer1 = "Delete from student where gpa = ?";
        PreparedStatement query = con3.prepareStatement(quer1);
        query.setString(1, catcode);
        query.executeUpdate();

        System.out.println("One record Deleted");
    }

    @Override
    public void display() throws ClassNotFoundException, SQLException {
        String quer1 = "Select * from student";
        PreparedStatement query = con3.prepareStatement(quer1);


        ResultSet rs = query.executeQuery();


        Category obj1;

        //display records if there is data;

        while (rs.next()) {

            obj1 = new StudentData(rs.getString("Name"), rs.getString("Type"), rs.getString("Collection"));


            System.out.println();

            System.out.print("gpa: " + obj1.getClass() + "  ");
            System.out.print("name " + obj1.getClass());


        }
    }
}
