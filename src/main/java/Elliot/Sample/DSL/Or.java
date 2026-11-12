package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonDeserializeAs;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = OrDeserializer.class)
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

    public void setOps(List<Operation> ops) {
        this.ops = ops;
    }

    @JsonProperty("Operands")
    private List<Operation> ops;
}
