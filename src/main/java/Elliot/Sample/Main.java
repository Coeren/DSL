package Elliot.Sample;

import Elliot.Sample.DSL.JsonReader;
import Elliot.Sample.DSL.Rule;

import java.util.Hashtable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        init(hashtable);
        System.out.println("---- Context -----");
        System.out.println(hashtable);
        System.out.println();

        JsonReader reader = new JsonReader(new SampleContext(hashtable));
        Rule rule;

        try {
            rule = reader.readFile("src/main/resources/test.dsl");
            System.out.println("First run");
//            System.out.println(rule.run());
            rule.run();
            System.out.println("---- Context -----");
            System.out.println(hashtable);
            System.out.println();

            System.out.println("Setting ContextVar1 to 1");
            hashtable.put("ContextVar1", "1");
            rule.run();
            System.out.println("---- Context -----");
            System.out.println(hashtable);
            System.out.println();

            System.out.println("Setting ContextVar2 to 40");
            System.out.println("Setting transaction.mcc to 8211");
            hashtable.put("ContextVar2", "40");
            hashtable.put("transaction.mcc", "8211");
            rule.run();
            System.out.println("---- Context -----");
            System.out.println(hashtable);
            System.out.println();

            System.out.println("Setting transaction.mcc to 3900");
            System.out.println("Clearing bonus results");
            hashtable.put("transaction.mcc", "3900");
            hashtable.remove("bonusTransaction");
            hashtable.remove("bonusedAmount");
            rule.run();
            System.out.println("---- Context -----");
            System.out.println(hashtable);
            System.out.println();

            System.out.println("Setting transaction.merchantname to yandex*8229*praktikum");
            System.out.println("Setting transactionAmount to 1100");
            System.out.println("Clearing bonus results");
            hashtable.put("transaction.merchantname", "yandex*8229*praktikum");
            hashtable.put("transactionAmount", "1100");
            hashtable.remove("bonusTransaction");
            hashtable.remove("bonusedAmount");
            rule.run();
            System.out.println("---- Context -----");
            System.out.println(hashtable);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    private static void init(Hashtable<String, String> hashtable) {
        hashtable.clear();
        System.out.println("Setting ContextVar1 to 2");
        System.out.println("Setting ContextVar2 to 20");
        System.out.println("Setting transactionAmount to 800");
        hashtable.put("ContextVar1", "2");
        hashtable.put("ContextVar2", "20");
        hashtable.put("transactionAmount", "800");
    }
}