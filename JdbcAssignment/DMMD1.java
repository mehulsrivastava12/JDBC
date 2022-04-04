package JdbcAssignment;
import java.sql.*;
import java.util.SortedMap;
import java.util.TreeMap;
public class DMMD1 {
    public static void main(String[] args) {
        SortedMap<Long,String> a=new TreeMap<Long,String>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select m.dept_no,e.first_name,e.last_name,max(DATEDIFF(m.to_date,m.from_date))"+
            "from dept_manager m INNER JOIN (employees e,dept_manager) ON e.emp_no=m.emp_no GROUP BY dept_no;");
            while(rs.next()){
                String value=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getLong(4)+" days";
                a.put(rs.getLong(4),value);
            }
            con.close();
            System.out.println("Employee who has been manager for maximum duration is : ");
            System.out.println(a.get(a.lastKey()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
