import entidades.Usuario;
import entidades.Tanque;
import telemetria.SensorNivel;
import telemetria.SensorFlujo;
import telemetria.Lectura;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Usuario ganadero = new Usuario(1, "Yisel Trujillo", "ganadero@ubate.com", "12345");

        System.out.println("BIENVENIDO A HYDRO CONTROL UBATÉ");
        System.out.print("Ingrese su correo electrónico: ");
        String correoInput = teclado.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String passInput = teclado.nextLine();

        if (!ganadero.iniciarSesion(correoInput, passInput)) {
            System.out.println("Credenciales incorrectas. Acceso denegado.");
            return;
        }

        System.out.println("\n¡Acceso concedido! Bienvenida, Ingeniera " + ganadero.getNombre());

        Tanque tanquePrincipal = new Tanque(101, "Tanque Reserva Principal", 2500.0, 600.0);
        SensorNivel ultrasonido = new SensorNivel(1, "HC-SR04", "A0", 3.0);
        SensorFlujo caudalimetro = new SensorFlujo(2, "YF-S201", "D2", 0.5);

        tanquePrincipal.agregarSensor(ultrasonido);
        tanquePrincipal.agregarSensor(caudalimetro);

        int opcion = 0;
        int contadorLecturas = 1;

        do {
            System.out.println("MENÚ DE CONTROL IOT");
            System.out.println("1. Lanzar lectura de sensores en tiempo real");
            System.out.println("2. Salir de la aplicación");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                if (opcion == 1) {
                    double litrosActuales = ultrasonido.leerDatos();
                    double flujoActual = caudalimetro.leerDatos();

                    System.out.println("\n[Leyendo Sensores de Ubaté...] Capturando telemetría...");
                    System.out.printf("Lectura Sensor de Nivel: %.2f Litros\n", litrosActuales);
                    System.out.printf("Lectura Sensor de Flujo: %.2f L/min\n", flujoActual);

                    tanquePrincipal.verificarAlertas(litrosActuales, flujoActual);

                    System.out.println("\n[Procesando persistencia...]");
                    Lectura l1 = new Lectura(contadorLecturas++, litrosActuales);
                    Lectura l2 = new Lectura(contadorLecturas++, flujoActual);
                    l1.guardarLectura();
                    l2.guardarLectura();

                    System.out.println("\nVolviendo al menú en un momento...");
                    Thread.sleep(2500);
                }
            } catch (Exception e) {
                System.out.println("Opción inválida. Ingrese un número válido.");
            }

        } while (opcion != 2);

        System.out.println("\nCerrando sesión en Hydro Control Ubaté. ¡Buen día!");
        teclado.close();
    }
}
