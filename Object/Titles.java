package Object;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class Titles {
    private int emp_no;
    private String title;
    private Date from_date;
    private Date to_date;

    public Titles(int emp_no,String title,Date from_Date,Date to_date){
        this.emp_no=emp_no;
        this.title=title;
        this.from_date=from_Date;
        this.to_date=to_date;
    }

    @Override
    public String toString(){
        return "{ "+emp_no+" "+title+" "+from_date+" "+to_date+ " }";
    }
}
