import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CompetenciaVideojuegos {
    private static final String ARCHIVO_JUGADORES = "jugadores.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- COMPETENCIA DE VIDEOJUEGOS ---");
            System.out.println("1. Agregar jugador de prueba (Ejemplo)");
            System.out.println("2. Procesar registros (Promedio, Máximo y Filtro > 70)");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarJugadorPrueba(scanner);
                    break;
                case 2:
                    procesarRegistrosJugadores();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    public static void agregarJugadorPrueba(Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la puntuación: ");
        String puntajeStr = scanner.nextLine();

        try {
            
            int puntaje = Integer.parseInt(puntajeStr);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_JUGADORES, true))) {
                bw.write(nombre + "," + puntaje);
                bw.newLine();
                System.out.println("Jugador agregado exitosamente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: La puntuación debe ser un número entero válido.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void procesarRegistrosJugadores() {
        Path ruta = Paths.get(ARCHIVO_JUGADORES);
        if (!Files.exists(ruta)) {
            System.out.println("El archivo '" + ARCHIVO_JUGADORES + "' no existe. Agregue registros primero.");
            return;
        }

        int totalJugadores = 0;
        double sumaPuntuaciones = 0;
        int mayorPuntaje = Integer.MIN_VALUE;
        String mejorJugador = "";
        
        System.out.println("\n--- RESULTADOS Y PROCESAMIENTO ---");
        System.out.println("Participantes con puntuación superior a 70:");

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_JUGADORES))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                
                String[] partes = linea.split(",");
                if (partes.length != 2) {
                    System.out.println("  [Advertencia] Línea " + numeroLinea + " con formato inválido (se esperaba Nombre,Puntuación): " + linea);
                    continue;
                }

                String nombre = partes[0].trim();
                try {
                    int puntuacion = Integer.parseInt(partes[1].trim());
                    
                    
                    totalJugadores++;
                    sumaPuntuaciones += puntuacion;

                    if (puntuacion > mayorPuntaje) {
                        mayorPuntaje = puntuacion;
                        mejorJugador = nombre;
                    }

                    
                    if (puntuacion > 70) {
                        System.out.println("  -> " + nombre + " con " + puntuacion + " puntos.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("  [Advertencia] Línea " + numeroLinea + ": La puntuación no es un número válido -> " + partes[1]);
                }
            }

            if (totalJugadores > 0) {
                double promedio = sumaPuntuaciones / totalJugadores;
                System.out.println("\n--- ESTADÍSTICAS GENERALES ---");
                System.out.println("Total de registros válidos procesados: " + totalJugadores);
                System.out.println("Promedio de puntuaciones: " + String.format("%.2f", promedio));
                System.out.println("Jugador con mayor puntaje: " + mejorJugador + " (" + mayorPuntaje + " puntos)");
            } else {
                System.out.println("\nNo se encontraron registros válidos para procesar.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de jugadores: " + e.getMessage());
        }
    }
}
