public class Contacto {

    // atributos privados de la clase contacto

    private String nombre;
    private String telefono;
    private String email;

    // Método: constructor que recibe todos los atributos de la clase Contacto

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Método: getters para todos los atributos de la clase Contacto

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    // Método: setters para todos los atributos de la clase Contacto

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método: toString

    @Override
    public String toString() {
        return nombre + " " + telefono + " " + email;

    }
}

