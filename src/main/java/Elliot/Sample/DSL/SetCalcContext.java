package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetCalcContext implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (Util.IsNullOrEmpty(var)) throw new ValidationException("Empty name for \"SetCalcContext\" operation");
        if (op == null) throw new ValidationException("Empty op for \"SetCalcContext\" operation");

        op.validate();
    }

    @Override
    public String run() {
        String value = op.run();
        JsonReader.getContext().setValue(var, value);

        return value;
    }

    @JsonProperty("Name")
    private String var;
    @JsonProperty("Value")
    private Operation op;
}
