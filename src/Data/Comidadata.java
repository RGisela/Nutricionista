/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class Comidadata {
    
  public class ComidaData {
    private List<Comida> comidas;

    public ComidaData() {
        comidas = new ArrayList<>();
    }

    public void agregarComida(Comida comida) {
        comidas.add(comida);
    }

    public void mostrarComidas() {
        for (Comida comida : comidas) {
            System.out.println(comida);
        }
    }

    public Comida buscarComida(String nombre) {
        for (Comida comida : comidas) {
            if (comida.getNombre().equals(nombre)) {
                return comida;
            }
        }
        return null;
    }

    public void eliminarComida(String nombre) {
        Comida comida = buscarComida(nombre);
        if (comida != null) {
            comidas.remove(comida);
            System.out.println("Comida '" + comida.getNombre() + "' eliminada.");
        } else {
            System.out.println("Comida '" + nombre + "' no encontrada.");
        }
    }

    public void modificarComida(String nombre, String nuevoNombre, String nuevoDetalle, double nuevasCalorias) {
        Comida comida = buscarComida(nombre);
        if (comida != null) {
            comida.setNombre(nuevoNombre);
            comida.setDetalle(nuevoDetalle);
            comida.setCaloriasPorGramo(nuevasCalorias);
            System.out.println("Comida '" + nombre + "' modificada.");
        } else {
            System.out.println("Comida '" + nombre + "' no encontrada.");
        }
    }
}

class Comida {
    private String nombre;
    private String detalle;
    private double caloriasPorGramo;

    public Comida(String nombre, String detalle, double caloriasPorGramo) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.caloriasPorGramo = caloriasPorGramo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getCaloriasPorGramo() {
        return caloriasPorGramo;
    }

    public void setCaloriasPorGramo(double caloriasPorGramo) {
        this.caloriasPorGramo = caloriasPorGramo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Detalle: " + detalle + ", Calorías por gramo: " + caloriasPorGramo;
    }
}
}
