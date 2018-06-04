package org.hillel.task40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Databases {

    private final String url;
    private final String root;
    private final String password;

    public Databases(String url, String root, String password) {
        this.url = url;
        this.root = root;
        this.password = password;
    }

    private Connection makeConnectionWithDataBase()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, root, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("Connection created successfully");

        } else {
            System.out.println("Problem with creating connection");
        }
        return connection;
    }

    private void printAllInformation (ResultSet rs) throws SQLException {
        while (rs.next()){
            String markOfCar = rs.getString("mark");
            String model = rs.getString("model");
            String transmission = rs.getString("transmission");
            int year = rs.getInt("year");
            int price = rs.getInt("price");
            int stock = rs.getInt("stock");
            String country = rs.getString("country");
            System.out.print("Mark - " + markOfCar + " ");
            System.out.print("Model - " + model + " ");
            System.out.print("Transmission - " + transmission + " ");
            System.out.print("Year - " + year + " ");
            System.out.print("Price - " + price + " ");
            System.out.print("Stock - " + stock + " ");
            System.out.print("Country - " + country + " ");
            System.out.println();
        }
    }

    public void autoCheaperThan(int highPrice) throws SQLException {
        Connection con = makeConnectionWithDataBase();
        String st = "select * from cars where price < MARKER;";
        st = st.replaceAll("MARKER",String.valueOf(highPrice));
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(st);
        printAllInformation(rs);
        rs.close();
        statement.close();
    }

    public void autoByMark (String mark) throws SQLException {
        Connection con = makeConnectionWithDataBase();
        String st = "select model from cars where mark in ('MARKER');";
        st = st.replaceAll("MARKER", mark);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(st);
        while (rs.next()){
            String model = rs.getString("model");
            System.out.print("Model - " + model + " ");
            System.out.println();
        }
        rs.close();
        statement.close();
    }

    public void autoByCountry(String countryName) throws SQLException {
        Connection con = makeConnectionWithDataBase();
        String st = "select mark, model from cars where country in ('MARKER');";
        st = st.replaceAll("MARKER", countryName);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(st);
        while (rs.next()){
            String markOfCar = rs.getString("mark");
            String model = rs.getString("model");
            System.out.print("Mark - " + markOfCar + " ");
            System.out.print("Model - " + model + " ");
            System.out.println();
        }
        rs.close();
        statement.close();
    }

    public void theMostExpensiveCar () throws SQLException {
        Connection con = makeConnectionWithDataBase();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from cars order by price desc;");
        rs.next();
        String markOfCar = rs.getString("mark");
        String model = rs.getString("model");
        String transmission = rs.getString("transmission");
        int year = rs.getInt("year");
        int price = rs.getInt("price");
        int stock = rs.getInt("stock");
        String country = rs.getString("country");
        System.out.print("Mark - " + markOfCar + " ");
        System.out.print("Model - " + model + " ");
        System.out.print("Transmission - " + transmission + " ");
        System.out.print("Year - " + year + " ");
        System.out.print("Price - " + price + " ");
        System.out.print("Stock - " + stock + " ");
        System.out.print("Country - " + country + " ");
        System.out.println();

        rs.close();
        statement.close();
    }

    public void theMostCheapestCar () throws SQLException {
        Connection con = makeConnectionWithDataBase();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from cars order by price;");
        rs.next();
        String markOfCar = rs.getString("mark");
        String model = rs.getString("model");
        String transmission = rs.getString("transmission");
        int year = rs.getInt("year");
        int price = rs.getInt("price");
        int stock = rs.getInt("stock");
        String country = rs.getString("country");
        System.out.print("Mark - " + markOfCar + " ");
        System.out.print("Model - " + model + " ");
        System.out.print("Transmission - " + transmission + " ");
        System.out.print("Year - " + year + " ");
        System.out.print("Price - " + price + " ");
        System.out.print("Stock - " + stock + " ");
        System.out.print("Country - " + country + " ");
        System.out.println();
        rs.close();
        statement.close();
    }
}
