package JavaForMobileTutorials;

/* Method 1 Lib */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class APIManipulate_Method1 extends APIManipulate{
    private static HttpURLConnection httpURLConnection;

    public static void main(String[] args) {

        /**
         * @fn: Fetch API and parse them
         * @brief: Method 1: Using java.net.HttpURLConnection
         *
         * */
        try {
            BufferedReader reader;
            String line;
            StringBuffer responseContent = new StringBuffer();

            URL url = new URL("https://api.waqi.info/feed/here/?token=a371d994b74489020d2361991b5cf80a1743e425");
            httpURLConnection = (HttpURLConnection) url.openConnection();

            // Request setup
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000); // 5s before timeout
            httpURLConnection.setReadTimeout(5000);

            // check if success Fetch
            int status = httpURLConnection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
            APIManipulate.parseAPI( "https://api.waqi.info/feed/here/?token=a371d994b74489020d2361991b5cf80a1743e425");
            APIManipulate.printAllValue();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
