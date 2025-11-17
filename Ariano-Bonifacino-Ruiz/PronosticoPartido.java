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

    public int getNumeroPartido() {
        return numeroPartido;
    }

    public void setNumeroPartido(int numeroPartido) {
        this.numeroPartido = numeroPartido;
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

    public boolean isDoble() {
        return esDoble;
    }

    public void setEsDoble(boolean esDoble) {
        this.esDoble = esDoble;
    }
}

