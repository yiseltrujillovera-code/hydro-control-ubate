package telemetria;
import java.util.Random;

public class SensorFlujo extends Sensor {
    private double diametroTuberia;

    public SensorFlujo(int idSensor, String marca, String pinConexion, double diametroTuberia) {
        super(idSensor, marca, pinConexion);
        this.diametroTuberia = diametroTuberia;
    }

    @Override
    public double leerDatos() {
        Random r = new Random();
        return 5 + (25 * r.nextDouble());
    }
}
