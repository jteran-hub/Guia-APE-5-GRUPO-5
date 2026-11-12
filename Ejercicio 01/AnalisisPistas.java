import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnalisisPistas {

    public static void main(String[] args) {

        int contador = 0;

        try {
            BufferedReader lector = new BufferedReader(
                new FileReader("pistas.txt")
            );

            String linea;

            while ((linea = lector.readLine()) != null) {

                System.out.println(linea);
                contador++;
            }

            lector.close();

            System.out.println("----------------------");
            System.out.println("Total de pistas: " + contador);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
