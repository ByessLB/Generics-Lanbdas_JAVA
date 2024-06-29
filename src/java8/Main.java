package java8;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        int x = 10, y = 3;

        // Operation addition = new Operation() {
        //     @Override
        //     public int operate(int a, int b) {
        //         return a + b;
        //     }
        // };

        Operation addition = (a, b) -> a + b;
        Operation multiplication = (a, b) -> a * b;

        System.out.println(addition.operate(x, y));
        System.out.println(multiplication.operate(x, y));

        Predicate<String> atChecker = str -> str.contains("@");

        System.out.println(atChecker.test("email@"));
    }
}
