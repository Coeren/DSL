package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class In implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (test == null) throw new ValidationException("Empty value for \"In\" operation");
        if (values == null || values.isEmpty()) throw new ValidationException("Empty list for \"In\" operation");

        test.validate();
    }

    @Override
    public String run() {
        if (values.contains(test.run()))
            return "True";

        return "False";
    }

    @JsonProperty("Test")
    private Operation test;
    @JsonProperty("Values")
    private List<String> values;
}
