package com.salmontt.model;

/**
 * Clase que representa un centro de cultivo.
 */

public class CentroCultivo {

    private String nombre;
    private String comuna;
    private int produccion;

    /**
     *Constructor de un centro de cultivo.
      * @param nombre
     * @param comuna
     * @param produccion
     */

    public CentroCultivo(String nombre, String comuna, int produccion) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.produccion = produccion;
    }

    /**
     * Getters y Setters de los atributos.
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    public String getComuna() {
        return comuna;
    }

    public int getProduccion() {
        return produccion;
    }

    /**
     * ToString de un centro de cultivo.
     * @return
     */

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Comuna: " + comuna + ", Producción: " + produccion;
    }
}

