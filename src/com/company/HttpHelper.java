package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class HttpHelper {

    public static String get(String uri) throws IOException {

        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(con.getInputStream());
        BufferedReader streamReader = new BufferedReader(reader);

        StringBuilder result = new StringBuilder();
        String currentLine = streamReader.readLine();
        while(currentLine != null) {
            result.append(currentLine);
            currentLine = streamReader.readLine();
        }

        return result.toString();

    }
}
