import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BibliotecaInteligente {
    private static final String NOMBRE_ARCHIVO = "libros.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE BIBLIOTECA INTELIGENTE ---");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Leer y contar todos los libros");
            System.out.println("3. Buscar un libro específico");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro a registrar: ");
                    String titulo = scanner.nextLine();
                    registrarLibro(titulo);
                    break;
                case 2:
                    leerYContarLibros();
                    break;
                case 3:
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String busqueda = scanner.nextLine();
                    buscarLibro(busqueda);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
        
        scanner.close();
    }

    public static void registrarLibro(String titulo) {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            bw.write(titulo);
            bw.newLine();
            System.out.println("Libro registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerYContarLibros() {
        Path ruta = Paths.get(NOMBRE_ARCHIVO);
        
        if (!Files.exists(ruta)) {
            System.out.println("El archivo '" + NOMBRE_ARCHIVO + "' aún no existe. Registre al menos un libro primero.");
            return;
        }

        System.out.println("\n--- LISTA DE LIBROS ALMACENADOS ---");
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("- " + linea);
                contador++;
            }
            System.out.println("Total de libros registrados: " + contador);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void buscarLibro(String tituloBuscado) {
        Path ruta = Paths.get(NOMBRE_ARCHIVO);
        if (!Files.exists(ruta)) {
            System.out.println("El archivo '" + NOMBRE_ARCHIVO + "' no existe todavía.");
            return;
        }

        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equalsIgnoreCase(tituloBuscado.trim())) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                System.out.println("¡El libro \"" + tituloBuscado + "\" SÍ se encuentra en la biblioteca!");
            } else {
                System.out.println("El libro \"" + tituloBuscado + "\" no fue encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Error al buscar en el archivo: " + e.getMessage());
        }
    }
}
