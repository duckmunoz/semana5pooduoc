package com.salmontt.ui;

/**
 * Clase principal.
 */

import com.salmontt.data.GestorDatos;
import com.salmontt.model.CentroCultivo;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("====Salmontt - Centros de Cultivo====\n");

        /**
         * Se cargan los datos del archivo CSV.
         */

        GestorDatos gd = new GestorDatos();
        String rutaArchivo = "datacentros.csv";
        ArrayList<CentroCultivo> centros = gd.cargarDatos(rutaArchivo);


        if (centros.isEmpty()) {
            System.out.println("No se cargaron datos del CSV.");
            return;
        }

        /**
         *Se imprimen por pantalla los centros con producción superior a 1000 toneladas.
         */

        System.out.println("\n===Centros con producción sobre 1000 toneladas===");
        boolean hayAltos = false;
        for (CentroCultivo c : centros) {
            if (c.getProduccion() > 1000) {
                System.out.println(c);
                hayAltos = true;
            }
        }
        if (!hayAltos) {
            System.out.println("No hay Centros de Cultivo con producción superior a 1000 toneladas");
        }
    }
}

