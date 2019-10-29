package eu.kratochvil.pwssync;

import eu.kratochvil.pwssync.model.Observations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class Downloader {

    private static final Logger log = LogManager.getLogger(Downloader.class);

    private static final String API_KEY = "d54747668467400387476684676003ff";
    private static final String PWS_ID = "IBUTHR1";

    private static final String URL = "https://api.weather.com/v2/pws/observations/all/1day?stationId=" + PWS_ID + "&format=json&units=m&apiKey=" + API_KEY;

    Observations download() {

        RestTemplate restTemplate = new RestTemplate();

        Observations result = restTemplate.getForObject(URL, Observations.class);

        if (result != null) {
            log.debug("Loaded {} records", () -> result.getObservations().size());
        }

        return result;
    }


}
