package javaapplication6;

import java.util.Scanner;
import java.util.Random;

/**
 * Clase JuegoAdvinaNumero que implementa el juego de adivinar números
 * Demuestra polimorfismo, herencia, try-catch-finally y validaciones
 */
public class JuegoAdvinaNumero extends Juego {
    private Scanner scanner;
    private Random random;
    private boolean continuar;
    
    /**
     * Constructor de JuegoAdvinaNumero
     * @param vidas Número inicial de vidas (1-10)
     * @param numero Número a adivinar (0-100)
     */
    public JuegoAdvinaNumero(int vidas, int numero) {
        super(vidas, numero);
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.continuar = true;
        
        // Validar y ajustar los parámetros si es necesario
        if (this.vidas < 1 || this.vidas > 10) {
            this.vidas = random.nextInt(10) + 1; // Generar vidas aleatorias entre 1 y 10
        }
        
        if (this.numero < 0 || this.numero > 100) {
            this.numero = random.nextInt(101); // Generar número aleatorio entre 0 y 100
        }
    }
    
    /**
     * Método Juega que implementa la lógica principal del juego
     * Utiliza try-catch-finally para manejar excepciones
     */
    @Override
    public void Juega() {
        ReiniciaPartida();
        
        while (continuar && vidas > 0) {
            try {
                System.out.println("\n--- INTENTO DE ADIVINAR ---");
                System.out.println("Vidas restantes: " + vidas);
                System.out.print("Adivina un número entre 0 y 100: ");
                
                // Validar que sea un número entero válido
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ ¡Error! Debes ingresar un número entero válido.");
                    scanner.nextLine(); // Limpiar el buffer
                    continue;
                }
                
                int intento = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del salto de línea
                
                // Validar que el número esté en el rango
                if (intento < 0 || intento > 100) {
                    System.out.println("❌ ¡Error! El número debe estar entre 0 y 100.");
                    continue;
                }
                
                // Comparar con el número a adivinar
                if (intento == numero) {
                    System.out.println("\n🎉 ¡¡¡ACERTASTE!!! 🎉");
                    System.out.println("El número era: " + numero);
                    ActualizaRecord();
                    break;
                } else {
                    // Proporcionar pista
                    if (intento < numero) {
                        System.out.println("❌ Incorrecto. El número es MÁS GRANDE que " + intento);
                    } else {
                        System.out.println("❌ Incorrecto. El número es MÁS PEQUEÑO que " + intento);
                    }
                    
                    // Quitar una vida
                    if (!QuitaVida()) {
                        System.out.println("\n💀 ¡¡SE ACABARON LAS VIDAS!! 💀");
                        System.out.println("El número correcto era: " + numero);
                        continuar = false;
                    }
                }
                
            } catch (Exception e) {
                System.out.println("❌ Error al procesar la entrada: " + e.getMessage());
                scanner.nextLine(); // Limpiar el buffer
            } finally {
                // El finally se ejecuta siempre, útil para limpiar recursos
                // En este caso, simplemente continuamos con el juego
            }
        }
        
        // Preguntar si desea jugar nuevamente
        System.out.println("\n¿Deseas jugar otra partida? (s/n): ");
        String respuesta = scanner.nextLine().toLowerCase();
        if (respuesta.equals("s")) {
            continuar = true;
            ActualizaRecord();
            Juega(); // Llamada recursiva para jugar nuevamente
        } else {
            System.out.println("\n¡Gracias por jugar! Adiós.");
            continuar = false;
        }
    }
    
    /**
     * Método que reinicia la partida preguntando si desea continuar
     * Implementa try-catch-finally
     */
    @Override
    public void ReiniciaPartida() {
        try {
            System.out.println("\n=== NUEVO JUEGO - ADIVINA EL NÚMERO ===");
            System.out.println("¿Deseas comenzar a jugar? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            
            if (!respuesta.equals("s")) {
                continuar = false;
                System.out.println("Juego cancelado.");
            } else {
                continuar = true;
                System.out.println("¡Que comience el juego!");
            }
        } catch (Exception e) {
            System.out.println("Error al reiniciar la partida: " + e.getMessage());
            continuar = false;
        } finally {
            if (continuar) {
                System.out.println("Tienes " + vidas + " vidas para adivinar el número.");
            }
        }
    }
    
    /**
     * Método que actualiza el registro generando nuevos parámetros
     * Genera nuevas vidas (1-10) y nuevo número (0-100)
     */
    @Override
    public void ActualizaRecord() {
        try {
            vidas = random.nextInt(10) + 1; // Generar vidas aleatorias entre 1 y 10
            numero = random.nextInt(101);   // Generar número aleatorio entre 0 y 100
            System.out.println("\n✅ Registro actualizado.");
            System.out.println("Nuevo número generado. Nuevas vidas: " + vidas);
        } catch (Exception e) {
            System.out.println("Error al actualizar el registro: " + e.getMessage());
        }
    }
    
    /**
     * Método que quita una vida
     * @return true si quedan vidas, false si no quedan vidas
     */
    @Override
    public boolean QuitaVida() {
        try {
            vidas--;
            if (vidas > 0) {
                System.out.println("Te queda " + vidas + " vida(s).");
                return true;
            } else {
                System.out.println("¡Se acabaron las vidas!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al quitar vida: " + e.getMessage());
            return false;
        }
    }
}
