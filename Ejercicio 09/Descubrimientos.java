import java.io.*;
import java.util.*;

public class Ejercicio9_Descubrimientos {
    static final String ARCHIVO = "descubrimientos.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op;
        do {
            System.out.println("\n1. Agregar descubrimiento\n2. Listar y contar\n3. Buscar por nombre\n0. Salir");
            System.out.print("Opcion: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1" -> {
                    System.out.print("Descubrimiento: ");
                    agregar(sc.nextLine().trim());
                }
                case "2" -> listar();
                case "3" -> {
                    System.out.print("Nombre a buscar: ");
                    buscar(sc.nextLine().trim());
                }
                case "0" -> System.out.println("Hasta luego.");
                default -> System.out.println("Opcion invalida.");
            }
        } while (!op.equals("0"));
    }

    static void agregar(String texto) {
        if (texto.isEmpty()) {
            System.out.println("El texto no puede estar vacio.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(texto);
            bw.newLine();
            System.out.println("Descubrimiento agregado.");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }

    // Valida que el archivo exista y tenga contenido antes de procesarlo
    static boolean archivoValido() {
        File f = new File(ARCHIVO);
        if (!f.exists()) {
            System.out.println("El archivo no existe.");
            return false;
        }
        if (f.length() == 0) {
            System.out.println("El archivo esta vacio.");
            return false;
        }
        return true;
    }

    static void listar() {
        if (!archivoValido()) return;
        int total = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) continue;
                total++;
                System.out.println(total + ". " + linea);
            }
            System.out.println("Total de descubrimientos: " + total);
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }

    static void buscar(String nombre) {
        if (!archivoValido()) return;
        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println("Encontrado: " + linea);
                    encontrado = true;
                }
            }
            if (!encontrado) System.out.println("No se encontro \"" + nombre + "\".");
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}
