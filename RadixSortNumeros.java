import java.io.*;
import java.util.*;

public class RadixSortNumeros {

    // Radix sort para enteros no negativos (LSD)
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        int max = arr[0];
        for (int v : arr) if (v > max) max = v;

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // dígitos 0..9

        // Contar ocurrencias del dígito (arr[i] / exp) % 10
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Convertir en posiciones acumuladas (estable)
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];

        // Construir salida (recorremos hacia atrás para estabilidad)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copiar a arr
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Entrada: nombre del archivo
            System.out.print("Nombre del archivo de entrada: ");
            String entrada = sc.nextLine().trim();

            File f = new File(entrada);
            if (!f.exists()) {
                System.out.println("ERROR: archivo no encontrado: " + entrada);
                sc.close();
                return;
            }

            // Leer números
            ArrayList<Integer> list = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            System.out.println("\n--- CONTENIDO DEL ARCHIVO ---");
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                int val = Integer.parseInt(line);
                System.out.println(val);
                if (val < 0) {
                    System.out.println("ERROR: RadixSortNumeros no soporta números negativos.");
                    br.close();
                    sc.close();
                    return;
                }
                list.add(val);
            }
            br.close();

            // Convertir a arreglo
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);

            // Ordenar
            radixSort(arr);

            // Archivo de salida
            System.out.print("\nNombre del archivo de salida: ");
            String salida = sc.nextLine().trim();

            PrintWriter pw = new PrintWriter(new FileWriter(salida));

            System.out.println("\n--- RESULTADO (RADIX SORT) ---");
            for (int v : arr) {
                System.out.println(v);
                pw.println(v);
            }
            pw.close();

            System.out.println("\n✓ Archivo generado: " + salida);

        } catch (NumberFormatException nf) {
            System.out.println("ERROR: el archivo debe contener solo enteros no negativos, uno por línea.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
