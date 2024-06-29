package java8;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        // Empty
        Optional<String> optionalEmpty = Optional.empty();

        // For value
        Optional<String> optionalOf = Optional.of("Bonjour");

        // For nullable
        Optional<String> optionalNullable = Optional.ofNullable(null);

        String defaultValue = optionalNullable.orElse("Default Value");

        System.out.println(defaultValue);
        if (optionalOf.isPresent()) System.out.println(optionalOf.get());

        Optional<String> optionalFilter = optionalOf.filter(s -> s.startsWith("Bon"));
        if (optionalFilter.isPresent()) System.out.println(optionalFilter.get());

        Optional<String> optionalMap = optionalOf.map(String::toUpperCase);
        if (optionalMap.isPresent()) System.out.println(optionalMap.get());
    }
}
