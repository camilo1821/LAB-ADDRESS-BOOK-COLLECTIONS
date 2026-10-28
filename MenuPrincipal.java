import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();

            // valida que la entrada sea un número
            if(!scanner.hasNextInt()){
                scanner.nextLine();  // descarta entradas inválidas
                System.out.println("Ingrese un numero del menu principal");
                continue;
            }

            int opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("---Agregar Contacto---");
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();

                    if(nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()){
                        System.out.println("El campo no puede estar vacio.");
                    }else{
                        agenda.agregarContacto(new Contacto(nombre, telefono, email));
                    }
                    break;

                case 2:
                    System.out.println("---Buscar Contacto---");
                    System.out.println("Nombre: ");
                    Contacto encontrado = agenda.buscarContacto(scanner.nextLine());
                    if(encontrado != null){
                        System.out.println(encontrado);
                    }else{
                        System.out.println("Contacto no encontrado");
                    }
                    break;

                case 3:
                    System.out.println("---Eliminar Contacto---");
                    System.out.println("Nombre: ");
                    String eliminar = scanner.nextLine();
                    if (agenda.eliminarContacto(eliminar)){
                        System.out.println("Contacto eliminado");
                    }else{
                        System.out.println("Contacto no eliminado, no existe");
                    }
                    break;

                case 4:
                    agenda.listarContactos();
                    break;

                case 5:
                    agenda.listarHistorial();
                    break;

                case 6:
                    System.out.println("---Agregar Grupo---");
                    System.out.println("Nombre del grupo: ");
                    agenda.agregarGrupo(scanner.nextLine());
                    break;

                case 7:
                    System.out.println("---Agregar Contacto A Grupo---");
                    System.out.println("Nombre del contacto: ");
                    String contacto = scanner.nextLine();
                    System.out.println("Nombre del grupo: ");
                    String grupo = scanner.nextLine();
                    agenda.agregarContactosGrupo(contacto, grupo);
                    break;

                case 8:
                    agenda.listarGrupos();
                    break;

                case 9:
                    System.out.println("---Contactos Por Grupo---");
                    System.out.println("Nombre del grupo: ");
                    agenda.mostrarContactosGrupo(scanner.nextLine());
                    break;

                case 10:
                    System.out.println("---Saliendo---");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida, ingrese un número entre 1 y 10");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void mostrarMenu(){
        System.out.println("---Agenda De Contactos---");
        System.out.println("1. Agregar Contacto");
        System.out.println("2. Buscar Contacto");
        System.out.println("3. Eliminar Contacto");
        System.out.println("4. Listar Contactos (Orden Alfabético)");
        System.out.println("5. Listar Historial (Orden De Inserción)");
        System.out.println("6. Agregar Grupo");
        System.out.println("7. Agregar Contacto A Grupo");
        System.out.println("8. Listar Grupos");
        System.out.println("9. Mostrar Contactos Por Grupo");
        System.out.println("10. Salir");
        System.out.println("=======================================");
        System.out.println("Elige Una Opción: ");
    }
}
