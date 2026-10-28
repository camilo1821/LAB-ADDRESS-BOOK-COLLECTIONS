import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import  java.util.ArrayList;
import  java.util.List;
import  java.util.Set;

public class Agenda {

        // ESTRUCTURAS

        // ordena los contactos alfabeticamente por nombre
        private Map<String, Contacto> contactos = new TreeMap<>();

        // grupos ordernados y unicidad

        private Set<String> grupos = new TreeSet<>();

        // relaciona los nombres de contacto con los grupos

        private Map<String, Set<String>> contactosGrupo = new TreeMap<>();

        // historial ordern de inserción

        private List<Contacto> historial = new ArrayList<>();

        // MÉTODOS REQUERIDOS

        // agregar contactos

        public void agregarContacto(Contacto c) {
            if (contactos.containsKey(c.getNombre())) {
                System.out.println("El contacto ya existe: " + c.getNombre());
                return;
            }
            contactos.put(c.getNombre(), c);
            historial.add(c);
            System.out.println("Contacto Agregado: " + c.getNombre());
        }

        // buscar contacto

        public Contacto buscarContacto(String nombre) {
            return contactos.get(nombre);
        }

        // eliminar contacto

        public boolean eliminarContacto(String nombre) {
            Contacto eliminado = contactos.remove(nombre);
            if (eliminado == null) {
                return false;
            }
            historial.remove(eliminado);

            // quita el nombre de todos los grupos donde se haya añadido
            for (Set<String> miembros: contactosGrupo.values()) {
                miembros.remove(nombre);
            }
            return true;
        }

        // lista de contactos por orden alfabético

        public void listarContactos() {
            if(contactos.isEmpty()) {
                System.out.println("No hay ningún contacto");
                return;
            }
            System.out.println("Contactos en Orden Alfabético");
            for (Contacto c : contactos.values()) {
                System.out.println(c);
            }
        }

        // lista del historial por orden de inserción

        public void listarHistorial() {
            if(historial.isEmpty()) {
                System.out.println("No hay historial de contactos");
                return;
            }
            System.out.println("Historial en orden de inserción");
            for (Contacto c : historial) {
                System.out.println(c);
            }
        }

        // agregar grupos

        public void agregarGrupo(String nombreGrupo) {
            if (grupos.contains(nombreGrupo)) {
                System.out.println("El grupo ya existe: " + nombreGrupo);
                return;
            }
            grupos.add(nombreGrupo);
            contactosGrupo.put(nombreGrupo, new TreeSet<>());
            System.out.println("Grupo Agregado: " + nombreGrupo);
        }

        // agregar contactos a los grupos

        public void agregarContactosGrupo(String nombreContacto, String nombreGrupo) {
            if (!contactos.containsKey(nombreContacto)) {
                System.out.println("El contacto no existe: " + nombreContacto);
                return;
            }
            if (!grupos.contains(nombreGrupo)) {
                System.out.println("El grupo no existe: " + nombreGrupo);
                return;
            }
            boolean agregado = contactosGrupo.get(nombreGrupo).add(nombreContacto);
            if (agregado) {
                System.out.println("Contacto Agregado: " + nombreContacto + "al grupo: " + nombreGrupo);
            }else {
                System.out.println("El contacto" + nombreContacto + "ya está en el grupo: " + nombreGrupo);
            }
        }

        // lista de grupos por orden alfabético

        public void listarGrupos() {
            if (grupos.isEmpty()) {
                System.out.println("No existen grupos");
                return;
            }
            System.out.println("Grupos en orden alfabético:");
            for (String g : grupos) {
                System.out.println(g);
            }
        }

        // muestra los contactos por cada grupo

        public void mostrarContactosGrupo(String nombreGrupo) {
            if (!grupos.contains(nombreGrupo)) {
                System.out.println("El grupo no existe: " + nombreGrupo);
                return;
            }
            Set<String> miembros = contactosGrupo.get(nombreGrupo);
            if (miembros.isEmpty()) {
                System.out.println("El grupo esta vacío: " + nombreGrupo);
                return;
            }
            System.out.println("Estos son los contactos agregados al grupo: " + nombreGrupo);
            for (String nombre : miembros) {
                System.out.println(contactos.get(nombre));
            }
        }

}
