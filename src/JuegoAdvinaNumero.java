import java.util.Random;
import java.util.Scanner;

/**
 * Clase JuegoAdvinaNumero que extiende la clase base Juego.
 * Implementa el juego de adivinar un número con manejo de excepciones
 * y validaciones de entrada.
 *
 * Universidad Tecnológica de Santiago (UTESA)
 * Programación II - Polimorfismo y manejo de excepciones
 */
public class JuegoAdvinaNumero extends Juego {

    // Objeto para leer la entrada del usuario
    private Scanner scanner;

    // Objeto para generar números aleatorios
    private Random random;

    // Indica si el jugador desea continuar jugando
    private boolean continuarJugando;

    // Vidas mínimas y máximas permitidas
    private static final int VIDAS_MINIMAS = 1;
    private static final int VIDAS_MAXIMAS = 10;

    // Rango del número a adivinar
    private static final int NUMERO_MINIMO = 0;
    private static final int NUMERO_MAXIMO = 100;

    /**
     * Constructor que recibe el número de vidas y el número a adivinar.
     * Ambos parámetros se generan automáticamente si no son válidos.
     *
     * @param vidas         Número de vidas (1-10)
     * @param numeroAdivinar Número a adivinar (0-100)
     */
    public JuegoAdvinaNumero(int vidas, int numeroAdivinar) {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.continuarJugando = true;

        // Validar y asignar las vidas
        if (vidas >= VIDAS_MINIMAS && vidas <= VIDAS_MAXIMAS) {
            this.vidas = vidas;
        } else {
            // Generar vidas automáticamente si el valor no es válido
            this.vidas = VIDAS_MINIMAS + random.nextInt(VIDAS_MAXIMAS);
            System.out.println("Vidas generadas automáticamente: " + this.vidas);
        }

        // Validar y asignar el número a adivinar
        if (numeroAdivinar >= NUMERO_MINIMO && numeroAdivinar <= NUMERO_MAXIMO) {
            this.numeroAdivinar = numeroAdivinar;
        } else {
            // Generar número automáticamente si el valor no es válido
            this.numeroAdivinar = random.nextInt(NUMERO_MAXIMO + 1);
            System.out.println("Número a adivinar generado automáticamente.");
        }
    }

    /**
     * Método principal del juego. Controla el flujo de la partida:
     * - Llama a ReiniciaPartida() para verificar si el usuario desea jugar
     * - Solicita al usuario que adivine el número
     * - Compara la entrada con el número predefinido
     * - Gestiona vidas y mensajes al usuario
     * Utiliza try-catch-finally para manejo de excepciones.
     */
    @Override
    public void Juega() {
        // Llamar a ReiniciaPartida para preguntar al usuario si desea jugar
        ReiniciaPartida();

        // Bucle principal del juego mientras el usuario quiera continuar
        while (continuarJugando) {
            System.out.println("\n========================================");
            System.out.println("   JUEGO: ADIVINA EL NÚMERO");
            System.out.println("========================================");
            System.out.println("Vidas restantes: " + vidas);

            boolean adivinado = false;

            // Bucle de intentos dentro de la misma partida
            while (!adivinado) {
                System.out.print("\nAdivina un número entre " + NUMERO_MINIMO
                        + " y " + NUMERO_MAXIMO + ": ");

                try {
                    // Leer el número ingresado por el usuario
                    String entradaTexto = scanner.nextLine().trim();
                    int numeroIngresado = Integer.parseInt(entradaTexto);

                    // Validar que el número esté en el rango permitido
                    if (numeroIngresado < NUMERO_MINIMO || numeroIngresado > NUMERO_MAXIMO) {
                        System.out.println("⚠  El número debe estar entre "
                                + NUMERO_MINIMO + " y " + NUMERO_MAXIMO
                                + ". Inténtalo de nuevo.");
                        continue;
                    }

                    // Comparar con el número predefinido
                    if (numeroIngresado == numeroAdivinar) {
                        // El usuario adivinó correctamente
                        System.out.println("\n🎉 ¡¡Acertaste!! El número era: " + numeroAdivinar);
                        ActualizaRecord();
                        adivinado = true;

                    } else {
                        // El número es incorrecto, quitamos una vida
                        boolean quedanVidas = QuitaVida();

                        if (quedanVidas) {
                            // Todavía quedan vidas, indicar si el número es mayor o menor
                            if (numeroIngresado < numeroAdivinar) {
                                System.out.println("📈 El número a adivinar es MAYOR que " + numeroIngresado);
                            } else {
                                System.out.println("📉 El número a adivinar es MENOR que " + numeroIngresado);
                            }
                            System.out.println("Vidas restantes: " + vidas + ". ¡Inténtalo de nuevo!");

                        } else {
                            // No quedan vidas, el juego termina
                            System.out.println("\n💔 ¡Se acabaron las vidas! El número era: " + numeroAdivinar);
                            adivinado = true; // Salir del bucle de intentos
                        }
                    }

                } catch (NumberFormatException e) {
                    // Manejar entrada no numérica
                    System.out.println("⚠  Entrada inválida. Por favor, ingresa solo números enteros.");

                } finally {
                    // El bloque finally se ejecuta siempre, independientemente de si hubo excepción
                    // Aquí podría registrarse cada intento si fuera necesario
                }
            }

            // Preguntar al usuario si desea jugar de nuevo
            ReiniciaPartida();
        }

        System.out.println("\n¡Gracias por jugar! Hasta la próxima. 👋");
    }

    /**
     * Pregunta al usuario si desea continuar jugando.
     * Actualiza el atributo continuarJugando según la respuesta.
     * Utiliza try-catch para manejar entradas inválidas.
     */
    @Override
    public void ReiniciaPartida() {
        boolean respuestaValida = false;

        while (!respuestaValida) {
            System.out.print("\n¿Deseas continuar jugando? (s/n): ");

            try {
                String respuesta = scanner.nextLine().trim().toLowerCase();

                if (respuesta.equals("s") || respuesta.equals("si")
                        || respuesta.equals("sí") || respuesta.equals("y")
                        || respuesta.equals("yes")) {
                    continuarJugando = true;
                    respuestaValida = true;
                    // Generar nuevos parámetros para la nueva partida
                    ActualizaRecord();

                } else if (respuesta.equals("n") || respuesta.equals("no")) {
                    continuarJugando = false;
                    respuestaValida = true;

                } else {
                    System.out.println("⚠  Respuesta inválida. Por favor escribe 's' para sí o 'n' para no.");
                }

            } catch (Exception e) {
                System.out.println("⚠  Error al leer la entrada: " + e.getMessage());
            } finally {
                // El bloque finally garantiza que el flujo continúe correctamente
            }
        }
    }

    /**
     * Actualiza el récord generando automáticamente nuevos valores
     * para vidas y número a adivinar.
     */
    @Override
    public void ActualizaRecord() {
        // Generar un nuevo número de vidas entre VIDAS_MINIMAS y VIDAS_MAXIMAS
        this.vidas = VIDAS_MINIMAS + random.nextInt(VIDAS_MAXIMAS);

        // Generar un nuevo número a adivinar entre NUMERO_MINIMO y NUMERO_MAXIMO
        this.numeroAdivinar = random.nextInt(NUMERO_MAXIMO + 1);

        System.out.println("✅ Nueva partida iniciada con " + vidas + " vidas. ¡Buena suerte!");
    }

    /**
     * Quita una vida al jugador.
     *
     * @return true si aún quedan vidas, false si ya no quedan vidas
     */
    @Override
    public boolean QuitaVida() {
        vidas--;
        return vidas > 0;
    }
}
