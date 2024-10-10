package Elliot.Sample.DSL;

public interface Context {
    String readValue(String name);
    void setValue(String name, String value);
}
