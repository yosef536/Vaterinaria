public class Gato extends Paciente {
    private int nivelEstres; // 0 a 10

    public Gato(String nombre, float peso, int edad) {
        // factorDosis = 6 (gato);
        super(nombre, peso, edad, "INGRESADO", 6);
        this.nivelEstres = 0;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public boolean setNivelEstres(int nivelEstres) {
        if (nivelEstres < 0 || nivelEstres > 10) {
            return false;
        }
        this.nivelEstres = nivelEstres;
        return true;
    }
    public String getTipo() { return "Gato"; }
    public void subirEstres() {
        nivelEstres = nivelEstres + 2;
        if (nivelEstres > 10) {
            nivelEstres = 10;
        }
    }
}