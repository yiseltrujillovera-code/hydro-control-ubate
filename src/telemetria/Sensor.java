package telemetria;

public abstract class Sensor {
    private int idSensor;
    private String marca;
    private String pinConexion;
    private boolean estado;

    public Sensor(int idSensor, String marca, String pinConexion) {
        this.idSensor = idSensor;
        this.marca = marca;
        this.pinConexion = pinConexion;
        this.estado = true; // Activo por defecto
    }

    public abstract double leerDatos();

    public int getIdSensor() { return idSensor; }
    public String getMarca() { return marca; }
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
