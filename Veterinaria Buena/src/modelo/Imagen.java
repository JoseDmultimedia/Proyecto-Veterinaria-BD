/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;

/**
 *
 * @author lab.informatica
 */
public class Imagen {
    Image imagen;
    String nombre;

    public Imagen() {
    }

    public Imagen(Image imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
