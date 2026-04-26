# Tarea 1 - Polimorfismo y Try-Catch-Finally

## Descripción del Proyecto

Sistema de juego "Adivina el Número" desarrollado en Java que demuestra conceptos clave de programación orientada a objetos:

- **Polimorfismo**: Herencia de clases abstractas
- **Try-Catch-Finally**: Manejo robusto de excepciones
- **Validaciones**: Control de entrada de datos
- **Encapsulación**: Gestión de datos privados

## Estructura del Proyecto

```
src/javaapplication6/
├── Juego.java                    # Clase abstracta base
├── JuegoAdvinaNumero.java        # Implementación del juego
└── JavaApplication6.java         # Clase main ejecutable
```

## Componentes

### 1. Juego.java (Clase Abstracta)
- Define la estructura base del juego
- Métodos abstractos:
  - `Juega()`: Lógica principal del juego
  - `ReiniciaPartida()`: Reiniciar la partida
  - `ActualizaRecord()`: Generar nuevos parámetros
  - `QuitaVida()`: Decrementar vidas

### 2. JuegoAdvinaNumero.java (Implementación)
Implementa toda la lógica del juego:

**Constructor:**
- Recibe vidas (1-10) y número (0-100)
- Auto-genera parámetros si son inválidos

**Validaciones Incluidas:**
- ✅ Solo acepta números enteros válidos
- ✅ Rango validado (0-100)
- ✅ Vidas validadas (1-10)
- ✅ Manejo de entrada inválida
- ✅ Try-catch-finally en cada método

**Funcionalidades:**
- 🎮 Pistas (número mayor/menor)
- ❤️ Sistema de vidas
- 🔄 Opción de jugar nuevamente
- 🎉 Mensajes con emojis para mejor UX

### 3. JavaApplication6.java (Punto de Entrada)
- Método `main()` que inicia la aplicación
- Demuestra polimorfismo
- Manejo de excepciones críticas

## Cómo Ejecutar

### En NetBeans (RECOMENDADO):
1. Abre tu proyecto `JavaApplication6`
2. Copia los 3 archivos `.java` a la carpeta `src/javaapplication6/`
3. Click derecho en `JavaApplication6.java`
4. Selecciona **"Run File"** (o presiona Shift + F6)
5. ¡A jugar!

### En Línea de Comandos:
```bash
cd ruta/del/proyecto
javac src/javaapplication6/*.java
java -cp src javaapplication6.JavaApplication6
```

## Flujo del Juego

```
1. Iniciar aplicación
2. Confirmar si desea jugar
3. Sistema genera vidas (1-10) y número (0-100)
4. Usuario intenta adivinar
5. Sistema proporciona pistas (mayor/menor)
6. Si acierta → ¡Acertaste! → Opción de jugar otra
7. Si falla → Pierde una vida
8. Si se acaban vidas → Fin del juego
9. Opción de jugar nuevamente
```

## Validaciones Implementadas

| Validación | Descripción | Tipo |
|-----------|-------------|------|
| Entrada Numérica | Solo acepta números enteros | Try-Catch |
| Rango (0-100) | Valida número dentro del rango | If-Else |
| Vidas (1-10) | Valida cantidad de vidas | If-Else |
| Entrada Inválida | Maneja entradas no numéricas | Try-Catch |
| Buffer | Limpia buffer del scanner | nextLine() |

## Conceptos OOP Demostrados

### Polimorfismo
```java
Juego juego = new JuegoAdvinaNumero(5, 50);
juego.Juega(); // Llamada polimórfica
```

### Herencia
```java
public class JuegoAdvinaNumero extends Juego
```

### Encapsulación
```java
protected int vidas;
protected int numero;
```

### Try-Catch-Finally
```java
try {
    // Código que puede lanzar excepciones
} catch (Exception e) {
    // Manejo de errores
} finally {
    // Siempre se ejecuta
}
```

## Requisitos del Sistema

- Java 8 o superior
- NetBeans (recomendado) o cualquier IDE Java
- Terminal/CMD para ejecución en línea de comandos

## Profesor

**Prof. Fausto Martínez Jiménez**
Programación II - UTESA

## Autor

**Jhofrandy15**
Universidad Tecnológica de Santiago (UTESA)

## Licencia

Este proyecto es de propósito educativo.

---

**Última actualización:** 2026-04-26
