import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class Application {
    File file=new File("info.txt");

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Application app=new Application();
        final String user="postgres";
        final String password="postgres";
        final String url="jdbc:postgresql://localhost:5432/company";
        PrintWriter pw=new PrintWriter(app.file);

        final Connection connection=DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM accounting ");
        try{
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String name="name: "+resultSet.getString(2);
                String sname="sname: "+resultSet.getString(3);
                String age="age: "+resultSet.getInt(4);
                String salary="salary: "+resultSet.getInt(5);
                String allStr=name +"| " + sname+ "| "+ age + "| "+ salary+ "";
                pw.println(allStr);
                System.out.println(allStr);

            }
        }finally {
            connection.close();
        }
        pw.close();

    }
}
