
// ! Les génériques
// Reproduction d'une méthode Map<K, V>();

public class Pair<K, V> {

    private K key;
    private V value;

    // Constructor
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
