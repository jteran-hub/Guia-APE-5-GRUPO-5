## GUIA PAE 5 

## 📑 Tabla de contenido

- [Temas que se practican](#-temas-que-se-practican)
- [Resumen de ejercicios](#-resumen-de-ejercicios)
- [Primera parte: lectura de archivos](#-primera-parte-lectura-de-archivos-grupo-5)
- [Segunda parte: lectura, escritura y procesamiento](#-segunda-parte-lectura-escritura-y-procesamiento)
- [Formato de los archivos de datos](#-formato-de-los-archivos-de-datos)



## 🧠 Temas que se practican

- ✅ Lectura **línea por línea** y **carácter por carácter**
- ✅ Escritura y **modo append** (sin borrar registros previos)
- ✅ Uso de `FileReader`, `BufferedReader`, `FileWriter` y `BufferedWriter`
- ✅ Conversión de **texto a números** (`parseInt`, `parseDouble`)
- ✅ Cálculo de **promedios, máximos, totales y conteos**
- ✅ **Filtrado** y **búsqueda** de registros
- ✅ **Validación** de existencia del archivo y del formato de los datos
- ✅ Manejo de excepciones (`IOException`, `NumberFormatException`, `FileNotFoundException`)

---

---

## 📋 Resumen de ejercicios

| #  | Ejercicio                    | Archivo               | Enfoque principal                                   |
|----|------------------------------|-----------------------|-----------------------------------------------------|
| 1  | 🕵️ Agencia de detectives      | `pistas.txt`          | Lectura línea por línea + contador                  |
| 2  | 🚀 Estación espacial          | `mensaje.txt`         | `FileReader` + `read()` carácter por carácter       |
| 3  | 🖼 Museo digital              | `obras.txt`           | Lectura de registros + clasificación por categoría  |
| 4  | 🏞 Parque de aventuras        | `resultados.txt`      | `BufferedReader` + total y máximo                   |
| 5  | 📚 Biblioteca inteligente     | `libros.txt`          | Registro, append, búsqueda y validación             |
| 6  | 🔐 Mensajes secretos          | `secreto.txt`         | `FileWriter`/`BufferedWriter` + lectura + errores   |
| 7  | 🎮 Competencia de videojuegos | `jugadores.txt`       | Parseo CSV, promedio, máximo y filtro (> 70)        |
| 8  | 🌡 Control de temperatura     | `temperaturas.txt`    | Guardar, convertir, promedio, máximo y filtro (> 30)|
| 9  | 🧭 Diario de exploradores     | `descubrimientos.txt` | Append, conteo, búsqueda y validación               |
| 10 | ☕ Ventas de una cafetería    | `ventas.txt`          | `BufferedWriter`, total, máximo y filtro por valor  |

---

## 📘 Primera parte: lectura de archivos (Grupo 5)

### 🕵️ Ejercicio 1 · Agencia de detectives: análisis de pistas

**Archivo:** `pistas.txt`

Una agencia de detectives almacena las pistas de una investigación en un archivo. El programa debe leer todas las pistas **línea por línea**, mostrarlas en pantalla y **contar** cuántas contiene el archivo.

- [ ] Leer `pistas.txt` línea por línea
- [ ] Mostrar cada pista en pantalla
- [ ] Contar el total de pistas

### 🚀 Ejercicio 2 · Estación espacial: descifrado de mensajes

**Archivo:** `mensaje.txt`

Una estación espacial recibe un mensaje de emergencia. El programa debe leer el archivo **carácter por carácter** usando `FileReader` y el método `read()`, mostrar su contenido y contabilizar el total de caracteres.

- [ ] Usar `FileReader` y `read()`
- [ ] Mostrar el contenido del mensaje
- [ ] Contar el número total de caracteres

### 🖼 Ejercicio 3 · Museo digital: registro de obras

**Archivo:** `obras.txt`

Cada línea contiene el **nombre de una obra y su categoría**. El programa debe leer los registros, mostrar las obras y **clasificar** cuántas pertenecen a cada categoría.

- [ ] Leer los registros nombre + categoría
- [ ] Mostrar las obras
- [ ] Contar obras por categoría

### 🏞 Ejercicio 4 · Parque de aventuras: resultados de participantes

**Archivo:** `resultados.txt`

El archivo guarda los nombres y puntajes de los participantes. El programa debe leer la información con `BufferedReader`, mostrar los participantes, calcular el **puntaje total** e identificar el **puntaje más alto**.

- [ ] Usar `BufferedReader`
- [ ] Mostrar los participantes
- [ ] Calcular el puntaje total
- [ ] Identificar el puntaje máximo

---

## 📗 Segunda parte: lectura, escritura y procesamiento

### 📚 Ejercicio 5 · Biblioteca inteligente

**Archivo:** `libros.txt`

Administrar los libros de una biblioteca mediante un archivo.

- [ ] Registrar nuevos libros
- [ ] Agregar información **sin eliminar** los registros anteriores
- [ ] Leer los títulos almacenados
- [ ] Buscar un libro específico
- [ ] Contar los libros registrados
- [ ] Validar que el archivo **exista** antes de leer

### 🔐 Ejercicio 6 · Sistema de mensajes secretos

**Archivo:** `secreto.txt`

Un grupo de investigadores almacena mensajes en un archivo.

- [ ] Escribir mensajes con `FileWriter` y `BufferedWriter`
- [ ] Agregar mensajes nuevos **sin sobrescribir** los anteriores
- [ ] Leer con `FileReader` y `BufferedReader`
- [ ] Mostrar los mensajes
- [ ] Contar las líneas registradas
- [ ] Controlar errores de entrada y salida

### 🎮 Ejercicio 7 · Competencia de videojuegos

**Archivo:** `jugadores.txt`

Cada línea contiene el nombre del jugador y su puntuación, **separados por una coma**.

- [ ] Leer los registros
- [ ] Convertir las puntuaciones de texto a números
- [ ] Calcular el **promedio**
- [ ] Identificar al jugador con **mayor puntaje**
- [ ] Filtrar a los participantes con puntuación **superior a 70**
- [ ] Validar el formato de los registros

### 🌡 Ejercicio 8 · Control de temperatura

**Archivo:** `temperaturas.txt`

Una estación meteorológica guarda las temperaturas de una semana.

- [ ] Guardar nuevas temperaturas
- [ ] Leer los registros y convertirlos a valores numéricos
- [ ] Calcular la temperatura **promedio**
- [ ] Identificar la temperatura **más alta**
- [ ] Contar cuántos registros superan los **30 grados**
- [ ] Controlar errores cuando el dato no sea numérico válido

### 🧭 Ejercicio 9 · Diario de exploradores

**Archivo:** `descubrimientos.txt`

Un grupo de exploradores registra sus descubrimientos.

- [ ] Escribir nuevos descubrimientos
- [ ] Agregar información **al final** del archivo
- [ ] Leer los registros línea por línea
- [ ] Contar los descubrimientos
- [ ] Buscar uno específico por su nombre
- [ ] Validar que el archivo exista y **tenga contenido** antes de procesarlo
- [ ] Manejar excepciones en lectura y escritura

### ☕ Ejercicio 10 · Sistema de ventas de una cafetería

**Archivo:** `ventas.txt`

Cada línea contiene el nombre de un producto y su precio, **separados por una coma**.

- [ ] Registrar nuevas ventas con `BufferedWriter`
- [ ] Leer los registros almacenados
- [ ] Convertir precios de texto a decimales
- [ ] Calcular el **total de ventas**
- [ ] Identificar el producto de **mayor precio**
- [ ] Filtrar los productos que superen un **valor determinado**
- [ ] Validar que los precios sean correctos













⭐ Si te sirvió este repositorio, ¡déjale una estrella!

</div>
