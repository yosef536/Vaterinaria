import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner sc = new Scanner(System.in);

        String opcion = "";
        while (!opcion.equals("9")) {
            System.out.println();
            System.out.println("=== HOSPITAL VETERINARIO ===");
            System.out.println("1. Ingresar perro");
            System.out.println("2. Ingresar gato");
            System.out.println("3. Ingresar ave");
            System.out.println("4. Vacunar");
            System.out.println("5. Asignar jaula");
            System.out.println("6. Medicar");
            System.out.println("7. Dar de alta");
            System.out.println("8. Reporte");
            System.out.println("9. Salir");
            opcion = pedir(sc, "Elige una opcion: ");

            if (opcion.equals("1")) {
                System.out.println(ingresarPerro(hospital, sc));
            } else if (opcion.equals("2")) {
                System.out.println(ingresarGato(hospital, sc));
            } else if (opcion.equals("3")) {
                System.out.println(ingresarAve(hospital, sc));
            } else if (opcion.equals("4")) {
                System.out.println(hospital.vacunar(pedir(sc, "Nombre: ")));
            } else if (opcion.equals("5")) {
                System.out.println(hospital.asignar(pedir(sc, "Nombre: ")));
            } else if (opcion.equals("6")) {
                System.out.println(medicar(hospital, sc));
            } else if (opcion.equals("7")) {
                System.out.println(hospital.alta(pedir(sc, "Nombre: ")));
            } else if (opcion.equals("8")) {
                System.out.println(hospital.reporte());
            } else if (!opcion.equals("9")) {
                System.out.println("ERROR: comando desconocido");
            }
        }
        sc.close();
    }

    // Muestra el mensaje y devuelve lo que escribe el usuario
    private static String pedir(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private static String ingresarPerro(Hospital h, Scanner sc) {
        String nombre = pedir(sc, "Nombre: ");
        String peso = pedir(sc, "Peso (kg): ");
        String edad = pedir(sc, "Edad (anos): ");
        String raza = pedir(sc, "Raza: ");
        String vac = pedir(sc, "Vacunado (si/no): ");
        if (!vac.equals("si") && !vac.equals("no")) {
            return "ERROR: datos invalidos";
        }
        try {
            return h.ingresarPerro(nombre, Float.parseFloat(peso), Integer.parseInt(edad),
                    raza, vac.equals("si"));
        } catch (NumberFormatException e) {
            return "ERROR: datos invalidos";
        }
    }

    private static String ingresarGato(Hospital h, Scanner sc) {
        String nombre = pedir(sc, "Nombre: ");
        String peso = pedir(sc, "Peso (kg): ");
        String edad = pedir(sc, "Edad (anos): ");
        try {
            return h.ingresarGato(nombre, Float.parseFloat(peso), Integer.parseInt(edad));
        } catch (NumberFormatException e) {
            return "ERROR: datos invalidos";
        }
    }

    private static String ingresarAve(Hospital h, Scanner sc) {
        String nombre = pedir(sc, "Nombre: ");
        String peso = pedir(sc, "Peso (kg): ");
        String edad = pedir(sc, "Edad (anos): ");
        String env = pedir(sc, "Envergadura (cm): ");
        try {
            return h.ingresarAve(nombre, Float.parseFloat(peso), Integer.parseInt(edad),
                    Float.parseFloat(env));
        } catch (NumberFormatException e) {
            return "ERROR: datos invalidos";
        }
    }

    private static String medicar(Hospital h, Scanner sc) {
        String nombre = pedir(sc, "Nombre: ");
        String mg = pedir(sc, "Dosis (mg): ");
        try {
            return h.medicar(nombre, Float.parseFloat(mg));
        } catch (NumberFormatException e) {
            return "ERROR: datos invalidos";
        }
    }
}