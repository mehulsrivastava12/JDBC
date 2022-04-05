package Object;
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
}