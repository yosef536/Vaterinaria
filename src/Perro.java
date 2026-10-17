public class Perro extends Paciente {
    private String raza;
    private boolean vacunado;

    public Perro(String nombre, float peso, int edad, String raza, boolean vacunado) {

        super(nombre, peso, edad, vacunado ? "INGRESADO" : "CUARENTENA", 10);
        this.raza = raza;
        this.vacunado = vacunado;
    }

}