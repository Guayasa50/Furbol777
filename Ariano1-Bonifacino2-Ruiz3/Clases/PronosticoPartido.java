package Clases;

public class PronosticoPartido {
    public int numeroPartido;

    public String equipoLocal;
    public String equipoVisitante;

    public int golesLocal;
    public int golesVisitante;

    public boolean esDoble;

    public PronosticoPartido(
            int numeroPartido,
            String eqLoc, int gLoc,
            String eqVis, int gVis,
            boolean esDoble
    ) {
        this.numeroPartido = numeroPartido;
        this.equipoLocal = eqLoc;
        this.golesLocal = gLoc;
        this.equipoVisitante = eqVis;
        this.golesVisitante = gVis;
        this.esDoble = esDoble;
    }
}

