package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.City;
import model.User;

public class DBQueries {
    public static ArrayList<City> getAllCities() throws SQLException
    {
       ArrayList<City> gradovi = new ArrayList<City>();
       Connection baza = DBConnection.getConn();
       Statement st = baza.createStatement();
       String upit = "select * from grad;";
       ResultSet rs = st.executeQuery(upit);
       while(rs.next()){
           City c = new City();
           c.setId(rs.getInt(1));
           c.setNaziv(rs.getString(2));
           gradovi.add(c);
       }      
     return gradovi;  
    }

    public static void insertUser(User u) throws SQLException {
        String upit =
        "insert into user (username, password, name, surname, sex, city_id) values (?,?,?,?,?,?);";
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setString(1, u.getUsername());
        pst.setString(2, u.getPassword());
        pst.setString(3, u.getName());
        pst.setString(4, u.getSurname());
        pst.setString(5, ""+u.getSex());
        pst.setInt(6, u.getGrad_id());
        
        pst.execute();
       
    }
}
