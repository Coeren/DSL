package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Use implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (Util.IsNullOrEmpty(value)) throw new ValidationException("Empty value for \"Use\" operation");
    }

    @Override
    public String run() {
        return value;
    }

    @JsonProperty("Value")
    private String value;
}
