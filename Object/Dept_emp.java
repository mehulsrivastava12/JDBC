package Object;
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
}