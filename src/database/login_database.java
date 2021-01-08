 
package database;
import domain.user;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class login_database {
    
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:data_base.db");
    }
      public static void insert_main_menue(int id,String st_name,String groub_st,String grade) throws SQLException{
           
        }

    public static void insert_user(String user, String pass) throws SQLException {
        try {
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into user values(?,?)");
            p.setString(1, user);
            p.setString(2, pass);
            p.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<user> get_user() {

        ArrayList<user> list = new ArrayList<>();
        try {
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from login");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new user(r.getString("user_name"), r.getString("password")));
            }

        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }

        return list;
    }

    public static int check_user(String user, String pass) {
        int x = 0;
        ArrayList<user> arr = get_user();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getUser_name().equalsIgnoreCase(user)) {
                if (arr.get(i).getPassword().equalsIgnoreCase(pass)) {

                    x = 1;
                    break;
                } else {
                    x = 2;
                    break;
                }

            } else {
                x=0;
            }

        }
        return x;
    }
}
