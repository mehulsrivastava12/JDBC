package JdbcAssignment;
import java.sql.*;
import java.util.*;
public class DMMD2 {
    public static void main(String[] args) {
        SortedMap<Long,String> ts=new TreeMap<Long,String>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT m.dept_no,e.first_name,e.last_name,m.from_date,m.to_date "+
            "FROM dept_manager m  INNER JOIN (employees e,dept_manager) ON e.emp_no=m.emp_no GROUP BY dept_no");
            while(rs.next()){
                long diff = (rs.getDate(5)).getTime()-(rs.getDate(4)).getTime();  
                String value=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDate(4)+" to "+rs.getDate(5);
                ts.put(diff,value);
            }
            con.close();
            System.out.println(ts.get(ts.lastKey()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}