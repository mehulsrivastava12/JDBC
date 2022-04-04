package JdbcAssignment;
import java.sql.*;
public class Emp {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/employees",user="root", password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select first_name,last_name from employees");
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }
            con.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}