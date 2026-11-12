package Elliot.Sample.DSL;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AndDeserializer extends JsonDeserializer<And> {
    @Override
    public And deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        And op = new And();
        List<Operation> ops = new ArrayList<>();
        ArrayNode node = p.readValueAsTree();

        for (Iterator<JsonNode> it = node.values(); it.hasNext(); ) {
            JsonNode val = it.next();
            Map.Entry<String, JsonNode> entry = val.properties().iterator().next();
            ObjectNode wrapper = JsonNodeFactory.instance.objectNode();
            wrapper.set(entry.getKey(), entry.getValue());
            ops.add(ctxt.readTreeAsValue(wrapper, Operation.class));
        }

        op.setOps(ops);
        return op;
    }
}
