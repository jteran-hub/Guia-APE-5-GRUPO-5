import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalisisPistas {

    public static void main(String[] args) {

        File archivo = new File("pistas.txt");
        int contador = 0;

        try {

            if (!archivo.exists()) {

                BufferedWriter escritor = new BufferedWriter(
                    new FileWriter(archivo)
                );

                escritor.write("Huella encontrada en la puerta.");
                escritor.newLine();
                escritor.write("Se encontro una carta en el escritorio.");
                escritor.newLine();
                escritor.write("Un testigo vio un vehiculo sospechoso.");
                escritor.newLine();
                escritor.write("Se encontro una llave en el jardin.");

                escritor.close();
            }

            BufferedReader lector = new BufferedReader(
                new FileReader(archivo)
            );

            String linea;

            System.out.println("ANALISIS DE PISTAS");
            System.out.println("----------------------");

            while ((linea = lector.readLine()) != null) {

                System.out.println(linea);
                contador++;
            }

            lector.close();

            System.out.println("----------------------");
            System.out.println("Total de pistas: " + contador);

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
