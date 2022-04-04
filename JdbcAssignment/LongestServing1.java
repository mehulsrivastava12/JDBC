package JdbcAssignment;
import java.util.*;
import java.sql.*;
public class LongestServing1 {
    public static void main(String[] args) {
        SortedMap<Long,String> a=new TreeMap<Long,String>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select t.title,t.emp_no,e.from_date,e.to_date "+
            "from dept_emp e JOIN (titles t) ON t.emp_no=e.emp_no;");
            while(rs.next()){
                long diff=(rs.getDate(4)).getTime()-(rs.getDate(3)).getTime();
                String value="Title : "+rs.getString(1)+"\nEmp_NO : "+rs.getInt(2)+"\nDuration : "+rs.getDate(3)+" to " +rs.getDate(4)+" days";
                a.put(diff,value);
            }                                      
            con.close();
            System.out.println(a.get(a.lastKey()));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
