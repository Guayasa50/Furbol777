package Clases;

public class Partido {
    public int numero;
    public String fecha;
    public String estadio;

    public String equipoLocal;
    public String equipoVisitante;

    public int golesLocal;
    public int golesVisitante;

    public Partido(
            int numero, String fecha, String estadio,
            String eqLoc, int gLoc,
            String eqVis, int gVis
    ) {
        this.numero = numero;
        this.fecha = fecha;
        this.estadio = estadio;
        this.equipoLocal = eqLoc;
        this.golesLocal = gLoc;
        this.equipoVisitante = eqVis;
        this.golesVisitante = gVis;
    }
}
