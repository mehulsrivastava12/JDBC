package Object;
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
}
    