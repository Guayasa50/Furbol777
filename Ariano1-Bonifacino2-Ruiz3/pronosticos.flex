import java_cup.runtime.*;

%%

// ===== Inicio =====

// (1) Crear clase Lexer
%class Lexer
// (2) Establecer compativilidad con CUP
%cup
// (3) Line: crea variable yyline (empieza en 0) ---> Registra la linea en la que se encuentra el token y aumenta por cada salto de linea
%line
// (4) Colimn: crea variable yycolumn (empieza en 0) ---> Regista la coluna donde se esta leyendo y aumenta por cada caracter leido. Esta se reinica a 0 luego de un salto de linea
%column

%{
    // Metodo de creacion de TOKENS sin value (solo el tipo de Token)
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    // Metodo de creacion de TOKENS con value (tipo de token y contenido)
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

// ===== Definiciones =====

// (1) Def Básicas

Digito = [0-9] // Un solo numero entre 0 y 9

Letra = [a-zA-ZÁÉÍÓÚÜÑáéíóúüñ]  // Un sólo simbolo del alfabeto (inglés) ya sea mayúscula o minúscula
                                // Acepta tildes
LineTerminator = \r|\n|\r\n 

// \r    finalizacion de línea en otros SO
// \n    finalizacion de línea en Linux
// \r\n  finalizacion de línea en Windows

WhiteSpace = [ \t\f]

// " "   espacios
// \t    tab
// \f    salto de página

// (2) Componentes de fecha

Anio = [0-9]{4} // 4 numeros entre 0 y 9

Mes = 0[1-9]|1[0-2] // Un número de 01 a 12
MesTexto = Ene|Feb|Mar|Abr|May|Jun|Jul|Ago|Sep|Oct|Nov|Dic
           |Enero|Febrero|Marzo|Abril|Mayo|Junio|Julio|Agosto|Septiembre|Octubre|Noviembre|Diciembre

Dia = 0[1-9]|[1][0-9]|[2][0-9]|30|31 // Un número de 01 a 31

// (3) Blancos (espacios, tabs, saltos de linea)
blancos = ({LineTerminator} | {WhiteSpace})+

// (4) Número: n cantidad de dígitos concatenados (n>=1)
numero = {Digito}+

// (5) Fecha válida (Formatos): (OPCIONAL C)
fecha =
      {Dia}\/{Mes}\/{Anio}         // DD/MM/YYYY
    | {Dia}\-{Mes}\-{Anio}         // DD-MM-YYYY
    | {Dia}\.{Mes}\.{Anio}         // DD.MM.YYYY
    | {Dia}\-{MesTexto}\-{Anio}    // 20-Ago-2026
    | {Dia}\ {MesTexto}\ {Anio}    // 20 Ago 2026

// (6) Email (EJ): juan@gmail.com
email = ({Letra}|{Digito}|[._-])+@({Letra}|{Digito})+(\.[a-zA-Z]{2,4})+

// (7) Nombre genérico (personas, equipos, países)
nombre = {Letra}+

// (8) Estadio (Nombre entre comillas, que puede estar compuesto por cualquier tipo de caracteres): "Centenario" (EJ)
estadio = \"([^\"\r\n])+\" 

// (9) Separador (el del txt de la letra)
separador = \*\-\*\-\*\-\*\-\*\-\*\-\*\-\*\-\*\-\*\-

%%

// ===== Reglas =====
{blancos}           {}

// (1) PALABRAS CLAVE (van siempre PRIMERO) 
"Campeonato"        { return symbol(sym.CAMPEONATO); } //Si veo en el texto un "Campeonato", entonces ejecuto la funcion entre corchetes {} que crea un TOKEN CAMPEONATO para el CUP
"Fixture"           { return symbol(sym.FIXTURE); }
"SERIE"             { return symbol(sym.SERIE); }
"Equipos:"          { return symbol(sym.EQUIPOS); }
"Partido Nro:"      { return symbol(sym.PARTIDO_NRO); }
"Participante:"     { return symbol(sym.PARTICIPANTE); }
"Pronosticos Partidos:"   { return symbol(sym.PRONOSTICOS_PARTIDOS); }


// (2) SÍMBOLOS Y MARCADORES
"(X)"               { return symbol(sym.DOBLE); }
{separador}         { return symbol(sym.SEPARADOR); }
"-"                 { return symbol(sym.GUION); }
":"                 { return symbol(sym.DOSPUNTOS); }
","                 { return symbol(sym.COMA); }
"["                 { return symbol(sym.CORCHETE_ABRE); }
"]"                 { return symbol(sym.CORCHETE_CIERRE); }

// (3) DATOS CON VALOR (tipos concretos)
{fecha}             { return symbol(sym.FECHA, yytext()); } // Creo un TOKEN que es un ojeto que guarda el tipo de token (FECHA) y el valor del mismo (en texto: yytext)
{email}             { return symbol(sym.EMAIL, yytext()); }
{estadio}           { return symbol(sym.ESTADIO, yytext().substring(1, yytext().length()-1)); }
{numero}            { return symbol(sym.NUMERO, Integer.parseInt(yytext())); }

// (4) NOMBRES Y PALABRAS COMUNES (últimos, para no tragarse palabras clave)
{nombre}            { return symbol(sym.NOMBRE, yytext().trim()); }

// (5) CARACTERES DESCONOCIDOS
.                   { System.err.println("Err, No se reconoce: " + yytext()); }