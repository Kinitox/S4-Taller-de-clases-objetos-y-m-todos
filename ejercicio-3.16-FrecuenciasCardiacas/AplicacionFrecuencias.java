import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class AplicacionFrecuencias {

    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Calculadora de frecuencia cardiaca ===");

        System.out.print("Primer nombre: ");
        String nombre = entrada.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = entrada.nextLine().trim();
        LocalDate nacimiento = pedirFechaNacimiento();

        FrecuenciasCardiacas persona = new FrecuenciasCardiacas(nombre, apellido,
                nacimiento.getDayOfMonth(), nacimiento.getMonthValue(), nacimiento.getYear());

        System.out.println();
        System.out.println("Nombre: " + persona.obtenerPrimerNombre());
        System.out.println("Apellido: " + persona.obtenerApellido());
        System.out.println("Fecha de nacimiento: " + String.format("%02d/%02d/%d",
                persona.obtenerDiaNacimiento(),
                persona.obtenerMesNacimiento(),
                persona.obtenerAnioNacimiento()));
        System.out.println("Edad: " + persona.calcularEdad() + " anios");
        System.out.println("Frecuencia cardiaca maxima: " + persona.calcularFrecuenciaMaxima() + " ppm");
        System.out.println("Frecuencia cardiaca esperada: "
                + String.format("%.2f", persona.calcularFrecuenciaEsperadaMinima())
                + " - "
                + String.format("%.2f", persona.calcularFrecuenciaEsperadaMaxima()) + " ppm");

        entrada.close();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    private static LocalDate pedirFechaNacimiento() {
        while (true) {
            int dia = leerEntero("Dia de nacimiento: ");
            int mes = leerEntero("Mes de nacimiento: ");
            int anio = leerEntero("Anio de nacimiento: ");
            try {
                LocalDate fecha = LocalDate.of(anio, mes, dia);
                if (fecha.isAfter(LocalDate.now()) || anio < 1900) {
                    System.out.println("La fecha debe estar entre 1900 y hoy.");
                } else {
                    return fecha;
                }
            } catch (DateTimeException e) {
                System.out.println("Esa fecha no esiste, intente de nuevo.");
            }
        }
    }
}