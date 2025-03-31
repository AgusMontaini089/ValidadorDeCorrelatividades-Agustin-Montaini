package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String nombre;
    private String apellido;
    private Set<Materia> materiasAprobadas;

    //CONSTRUCTOR
    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = new HashSet<>();
    }

    //METODOS
    public void agregarMateriaAprobada(Materia materia){
        if(this.cumpleCorrelativas(materia)) {
            this.materiasAprobadas.add(materia);
        }
    }

    public boolean cumpleCorrelativas(Materia materia){
        return this.materiasAprobadas.containsAll(materia.getCorrelativas());
    }

    //GETTERS Y SETTERS


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }


}
