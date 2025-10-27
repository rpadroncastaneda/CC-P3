# Simulador de Funciones recursivas

## Descripción

**Características principales:**

**Funciones implementadas:**

## Autor

Roberto Padrón Castañeda  
Complejidad Computacional - Curso 2025/26

## Compilación y Ejecución

### Script de construcción

El proyecto incluye un script `build.sh` que facilita la compilación y ejecución:

```bash
# Compilar el proyecto (crea archivos .class en out/)
./build.sh build

# Ayuda
./build.sh run -h
./build.sh run --help

# Limpiar archivos compilados
./build.sh clean
```

### Compilación y ejecución manual (alternativa)

Si prefieres no usar el script:

```bash
# Crear directorio y compilar
mkdir -p out
javac -d out $(find src -name "*.java")

javac -d out src\*.java src\core\*.java src\parser\*.java src\simulator\*.java src\transitions\*.java

# Ejecutar (requiere classpath correcto)
java -cp out Main -x 4 -y 5
```

## Estructura del proyecto

## Ejemplos de uso

## Opciones de línea de comandos
