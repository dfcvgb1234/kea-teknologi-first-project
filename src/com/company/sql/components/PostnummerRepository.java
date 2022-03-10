package com.company.sql.components;

import com.company.sql.SqlComponent;
import com.company.sql.SqlController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostnummerRepository implements SqlComponent<String, Postnummer> {

    private final String TABLE_NAME = "Postnumre";

    @Override
    public Postnummer getFirstById(String id) {
        SqlController controller = new SqlController("root", "Admin123");

        // Using "SELECT *" is not advisable in case new columns are added or moved around.
        ResultSet result = controller.getResultSetFromQuery(String.format("SELECT * FROM " + TABLE_NAME + " WHERE id = '%s' LIMIT 1", id));

        try {
            if (result.next()) {
                return new Postnummer(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5));
            }
            else{
                return null;
            }
        }
        catch (SQLException exception) {
            return null;
        }
        finally {
            controller.closeConnection();
        }
    }

    @Override
    public List<Postnummer> getAll() {
        SqlController controller = new SqlController("root", "Admin123");

        ResultSet result = controller.getResultSetFromQuery("SELECT id, Regionsnavn, Kommunenavn, DISTINCT(Postnr), Bynavn FROM " + TABLE_NAME);

        List<Postnummer> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(new Postnummer(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5)));
            }

            if (results.size() == 0) {
                return new ArrayList<>();
            }
            else {
                return results;
            }
        }
        catch (SQLException exception) {
            return new ArrayList<>();
        }
        finally {
            controller.closeConnection();
        }
    }

    public List<Postnummer> getAllWithDistinctPostnr() {
        SqlController controller = new SqlController("root", "Admin123");

        // This is not really distinct, but it gives the correct result set for this table
        ResultSet result = controller.getResultSetFromQuery("SELECT * FROM " + TABLE_NAME + " group by postnr");

        List<Postnummer> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(new Postnummer(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5)));
            }

            if (results.size() == 0) {
                return new ArrayList<>();
            }
            else {
                return results;
            }
        }
        catch (SQLException exception) {
            return new ArrayList<>();
        }
        finally {
            controller.closeConnection();
        }
    }

    @Override
    public void insert(Postnummer component) {
        SqlController controller = new SqlController("root", "Admin123");

        controller.insertIntoDatabaseWithQuery("INSERT INTO " + TABLE_NAME + " VALUES " + createInsertStatement(component));
        controller.closeConnection();
    }

    @Override
    public void insertAll(List<Postnummer> components) {
        SqlController controller = new SqlController("root", "Admin123");

        StringBuilder insertQuery = new StringBuilder("INSERT INTO " + TABLE_NAME + " VALUES ");

        for (int i = 0; i < components.size(); i++) {
            if (i+1 == components.size()) {
                insertQuery.append(createInsertStatement(components.get(i)) + ";");
            }
            else
            {
                insertQuery.append(createInsertStatement(components.get(i)) + ",");
            }
        }
        controller.closeConnection();
    }

    private String createInsertStatement(Postnummer postnummer) {
        return String.format("(DEFAULT, '%s', '%s', %4d, '%s')",
                             postnummer.getRegion(),
                             postnummer.getKommune(),
                             postnummer.getPostnr(),
                             postnummer.getBynavn());
    }
}
