# Furbol777
# Analizador de Pronósticos de Fútbol  
Proyecto desarrollado con JFlex y CUP

Este repositorio contiene un analizador que procesa un archivo de texto con información sobre un campeonato de fútbol, incluyendo:

- Nombre del campeonato.
- Series y equipos participantes.
- Partidos jugados con fecha, estadio y resultado.
- Participantes y sus pronósticos.

El objetivo del proyecto es validar que el archivo tenga el formato correcto y que todos los elementos aparezcan en el orden adecuado.

---

## 📝 ¿Qué hace este analizador?

El programa lee un archivo de texto (`pronosticos.txt`) y verifica que cumpla una estructura específica.  
Si el archivo es válido, el analizador muestra:

Parseo finalizado correctamente.

yaml
Copiar código

En caso contrario, marca errores indicando en qué parte del archivo hay un problema.

Este proyecto es parte del trabajo práctico de Teoría de la computación, donde se utiliza:

- **JFlex** para generar el analizador léxico (qué palabras reconoce el sistema).
- **CUP** para generar el analizador sintáctico (cómo se organiza el archivo y qué estructura debe tener).

---

## 📄 Formato general del archivo a analizar

El archivo tiene una estructura como la siguiente:

Campeonato Mundial 2026
Fixture

SERIE GrupoA
Equipos: [Japón, Qatar, Alemania, Uruguay]
Partido Nro: 1
2026/06/15 - "Estadio Monumental"
Japón 2 - Qatar 1

...

----------
Participante: Pepe Repepe - pepe@mail.com
Pronosticos Partidos:
1: Japón 1 - Qatar 2
2:(X) Japón 0 - Alemania 2
...
----------

yaml
Copiar código

El analizador revisa cada parte y confirma que el texto sigue este formato correctamente.

---

## 📁 Archivos del proyecto

- `pronosticos.flex` → Reglas del analizador léxico (JFlex)
- `pronosticos.cup` → Reglas del analizador sintáctico (CUP)
- `Main.java` → Clase principal que ejecuta el análisis
- `pronosticos.txt` → Archivo de ejemplo para probar
- `Lexer.java`, `parser.java`, `sym.java` → Archivos generados automáticamente

---

## ▶️ Cómo ejecutar el proyecto

1. **Generar el lexer**  
```bash
java -jar jflex-full-1.9.1.jar pronosticos.flex
Generar el parser

bash
Copiar código
java -jar java-cup-11b.jar pronosticos.cup
Compilar todos los archivos Java

bash
Copiar código
javac -cp ".;java-cup-11b-runtime.jar" *.java
Ejecutar el programa

bash
Copiar código
java -cp ".;java-cup-11b-runtime.jar" Main pronosticos.txt
