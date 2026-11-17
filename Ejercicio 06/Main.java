import java.io.*;
import java.util.Scanner;

public class SistemaMensajesSecretos {
    private static final String ARCHIVO_SECRETO = "secreto.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE MENSAJES SECRETOS ---");
            System.out.println("1. Escribir nuevo mensaje");
            System.out.println("2. Leer y contar mensajes");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente de nuevo.");
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el mensaje secreto: ");
                    String mensaje = scanner.nextLine();
                    escribirMensaje(mensaje);
                    break;
                case 2:
                    leerMensajes();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema de mensajes...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    public static void escribirMensaje(String mensaje) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_SECRETO, true))) {
            writer.write(mensaje);
            writer.newLine();
            System.out.println("Mensaje guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida (I/O) al escribir el mensaje: " + e.getMessage());
        }
    }

    public static void leerMensajes() {
        File archivo = new File(ARCHIVO_SECRETO);
        if (!archivo.exists()) {
            System.out.println("No hay mensajes registrados aún (el archivo no existe).");
            return;
        }

        System.out.println("\n--- MENSAJES ALMACENADOS ---");
        int contadorLineas = 0;

        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_SECRETO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("[Mensaje]: " + linea);
                contadorLineas++;
            }
            System.out.println("Total de líneas registradas: " + contadorLineas);
        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida (I/O) al leer el archivo: " + e.getMessage());
        }
    }
}
