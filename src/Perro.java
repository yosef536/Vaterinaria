public class Perro extends Paciente {
    private String raza;
    private boolean vacunado;

    public Perro(String nombre, float peso, int edad, String raza, boolean vacunado) {
        // factorDosis = 10 (perro). R3: no vacunado -> CUARENTENA, vacunado -> INGRESADO
        super(nombre, peso, edad, vacunado ? "INGRESADO" : "CUARENTENA", 10);
        this.raza = raza;
        this.vacunado = vacunado;
    }

    public String getRaza() {
        return raza;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public boolean setRaza(String raza) {
        if (raza == null || raza.trim().isEmpty()) {
            return false;
        }
        this.raza = raza.trim();
        return true;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }
    public String getTipo() { return "Perro"; }
    public void marcarVacunado() { vacunado = true; }
}