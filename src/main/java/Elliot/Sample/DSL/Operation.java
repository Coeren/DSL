package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
        @JsonSubTypes.Type(value = If.class),
        @JsonSubTypes.Type(ReadContext.class),
        @JsonSubTypes.Type(SetContext.class),
        @JsonSubTypes.Type(Use.class)
})
public interface Operation {
    void validate() throws ValidationException;
    String run();
}
