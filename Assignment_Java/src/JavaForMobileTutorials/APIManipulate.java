package JavaForMobileTutorials;

/**
 * @note Download jar file and add to Project Structure
 * @link https://mvnrepository.com/artifact/org.json/json/20220924
 * @version 20220924
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class APIManipulate {
    private static Float CO_val;
    private static Float NO2_val;
    private static Float O3_val;
    private static Float SO2_val;
    private static Float PM25_val;
    private static Float PM10_val;
    private static Float temperature;
    private static Float windSpeed;
    private static Float pressure;
    private static Float humidity;
    private static String station;
    private static String link;
    private static Float[] geoLocation = new Float[2];
    private static Float aqi;


    /* Getter */
    public static Float getCO_val() {
        return CO_val;
    }

    public static Float getNO2_val() {
        return NO2_val;
    }

    public static Float getO3_val() {
        return O3_val;
    }

    public static Float getSO2_val() {
        return SO2_val;
    }

    public static Float getPM25_val() {
        return PM25_val;
    }

    public static Float getPM10_val() {
        return PM10_val;
    }

    public static Float getTemperature() {
        return temperature;
    }

    public static Float getWindSpeed() {
        return windSpeed;
    }

    public static Float getAirPressure() {
        return pressure;
    }

    public static Float getHumidity() {
        return humidity;
    }


    public static String getStation() {
        return station;
    }

    public static String getLink() {
        return link;
    }

    public static Float[] getGeoLocation() {
        return geoLocation;
    }

    public static Float getAqi() {
        return aqi;
    }


    /* Setter */
    private static void setCO_val(Float CO_val) {
        APIManipulate.CO_val = CO_val;
    }

    private static void setNO2_val(Float NO2_val) {
        APIManipulate.NO2_val = NO2_val;
    }

    private static void setO3_val(Float O3_val) {
        APIManipulate.O3_val = O3_val;
    }

    private static void setSO2_val(Float SO2_val) {
        APIManipulate.SO2_val = SO2_val;
    }

    private static void setPM25_val(Float PM25_val) {
        APIManipulate.PM25_val = PM25_val;
    }

    private static void setPM10_val(Float PM10_val) {
        APIManipulate.PM10_val = PM10_val;
    }

    private static void setTemperature(Float temperature) {
        APIManipulate.temperature = temperature;
    }

    private static void setWindSpeed(Float windSpeed) {
        APIManipulate.windSpeed = windSpeed;
    }

    private static void setPressure(Float pressure) {
        APIManipulate.pressure = pressure;
    }

    private static void setHumidity(Float humidity) {
        APIManipulate.humidity = humidity;
    }

    private static void setStation(String station) {
        APIManipulate.station = station;
    }

    private static void setLink(String link) {
        APIManipulate.link = link;
    }

    private static void setGeoLocation(Float[] geoLocation) {
        APIManipulate.geoLocation = geoLocation;
    }

    private static void setAqi(Float aqi) {
        APIManipulate.aqi = aqi;
    }

    /**
     * @fn Parse JSON pulled from API
     * @Lib Using org.JSON
     */
    private static String parseJSON(String responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody);

            /* City */
            JSONObject city = (JSONObject) jsonObject.getJSONObject("data").getJSONObject("city");
            APIManipulate.setStation(city.getString("name"));
            APIManipulate.setLink(city.getString("url"));

            /* Location */
            JSONArray geo = (JSONArray) city.get("geo");
            Float[] location = new Float[2];
            for (int i = 0; i < geo.length(); i++) {
                location[i] = Float.valueOf(geo.getFloat(i));
            }
            APIManipulate.setGeoLocation(location);

            /* AQI index */
            try {
                APIManipulate.setAqi(Float.valueOf(jsonObject.getJSONObject("data").getFloat("aqi")));
            } catch (JSONException e) {
                APIManipulate.handleJSONException(e);
            }

            /* iAQI */
            JSONObject iaqi = (JSONObject) jsonObject.getJSONObject("data").getJSONObject("iaqi");
            try {
                APIManipulate.setCO_val(Float.valueOf(iaqi.getJSONObject("co").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setCO_val(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setNO2_val(Float.valueOf(iaqi.getJSONObject("no2").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setNO2_val(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setSO2_val(Float.valueOf(iaqi.getJSONObject("so2").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setSO2_val(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setO3_val(Float.valueOf(iaqi.getJSONObject("o3").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setO3_val(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setPM25_val(Float.valueOf(iaqi.getJSONObject("pm25").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setPM25_val(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setPM10_val(Float.valueOf(iaqi.getJSONObject("pm10").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setPM10_val(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setTemperature(Float.valueOf(iaqi.getJSONObject("t").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setTemperature(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setHumidity(Float.valueOf(iaqi.getJSONObject("h").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setHumidity(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setWindSpeed(Float.valueOf(iaqi.getJSONObject("w").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setWindSpeed(null);
                APIManipulate.handleJSONException(e);
            }

            try {
                APIManipulate.setPressure(Float.valueOf(iaqi.getJSONObject("p").getFloat("v")));
            } catch (JSONException e) {
                APIManipulate.setPressure(null);
                APIManipulate.handleJSONException(e);
            }

        } catch (JSONException e) {
            APIManipulate.handleJSONException(e);
        }
        return null;
    }

    /**
     * @fn Using HttpClient
     * @Using HttpClient to pull API
     */
    public static void parseAPI(String API) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API)).build();
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(APIManipulate::parseJSON)
                .join();
    }

    private static void handleJSONException(JSONException e) {
        System.out.println("JSON Exception: " + e.getMessage());
    }

    public static void printTemperature() {
        if (getTemperature() == null)
            System.out.println("Temperature value is not available in this station !!!");
        else
            System.out.println("Temperature: " + getTemperature() + " Celsius degree");
    }

    public static void printHumidity() {
        if (getHumidity() == null)
            System.out.println("Humidity value is not available in this station !!!");
        else
            System.out.println("Humidity: " + getHumidity() + " %RH");
    }

    public static void printCOValue() {
        if (getCO_val() == null)
            System.out.println("CO value is not available in this station !!!");
        else
            System.out.println("CO: " + getCO_val() + " ug/m3");
    }

    public static void printSO2Value() {
        if (getSO2_val() == null)
            System.out.println("SO2 value is not available in this station !!!");
        else
            System.out.println("SO2: " + getSO2_val() + " ug/m3");
    }

    public static void printO3Value() {
        if (getO3_val() == null)
            System.out.println("O3 value is not available in this station !!!");
        else
            System.out.println("O3: " + getO3_val() + " ug/m3");
    }

    public static void printPM25Value() {
        if (getPM25_val() == null)
            System.out.println("PM 2.5 value is not available in this station !!!");
        else
            System.out.println("PM 2.5: " + getPM25_val() + " ug/m3");
    }

    public static void printPM10Value() {
        if (getPM10_val() == null)
            System.out.println("PM 10 value is not available in this station !!!");
        else
            System.out.println("PM 10: " + getPM10_val() + " ug/m3");
    }

    public static void printWindSpeed() {
        if (getWindSpeed() == null)
            System.out.println("Wind Speed value is not available in this station !!!");
        else
            System.out.println("Wind Speed: " + getWindSpeed() + " m/s");
    }

    public static void printAirPressure() {
        if (getAirPressure() == null)
            System.out.println("Air Pressure value is not available in this station !!!");
        else
            System.out.println("Air Pressure: " + getAirPressure() + " mmHg");
    }

    public static void printNO2Value() {
        if (getNO2_val() == null)
            System.out.println("NO2 value is not available in this station !!!");
        else
            System.out.println("NO2: " + getNO2_val() + " ug/m3");
    }

    public static void printStationName() {
        System.out.println("Station: " + getStation());
    }

    public static void printLink() {
        System.out.println("Link: " + getLink());
    }

    public static void printAQIIndex() {
        if (getAqi() == null)
            System.out.println("** ---> This station dont measure any AQI value <--- **");
        else
            System.out.println("-----> AQI: " + getAqi() + " <-----");
    }

    public static void printGeoLocation() {
        System.out.println("Latitude: " + getGeoLocation()[0]);
        System.out.println("Longitude: " + getGeoLocation()[1]);
    }

    public static void printAllValue() {
        System.out.println();
        printStationName();
        printLink();
        printGeoLocation();
        System.out.println("\n-- Some basic value of environment --");
        printTemperature();
        printHumidity();
        printAirPressure();
        printWindSpeed();
        System.out.println("\n***** -- AQI -- *****");
        printCOValue();
        printSO2Value();
        printO3Value();
        printNO2Value();
        printPM25Value();
        printPM10Value();
        printAQIIndex();
    }

}
