package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;;

public class Stream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Filter
        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);

        // Map
        names.stream().map(n -> n.toUpperCase()).forEach(System.out::println);

        // Reduce
        String concatened = names.stream().reduce("Names", (accumulator, currentValue) -> accumulator + ", " + currentValue);
        System.out.println(concatened);
    }
}
