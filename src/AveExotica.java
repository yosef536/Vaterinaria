public class AveExotica extends Paciente {
    private float envergadura; // cm

    public AveExotica(String nombre, float peso, int edad, float envergadura) {
        // factorDosis = 3 (ave); ingresa como INGRESADO (R3)
        super(nombre, peso, edad, "INGRESADO", 3);
        setEnvergadura(envergadura);
    }

    public float getEnvergadura() {
        return envergadura;
    }

    public boolean setEnvergadura(float envergadura) {
        if (!(envergadura > 0)) {
            return false;
        }
        this.envergadura = envergadura;
        return true;
    }
    public String getTipo() { return "Ave"; }
}