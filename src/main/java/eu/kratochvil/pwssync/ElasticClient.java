package eu.kratochvil.pwssync;

import eu.kratochvil.pwssync.model.Observation;
import eu.kratochvil.pwssync.model.ObservationElastic;
import eu.kratochvil.pwssync.model.ObservationFactory;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.IndicesExists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${elasticsearch.host}")
    private String HOST;

    @Value("${elasticsearch.port}")
    private int PORT_ONE = 9200;

    @Value("${elasticsearch.scheme}")
    private String SCHEME = "http";

    private static final String INDEX = "pws-observations-data";
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

        // Check for index
        JestResult result = jestClient().execute(new IndicesExists.Builder(INDEX).build());
        if (!result.isSucceeded()) {
            jestClient.execute(new CreateIndex.Builder(INDEX).build());
        }

        ObservationElastic observationElastic = ObservationFactory.convert(observation);

        // Check for existing record
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("id", observationElastic.getId()));

        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(INDEX)
                .addType(TYPE)
                .build();

        SearchResult searchResult = jestClient().execute(search);
//        Get get = new Get.Builder(INDEX, observationElastic.getId()).type(TYPE).build();
//        JestResult getResult = jestClient().execute(get);
        if (searchResult.isSucceeded() && searchResult.getTotal() == 0) {
            log.trace("Storing object");
            Index index = new Index.Builder(observationElastic).index(INDEX).type(TYPE).build();
            JestResult insertResult = jestClient().execute(index);
            log.trace("Insert result: {}", () -> insertResult.isSucceeded());
            log.info("Inserted observation: {}, with result: {}", () -> observationElastic.getObsTimeLocal(), ()->insertResult.isSucceeded());
        } else {
            log.trace("Object already exists");
        }
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



