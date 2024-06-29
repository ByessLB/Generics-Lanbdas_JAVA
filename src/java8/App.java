package java8;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);

        // Factory<ArrayList<String>> arrayListFactory = () -> new ArrayList<>();
        Factory<ArrayList<String>> arrayListFactory = ArrayList::new;
        ArrayList<String> arrayList = arrayListFactory.create();
    }
}
