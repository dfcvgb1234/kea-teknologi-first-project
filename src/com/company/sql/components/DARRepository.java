package com.company.sql.components;

import com.company.sql.SqlComponent;
import com.company.sql.SqlController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DARRepository implements SqlComponent<String, DAR> {

    private final String TABLE_NAME = "dar";

    @Override
    public DAR getFirstById(String id) {
        SqlController controller = new SqlController("root", "Admin123");

        ResultSet result = controller.getResultSetFromQuery(String.format("SELECT * FROM " + TABLE_NAME + " WHERE id_lokalId = '%s' LIMIT 1", id));

        try {
            if (result.next()) {
                return new DAR.Builder()
                        .setDatafordelerOpdateringstid("")
                        .setForretningshandelse("")
                        .setForretningsomraade("")
                        .setForretningsproces("")
                        .setId_lokalId("")
                        .setId_namespace("")
                        .setNavn("")
                        .setPostnr("")
                        .setPostnummerinddeling("")
                        .setRegistreringFra("")
                        .setRegistreringsaktor("")
                        .setStatus("")
                        .setVirkningAktor("")
                        .setVirkningFra("")
                        .setForretningsproces("")
                        .setVirkningFra("")
                        .setStatus("")
                        .setVirkningAktor("")
                        .build();
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
    public List<DAR> getAll() {
        SqlController controller = new SqlController("root", "Admin123");

        ResultSet result = controller.getResultSetFromQuery("SELECT id, Regionsnavn, Kommunenavn, DISTINCT(Postnr), Bynavn FROM " + TABLE_NAME);

        List<DAR> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(new DAR.Builder()
                        .setDatafordelerOpdateringstid("")
                        .setForretningshandelse("")
                        .setForretningsomraade("")
                        .setForretningsproces("")
                        .setId_lokalId("")
                        .setId_namespace("")
                        .setNavn("")
                        .setPostnr("")
                        .setPostnummerinddeling("")
                        .setRegistreringFra("")
                        .setRegistreringsaktor("")
                        .setStatus("")
                        .setVirkningAktor("")
                        .setVirkningFra("")
                        .setForretningsproces("")
                        .setVirkningFra("")
                        .setStatus("")
                        .setVirkningAktor("")
                        .build());
            }

            if (results.size() == 0) {
                return new ArrayList<>();
            } else {
                return results;
            }
        } catch (SQLException exception) {
            return new ArrayList<>();
        } finally {
            controller.closeConnection();
        }
    }

    @Override
    public void insert(DAR component) {
        SqlController controller = new SqlController("root", "Admin123");

        controller.insertIntoDatabaseWithQuery("INSERT INTO " + TABLE_NAME + " VALUES " + createInsertStatement(component));
        controller.closeConnection();
    }

    @Override
    public void insertAll(List<DAR> components) {
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

    private String createInsertStatement(DAR dar) {
        // TODO make this shit work
        return "";
    }
}
