import java.util.ArrayList;
import java.util.List;

public class Participante {
    public String nombre;
    public String email;

    public List<PronosticoPartido> pronosticos = new ArrayList<>();

    private int dobles = 0;

    public Participante(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public void addPronostico(PronosticoPartido p) {
        pronosticos.add(p);

        // Si el pronóstico es doble (X), incremento el contador
        if (p.isDoble()) {
            dobles++;
        }
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PronosticoPartido> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<PronosticoPartido> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public int getDobles() {
        return dobles;
    }

}

