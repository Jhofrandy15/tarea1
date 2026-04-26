import java.util.Random;

/**
 * Clase Aplicacion - Punto de entrada del programa.
 * Crea una instancia de JuegoAdvinaNumero e inicia el juego.
 *
 * Universidad Tecnológica de Santiago (UTESA)
 * Programación II - Polimorfismo y manejo de excepciones
 */
public class Aplicacion {

    /**
     * Método principal que crea una instancia de JuegoAdvinaNumero
     * y llama al método Juega().
     *
     * @param args Argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Random random = new Random();

        // Generar parámetros automáticamente al iniciar la aplicación
        // Vidas: entre 1 y 10
        int vidasIniciales = 1 + random.nextInt(10);

        // Número a adivinar: entre 0 y 100
        int numeroAdivinar = random.nextInt(101);

        System.out.println("========================================");
        System.out.println("  BIENVENIDO AL JUEGO ADIVINA EL NÚMERO");
        System.out.println("========================================");
        System.out.println("Se generaron " + vidasIniciales + " vidas para esta sesión.");

        // Crear una instancia del juego con los parámetros generados
        JuegoAdvinaNumero juego = new JuegoAdvinaNumero(vidasIniciales, numeroAdivinar);

        // Iniciar el juego
        juego.Juega();
    }
}
