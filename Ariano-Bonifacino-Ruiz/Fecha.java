public class Fecha {

    public static boolean fechaValida(String fecha) {
        try {
            // Normalizar separadores
            String f = fecha.replace('.', '/')
                    .replace('-', '/')
                    .replace('|', '/');

            String[] partes = f.split("/");
            if (partes.length != 3) return false;

            String p1 = partes[0];
            String p2 = partes[1];
            String p3 = partes[2];

            int dia, mes, anio;

            // FORMATO: AAAA/MM/DD
            if (p1.length() == 4) {
                anio = Integer.parseInt(p1);
                mes  = convertirMes(p2);
                dia  = Integer.parseInt(p3);
            }
            // FORMATO: DD/MM/AAAA
            else {
                dia  = Integer.parseInt(p1);
                mes  = convertirMes(p2);
                anio = Integer.parseInt(p3);
            }

            if (mes < 1 || mes > 12) return false;
            if (dia < 1 || dia > diasEnMes(mes, anio)) return false;

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static int convertirMes(String m) {
        m = m.toLowerCase();

        // numérico
        if (m.matches("[0-9]+"))
            return Integer.parseInt(m);

        switch (m) {
            case "ene": case "enero": return 1;
            case "feb": case "febrero": return 2;
            case "mar": case "marzo": return 3;
            case "abr": case "abril": return 4;
            case "may": case "mayo": return 5;
            case "jun": case "junio": return 6;
            case "jul": case "julio": return 7;
            case "ago": case "agosto": return 8;
            case "sep": case "sept": case "septiembre": return 9;
            case "oct": case "octubre": return 10;
            case "nov": case "noviembre": return 11;
            case "dic": case "diciembre": return 12;
        }

        return -1;
    }

    public static int diasEnMes(int mes, int anio) {
        switch (mes) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (anio % 4 == 0 ? 29 : 28);
        }
        return 0;
    }
}
