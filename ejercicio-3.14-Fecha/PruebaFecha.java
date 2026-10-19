import java.util.Scanner;

public class PruebaFecha {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el mes: ");
        int mes = entrada.nextInt();
        System.out.print("Ingrese el dia: ");
        int dia = entrada.nextInt();
        System.out.print("Ingrese el anio: ");
        int anio = entrada.nextInt();

        Fecha fecha = new Fecha(mes, dia, anio);
        System.out.print("La fecha ingresada es: ");
        fecha.mostrarFecha();

        System.out.print("Ingrese un nuevo dia: ");
        fecha.establecerDia(entrada.nextInt());
        System.out.print("Fecha actualizada: ");
        fecha.mostrarFecha();

        System.out.println("Mes: " + fecha.obtenerMes());
        System.out.println("Dia: " + fecha.obtenerDia());
        System.out.println("Anio: " + fecha.obtenerAnio());

        entrada.close();

        //si funciono bien
    }
}
