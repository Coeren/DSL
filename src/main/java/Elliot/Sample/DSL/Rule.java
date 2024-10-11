package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Rule {
    public void validate() throws ValidationException {
        if (ops == null) throw new ValidationException("Empty rule");
        for (Operation op : ops)
            op.validate();
    }

    public String run() {
        String res = "";
        for (Operation op : ops)
            res = op.run();

        return res;
    }

    @JsonProperty("Rule")
    private List<Operation> ops;
}
