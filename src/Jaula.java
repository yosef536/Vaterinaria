public class Jaula {
    private int numero;
    private String tamano; // S, M o L
    private String zona;   // A o B
    private Paciente ocupante; // null = libre

    public Jaula(int numero, String tamano, String zona) {
        this.numero = numero;
        setTamano(tamano);
        setZona(zona);
        this.ocupante = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getTamano() {
        return tamano;
    }

    public String getZona() {
        return zona;
    }

    public Paciente getOcupante() {
        return ocupante;
    }

    public boolean setTamano(String tamano) {
        if ("S".equals(tamano) || "M".equals(tamano) || "L".equals(tamano)) {
            this.tamano = tamano;
            return true;
        }
        return false;
    }

    public boolean setZona(String zona) {
        if ("A".equals(zona) || "B".equals(zona)) {
            this.zona = zona;
            return true;
        }
        return false;
    }

    public void setOcupante(Paciente ocupante) {
        this.ocupante = ocupante;
    }

    public boolean estaLibre() {
        return ocupante == null;
    }
}