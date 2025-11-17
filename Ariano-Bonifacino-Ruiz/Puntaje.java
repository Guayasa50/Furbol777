import java.util.Map;

public class Puntaje {

    // Calcula el puntaje del participante
    public static int puntajeTotal(Participante participante,
                                   Map<Integer, Partido> partidosPorNumero) {

        int total = 0;

        for (PronosticoPartido pr : participante.getPronosticos()) {

            Partido real = partidosPorNumero.get(pr.getNumeroPartido());
            if (real == null) continue; // seguridad

            // puntos por ganador / empate
            total += puntajeResultado(pr, real);

            // puntos por goles acertados
            total += puntajeGoles(pr, real);

            // puntos extra por resultado exacto
            total += puntajeExacto(pr, real);
        }

        return total;
    }


    // 1) Ganador / empate (2 puntos)
    private static int puntajeResultado(PronosticoPartido pr, Partido real) {

        int gL = real.getGolesLocal();
        int gV = real.getGolesVisitante();

        int prL = pr.getGolesLocal();
        int prV = pr.getGolesVisitante();

        boolean realEmpate = gL == gV;
        boolean pronosEmpate = prL == prV;

        if (realEmpate && pronosEmpate) return 2;

        boolean realLocal = gL > gV;
        boolean pronosLocal = prL > prV;

        if (realLocal == pronosLocal) return 2;

        return 0;
    }


    // 2) Goles acertados (1 punto por cada lado)
    private static int puntajeGoles(PronosticoPartido pr, Partido real) {
        int puntos = 0;

        if (pr.getGolesLocal() == real.getGolesLocal()) puntos++;
        if (pr.getGolesVisitante() == real.getGolesVisitante()) puntos++;

        return puntos;
    }


    // 3) Resultado exacto (2 puntos extra)
    private static int puntajeExacto(PronosticoPartido pr, Partido real) {

        if (pr.getGolesLocal() == real.getGolesLocal() &&
                pr.getGolesVisitante() == real.getGolesVisitante()) {
            return 2;
        }

        return 0;
    }
}
