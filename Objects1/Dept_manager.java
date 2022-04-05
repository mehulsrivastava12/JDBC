package Objects1;
import java.util.Date;
import java.util.*;
import java.sql.*;

public class Dept_manager {
    private int emp_no;
    private String dept_no;
    private Date from_date;
    private Date to_date;

    public Dept_manager(int emp_no,String dept_no,Date from_date,Date to_date) {
        this.emp_no = emp_no;
        this.dept_no =dept_no;
        this.from_date=from_date;
        this.to_date=to_date;
    }

    @Override
    public String toString() {
        return "{" +
                "emp_no=" + emp_no + '\'' +
                ", dept_no =" + dept_no + ", from_date=" + from_date + '\'' + ", to_date=" + to_date + '\''+
                '}';
    }
    public static void main(String[] args) {
        ArrayList<Dept_manager> manager = new ArrayList<>();
        String query="Select * from dept_manager";
        try {
            ResultSet rs =Conn.connection(query);
            while (rs.next()) {
                Dept_manager man = new Dept_manager(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4));
                manager.add(man);
            }

            System.out.println(manager+"\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}