package Elliot.Sample.DSL;

public class Nop implements Operation {
    @Override
    public void validate() throws ValidationException {}

    @Override
    public String run() {
        return "";
    }
}
