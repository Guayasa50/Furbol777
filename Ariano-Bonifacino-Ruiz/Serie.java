import java.util.ArrayList;
import java.util.List;

public class Serie {
    public String nombre;
    public List<String> equipos = new ArrayList<>();
    public List<Partido> partidos = new ArrayList<>();

    public Serie(String nombre) {
        this.nombre = nombre;
    }

    public void addEquipo(String e) {
        equipos.add(e);
    }

    public void addPartido(Partido p) {
        partidos.add(p);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<String> equipos) {
        this.equipos = equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
}
