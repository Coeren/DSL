package Elliot.Sample;

import Elliot.Sample.DSL.JsonReader;
import Elliot.Sample.DSL.Rule;

import java.util.Hashtable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("ContextVar1", "2");
        hashtable.put("ContextVar2", "20");
        JsonReader reader = new JsonReader(new SampleContext(hashtable));

        Rule rule;
        try {
            rule = reader.readFile("src/main/resources/test.dsl");
            System.out.println(rule.run());
            hashtable.put("ContextVar1", "1");
            System.out.println(rule.run());
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        System.out.println("---- Context -----");
        System.out.println(hashtable);
    }
}