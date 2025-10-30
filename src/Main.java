
import core.CallCounter;
import core.primitives.PRFunction;
import core.Potencia;
import java.util.Scanner;

public class Main {
    /**
     * Calcula potencia(x, y) = x^y sobre N usando funciones recursivas primitivas.
     * Entrada: x e y por argumentos (o por teclado si se omiten).
     * Salida: resultado y número de llamadas a funciones realizadas.
     * Nota: el contador incluye todas las invocaciones a primitivas y operadores PR.
     */
    public static void main(String[] args) {
        int x_value, y_value;

        if (args != null && args.length >= 2) {
            x_value = parseNonNegative(args[0], "x");
            y_value = parseNonNegative(args[1], "y");
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.print("Introduce x (>=0): ");
            x_value = parseNonNegative(scan.nextLine(), "x");
            System.out.print("Introduce y (>=0): ");
            y_value = parseNonNegative(scan.nextLine(), "y");
        }

        PRFunction pow = Potencia.build();
        CallCounter.reset();
        int result = pow.apply(x_value, y_value);
        long calls = CallCounter.get();

        System.out.println("Resultado: " + x_value + "^" + y_value + " = " + result);
        System.out.println("Llamadas a funciones: " + calls);
    }

    /**
     * Parsea un entero no negativo.
     * @param input texto introducido
     * @param name nombre del parámetro (para mensajes de error)
     * @return valor entero >= 0
     * @throws IllegalArgumentException si no es un entero válido o es negativo
     */
    private static int parseNonNegative(String input, String name) {
        try {
            int value = Integer.parseInt(input.trim());
            if (value < 0) throw new IllegalArgumentException(name + " debe ser >= 0");
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(name + " no es un entero válido: '" + input + "'");
        }
    }
}