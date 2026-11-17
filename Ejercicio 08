import java.io.*;
import java.util.*;

public class Ejercicio8_Temperaturas {
    static final String ARCHIVO = "temperaturas.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n1. Guardar temperatura\n2. Analizar temperaturas\n0. Salir");
            System.out.print("Opcion: ");
            op = leerEntero(sc);
            switch (op) {
                case 1 -> {
                    System.out.print("Temperatura: ");
                    guardar(sc.nextLine().trim());
                }
                case 2 -> analizar();
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opcion invalida.");
            }
        } while (op != 0);
    }

    static int leerEntero(Scanner sc) {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    static void guardar(String dato) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(dato);
            bw.newLine();
            System.out.println("Registro guardado.");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }

    static void analizar() {
        List<Double> temps = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            int n = 0;
            while ((linea = br.readLine()) != null) {
                n++;
                if (linea.isBlank()) continue;
                try {
                    temps.add(Double.parseDouble(linea.trim().replace(',', '.')));
                } catch (NumberFormatException e) {
                    System.out.println("Linea " + n + " ignorada (no es numerica): \"" + linea + "\"");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe todavia.");
            return;
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
            return;
        }

        if (temps.isEmpty()) {
            System.out.println("No hay temperaturas validas.");
            return;
        }
        double suma = 0, max = temps.get(0);
        int mayores30 = 0;
        for (double t : temps) {
            suma += t;
            if (t > max) max = t;
            if (t > 30) mayores30++;
        }
        System.out.printf("Promedio: %.2f%n", suma / temps.size());
        System.out.println("Temperatura mas alta: " + max);
        System.out.println("Registros mayores a 30: " + mayores30);
    }
}
