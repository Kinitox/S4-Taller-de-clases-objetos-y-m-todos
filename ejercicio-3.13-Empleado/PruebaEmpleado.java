import javax.swing.JOptionPane;

public class PruebaEmpleado {

    public static void main(String[] args) {
        Empleado empleado1 = pedirEmpleado(1);
        Empleado empleado2 = pedirEmpleado(2);

        mostrarSalariosAnuales("Salario anual actual", empleado1, empleado2);

        darAumento(empleado1, 10);
        darAumento(empleado2, 10);
        mostrarSalariosAnuales("Salario anual con aumento del 10%", empleado1, empleado2);

        // prueba de la validacion: un salario negativo no debe cambiar nada
        empleado1.establecerSalarioMensual(-500);
        JOptionPane.showMessageDialog(null,
                "Intento de poner salario -500 a " + empleado1.obtenerPrimerNombre()
                        + "\nSalario mensual sigue en: $"
                        + String.format("%.2f", empleado1.obtenerSalarioMensual()));
    }

    private static Empleado pedirEmpleado(int numero) {
        String nombre = pedirTexto("Empleado " + numero + ": primer nombre");
        String apellido = pedirTexto("Empleado " + numero + ": apellido paterno");
        double salario = pedirSalario(numero);
        return new Empleado(nombre, apellido, salario);
    }

    private static String pedirTexto(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        // pendiente: por ahora si cierran la ventana (null) el programa termina
        if (texto == null) {
            System.exit(0);
        }
        return texto.trim();
    }

    private static double pedirSalario(int numero) {
        while (true) {
            String texto = pedirTexto("Empleado " + numero
                    + ": salario mensual (use punto para decimales)");
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
            }
        }
    }

    private static void darAumento(Empleado empleado, double porcentaje) {
        double nuevoSalario = empleado.obtenerSalarioMensual() * (1 + porcentaje / 100);
        empleado.establecerSalarioMensual(nuevoSalario);
    }

    private static double calcularSalarioAnual(Empleado empleado) {
        return empleado.obtenerSalarioMensual() * 12;
    }

    private static void mostrarSalariosAnuales(String titulo, Empleado empleado1, Empleado empleado2) {
        String mensaje = empleado1.obtenerPrimerNombre() + " " + empleado1.obtenerApellidoPaterno()
                + ": $" + String.format("%.2f", calcularSalarioAnual(empleado1))
                + "\n" + empleado2.obtenerPrimerNombre() + " " + empleado2.obtenerApellidoPaterno()
                + ": $" + String.format("%.2f", calcularSalarioAnual(empleado2));
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
