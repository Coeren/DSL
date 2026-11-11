package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ParamInList implements Operation {

    @Override
    public void validate() throws ValidationException {
        if (StringUtils.isEmpty(paramName))
            throw new ValidationException("No parameter name in 'ParamInList'");
        if (values == null || values.isEmpty())
            throw new ValidationException("No values in 'ParamInList'");
    }

    @Override
    public String run() {
        String ctxValue = JsonReader.getContext().readValue(paramName);
        for (String s : values)
            if (s.equals(ctxValue))
                return "True";

        return "False";
    }

    @JsonAnySetter
    public void setOp(String name, List<String> list) throws ValidationException {
        if (paramName != null || values != null)
            throw new ValidationException("Several operations in 'ParamInList'");

        paramName = name;
        values = list;
    }

    private String paramName;
    private List<String> values;
}
