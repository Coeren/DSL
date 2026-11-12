package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = AndDeserializer.class)
public class And implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (ops == null) throw new ValidationException("Empty And");
        for (Operation op : ops)
            op.validate();
    }

    @Override
    public String run() {
        for (Operation op : ops)
            if (op.run().equals("False")) return "False";

        return "True";
    }

    public void setOps(List<Operation> ops) {
        this.ops = ops;
    }

    @JsonProperty("Operands")
    private List<Operation> ops;
}
