import java.io.*;
import java.util.*;

public class Ejercicio10_Ventas {
    static final String ARCHIVO = "ventas.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op;
        do {
            System.out.println("\n1. Registrar venta\n2. Total y producto de mayor precio\n3. Filtrar por precio minimo\n0. Salir");
            System.out.print("Opcion: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1" -> registrar(sc);
                case "2" -> resumen();
                case "3" -> {
                    System.out.print("Valor minimo: ");
                    try {
                        filtrar(Double.parseDouble(sc.nextLine().trim().replace(',', '.')));
                    } catch (NumberFormatException e) {
                        System.out.println("Valor invalido.");
                    }
                }
                case "0" -> System.out.println("Hasta luego.");
                default -> System.out.println("Opcion invalida.");
            }
        } while (!op.equals("0"));
    }

    static void registrar(Scanner sc) {
        System.out.print("Producto: ");
        String producto = sc.nextLine().trim();
        System.out.print("Precio: ");
        String precioTxt = sc.nextLine().trim().replace(',', '.');
        try {
            double precio = Double.parseDouble(precioTxt);
            if (producto.isEmpty() || producto.contains(",") || precio < 0) {
                System.out.println("Datos invalidos (nombre vacio, con coma o precio negativo).");
                return;
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
                bw.write(producto + "," + precio);
                bw.newLine();
                System.out.println("Venta registrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("El precio no es un numero valido.");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }

    // Lee el archivo y devuelve solo las lineas validas: [nombre, precio]
    static List<Object[]> leerVentas() {
        List<Object[]> ventas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            int n = 0;
            while ((linea = br.readLine()) != null) {
                n++;
                if (linea.isBlank()) continue;
                String[] p = linea.split(",");
                if (p.length != 2) {
                    System.out.println("Linea " + n + " con formato incorrecto: " + linea);
                    continue;
                }
                try {
                    double precio = Double.parseDouble(p[1].trim());
                    if (precio < 0) throw new NumberFormatException();
                    ventas.add(new Object[]{p[0].trim(), precio});
                } catch (NumberFormatException e) {
                    System.out.println("Linea " + n + " con precio invalido: " + linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe todavia.");
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return ventas;
    }

    static void resumen() {
        List<Object[]> ventas = leerVentas();
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas validas.");
            return;
        }
        double total = 0;
        Object[] mayor = ventas.get(0);
        for (Object[] v : ventas) {
            double precio = (double) v[1];
            total += precio;
            if (precio > (double) mayor[1]) mayor = v;
        }
        System.out.printf("Total de ventas: %.2f%n", total);
        System.out.println("Producto de mayor precio: " + mayor[0] + " (" + mayor[1] + ")");
    }

    static void filtrar(double minimo) {
        boolean hay = false;
        for (Object[] v : leerVentas()) {
            if ((double) v[1] > minimo) {
                System.out.println(v[0] + " - " + v[1]);
                hay = true;
            }
        }
        if (!hay) System.out.println("Ningun producto supera " + minimo);
    }
}
