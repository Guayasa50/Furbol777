package Clases;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    public String nombre;
    public String email;

    public List<PronosticoPartido> pronosticos = new ArrayList<>();

    public Participante(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public void addPronostico(PronosticoPartido p) {
        pronosticos.add(p);
    }
}

