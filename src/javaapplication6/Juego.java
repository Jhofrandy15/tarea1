package javaapplication6;

/**
 * Clase abstracta Juego que define la estructura base para los juegos
 * Demuestra el uso de polimorfismo en Java
 */
public abstract class Juego {
    protected int vidas;
    protected int numero;
    
    /**
     * Constructor de la clase Juego
     * @param vidas Número inicial de vidas (debe estar entre 1 y 10)
     * @param numero Número a adivinar (debe estar entre 0 y 100)
     */
    public Juego(int vidas, int numero) {
        this.vidas = vidas;
        this.numero = numero;
    }
    
    /**
     * Método abstracto que debe implementarse en las subclases
     * Define la lógica principal del juego
     */
    public abstract void Juega();
    
    /**
     * Método abstracto para reiniciar la partida
     */
    public abstract void ReiniciaPartida();
    
    /**
     * Método abstracto para actualizar el registro con nuevos parámetros
     */
    public abstract void ActualizaRecord();
    
    /**
     * Método abstracto para quitar una vida
     * @return true si quedan vidas, false si no quedan vidas
     */
    public abstract boolean QuitaVida();
    
    // Getters y Setters
    public int getVidas() {
        return vidas;
    }
    
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
