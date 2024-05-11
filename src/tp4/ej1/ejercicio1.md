# Ejercicio 1
### Inciso a: tabla de tiempos de ejecución

| N° cuentas (y consultas) | procesarMovimientos | procesarMovimientosOptimizado |
|--------------------------|---------------------|-------------------------------|
| 1.000                    | 0.043 segundos      | 0.001 segundos                |
| 10.000                   | 0.758 segundos      | 0.001 segundos                |
| 25.000                   | 4.812 segundos      | 0.02 segundos                 |
| 50.000                   | 17.902 segundos     | 0.034 segundos                |
| 100.000                  | 72.45 segundos      | 0.058 segundos                |

```mermaid
xychart-beta
    title "Tiempos de ejecución - procesarMovimientos"
    x-axis "Tiempo (en segundos)"["0.043", "0.758", "4.812", "17.902", "72.45"]
    y-axis "N° de Cuentas (y consultas)" 1000 --> 100000
    line [1000, 10000, 25000, 50000, 100000]
```
```mermaid
xychart-beta
    title "Tiempos de ejecución - procesarMovimientosOptimizado"
    x-axis "Tiempo (en segundos)"["0.001", "0.001", "0.02", "0.034", "0.058"]
    y-axis "N° de Cuentas (y consultas)" 1000 --> 100000
    line [1000, 10000, 25000, 50000, 100000]
```

### Inciso b

