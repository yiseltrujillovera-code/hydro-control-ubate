package entidades;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasenia;

    public Usuario(int idUsuario, String nombre, String correo, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public boolean iniciarSesion(String correo, String contrasenia) {
        return this.correo.equalsIgnoreCase(correo) && this.contrasenia.equals(contrasenia);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
