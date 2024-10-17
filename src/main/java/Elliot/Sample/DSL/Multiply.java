package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Multiply implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (ops == null) throw new ValidationException("Empty Or");
        for (Operation op : ops)
            op.validate();
    }

    @Override
    public String run() {
        double res = 1;
        for (Operation op : ops)
            res *= Double.parseDouble(op.run());

        if ((int) res == res)
            return ((Integer) ((int) res)).toString();

        return ((Double) res).toString();
    }

    @JsonProperty("Operands")
    private List<Operation> ops;
}
