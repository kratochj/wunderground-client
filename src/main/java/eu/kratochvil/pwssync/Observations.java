package eu.kratochvil.pwssync;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Observations {

    private List<Observation> observations;

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("observations", observations)
                .toString();
    }
}
