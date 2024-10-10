package Elliot.Sample;

import Elliot.Sample.DSL.Context;

import java.util.Dictionary;

public class SampleContext implements Context {
    @Override
    public String readValue(String name) {
        return map.get(name);
    }

    @Override
    public void setValue(String name, String value) {
        map.put(name, value);
    }

    public SampleContext(Dictionary<String, String> dict) {
        map = dict;
    }

    private final Dictionary<String, String> map;
}
