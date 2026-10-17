public class Hospital {
    private Paciente[] pacientes = new Paciente[10];
    private int contador = 0;
    private Jaula[] jaulas = new Jaula[6];

    public Hospital() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        pacientes[0] = new Perro("Rocky", 30.0f, 4, "labrador", true);
        pacientes[1] = new Gato("Misifu", 4.0f, 3);
        pacientes[2] = new AveExotica("Kiwi", 0.8f, 2, 70);
        contador = 3;

        jaulas[0] = new Jaula(1, "S", "A");
        jaulas[1] = new Jaula(2, "M", "A");
        jaulas[2] = new Jaula(3, "M", "A");
        jaulas[3] = new Jaula(4, "L", "A");
        jaulas[4] = new Jaula(5, "S", "B");
        jaulas[5] = new Jaula(6, "M", "B");
    }

    // Devuelve la posición del paciente o -1 si no existe
    private int buscar(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (pacientes[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public String ingresarPerro(String nombre, float peso, int edad, String raza, boolean vacunado) {
        if (nombre.trim().equals("") || peso <= 0 || peso > 80 || edad < 0 || edad > 30
                || raza.trim().equals("")) {
            return "ERROR: datos invalidos";
        }
        if (buscar(nombre) != -1) {
            return "ERROR: nombre duplicado";
        }
        if (contador == 10) {
            return "ERROR: hospital lleno";
        }
        pacientes[contador] = new Perro(nombre, peso, edad, raza, vacunado);
        contador++;
        if (vacunado) {
            return "OK: " + nombre + " ingresado";
        } else {
            return "OK: " + nombre + " ingresado en CUARENTENA";
        }
    }

    public String ingresarGato(String nombre, float peso, int edad) {
        if (nombre.trim().equals("") || peso <= 0 || peso > 15 || edad < 0 || edad > 30) {
            return "ERROR: datos invalidos";
        }
        if (buscar(nombre) != -1) {
            return "ERROR: nombre duplicado";
        }
        if (contador == 10) {
            return "ERROR: hospital lleno";
        }
        pacientes[contador] = new Gato(nombre, peso, edad);
        contador++;
        return "OK: " + nombre + " ingresado";
    }

    public String ingresarAve(String nombre, float peso, int edad, float envergadura) {
        if (nombre.trim().equals("") || peso <= 0 || peso > 15 || edad < 0 || edad > 30
                || envergadura <= 0) {
            return "ERROR: datos invalidos";
        }
        if (buscar(nombre) != -1) {
            return "ERROR: nombre duplicado";
        }
        if (contador == 10) {
            return "ERROR: hospital lleno";
        }
        pacientes[contador] = new AveExotica(nombre, peso, edad, envergadura);
        contador++;
        return "OK: " + nombre + " ingresado";
    }

    public String vacunar(String nombre) {
        int pos = buscar(nombre);
        if (pos == -1) {
            return "ERROR: paciente no encontrado";
        }
        Paciente p = pacientes[pos];
        if (!p.getTipo().equals("Perro")) {
            return "ERROR: solo aplica a perros";
        }
        if (!p.getEstado().equals("CUARENTENA")) {
            return "ERROR: ya vacunado";
        }
        p.marcarVacunado();
        p.setEstado("INGRESADO");
        return "OK: " + p.getNombre() + " vacunado (pasa a INGRESADO)";
    }

    public String asignar(String nombre) {
        int pos = buscar(nombre);
        if (pos == -1) {
            return "ERROR: paciente no encontrado";
        }
        Paciente p = pacientes[pos];
        if (p.getEstado().equals("CUARENTENA")) {
            return "ERROR: paciente en cuarentena";
        }
        if (p.getJaula() != null) {
            return "ERROR: paciente ya tiene jaula";
        }

        String tamano;
        if (p.getPeso() < 5) {
            tamano = "S";
        } else if (p.getPeso() <= 25) {
            tamano = "M";
        } else {
            tamano = "L";
        }
        if (p.getTipo().equals("Ave") && p.getEnvergadura() > 60 && tamano.equals("S")) {
            tamano = "M";
        }

        String zona;
        if (p.getTipo().equals("Ave")) {
            zona = "B";
        } else {
            zona = "A";
        }

        for (int i = 0; i < jaulas.length; i++) {
            Jaula j = jaulas[i];
            if (j.estaLibre() && j.getTamano().equals(tamano) && j.getZona().equals(zona)) {
                j.setOcupante(p);
                p.setJaula(j);
                return "OK: " + p.getNombre() + " asignado a jaula " + j.getNumero();
            }
        }
        return "ERROR: no hay jaula compatible";
    }

    public String medicar(String nombre, float mg) {
        int pos = buscar(nombre);
        if (pos == -1) {
            return "ERROR: paciente no encontrado";
        }
        Paciente p = pacientes[pos];
        if (mg <= 0) {
            return "ERROR: datos invalidos";
        }
        if (p.getEstado().equals("CUARENTENA")) {
            return "ERROR: paciente en cuarentena";
        }
        if (p.getJaula() == null) {
            return "ERROR: paciente sin jaula";
        }
        if (p.getTipo().equals("Gato") && p.getNivelEstres() >= 8) {
            return "ERROR: gato con estres alto";
        }
        if (mg > p.getDosisMaxima()) {
            return "ERROR: dosis excede el maximo";
        }
        if (p.getDosisAcumulada() + mg > 3 * p.getDosisMaxima()) {
            return "ERROR: tope acumulado superado";
        }
        p.setDosisAcumulada(p.getDosisAcumulada() + mg);
        p.setEstado("EN_TRATAMIENTO");
        p.subirEstres();   // solo el gato hace algo aquí
        return "OK: " + p.getNombre() + " medicado con " + mg + " mg";
    }

    public String alta(String nombre) {
        int pos = buscar(nombre);
        if (pos == -1) {
            return "ERROR: paciente no encontrado";
        }
        Paciente p = pacientes[pos];
        if (!p.getEstado().equals("EN_TRATAMIENTO")) {
            return "ERROR: paciente no apto para alta";
        }
        if (p.getJaula() != null) {
            p.getJaula().setOcupante(null);
            p.setJaula(null);
        }
        for (int i = pos; i < contador - 1; i++) {
            pacientes[i] = pacientes[i + 1];
        }
        pacientes[contador - 1] = null;
        contador--;
        return "OK: " + p.getNombre() + " dado de alta";
    }

    public String reporte() {
        String texto = "--- REPORTE ---\n";
        texto = texto + "Pacientes: " + contador + "/10\n";
        for (int i = 0; i < contador; i++) {
            Paciente p = pacientes[i];
            String jaula = "-";
            if (p.getJaula() != null) {
                jaula = "" + p.getJaula().getNumero();
            }
            float peso = Math.round(p.getPeso() * 10) / 10.0f;
            texto = texto + p.getNombre() + " | " + p.getTipo() + " | " + peso + " kg | "
                    + p.getEstado() + " | jaula: " + jaula + "\n";
        }
        int libres = 0;
        for (int i = 0; i < jaulas.length; i++) {
            if (jaulas[i].estaLibre()) {
                libres++;
            }
        }
        texto = texto + "Jaulas libres: " + libres;
        return texto;
    }
}