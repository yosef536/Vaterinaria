public class Gato extends Paciente {
    private int nivelEstres;

    public Gato(String nombre, float peso, int edad, String estado, float factorDosis, int nivelEstres) {
        super(nombre, peso, edad, estado, factorDosis);
        this.nivelEstres = nivelEstres;

    }

}
