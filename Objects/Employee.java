package Objects;
import java.util.Date;
import java.util.*;
import java.sql.*;

public class Employee {
    private int emp_no;
    private Date birth_date;
    private String first_name;
    private String last_name;
    private String gender;
    private Date hire_date;

    public Employee(int emp_no,Date birth_date,String first_name,String last_name,String gender,Date hire_date) {
        this.emp_no = emp_no;
        this.birth_date =birth_date;
        this.first_name=first_name;
        this.last_name=last_name;
        this.gender=gender;
        this.hire_date=hire_date;
    }
    
    public int getemp_no() {
        return emp_no;
    }
    
    public void setemp_no(int emp_no) {
        this.emp_no = emp_no;
    }
    
    public Date getbirth_date() {
        return birth_date;
    }
    
    public void setbirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getfirst_name() {
        return first_name;
    }
    
    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public Date gethire_date() {
        return hire_date;
    }

    public void sethire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    @Override
    public String toString() {
        return "{" +
                "emp_no = " + emp_no + '\'' + ", birth_date = " + birth_date + ", first_name = " + first_name + '\'' + 
                ", last_name = " + last_name + '\'' + ", gender = " + gender + '\'' + ", hire_date = " + hire_date + '\'' + '}';
    }
    public static void main(String[] args) {
        ArrayList<Employee> staffs = new ArrayList<>();
        String query="Select * from employees";
        try {
            ResultSet rs = Conn.connection(query);
            while (rs.next()) {
                Employee people = new Employee(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6));
                staffs.add(people);
            }
            System.out.println(staffs+"\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}