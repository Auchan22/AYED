# Ejercicio 1
### Inciso a: tabla de tiempos de ejecución

| N° cuentas (y consultas) | procesarMovimientos | procesarMovimientosOptimizado |
|--------------------------|---------------------|-------------------------------|
| 1.000                    | 0.043 segundos      | 0.001 segundos                |
| 10.000                   | 0.758 segundos      | 0.001 segundos                |
| 25.000                   | 4.812 segundos      | 0.02 segundos                 |
| 50.000                   | 17.902 segundos     | 0.034 segundos                |
| 100.000                  | 0.037 segundos      | 0.001 segundos                |

```mermaid
xychart-beta
    title "Tiempos de ejecución - procesarMovimientos"
    x-axis "Tiempo (en segundos)"["0.037", "17.902", "4.812", "0.758", "0.043"]
    y-axis "N° de Cuentas (y consultas)" 1000 --> 100000
    line [100000, 50000, 25000, 10000, 1000]
```
```mermaid
xychart-beta
    title "Tiempos de ejecución - procesarMovimientosOptimizado"
    x-axis "Tiempo (en segundos)"["0.001", "0.001", "0.02", "0.001", "0.001"]
    y-axis "N° de Cuentas (y consultas)" 1000 --> 100000
    line [100000, 50000, 25000, 10000, 1000]
```

### Inciso b

