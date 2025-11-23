# Radix-Sort-numeros

¿Cómo funciona el algoritmo Radix Sort?

El algoritmo Radix Sort es un método de ordenamiento que trabaja a partir de los dígitos de los números. A diferencia de otros algoritmos que comparan elementos directamente, Radix Sort ordena los valores dígito por dígito, comenzando desde el menos significativo (LSD) hasta el más significativo. Este proceso permite ordenar números enteros de manera rápida y estable.

1. Identificación del número con más dígitos

Para comenzar, se busca el número más grande del arreglo. Esto sirve para saber cuántas veces se debe repetir el proceso de ordenamiento por dígitos.

Ejemplo: si el número más grande es 924 → tiene 3 dígitos, así que el algoritmo realizará 3 pasadas.

2. Ordenamiento por cada dígito (LSD → MSD)

Radix Sort trabaja en ciclos.
En cada ciclo se ordena el arreglo según un solo dígito, empezando por:

las unidades (1),

luego las decenas (10),

después las centenas (100),

y así sucesivamente.

Para hacer este ordenamiento por dígitos, el algoritmo utiliza un método auxiliar llamado Counting Sort, pero aplicado únicamente al dígito que corresponde a esa pasada.

3. Counting Sort por dígito

En cada iteración:

Se obtiene el dígito actual de cada número (por ejemplo, solo las unidades).

Se cuentan las ocurrencias de cada dígito del 0 al 9.

Se calculan posiciones acumuladas para saber dónde debe ir cada elemento.

Se genera un nuevo arreglo ordenado por ese dígito.

Este proceso mantiene el orden relativo de los elementos, lo cual hace que Radix Sort sea un algoritmo estable.

4. Repetir el proceso

Una vez que termina el ordenamiento por el dígito actual, el algoritmo pasa al siguiente (decenas, centenas, etc.).
Cuando ya se procesaron todos los dígitos del número más grande, el arreglo queda completamente ordenado.

- En resumen general

Radix Sort funciona así:

Encontrar el número con más dígitos.

Ordenar el arreglo por cada dígito de menor a mayor importancia.

Utilizar Counting Sort en cada pasada para mantener estabilidad.

Repetir hasta procesar todos los dígitos.

- Ventaja principal

Radix Sort es muy eficiente cuando trabajamos con muchos números y especialmente cuando tienen un tamaño similar. Además, al no basarse en comparaciones directas, puede ofrecer un rendimiento mejor que otros algoritmos clásicos en ciertos casos.