package domain;

import java.util.Set;

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;

    //CONSTRUCTOR
    public Materia(String nombre, Set<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(Set<Materia> correlativas) {
        this.correlativas = correlativas;
    }
}
