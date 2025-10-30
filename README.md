# Potencia como función recursiva primitiva

Implementación orientada a objetos de la función potencia potencia(x, y) = x^y sobre N utilizando funciones recursivas primitivas: funciones iniciales (cero, sucesor, proyección) y operadores (composición y recursión primitiva). El programa imprime el resultado y el número total de llamadas a funciones realizadas durante el cálculo.

## Estructura

- `src/Main.java`: CLI; lee x e y (args o teclado), evalúa x^y y muestra resultado y llamadas.
- `src/core/CallCounter.java`: contador global, thread-safe, de invocaciones a funciones PR.
- `src/core/Potencia.java`: factoría de la función pow(x,y) a partir de add y mult definidas con PR.
- `src/core/Primitives/PRFunction.java`: interfaz común de funciones PR.
- `src/core/Primitives/AbstractFunction.java`: base con aridad y registro de invocaciones.
- `src/core/Primitives/Functions/Zero.java`: Z^n (constante 0 para aridad n).
- `src/core/Primitives/Functions/Successor.java`: S(x) = x + 1 (aridad 1).
- `src/core/Primitives/Functions/Projection.java`: P(i,n) devuelve el i‑ésimo argumento.
- `src/core/Primitives/Operations/Composition.java`: f(g1(...),...,gm(...)).
- `src/core/Primitives/Operations/PrimitiveRecursion.java`: operador de recursión primitiva.

## Compilación y ejecución (Windows PowerShell)

```powershell
# Compilar todo a out/
mkdir -Force out
javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })

# Ejecutar con argumentos (x y)
java -cp out Main 2 10

# Ejecutar sin argumentos (pedirá por teclado)
java -cp out Main
```

Salida de ejemplo:

```
Resultado: 2^10 = 1024
Llamadas a funciones: <número grande>
```

## Resumen de implementación

- add(x, y): recursión primitiva sobre x (base: y; paso: sucesor del acumulado).
- mult(x, y): recursión primitiva sobre x a partir de add (suma repetida).
- pow(x, y): recursión primitiva sobre y (base: 1; paso: multiplicación por x); se expone como (x, y) mediante composición que permuta argumentos.

## Autor

Roberto Padrón Castañeda  
Complejidad Computacional - Curso 2025/26
