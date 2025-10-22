package run;

import services.interfaces.ICRUD;
import entities.Autor;

public class Main {
    
    public static final ICRUD dao = new services.dao.MyDao();
    
    public static void insertarAutor() {
        Autor a = new Autor();
        a.setNombre("Gabriel Garcia Marquez");
        a.setNacionalidad("Mexicana");
        dao.insert(a);
        
        Autor r = new Autor();
        r.setNombre("Ruben Dario");
        r.setNacionalidad("Nicaraguense");
        dao.insert(r);
    }
    
    public static void listarAutores() {
        System.out.println("Registro Almacenados:");
        dao.getAll("autores.All", Autor.class).forEach(autor -> System.out.println(autor.getNombre()));
    }
    
    public static void editarAutor() {
        Autor a = dao.findById(1, Autor.class);
        a.setNacionalidad("Colombiana");
        dao.update(a);
    }
    
    public static void eliminarAutor() {
        Autor a = dao.findById(2, Autor.class);
        dao.delete(a);
    }
    
    public static void main(String[] args) {
        insertarAutor();
        listarAutores();
        editarAutor();
        listarAutores();
        eliminarAutor();
        listarAutores();
    }
}
