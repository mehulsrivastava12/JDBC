package JdbcAssignment;
import java.sql.*;
import java.util.Map;
import java.util.TreeMap;
public class Emp1 {
    public static void main(String[] args) {
        TreeMap<String,Integer> tm=new TreeMap<String,Integer>();
        String url="jdbc:mysql://localhost:3306/employees",user="root", password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT e.dept_no,sum(salary)"+
            "from salaries s INNER JOIN (dept_emp e,dept_manager m) ON e.emp_no=s.emp_no AND m.emp_no=s.emp_no GROUP BY e.dept_no;");
            while(rs.next()){
                tm.put(rs.getString(1),rs.getInt(2));
            }
            con.close();
            for(Map.Entry<String,Integer> e:tm.entrySet()){
                System.out.println(e.getKey()+" "+e.getValue());
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
