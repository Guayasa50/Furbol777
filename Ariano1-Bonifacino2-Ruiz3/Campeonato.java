import java.util.ArrayList;
import java.util.List;

public class Campeonato {
    public String nombre;
    public int anio;

    public List<Serie> series = new ArrayList<>();

    private int maxDobles = 4; // valor por defecto

    public Campeonato(String nombre, int anio) {
        this.nombre = nombre;
        this.anio = anio;
    }

    public void agregarSerie(Serie s) {
        series.add(s);
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMaxDobles() {return maxDobles;}

    public void setMaxDobles(int maxDobles) {this.maxDobles = maxDobles;}

}
