package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Or implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (ops == null) throw new ValidationException("Empty Or");
        for (Operation op : ops)
            op.validate();
    }

    @Override
    public String run() {
        for (Operation op : ops)
            if (op.run().equals("True")) return "True";

        return "False";
    }

    @JsonProperty("Operands")
    private List<Operation> ops;
}
