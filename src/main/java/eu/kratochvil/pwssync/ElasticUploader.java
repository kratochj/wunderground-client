package eu.kratochvil.pwssync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ElasticUploader {

    private static final Logger log = LogManager.getLogger(ElasticUploader.class);

    @Autowired
    private ElasticClient elasticClient;

    @Autowired
    private Downloader downloader;

    public boolean uploadData() {
        try {
            Observations observations = downloader.download();
            log.info("Uploading data - {} records", () -> observations.getObservations().size());
            for (Observation observation : observations.getObservations()) {
                elasticClient.insertObservation(observation);
            }

            return true;
        } catch (Exception e) {
            log.error("Error uploading data", e);
            return false;
        }


    }

}
