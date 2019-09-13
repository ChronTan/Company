import java.io.*;
import java.sql.*;

public class Application {
    File file=new File("info.txt");

    public static void main(String[] args) throws SQLException, IOException {
        Application app=new Application();
        final String user="postgres";
        final String password="postgres";
        final String url="jdbc:postgresql://localhost:5432/company";
        PrintWriter pw=new PrintWriter(app.file );
//        PrintWriter pw=new PrintWriter(new FileWriter(app.file, true));
        PreparedStatement preparedStatement, preparedStatement1, preparedStatement2;
        ResultSet resultSet;
        pw.println("                        Вывод всей таблицы");
        pw.println("");

        final Connection connection=DriverManager.getConnection(url, user, password);
        preparedStatement=connection.prepareStatement("SELECT * FROM accounting ");
        preparedStatement1=connection.prepareStatement("Select * FROM accounting WHERE salary>30000");
        preparedStatement2=connection.prepareStatement("Select * FROM accounting WHERE age<=30");


            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String name="name: "+resultSet.getString(2);
                String sname="sname: "+resultSet.getString(3);
                String age="age: "+resultSet.getInt(4);
                String salary="salary: "+resultSet.getInt(5);
                String allStr=name +"| " + sname+ "| "+ age + "| "+ salary+ "";
                pw.println(allStr);

            }

        pw.println("");
        pw.println("");
        pw.println("                        Зарплата больше 30000");
        resultSet=preparedStatement1.executeQuery();
        while(resultSet.next()){
            String name="name: "+resultSet.getString(2);
            String sname="sname: "+resultSet.getString(3);
            String age="age: "+resultSet.getInt(4);
            String salary="salary: "+resultSet.getInt(5);
            String allStr=name +"| " + sname+ "| "+ age + "| "+ salary+ "";
            pw.println(allStr);

        }
        pw.println("");
        pw.println("");
        pw.println("                        Не старше 30");
        resultSet=preparedStatement2.executeQuery();
        while(resultSet.next()){
            String name="name: "+resultSet.getString(2);
            String sname="sname: "+resultSet.getString(3);
            String age="age: "+resultSet.getInt(4);
            String salary="salary: "+resultSet.getInt(5);
            String allStr=name +"| " + sname+ "| "+ age + "| "+ salary+ "";
            pw.println(allStr);

        }
        connection.close();
        pw.close();

    }
}
