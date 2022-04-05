package Object;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class Salaries {
    private int emp_no;
    private int salaries;
    private Date from_date;
    private Date to_date;

    public Salaries(int emp_no,int salaries,Date from_Date,Date to_date){
        this.emp_no=emp_no;
        this.salaries=salaries;
        this.from_date=from_Date;
        this.to_date=to_date;
    }
}
