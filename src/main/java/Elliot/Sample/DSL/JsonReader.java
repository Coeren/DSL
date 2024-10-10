package Elliot.Sample.DSL;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    public JsonReader(Context ctx) {
        context = ctx;
    }

    public Rule readFile(String fileName) throws IOException, ValidationException {
        ObjectMapper mapper = new ObjectMapper();

        Rule rule = mapper.readValue(new File(fileName), Rule.class);
        rule.validate();

        return rule;
    }

    @Getter
    private static Context context;
}
