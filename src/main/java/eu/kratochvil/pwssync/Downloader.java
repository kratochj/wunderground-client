package eu.kratochvil.pwssync;

import org.springframework.web.client.RestTemplate;

public class Downloader {

    public static final String API_KEY = "d54747668467400387476684676003ff";
    public static final String PWS_ID = "IBUTHR1";

    public static final String URL = "https://api.weather.com/v2/pws/observations/all/1day?stationId=" + PWS_ID + "&format=json&units=m&apiKey=" + API_KEY;

    public void download() {

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(URL, String.class);

        System.out.println(result);
    }


}
