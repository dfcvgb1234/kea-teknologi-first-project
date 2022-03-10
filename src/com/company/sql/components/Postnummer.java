package com.company.sql.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Postnummer{

    private int id;
    private String region;
    private String kommune;
    private int postnr;
    private String bynavn;

    public Postnummer(int id, String region, String kommune, int postnr, String bynavn) {
        this.id = id;
        this.region = region;
        this.kommune = kommune;
        this.postnr = postnr;
        this.bynavn = bynavn;
    }

    public int getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public String getKommune() {
        return kommune;
    }

    public int getPostnr() {
        return postnr;
    }

    public String getBynavn() {
        return bynavn;
    }


}
