package eu.kratochvil.pwssync;


import eu.kratochvil.pwssync.model.Metric;
import eu.kratochvil.pwssync.model.Observation;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ElasticClientTest {

    ElasticClient ec;

    @Before
    public void setup() {
        ec = new ElasticClient();
    }

    @Test
    public void testUpload() throws IOException {
        Metric m = new Metric(20f, 10f, 15f, 10f, 0f, 5f, 25f,
                5f, 12f, 5f, 6f, 5f, 10f, 2f, 7f,
                10f, 12f, 15f, 25f, 2f, 1f, 15f, 11f);

        Observation obs = new Observation("123KJL321", "Europe/Prague", "2019-10-28 00:04:54",
                "2019-10-28 00:04:54", 345435638L, 50.14873f, 14.186605f, null,
                null, 270, 76, 25, 55, 1, m);


        ec.insertObservation(obs);
    }

}