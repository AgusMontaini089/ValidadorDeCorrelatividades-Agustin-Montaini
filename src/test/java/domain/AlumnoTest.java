package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    @DisplayName("El Alumno Jose aprueba la materia Algoritmos y estructuras de  y se agrega a la lista de materias aprobadas ")
    public void agregarMateriaAprobadaAlgoritmos(){
        Materia algoritmosYEstructurasDeDatos = new Materia("Algoritmos y estructuras de datos",new HashSet<>());
        Alumno alumno = new Alumno("Jose","Gomez");

        alumno.agregarMateriaAprobada(algoritmosYEstructurasDeDatos);

        Assertions.assertTrue(alumno.getMateriasAprobadas().contains(algoritmosYEstructurasDeDatos));
    }

    @Test
    @DisplayName("El Alumno jose puede Cursar paradigmas de programacion luego de haber aprobado algoritmos")
    public void puedeCursarParadigmas(){
        Materia algoritmosYEstructurasDeDatos = new Materia("Algoritmos y estructuras de datos",new HashSet<>());
        Materia paradigmasDeProgramacion = new Materia("Paradigmas de Programacion",new HashSet<>());
        paradigmasDeProgramacion.getCorrelativas().add(algoritmosYEstructurasDeDatos);

        Alumno alumno = new Alumno("Jose","Gomez");
        alumno.agregarMateriaAprobada(algoritmosYEstructurasDeDatos);

        Assertions.assertTrue(alumno.cumpleCorrelativas(paradigmasDeProgramacion));
    }

    @Test
    @DisplayName("El Alumno no puede Cursar paradigmas de programacion sin haber aprobado algoritmos")
    public void noPuedeCursarParadigmas(){
        Materia algoritmosYEstructurasDeDatos = new Materia("Algoritmos y estructuras de datos",new HashSet<>());
        Materia paradigmasDeProgramacion = new Materia("Paradigmas de Programacion",new HashSet<>());
        paradigmasDeProgramacion.getCorrelativas().add(algoritmosYEstructurasDeDatos);

        Alumno alumno = new Alumno("Jose","Gomez");

        Assertions.assertFalse(alumno.cumpleCorrelativas(paradigmasDeProgramacion));
    }

    @Test
    @DisplayName("El Alumno no puede anotarse a Diseño sin tener aprobada algortimos")
        public void noPuedeAnotarseADisenio(){
            Materia algoritmosYEstructurasDeDatos = new Materia("Algoritmos y estructuras de datos",new HashSet<>());
            Materia paradigmasDeProgramacion = new Materia("Paradigmas de Programacion",new HashSet<>());
            paradigmasDeProgramacion.getCorrelativas().add(algoritmosYEstructurasDeDatos);
            Materia disenio = new Materia("Diseño de Sistemas de Informacion", new HashSet<>());
            disenio.getCorrelativas().add(paradigmasDeProgramacion);

            Alumno alumno = new Alumno("Jose","Gomez");
            alumno.agregarMateriaAprobada(paradigmasDeProgramacion);

            Assertions.assertFalse(alumno.cumpleCorrelativas(disenio));
    }

}