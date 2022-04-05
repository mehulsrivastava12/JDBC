package Objects;
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

    public int getemp_no() {
        return emp_no;
    }
    
    public void setemp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public int getsalaries() {
        return salaries;
    }
    
    public void setsalaries(int salaries) {
        this.salaries = salaries;
    }

    public Date getfrom_date() {
        return from_date;
    }
    
    public void setfrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getto_date() {
        return to_date;
    }
    
    public void setto_date(Date to_date) {
        this.to_date = to_date;
    }

    @Override
    public String toString(){
        return "{ "+emp_no+" "+salaries+" "+from_date+" "+to_date+ " }";
    }
    public static void main(String[] args) {
        ArrayList<Salaries> sa = new ArrayList<>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con con = DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("Select * from salaries");
            while (rs.next()) {
                Salaries s = new Salaries(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4));
                sa.add(s);
            }
            con.close();
            System.out.println(sa);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}