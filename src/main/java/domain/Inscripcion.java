package domain;

import java.time.LocalDateTime;
import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materias;
    private LocalDateTime fecha;

    //CONSTRUCTOR


    public Inscripcion(Alumno alumno, Set<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
        this.fecha = LocalDateTime.now();
    }

    //METODOS
    public boolean aprobada(){
        for (Materia materia : this.materias) {
            if(!this.alumno.cumpleCorrelativas(materia))
                return false; // FALSO SI NO CUMPLE LAS CORRELATIVAS DE UNA MATERIA
        }
        return true; // VERDADERO SI CUMPLE TODAS LAS CORRELATIVAS
    }

    // GETTERS Y SETTERS

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
