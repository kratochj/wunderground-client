package eu.kratochvil.pwssync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "eu.kratochvil.pwssync")
@EnableScheduling
public class Application {
    private static final Logger log = LogManager.getLogger(ElasticClient.class);


    //The config parameters for the connection
    @Value("${elasticsearch.host}")
    private String HOST = "localhost";

    @Value("${elasticsearch.port}")
    private int PORT_ONE = 9200;

    @Value("${elasticsearch.scheme}")
    private String SCHEME = "http";


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        log.info("Elastic search parameters:");
        log.info("    Host: {}", HOST);
        log.info("    Port: {}", PORT_ONE);
        log.info("    Scheme: {}", SCHEME);
    }
}
