package JdbcAssignment;
import java.sql.*;
import java.util.Map;
import java.util.TreeMap;
public class Highest {
    public static void main(String[] args) {
        TreeMap<String,String> tm=new TreeMap<String,String>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select dept_no,ee.first_name,ee.last_name,max(salary)"+
            "FROM salaries s INNER JOIN (dept_emp e,employees ee) ON s.emp_no = e.emp_no AND s.emp_no=ee.emp_no GROUP BY dept_no;"); 
            while(rs.next()){
               String value=rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4);
               tm.put(rs.getString(1),value);
            }
            con.close();
            for(Map.Entry<String,String> e:tm.entrySet()){
                System.out.println(e.getKey()+" "+e.getValue());
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}