/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicfypablosl;

import java.io.FileNotFoundException;
import java.io.Serializable;
import view.View;

/**
 *
 * @author Usuario
 */
public class MusicfyPabloSL implements Serializable {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        View v = new View();
        v.runMenu("+--------MENU PRINCIPAl--------+%n"
                + "|                              |%n"
                + "| [1] Generacion aleatoria.    |%n"
                + "| [2] Archivos.                |%n"
                + "| [3] Album.                   |%n"
                + "| [4] Artista.                 |%n"
                + "| [5] Playlist.                |%n"
                + "| [6] Canciones.               |%n"
                + "| [S] salir.                   |%n"
                + "|                              |%n"
                + "+------------------------------+%n");
    }

}
