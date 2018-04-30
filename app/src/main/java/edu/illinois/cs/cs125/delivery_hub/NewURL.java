package edu.illinois.cs.cs125.delivery_hub;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class NewURL {

    /**
     * This class will download the url needed to get all the information about the public
     * locations. This url will display my data from the url as a JSON object since I specified
     * JSON in my html request. We send that request with getUrl().
     *
     * @param myUrl The url that we use to open a connection.
     * @return The url.
     * @throws IOException
     */
    public String readUrl(String myUrl) throws IOException {
        String data = "";
        HttpURLConnection urlConnection = null;
        URL url = new URL(myUrl);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        try {
            url = new URL(myUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            InputStream iStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            data = stringBuffer.toString();
            Log.d("downloadUrl", data);
            bufferedReader.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            urlConnection.disconnect();
        }
        return data;
    }
}
