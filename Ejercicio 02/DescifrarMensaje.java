import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DescifrarMensaje {

    public static void main(String[] args) {

        File archivo = new File("mensaje.txt");

        int caracter;
        int contador = 0;

        try {

            if (!archivo.exists()) {

                FileWriter escritor = new FileWriter(archivo);

                escritor.write("ALERTA: SISTEMA DE EMERGENCIA ACTIVADO");

                escritor.close();
            }

            FileReader lector = new FileReader(archivo);

            System.out.println("MENSAJE RECIBIDO:");
            System.out.println("----------------------");

            while ((caracter = lector.read()) != -1) {

                System.out.print((char) caracter);
                contador++;
            }

            lector.close();

            System.out.println();
            System.out.println("----------------------");
            System.out.println("Total de caracteres: " + contador);

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
