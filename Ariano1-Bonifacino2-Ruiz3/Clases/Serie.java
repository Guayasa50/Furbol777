package Clases;

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
}
