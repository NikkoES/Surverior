package uinbdg.developer.surveriorapps.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Nikko Eka Saputra on 11/02/2018.
 */

public class HttpConnect {

    public HttpConnect() {

    }


    public String makeHttpCall(String call) {
        String response = null;
        try {
            URL url = new URL(call);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();


            InputStream inputStream = connection.getInputStream();

            response = converter(inputStream);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


    private String converter(InputStream inputStream) {
        String resultJson="";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while((line=bufferedReader.readLine())!=null) {
                sb.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        resultJson = sb.toString();
        return resultJson;
    }
}