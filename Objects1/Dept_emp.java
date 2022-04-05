package Objects1;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Dept_emp{
    private int emp_no;
    private String dept_no;
    private Date from_date;
    private Date to_date;

    public Dept_emp(int emp_no,String dept_no,Date from_date,Date to_date){
        this.emp_no=emp_no;
        this.dept_no=dept_no;
        this.from_date=from_date;
        this.to_date=to_date;
    }

    @Override
    public String toString(){
        return "{ "+emp_no+" "+dept_no+" "+from_date+" "+to_date+ " }";
    }
    public static void main(String[] args) {
        ArrayList<Dept_emp> emp = new ArrayList<>();
        String query="Select * from dept_emp";
        try {

            ResultSet rs = Conn.connection(query);
            while (rs.next()) {
                Dept_emp man = new Dept_emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4));
                emp.add(man);
            }
            System.out.println(emp+"\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}