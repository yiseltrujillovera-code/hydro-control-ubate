package telemetria;
import java.time.LocalDateTime;

public class Lectura {
    private int idLectura;
    private double valor;
    private LocalDateTime fechaHora;

    public Lectura(int idLectura, double valor) {
        this.idLectura = idLectura;
        this.valor = valor;
        this.fechaHora = LocalDateTime.now();
    }

    public void guardarLectura() {
        System.out.println("[Base de Datos] Guardado en historial -> Registro #" + idLectura + " | Valor: " + String.format("%.2f", valor) + " | Hora: " + fechaHora);
    }

    public double getValor() { return valor; }
}
