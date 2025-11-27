package com.salmontt.data;

import com.salmontt.model.CentroCultivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class GestorDatos {

    public ArrayList<CentroCultivo> cargarDatos(String archivo) {
        ArrayList<CentroCultivo> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // Lee cada línea

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length >= 3) {
                    String nombre = datos[0].trim();
                    String comuna = datos[1].trim();
                    int produccion = Integer.parseInt(datos[2].trim());

                    lista.add(new CentroCultivo(nombre, comuna, produccion));
                } else {
                    System.out.println("Línea inválida: no tiene 3 columnas");
                }
            }

            System.out.println("=== Datos leídos desde el CSV ===");
            for (CentroCultivo c : lista) {
                System.out.println(c);
            }

        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Guarda los datos en un archivo CSV.
     * @param archivo
     * @param lista
     */

    public void guardarDatos(String archivo, ArrayList<CentroCultivo> lista) {
        try (FileWriter archivoCsv = new FileWriter(archivo)) {
            archivoCsv.write("nombre,comuna,produccion\n");

            for (CentroCultivo c : lista) {
                archivoCsv.write(c.getNombre() + "," + c.getComuna() + "," + c.getProduccion() + "\n");
            }

            System.out.println("Archivo CSV creado en: " + new File(archivo).getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}


