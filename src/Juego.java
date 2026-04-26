/**
 * Clase base abstracta que define la estructura del juego.
 * Universidad Tecnológica de Santiago (UTESA)
 * Programación II - Polimorfismo y manejo de excepciones
 */
public abstract class Juego {

    // Número de vidas disponibles para el jugador
    protected int vidas;

    // Número secreto que el jugador debe adivinar
    protected int numeroAdivinar;

    /**
     * Método principal que contiene la lógica del juego.
     */
    public abstract void Juega();

    /**
     * Pregunta al usuario si desea continuar jugando y reinicia la partida.
     */
    public abstract void ReiniciaPartida();

    /**
     * Actualiza el récord generando nuevos valores para vidas y número a adivinar.
     */
    public abstract void ActualizaRecord();

    /**
     * Quita una vida al jugador.
     *
     * @return true si aún quedan vidas, false si ya no quedan
     */
    public abstract boolean QuitaVida();
}
