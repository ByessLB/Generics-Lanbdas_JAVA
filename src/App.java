
public class App {
    public static void main(String[] args) {

        /*
         * Box<Integer> integerBox = new Box<>();
         * Box<String> stringBox = new Box<>();
         *
         * integerBox.set(10);
         * stringBox.set("Hello");
         */

        Pair<String, Double> articlePrice = new Pair<>("Pull", 75.0);
        Pair<String, Integer> studentGrade = new Pair<>("Henry", 16);

        articlePrice.getKey();
        studentGrade.getValue();

        isEqual(articlePrice, studentGrade);
        isEqual(5, 5);
        isEqual("Test", "test");
    }

    //! Les Génériques
    // Reproduction de la méthode de comparaison
    static <T> boolean isEqual(T element1, T element2) {
        return element1.equals(element2);
    }
}
