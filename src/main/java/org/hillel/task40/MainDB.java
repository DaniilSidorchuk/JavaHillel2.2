package org.hillel.task40;

import org.hillel.task40.Databases;

import java.sql.SQLException;

public class MainDB {
    public static void main(String[] args) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Databases db = new Databases("jdbc:mysql://localhost:3306/cars?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC", "root", "Da1992Va1966");
        db.autoCheaperThan(100000);
        db.autoByMark("BMW");
        db.autoByCountry("Japan");
        db.theMostExpensiveCar();
        db.theMostCheapestCar();
    }
}
