import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // staticMethods();
        // metodoOrElse();
        pru3();
        // pru4();
        // pru5();
        // pru6();
    }

    public static void showMe(String title, Optional<?> optObj) {
        System.out.println("\n\n" + title + "\n");
        // Estamos usando el método toString() de la clase Optional.
        System.out.println("optObj: " + optObj);
        System.out.println("optObj.isPresent(): " + optObj.isPresent());
        System.out.println("optObj.isEmpty(): " + optObj.isEmpty());
    }

    public static void staticMethods() {
        // Estos son los tres métodos static que tiene la clase Optional.
        // Returns an empty Optional instance. No value is present for this Optional.
        showMe("Optional.empty()", Optional.empty());
        // Returns an Optional describing the given non-null value.
        showMe("Optional.of(456)", Optional.of(456));
        // Returns an Optional describing the given value, if non-null, otherwise
        // returns an empty Optional.
        showMe("Optional.ofNullable('Una cadena')", Optional.ofNullable("Una cadena"));
        showMe("Optional.ofNullable(null)", Optional.ofNullable(null));
    }

    public static void metodoOrElse() {
        /**
         * No hay problema, porque estoy realmente pasando un valor no null.
         * Como era de esperar, simplemente imprime "Hola"
         */
        System.out.println(Optional.of("Hola").orElse("Chau"));
        /**
         * Ahora le paso un argumento null. Me da NullPointerException.
         * O sea que no le puedo pasar un argumento null a este método.
         */
        // System.out.println(Optional.of(null).orElse("Chau"));
        /**
         * Ahora le paso un argumento null, pero este método sí lo admite.
         * No hay problema. Como era de esperar, imprime "Chau".
         */
        System.out.println(Optional.ofNullable(null).orElse("Chau"));
    }

    public static void pru3() {
        Optional<String> hola;
        hola = Optional.ofNullable("Hola");
        hola = Optional.ofNullable(null);

        String chau = hola
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // Poner acá toda la lógica que necesite. Al final
                    return ("Chau");
                });
        System.out.println(chau);
    }

    public static void pru4() {
        Optional<String> hola;
        hola = Optional.ofNullable("Hola");
        hola = Optional.ofNullable(null);

        hola.ifPresentOrElse(
                x -> {
                    System.out.println(x);
                },
                () -> System.out.println("NULL"));
    }

    public static void printEmail(Person person) {
        String email = person
                .getEmail()
                .map(String::toLowerCase)
                .orElse("email no proporcionado.");
        System.out.println(email);
    }

    public static void pru5() {
        Person jose = new Person("José", "JOSE@coldmail.com");
        Person miguel = new Person("Miguel", null);
        printEmail(jose);
        printEmail(miguel);
    }

    public static void print2Email(Person person) {
        if (person.getEmail().isPresent()) {
            String email = person.getEmail().get();
            System.out.println(email.toLowerCase());
        } else {
            System.out.println("email no proporcionado.");
        }
    }

    public static void pru6() {
        Person jose = new Person("José", "JOSE@coldmail.com");
        Person miguel = new Person("Miguel", null);
        print2Email(jose);
        print2Email(miguel);
    }
}
