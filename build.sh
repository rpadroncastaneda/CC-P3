#!/bin/bash

# Carpeta de salida para los .class
OUT="out"

case "$1" in
  build)
    echo "Compilando proyecto..."
    mkdir -p $OUT
    # Compila todos los .java de src/
    javac -d $OUT $(find src -name "*.java")
    ;;
  run)
    shift
    echo "Ejecutando proyecto..."
    # Main class is in the default package
    java -cp $OUT Main "$@"
    ;;
  clean)
    echo "Limpiando archivos compilados..."
    rm -rf $OUT
    ;;
  *)
    echo "Uso: ./build.sh {build|run|clean}"
    ;;
esac
