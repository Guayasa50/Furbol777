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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
}
