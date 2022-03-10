package com.company;

import com.company.sql.components.Postnummer;
import com.company.sql.components.PostnummerRepository;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(HttpHelper.get("https://services.datafordeler.dk/DAR/DAR/1/rest/Postnummer?username=xxxx&password=yyyy&Format=JSON&postnr=2400"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CreateInfoFromWebservice() {
        List<Postnummer> postnumre = new PostnummerRepository().getAllWithDistinctPostnr();

        for (Postnummer pn : postnumre) {

        }
    }
}
