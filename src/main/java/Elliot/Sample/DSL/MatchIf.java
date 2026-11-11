package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MatchIf implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (op == null) throw new ValidationException("Empty operation");
        op.validate();
    }

    @Override
    public String run() {
        return op.run();
    }

    @JsonAnySetter
    public void setOp(String name, JsonNode node) throws ValidationException, JsonProcessingException {
        if (op != null)
            throw new ValidationException("Several operations in MatchIf");

        ObjectNode wrapper = JsonNodeFactory.instance.objectNode();
        wrapper.set(name, node);

        op = new ObjectMapper().treeToValue(wrapper, Operation.class);
    }

    private Operation op;
}
