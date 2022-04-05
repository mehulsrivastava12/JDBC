package Objects1;
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

    @Override
    public String toString(){
        return "{ "+emp_no+" "+salaries+" "+from_date+" "+to_date+ " }";
    }
    public static void main(String[] args) {
        ArrayList<Salaries> sa = new ArrayList<>();
        String query="Select * from salaries";
        try {
            ResultSet rs =Conn.connection(query);
            while (rs.next()) {
                Salaries s = new Salaries(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4));
                sa.add(s);
            }
            System.out.println(sa+"\n");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}