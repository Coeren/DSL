package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReadContext implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (Util.IsNullOrEmpty(value)) throw new ValidationException("Empty value for \"ReadContext\" operation");
    }

    @Override
    public String run() {
        return JsonReader.getContext().readValue(value);
    }

    @JsonProperty("Value")
    private String value;
}
