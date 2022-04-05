package Object;
import java.util.*;
import java.sql.*;
import Object.Titles;
public class Main {
    public static void main(String[] args) {
        ArrayList<Titles> ti = new ArrayList<>();
        String url="jdbc:mysql://localhost:3306/employees",user="root",password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("Select * from titles");
            while (rs.next()) {
                Titles t = new Titles(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4));
                ti.add(t);
            }
            con.close();
            System.out.println(ti);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}