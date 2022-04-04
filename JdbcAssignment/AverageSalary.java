package JdbcAssignment;
import java.sql.*;
public class AverageSalary {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select t.title,avg(salary) from salaries s INNER JOIN (titles t) ON t.emp_no=s.emp_no GROUP BY title;");
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getInt(2));
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
