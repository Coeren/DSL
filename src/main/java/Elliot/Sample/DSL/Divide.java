package Elliot.Sample.DSL;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Divide implements Operation {
    enum Round {
        Integer,
        None
    }

    @Override
    public void validate() throws ValidationException {
        if (left == null) throw new ValidationException("Empty left value for \"Divide\" operation");
        if (right == null) throw new ValidationException("Empty right value for \"Divide\" operation");
        if (round == null) throw new ValidationException("Empty round for \"Divide\" operation");

        left.validate();
        right.validate();
    }

    @Override
    public String run() {
        double res = Double.parseDouble(left.run()) / Double.parseDouble(right.run());

        if (round == Round.Integer)
            return ((Integer) ((int) res)).toString();

        return ((Double) res).toString();
    }

    @JsonProperty("Left")
    private Operation left;
    @JsonProperty("Right")
    private Operation right;
    @JsonProperty("Round")
    private Round round = Round.None;
}
