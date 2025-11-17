import java.util.*;

public class Estadistica {

    public static void generar(Map<Integer, Partido> partidosPorNumero,
                               List<Participante> participantes) {

        System.out.println("\n=== ESTADÍSTICAS DEL CAMPEONATO ===");

        // 1) Equipo mas goleado

        Map<String, Integer> golesRecibidos = new HashMap<>();

        for (Partido p : partidosPorNumero.values()) {
            // goles recibidos por el local
            golesRecibidos.put(p.getEquipoLocal(),
                    golesRecibidos.getOrDefault(p.getEquipoLocal(), 0) + p.getGolesVisitante());

            // goles recibidos por el visitante
            golesRecibidos.put(p.getEquipoVisitante(),
                    golesRecibidos.getOrDefault(p.getEquipoVisitante(), 0) + p.getGolesLocal());
        }

        String equipoMasGoleado = null;
        int maxGoles = -1;

        for (Map.Entry<String, Integer> e : golesRecibidos.entrySet()) {
            if (e.getValue() > maxGoles) {
                maxGoles = e.getValue();
                equipoMasGoleado = e.getKey();
            }
        }

        System.out.println("Equipo más goleado: " +
                equipoMasGoleado + " (" + maxGoles + " goles recibidos)");

        // =============================================
        // 2) Promedio de goles por partido

        int golesTotales = 0;
        for (Partido p : partidosPorNumero.values()) {
            golesTotales += p.getGolesLocal() + p.getGolesVisitante();
        }

        double promedio = (double) golesTotales / partidosPorNumero.size();

        System.out.println("Promedio de goles por partido: " +
                String.format("%.2f", promedio));



        // 3) Equipo que pronosticaron mejor

        Map<String, Integer> aciertosPorEquipo = new HashMap<>();

        for (Participante part : participantes) {
            if (part == null) continue;

            for (PronosticoPartido pr : part.getPronosticos()) {

                Partido real = partidosPorNumero.get(pr.getNumeroPartido());
                if (real == null) continue;

                int tReal = Integer.compare(real.getGolesLocal(), real.getGolesVisitante());
                int tPr = Integer.compare(pr.getGolesLocal(), pr.getGolesVisitante());

                // Acertó ganaba local / ganaba visitante / empate
                if (tReal == tPr) {

                    // sumamos acierto asociado al equipo local y visitante
                    aciertosPorEquipo.put(pr.getEquipoLocal(),
                            aciertosPorEquipo.getOrDefault(pr.getEquipoLocal(), 0) + 1);

                    aciertosPorEquipo.put(pr.getEquipoVisitante(),
                            aciertosPorEquipo.getOrDefault(pr.getEquipoVisitante(), 0) + 1);
                }
            }
        }

        String equipoMejorPronosticado = null;
        int maxAciertos = -1;

        for (Map.Entry<String, Integer> e : aciertosPorEquipo.entrySet()) {
            if (e.getValue() > maxAciertos) {
                maxAciertos = e.getValue();
                equipoMejorPronosticado = e.getKey();
            }
        }

        System.out.println("Equipo mejor pronosticado: " +
                equipoMejorPronosticado + " (" + maxAciertos + " aciertos de tendencia)");
    }
}
