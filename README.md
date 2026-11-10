# Ejercicio 3 — BurgerLab

Programación 1 · Universidad Libre · Docente: Andrés Castaño

## Cómo ejecutarlo

```bash
javac -d out src/*.java
java -cp out Main
```

## Qué hace

Arma los pedidos de hamburguesas con proteína, porciones, pan, ingredientes extra y salsa.

## Qué se resolvió

- **Antes:** el constructor tenía nueve parámetros, con varios `boolean` seguidos y `null` como relleno. Nadie sabía qué significaba cada valor (el pedido 1 salió con queso en vez de tocineta), el pan y la salsa quedaban en `null` y se aceptaban pedidos imposibles como 7 porciones.
- **Ahora:** se aplicó **Builder**. Cada ingrediente se agrega por su nombre (`conTocineta()`, `conQueso()`, ...). El pan por defecto es brioche y la salsa por defecto es "ninguna". La proteína y las porciones son obligatorias, y `build()` rechaza con una excepción los pedidos de más de 3 porciones
