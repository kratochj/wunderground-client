package eu.kratochvil.pwssync;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.kratochvil.pwssync.model.Observation;
import eu.kratochvil.pwssync.model.ObservationElastic;
import eu.kratochvil.pwssync.model.ObservationFactory;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
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
    private String HOST = "localhost";

    @Value("${elasticsearch.port}")
    private int PORT_ONE = 9200;

    @Value("${elasticsearch.scheme}")
    private String SCHEME = "http";

    private static final String INDEX = "pws-observations-data";
    private static final String TYPE = "observation";

    private static RestHighLevelClient restHighLevelClient = null;

    public Observation insertObservation(Observation observation) throws IOException {
        try (RestHighLevelClient client = getClient(SCHEME, HOST, PORT_ONE)) {

            GetIndexRequest request = new GetIndexRequest(INDEX);
            boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
            if (!exists) {
                CreateIndexRequest newIndexRequest = new CreateIndexRequest(INDEX);
                CreateIndexResponse createIndexResponse = client.indices().create(newIndexRequest, RequestOptions.DEFAULT);
                log.debug("New index {} created", INDEX);
            }

            ObservationElastic observationElastic = ObservationFactory.convert(observation);

            IndexRequest idxrq = new IndexRequest(INDEX);
            idxrq.id(observationElastic.getId());
            idxrq.source(new ObjectMapper().writeValueAsString(observationElastic), XContentType.JSON);
            IndexResponse indexResponse = client.index(idxrq, RequestOptions.DEFAULT);
            System.out.println("response id: " + indexResponse.getId());
        }
        return observation;
    }

    private static RestHighLevelClient getClient(String SCHEME, String HOST, int PORT_ONE) {
        if (restHighLevelClient == null) {
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(HttpHost.create(SCHEME + "://" + HOST + ":" + PORT_ONE)));
        }
        return restHighLevelClient;
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

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public void setPORT_ONE(int PORT_ONE) {
        this.PORT_ONE = PORT_ONE;
    }

    public void setSCHEME(String SCHEME) {
        this.SCHEME = SCHEME;
    }
}



