public class Fecha {

    private int mes;
    private int dia;
    private int anio;

    public Fecha(int mes, int dia, int anio) {
        establecerMes(mes);
        establecerDia(dia);
        establecerAnio(anio);
    }

    public void establecerMes(int mes) {
        this.mes = mes;
    }

    public int obtenerMes() {
        return mes;
    }

    public void establecerDia(int dia) {
        this.dia = dia;
    }

    public int obtenerDia() {
        return dia;
    }

    public void establecerAnio(int anio) {
        this.anio = anio;
    }

    public int obtenerAnio() {
        return anio;
    }
}
//Gabitoo use la sintaxis en español porque aun estoy aprendiendo y asi se me hace primer mas facil en los get/set