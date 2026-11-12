import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ResultadosParticipantes {

    public static void main(String[] args) {

        File archivo = new File("resultados.txt");

        double total = 0;
        double mayorPuntaje = -1;

        String mejorParticipante = "";

        int contador = 0;

        try {

            if (!archivo.exists()) {

                BufferedWriter escritor = new BufferedWriter(
                    new FileWriter(archivo)
                );

                escritor.write("Juan,85");
                escritor.newLine();
                escritor.write("Maria,92");
                escritor.newLine();
                escritor.write("Carlos,78");
                escritor.newLine();
                escritor.write("Ana,96");
                escritor.newLine();
                escritor.write("Pedro,88");

                escritor.close();
            }

            BufferedReader lector = new BufferedReader(
                new FileReader(archivo)
            );

            String linea;

            System.out.println("RESULTADOS DE PARTICIPANTES");
            System.out.println("----------------------");

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 2) {

                    String nombre = datos[0];
                    double puntaje = Double.parseDouble(datos[1]);

                    System.out.println("Participante: " + nombre);
                    System.out.println("Puntaje: " + puntaje);
                    System.out.println("----------------------");

                    total += puntaje;
                    contador++;

                    if (puntaje > mayorPuntaje) {

                        mayorPuntaje = puntaje;
                        mejorParticipante = nombre;
                    }
                }
            }

            lector.close();

            System.out.println("RESULTADOS FINALES");
            System.out.println("Puntaje total: " + total);

            if (contador > 0) {

                System.out.println("Puntaje mas alto: " + mayorPuntaje);
                System.out.println("Mejor participante: " + mejorParticipante);

            } else {

                System.out.println("No existen participantes registrados.");
            }

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Error: existe un puntaje no numerico.");
        }
    }
}
