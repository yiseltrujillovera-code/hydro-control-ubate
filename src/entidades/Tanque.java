package entidades;
import telemetria.Sensor;
import java.util.ArrayList;

public class Tanque {
    private int idTanque;
    private String nombre;
    private double capacidadMaxima;
    private double nivelCriticoMinimo;
    private ArrayList<Sensor> sensores;

    public Tanque(int idTanque, String nombre, double capacidadMaxima, double nivelCriticoMinimo) {
        this.idTanque = idTanque;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.nivelCriticoMinimo = nivelCriticoMinimo;
        this.sensores = new ArrayList<>();
    }

    public void agregarSensor(Sensor sensor) {
        this.sensores.add(sensor);
    }

    public double calcularPorcentajeLlenado(double nivelActual) {
        return (nivelActual / capacidadMaxima) * 100;
    }

    public void verificarAlertas(double nivelActual, double flujoActual) {
        System.out.println("\n--- MONITOREO DE RECIPIENTE: " + nombre.toUpperCase() + " ---");
        System.out.printf("-> Nivel actual del tanque: %.2f Litros (%.1f%%)\n", nivelActual, calcularPorcentajeLlenado(nivelActual));
        System.out.printf("-> Flujo de salida actual a bebederos: %.2f L/min\n", flujoActual);

        if (nivelActual < nivelCriticoMinimo) {
            System.out.println("[ALERTA CRÍTICA] ¡Nivel de agua por debajo del umbral mínimo de seguridad en Ubaté!");
        }
        if (flujoActual > 25.0) {
            System.out.println("[ALERTA CONSUMO] Flujo inusualmente alto. Posible fuga en la tubería o bebedero abierto.");
        }
    }
}
