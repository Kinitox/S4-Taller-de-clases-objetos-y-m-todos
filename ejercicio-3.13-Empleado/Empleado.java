public class Empleado {

    private String primerNombre;
    private String apellidoPaterno;
    private double salarioMensual;

    public Empleado(String primerNombre, String apellidoPaterno, double salarioMensual) {
        establecerPrimerNombre(primerNombre);
        establecerApellidoPaterno(apellidoPaterno);
        establecerSalarioMensual(salarioMensual);
    }

    public void establecerPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public void establecerApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    public void establecerSalarioMensual(double salarioMensual) {
        // ya valide con esto
        if (salarioMensual > 0) {
            this.salarioMensual = salarioMensual;
        }
    }

    public double obtenerSalarioMensual() {
        return salarioMensual;
    }
}
//Te revisas Gabito te dejo que hagas el otro
//weno we