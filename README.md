# Génériques et Paramètres de Types

Les génériques permettent de créer des classes, des interfaces et des méthodes avec type de donnée paramétrable. Cela améliore considérablement la sécurité à la compilation, dont la sécurité de type et cela réduit le besoin de convertion à chaque fois.

## I/ Génériqeus pour les classes :

- Une classe générique permet de définir une classe qui peut fonctionner avec différents types de données.
- La syntaxe utilise les symboles `<` et `>` pour précriser le ou les types des objets à utiliser.
- Exemple :

```java
import java.util.*;

public class avecGenerique {
    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        // ...
    }
}
```

## II/ Génériques pour les méthodes :

- Une méthode générique a un type paramétré avant le type de retour.
- Les paramètres de type agissent comme des espaces réservés pour les types d'arguments passés à la méthode générique.
- Exemple :

```java
public <T> void afficher(T[] tableau) {
    // ...
}
```

## III/ Avantages des génériques :

- Sécurité des types : le compilateur vérifie les types au moment de la compilation.
- Lisibilité du code : précise explicitement le type d'objet.
- Evites les casts inutiles.

## IV/ Types Limités et Wildcards (joker) :

- Les wildcards permettent de manipuler des types inconnus ou de spécifier des restrictions sur les types utilisés dans des classes, méthodes ou interfaces génériques.
- Trois types de wildcards :
    - **Upper bound wildcard** (borne supérieure) : Utilise `extends` pour restreindre les types possibles (exemple : `List<? extends Number>` : la liste accepte  des objets de type Number ou de type hérité de Number).
    - **Lower bound wildcard** (borne inférieure) : Utilise `super` pour accepter des types plus larges (exemple : `List<? super Integer` : la liste accepte au moins des objets de type Integer ou de type hérité de Integer).
    - **Unbounded wildcard** (sans borne) : Utilise `?` pour accepter n'importe quel type (exemple : `List<?>` : la liste accepte n'importe quel type).

En résumé, les wildcards rendent le code plus souple et plus flexible, tandis que les paramètres te type sont utilisés pour créer des composants génériques spécifiques.

## V/ Interfaces fonctionnelles et expressions Lambdas :

### Interfaces fonctionnelles :

- Une interface fonctionnelle est une interface qui ne contient qu'une seule méthode abstraite.
- A partir de java 8, les expressions lambda peuvent être utilisées pour représenter l'instance d'une interface fonctionnelle.
- Exemples d'interfaces fonctionnelles : `Runnable`, `ActionListener`, `Comparable`.
- L'annotation `@FunctionalInterface` garantit qu'une interface ne possède qu'une seule méthode abstraite.

### Expressions lambda :

- Les expressions lambdas fournissent l'implémentation d'une interface fonctionnelle.
- Elles permettent de créer des fonctions sans appartenir à une classe spécifique.
- Syntaxe : `(liste d'arguments) -> { corps lambda }`.
- Utilisées pour traiter des fonctions en tant qu'arguments de méthode ou pour manipuler du code comme des données.

En résumé, les interface fonctionnelles et les expressions lamba sont des fonctionnalités puissantes de Java 8 pour simplifier la programmation fonctionnelle et rendre le code plus concis et lisible.


## VI/ Les références aux méthodes et contstructeurs :

### Références de Méthodes :

- Les références de méthodes sont un type spécial d'expression lambda.
- Elles permettent de créer des expressions lambda simples en référençant des méthodes existantes.
- Trois types de références de méthodes :
    - **Référence de méthode statique** : Vous pouvez référencez une méthode statique définie dans une classe. La syntaxe est `ClasseName::staticMethodName`.
    - **Référence de méthode d'instance** : Vous pouvez référencez une méthode d'instance. La syntaxe est `ObjectName::instanceMethodName`.
    - **Référence à un constructeur** : Vous pouvez référencez un constructeur en utilisant le mot-clé `new`. La syntaxe est `ClassName::new`.

### Constructeurs :

- Les constructeurs ne renvoient aucun type, contrairement aux méthodes qui ont un type de retour (ou `void` si elles ne renvoient aucune valeur).
- Le constructeur est appelé une seule fois lors de la création de l'objet, tandis que les méthodes peuvent être appelées plusieurs fois.

En résumé, les références de méthodes permettent de simplifier la création d'expression lambda, tandis que les constructeurs sont utilisés pour initialiser les objets de leur création.

## L'API Stream :

L'API Stream en Java 8 est un outil puissant pour manipuler des collections de données de manière déclarative.
Un Stream est une séquence d'éléments provenant d'une source tel qu'une collection ou un tableau.
Il permet d'effectuer des opérations sur ces éléments de manière fluide et expressive.

### Création d'un Stream :

- A partir d'une liste :

```java
List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
Stream<String> stream = noms.stream();
```
- A partir d'une tableau :
```java
String[] prenoms = {"Alice", "Bob", "Charlie"};
Stream<String> stream = Arrays.stream(prenoms);
```

### Opérations sur le Stream :

- **Filtrage (Filter)** : (Filtrer les noms commençant par "A").
```java
streamNoms.filter(nom -> nom.startsWith("A")).forEach(System.out::println).
```
- **Transformation (Map)** : (Convertir les noms en majuscules).
```java
streamNoms.map(nom -> nom.toUpperCase()).forEach(System.out::println);
```
- **Réduction (Reduce)** : (Concaténer tous les noms avec la chaîne "Noms").
```java
String concatene = streamNoms.reduce("Noms", (acc, nom) -> acc + ", " + nom);
System.out.println(concatene);
```

En résumé, l'API Stream simplifie la manipulation des données en utilisant une approche fonctionnelle et expressive.

## Les Optionals :

Les optionals sont une fonctionnalité introduite dans java8, et il font partie de la classe `java.util.Optional`. 
- Qu'est-ce qu'un Optional ?
    - Un `Optional` est un conteneur qui peut contenir une valeur non nulle ou être vide.
    - Si une valeur est présente, la méthode `isPresent()` renverra `true`, et `get()` renverra la valeur.
    - Les `Optionals` permettent d'éviter les vérifications excessives de null et rendent le code plus lisible.
- Méthodes courantes de la class `Optional` :
    - `of(T value)` : Crée un `Optional` avec une valeur non nulle.
    - `ofNullable(T value)` : Crée un `Optional` avec une valeur (peut être nulle).
    - `empty()` : Crée un `Optional` vide.
    - `orElse(T other)` : Renvoie la valeur si présente, sinon renvoie une valeur par défaut.
    - `orElseGet(Supplier<? extends T> other)` : Renvoie la valeur si présente, sinon exécute un bloc de code pour obtenir une valeur alternative.
    - `ifPresent(Consumer<? super T> consumer)` : Exécute un bloc de code si la valeur est présente.

En résumé, les `Optionals` simplifie la gestion des valeurs potentiellement nulles et améliorent la lisibilité du code.

"# Generics-Lanbdas_JAVA" 
