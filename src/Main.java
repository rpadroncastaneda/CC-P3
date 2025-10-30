
import core.CallCounter;
import core.primitives.PRFunction;
import core.Potencia;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x;
        int y;

        if (args != null && args.length >= 2) {
            x = parseNonNegative(args[0], "x");
            y = parseNonNegative(args[1], "y");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce x (>=0): ");
            x = parseNonNegative(sc.nextLine(), "x");
            System.out.print("Introduce y (>=0): ");
            y = parseNonNegative(sc.nextLine(), "y");
        }

        PRFunction pow = Potencia.build();
        CallCounter.reset();
        int result = pow.apply(x, y);
        long calls = CallCounter.get();

        System.out.println("Resultado: " + x + "^" + y + " = " + result);
        System.out.println("Llamadas a funciones: " + calls);
    }

    private static int parseNonNegative(String s, String name) {
        try {
            int v = Integer.parseInt(s.trim());
            if (v < 0) throw new IllegalArgumentException(name + " debe ser >= 0");
            return v;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(name + " no es un entero válido: '" + s + "'");
        }
    }
}