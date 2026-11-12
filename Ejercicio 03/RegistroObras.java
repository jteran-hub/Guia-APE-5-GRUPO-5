
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroObras {

    public static void main(String[] args) {

        File archivo = new File("obras.txt");

        int pinturas = 0;
        int esculturas = 0;

        try {

            if (!archivo.exists()) {

                BufferedWriter escritor = new BufferedWriter(
                    new FileWriter(archivo)
                );

                escritor.write("La Mona Lisa,Pintura");
                escritor.newLine();
                escritor.write("El Grito,Pintura");
                escritor.newLine();
                escritor.write("David,Escultura");
                escritor.newLine();
                escritor.write("La Noche Estrellada,Pintura");
                escritor.newLine();
                escritor.write("El Pensador,Escultura");
                escritor.newLine();
                escritor.write("Guernica,Pintura");

                escritor.close();
            }

            BufferedReader lector = new BufferedReader(
                new FileReader(archivo)
            );

            String linea;

            System.out.println("REGISTRO DE OBRAS");
            System.out.println("----------------------");

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 2) {

                    String nombre = datos[0];
                    String categoria = datos[1];

                    System.out.println("Obra: " + nombre);
                    System.out.println("Categoria: " + categoria);
                    System.out.println("----------------------");

                    if (categoria.equalsIgnoreCase("Pintura")) {

                        pinturas++;

                    } else if (categoria.equalsIgnoreCase("Escultura")) {

                        esculturas++;
                    }
                }
            }

            lector.close();

            System.out.println("CLASIFICACION DE OBRAS");
            System.out.println("Pinturas: " + pinturas);
            System.out.println("Esculturas: " + esculturas);

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
