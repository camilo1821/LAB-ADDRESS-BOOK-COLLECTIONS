import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import  java.util.ArrayList;
import  java.util.List;
import  java.util.Set;

public class Agenda {
    public static void main(String[] args) {

        // TreeMap - ordenado por clave
        // Búsqueda rápida ordenada alfabéticamente

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("Beltran", "Cristhian");
        treeMap.put("Rojas", "Cristian");
        treeMap.put("Bernal", "Juliana");
        treeMap.put("Vallejo", "Dayana");
        treeMap.put("Ortiz", "Diana");

        System.out.println("TreeMap (Ordenado: " + treeMap);

        // TreeSet - elementos único ordenados automáticamente de forma natural
        // (A-Z, 1-10) o mediante un `Comparator`

        TreeSet<String> nombre =  new TreeSet<>();
        nombre.add("Daniel");
        nombre.add("Luis");
        nombre.add("Darwing");
        nombre.add("Narciris");

        // TreeMap de TreeSet
        // Relación grupo -> nombres de contactos

    }

}
