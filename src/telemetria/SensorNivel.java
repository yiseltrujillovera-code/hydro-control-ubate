package telemetria;
import java.util.Random;

public class SensorNivel extends Sensor {
    private double alturaTanque;

    public SensorNivel(int idSensor, String marca, String pinConexion, double alturaTanque) {
        super(idSensor, marca, pinConexion);
        this.alturaTanque = alturaTanque;
    }

    @Override
    public double leerDatos() {
        Random r = new Random();
        return 500 + (1500 * r.nextDouble());
    }
}
