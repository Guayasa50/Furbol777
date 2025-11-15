import java.util.ArrayList;
import java.util.List;

public class Campeonato {
    public String nombre;
    public int anio;

    public List<Serie> series = new ArrayList<>();

    public Campeonato(String nombre, int anio) {
        this.nombre = nombre;
        this.anio = anio;
    }

    public void agregarSerie(Serie s) {
        series.add(s);
    }
}
