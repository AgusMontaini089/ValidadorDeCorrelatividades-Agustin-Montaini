package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("el alumno puede inscribirse a algortimos si cumple correlativas")
    public void puedeInscribirseAAlgoritmos(){
        Materia algoritmos = new Materia("Algoritmos y estructuras de datos", new HashSet<>());
        Alumno alumno = new Alumno("Jose","Gomez");

        Set<Materia> materias = new HashSet<>();
        materias.add(algoritmos);

        Inscripcion inscripcion = new Inscripcion(alumno,materias);

        Assertions.assertTrue(inscripcion.aprobada());

    }

    @Test
    @DisplayName("el alumno puede inscribirse a paradigmas, si cumple con correlativas")
    public void puedeInscribirseAParadigmas(){
        Materia algoritmos = new Materia("Algoritmos y estructuras de datos", new HashSet<>());
        Materia paradigmas = new Materia("Paradigmas de Programacion", new HashSet<>());
        paradigmas.getCorrelativas().add(algoritmos);

        Alumno alumno = new Alumno("Jose","Gomez");
        alumno.agregarMateriaAprobada(algoritmos);

        Set<Materia> materiasInscripcion = new HashSet<>();
        materiasInscripcion.add(paradigmas);

        Inscripcion inscripcion = new Inscripcion(alumno,materiasInscripcion);

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("el alumno No puede inscribirse a disenio por no haber aprobado paradigmas")
        public void noPuedeAnotarseADisenio(){
        Materia algoritmos = new Materia("Algoritmos y estructuras de datos", new HashSet<>());
        Materia paradigmas = new Materia("Paradigmas de Programacion", new HashSet<>());
        Materia disenio = new Materia("Diseño de Sistemas de Informacion",new HashSet<>());

        paradigmas.getCorrelativas().add(algoritmos);
        disenio.getCorrelativas().add(paradigmas);

        Alumno alumno = new Alumno("Jose","Gomez");
        alumno.agregarMateriaAprobada(algoritmos);

        Set<Materia> materiasInscripcion = new HashSet<>();
        materiasInscripcion.add(disenio);

        Inscripcion inscripcion = new Inscripcion(alumno,materiasInscripcion);

        Assertions.assertFalse(inscripcion.aprobada());

    }

    @Test
    @DisplayName("el alumno puede inscribirse a disenio si cumple correlativas")
    public void puedeAnotarseADisenio(){
        Materia algoritmos = new Materia("Algoritmos y estructuras de datos", new HashSet<>());
        Materia paradigmas = new Materia("Paradigmas de Programacion", new HashSet<>());
        Materia disenio = new Materia("Diseño de Sistemas de Informacion",new HashSet<>());

        paradigmas.getCorrelativas().add(algoritmos);
        disenio.getCorrelativas().add(paradigmas);

        Alumno alumno = new Alumno("Jose","Gomez");
        alumno.agregarMateriaAprobada(algoritmos);
        alumno.agregarMateriaAprobada(paradigmas);

        Set<Materia> materiasInscripcion = new HashSet<>();
        materiasInscripcion.add(disenio);

        Inscripcion inscripcion = new Inscripcion(alumno,materiasInscripcion);

        Assertions.assertTrue(inscripcion.aprobada());

    }

    @Test
    @DisplayName("el alumno quiere inscribirse a disenio y a sistemas operativos, pero no tiene aprobada arquitectura")
     public void noPuedeInscribirsePorNoCumplirCorrelativasDeUnaMateria(){
        Materia algoritmos = new Materia("Algoritmos y estructuras de datos", new HashSet<>());
        Materia paradigmas = new Materia("Paradigmas de Programacion", new HashSet<>());
        Materia disenio = new Materia("Diseño de Sistemas de Informacion",new HashSet<>());
        Materia arquitectura = new Materia("Arquitectura de Computadoras",new HashSet<>());
        Materia siso = new Materia("Sistemas Operativos",new HashSet<>());

        paradigmas.getCorrelativas().add(algoritmos);
        disenio.getCorrelativas().add(paradigmas);
        siso.getCorrelativas().add(arquitectura);

        Alumno alumno = new Alumno("Jose","Gomez");
        alumno.agregarMateriaAprobada(algoritmos);
        alumno.agregarMateriaAprobada(paradigmas);

        Set<Materia> materiasInscripcion = new HashSet<>();
        materiasInscripcion.add(disenio);
        materiasInscripcion.add(siso);

        Inscripcion inscripcion = new Inscripcion(alumno,materiasInscripcion);

        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("el alumno quiere inscribirse a disenio y a sistemas operativos y tiene todas las correlativas aprobadas")
    public void puedeInscribirsePorCumplirTodasLasCorrelativas(){
        Materia algoritmos = new Materia("Algoritmos y estructuras de datos", new HashSet<>());
        Materia paradigmas = new Materia("Paradigmas de Programacion", new HashSet<>());
        Materia disenio = new Materia("Diseño de Sistemas de Informacion",new HashSet<>());
        Materia arquitectura = new Materia("Arquitectura de Computadoras",new HashSet<>());
        Materia siso = new Materia("Sistemas Operativos",new HashSet<>());

        paradigmas.getCorrelativas().add(algoritmos);
        disenio.getCorrelativas().add(paradigmas);
        siso.getCorrelativas().add(arquitectura);

        Alumno alumno = new Alumno("Jose","Gomez");
        alumno.agregarMateriaAprobada(algoritmos);
        alumno.agregarMateriaAprobada(paradigmas);
        alumno.agregarMateriaAprobada(arquitectura);


        Set<Materia> materiasInscripcion = new HashSet<>();
        materiasInscripcion.add(disenio);
        materiasInscripcion.add(siso);

        Inscripcion inscripcion = new Inscripcion(alumno,materiasInscripcion);

        Assertions.assertTrue(inscripcion.aprobada());
    }


}