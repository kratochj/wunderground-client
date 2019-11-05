package eu.kratochvil.pwssync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private static final Logger log = LogManager.getLogger(ScheduledTask.class);

    @Autowired
    private ElasticUploader elasticUploader;

    @Scheduled(fixedDelay = 600000)
    public void runImport() {
        log.debug("Running import job");
        elasticUploader.uploadData();
    }
}
