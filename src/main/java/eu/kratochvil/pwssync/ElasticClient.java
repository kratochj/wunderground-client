package eu.kratochvil.pwssync;

import eu.kratochvil.pwssync.model.Observation;
import eu.kratochvil.pwssync.model.ObservationFactory;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.IndicesExists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

@Component
public class ElasticClient {

    private static final Logger log = LogManager.getLogger(ElasticClient.class);

    //The config parameters for the connection
    private static final String HOST = "192.168.1.34";
    private static final int PORT_ONE = 9200;
    private static final String SCHEME = "http";

    private static final String INDEX = "observations-data";
    private static final String TYPE = "observation";

    private static JestClient jestClient;

    public JestClient jestClient() {
        if (jestClient != null) {
            return jestClient;
        }
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(
                new HttpClientConfig.Builder("http://192.168.1.34:9200")
                        .multiThreaded(true)
                        .defaultMaxTotalConnectionPerRoute(2)
                        .maxTotalConnection(10)
                        .build());
        jestClient = factory.getObject();
        return jestClient;
    }


    public Observation insertObservation(Observation observation) throws IOException{

        JestResult result = jestClient().execute(new IndicesExists.Builder(INDEX).build());
        if (!result.isSucceeded()) {
            jestClient.execute(new CreateIndex.Builder(INDEX).build());
        }

        Index index = new Index.Builder(ObservationFactory.convert(observation)).index(INDEX).type(TYPE).build();
        jestClient().execute(index);

        // jestClient().execute(new Index.Builder(observation).index(INDEX).build());
        return observation;
    }

    private DateFormat dateFormatResult = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private DateFormat dateFormatSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Date convertPwsDate(String in) {
        try {
            return dateFormatSource.parse(in);
        } catch (ParseException e) {
            try {
                return dateFormatResult.parse(in);
            } catch (ParseException ex) {
                log.error("Error parsing data", ex);
                return null;
            }
        }
    }

}



