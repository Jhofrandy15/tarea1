package javaapplication6;

/**
 * Clase principal - Punto de entrada de la aplicación
 * Demuestra el uso de polimorfismo y manejo de excepciones
 */
public class JavaApplication6 {
    
    /**
     * Método main - Inicia la aplicación
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        try {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║   BIENVENIDO AL JUEGO ADIVINA NÚMEROS   ║");
            System.out.println("║          Polimorfismo y Try-Catch       ║");
            System.out.println("╚════════════════════════════════════════╝\n");
            
            // Crear una instancia de JuegoAdvinaNumero
            // Demuestra polimorfismo: la referencia es de tipo Juego
            // pero el objeto es de tipo JuegoAdvinaNumero
            Juego juego = new JuegoAdvinaNumero(5, 50);
            
            // Llamada polimórfica al método Juega()
            juego.Juega();
            
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║      ¡GRACIAS POR JUGAR! ADIÓS          ║");
            System.out.println("╚════════════════════════════════════════╝");
            
        } catch (Exception e) {
            System.out.println("\n❌ Error crítico en la aplicación: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n✅ Programa finalizado correctamente.\n");
        }
    }
}
