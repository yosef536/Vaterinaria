public class Paciente {
    private String nombre;
    private float peso;
    private int edad;
    private String estado;
    private float factorDosis;
    private float dosisAcumulada;
    private Jaula jaula; // null si no tiene

    public Paciente(String nombre, float peso, int edad, String estado, float factorDosis) {
        setNombre(nombre);
        setPeso(peso);
        setEdad(edad);
        setEstado(estado);
        this.factorDosis = factorDosis;
        this.dosisAcumulada = 0;
        this.jaula = null;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public float getPeso() {
        return peso;
    }
    public int getEdad() {
        return edad;
    }
    public String getEstado() {
        return estado;
    }
    public float getFactorDosis() {
        return factorDosis;
    }
    public float getDosisAcumulada() {
        return dosisAcumulada;
    }
    public Jaula getJaula() {
        return jaula;
    }

    public String getTipo() {
        return "Paciente";
    }

    public int getNivelEstres() {
        return 0;               // solo el gato lo cambia
    }

    public void subirEstres() {
        // solo el gato lo cambia
    }

    public float getEnvergadura() {
        return 0; // solo el ave lo cambia
    }

    public void marcarVacunado() {
        // solo el perro lo cambia
    }

    // Setters

    public boolean setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) { // borra espacios en blanco y verifica que alla texto
            return false;
        }
        this.nombre = nombre.trim();
        return true;
    }

    public boolean setPeso(float peso) {
        if (peso <= 0) {
            return false;
        }
        this.peso = peso;
        return true;
    }

    public boolean setEdad(int edad) {
        if (edad < 0 || edad > 30) {
            return false;
        }
        this.edad = edad;
        return true;
    }

    public boolean setEstado(String estado) {
        if ("INGRESADO".equals(estado) || "CUARENTENA".equals(estado)
                || "EN_TRATAMIENTO".equals(estado)) {
            this.estado = estado;
            return true;
        }
        return false;
    }

    public boolean setDosisAcumulada(float dosisAcumulada) {
        if (dosisAcumulada < 0) {
            return false;
        }
        this.dosisAcumulada = dosisAcumulada;
        return true;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public float getDosisMaxima() {
        return peso * factorDosis;
    }
}