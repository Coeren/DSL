package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetContext implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (Util.IsNullOrEmpty(var)) throw new ValidationException("Empty name for \"SetContext\" operation");
        if (Util.IsNullOrEmpty(value)) throw new ValidationException("Empty value for \"SetContext\" operation");
    }

    @Override
    public String run() {
        JsonReader.getContext().setValue(var, value);
        return value;
    }

    @JsonProperty("Name")
    private String var;
    @JsonProperty("Value")
    private String value;
}
