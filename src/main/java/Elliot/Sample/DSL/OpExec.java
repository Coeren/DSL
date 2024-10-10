package Elliot.Sample.DSL;


import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class OpExec implements Operation {
    @Override
    public void validate() throws ValidationException {
        if (op == null) throw new ValidationException("Empty operation");
        op.validate();
    }

    @Override
    public String run() {
        return op.run();
    }

    @JsonUnwrapped
    private Operation op;
}
