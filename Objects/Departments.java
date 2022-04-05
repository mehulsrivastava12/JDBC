package Objects;
import java.sql.*;
import java.util.*;
public class Departments {
    private String dept_no;
    private String dept_name;

    public Departments(String dept_no,String dept_name){
        this.dept_no=dept_no;
        this.dept_name=dept_name;
    }

    public String getdept_no() {
        return dept_no;
    }
    
    public void setdept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public String getdept_name() {
        return dept_name;
    }
    
    public void setdept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "{ "+ dept_no+ " "+ dept_name+ " }";
    }
    public static void main(String[] args) {
        ArrayList<Departments> dept=new ArrayList<>();
        String query="Select * from departments";
        try {
            ResultSet rs=Conn.connection(query);
            while(rs.next()){
                Departments d=new Departments(rs.getString(1), rs.getString(2));
                dept.add(d);
            }
            System.out.println(dept);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
