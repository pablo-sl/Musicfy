/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PlayList implements Serializable {

    private String nombre;
    private List<Song> canciones;

    public PlayList(String nombre, List<Song> canciones) {
        this.nombre = nombre;
        this.canciones = canciones;
    }

    public PlayList() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Song> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Song> canciones) {
        this.canciones = canciones;
    }

}
