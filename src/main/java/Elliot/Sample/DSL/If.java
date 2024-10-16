package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

public class If implements Operation {
    enum Condition {
        Equal,
        Less,
        Greater
    }

    @Override
    public void validate() throws ValidationException {
        if (left == null) throw new ValidationException("Empty left value for \"If\" operation");
        if (right == null) throw new ValidationException("Empty right value for \"If\" operation");
        if (condition == null) throw new ValidationException("Empty condition for \"If\" operation");
        if (thenOp == null) throw new ValidationException("Empty then for \"If\" operation");
        if (elseOp == null) throw new ValidationException("Null else in \"If\" operation");

        left.validate();
        right.validate();
        thenOp.validate();
        elseOp.validate();
    }

    @Override
    public String run() {
        int cmp = left.run().compareTo(right.run());

        if (condition == Condition.Equal && cmp == 0 || condition == Condition.Greater && cmp > 0 || condition == Condition.Less && cmp < 0)
            return thenOp.run();

        return elseOp.run();
    }

    @JsonProperty("Left")
    private Operation left;
    @JsonProperty("Right")
    private Operation right;
    @JsonProperty("Condition")
    private Condition condition;
    @JsonProperty("Then")
    private Operation thenOp;
    @JsonProperty("Else")
    private Operation elseOp = new Nop();
}
