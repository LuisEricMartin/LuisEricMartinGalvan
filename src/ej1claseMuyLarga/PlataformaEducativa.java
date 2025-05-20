package ej1claseMuyLarga;

import java.util.*;

public class PlataformaEducativa {
	private Map<String, String> usuarios; // username -> password
	private Map<String, List<String>> cursos; // username -> cursos
	private Map<String, String> contenidoCursos; // curso -> contenido

    // Constructor que inicializa las estructuras de datos
    public PlataformaEducativa() {
        usuarios = new HashMap<>();
        cursos = new HashMap<>();
        contenidoCursos = new HashMap<>();
    }

    // Método para registrar un nuevo usuario
    public void registrarUsuario(String username, String password) {
        if (!usuarios.containsKey(username)) {
            usuarios.put(username, password);
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("El usuario ya existe.");
        }
    }

    // Método para iniciar sesión verificando usuario y contraseña
    public boolean iniciarSesion(String username, String password) {
        return usuarios.containsKey(username) && usuarios.get(username).equals(password);
    }

    // Método para agregar un curso con su contenido
    public void agregarCurso(String curso, String contenido) {
        if (!contenidoCursos.containsKey(curso)) {
            contenidoCursos.put(curso, contenido);
            System.out.println("Curso agregado con éxito.");
        } else {
            System.out.println("El curso ya existe.");
        }
    }

    // Método para inscribir un usuario en un curso
    public void inscribirUsuarioEnCurso(String username, String curso) {
        if (usuarios.containsKey(username) && contenidoCursos.containsKey(curso)) {
            // Verificamos si el usuario tiene una lista de cursos, si no, la inicializamos
            cursos.putIfAbsent(username, new ArrayList<>());
            cursos.get(username).add(curso);
            System.out.println("Usuario inscrito en el curso.");
        } else {
            System.out.println("Error al inscribir al usuario.");
        }
    }

    // Método para mostrar los cursos en los que está inscrito un usuario
    public void mostrarCursosUsuario(String username) {
        if (cursos.containsKey(username)) {
            List<String> listaCursos = cursos.get(username);
            System.out.println("Cursos de " + username + ": " + listaCursos);
        } else {
            System.out.println("El usuario no está inscrito en ningún curso.");
        }
    }

    // Método para mostrar todos los cursos disponibles
    public void mostrarCursos() {
        for (String nombreCurso : contenidoCursos.keySet()) { // Corrección: recorrer el mapa correcto
                System.out.println("Curso: " + nombreCurso);
        }
    }
}

