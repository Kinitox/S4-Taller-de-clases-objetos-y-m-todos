import java.time.LocalDate;
public class FrecuenciasCardiacas {
    private static final int FRECUENCIA_BASE = 220;
    private static final double PORCENTAJE_MINIMO = 0.50;
    private static final double PORCENTAJE_MAXIMO = 0.85;
        private String primerNombre;
        private String apellido;
        private int diaNacimiento;
        private int mesNacimiento;
        private int anioNacimiento;

        public FrecuenciasCardiacas(String primerNombre, String apellido,
                                     int diaNacimiento, int mesNacimiento, int anioNacimiento) {
            establecerPrimerNombre(primerNombre);
            establecerApellido(apellido);
            establecerDiaNacimiento(diaNacimiento);
            establecerMesNacimiento(mesNacimiento);
            establecerAnioNacimiento(anioNacimiento);
        }

        public void establecerPrimerNombre(String primerNombre) {
            this.primerNombre = primerNombre;
        }

        public String obtenerPrimerNombre() {
            return primerNombre;
        }

        public void establecerApellido(String apellido) {
            this.apellido = apellido;
        }

        public String obtenerApellido() {
            return apellido;
        }

        public void establecerDiaNacimiento(int diaNacimiento) {
            this.diaNacimiento = diaNacimiento;
        }

        public int obtenerDiaNacimiento() {
            return diaNacimiento;
        }

        public void establecerMesNacimiento(int mesNacimiento) {
            this.mesNacimiento = mesNacimiento;
        }

        public int obtenerMesNacimiento() {
            return mesNacimiento;
        }

        public void establecerAnioNacimiento(int anioNacimiento) {
            this.anioNacimiento = anioNacimiento;
        }

        public int obtenerAnioNacimiento() {
            return anioNacimiento;
        }
    public int calcularEdad() {
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - anioNacimiento;
        // si todavia no cumple anios este anio, se resta uno
        if (hoy.getMonthValue() < mesNacimiento
                || (hoy.getMonthValue() == mesNacimiento && hoy.getDayOfMonth() < diaNacimiento)) {
            edad--;
        }
        return edad;
    }

    public int calcularFrecuenciaMaxima() {
        return FRECUENCIA_BASE - calcularEdad();
    }

    public double calcularFrecuenciaEsperadaMinima() {
        return calcularFrecuenciaMaxima() * PORCENTAJE_MINIMO;
    }

    public double calcularFrecuenciaEsperadaMaxima() {
        return calcularFrecuenciaMaxima() * PORCENTAJE_MAXIMO;
    }
    }

