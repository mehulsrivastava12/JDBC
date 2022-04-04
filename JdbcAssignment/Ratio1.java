package JdbcAssignment;
import java.sql.*;
public class Ratio1{
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT tb.dept_no,tb.Male,tb.Female,(tb.Female/tb.Male)"+
            "FROM(SELECT Dept_no,COUNT(CASE WHEN UPPER(gender)='M' THEN 1 END) AS Male, COUNT(CASE WHEN UPPER(gender)='F' THEN 1 END)"+
            "AS Female FROM(employees NATURAL JOIN dept_emp) GROUP BY Dept_no) tb ORDER BY CASE WHEN tb.Dept_no IS NULL THEN 1 ELSE 0 END");
           while(rs.next()){
                    System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getFloat(4));
               }                    
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
