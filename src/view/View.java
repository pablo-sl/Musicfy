/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.coti.tools.Esdia.readString;
import controller.Controller;
import java.io.IOException;
import static java.lang.System.out;
import data.Musicfy;
import data.ComparadorDeAgnoSong;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constants;

/**
 *
 * @author Usuario
 */
public class View implements Serializable {

    Scanner in = new Scanner(System.in);
    Musicfy mf = new Musicfy();
    Controller c = new Controller();
    Constants co = new Constants();
    ComparadorDeAgnoSong cdi = new ComparadorDeAgnoSong();

    public void runMenu(String menu) throws FileNotFoundException {
        String option;
        boolean exit = false;
        try {
            c.comienzo();

        } catch (IOException e) {
            System.err.printf("ERROR: los datos no pudieron importarse. Saliendo...");
            option = "s";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {
            out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n"
                    + "%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n"
                    + "%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n");
            out.printf(menu);
            out.printf("OPCION?");
            option = readString("");
            option = option.toLowerCase();
            if (option.isEmpty()) {
                out.printf("Por favor. Introduzca una opcion valida cuando aparezca "
                        + "\"OPCION?\"%n");
            }

            switch (option) {
                case "1":
                    toRandomGeneration();
                    break;  // A generar colecciones de manera aleatoria
                case "2":
                    toMenus(2);
                    break;  // Menu de Archivos
                case "3":
                    toMenus(3);
                    break;  // Menu de Albumes
                case "4":
                    toMenus(4);
                    break;  // Menu de Artistas
                case "5":
                    toMenus(5);
                    break;  // Menu de Playlists
                case "6":
                    sortedSongs();
                    break;  //A ordenar las canciones
                case "s":
                    exit = true;
                    break;  //Saliendo del menu
                default:
                    out.printf("NO VALIDO\n");
                    break;
            }
            out.println();
        } while (!exit);
        try {
            c.salida();
        } catch (IOException e) {
            out.println("No pudo excribirse");
        }
    }

    private void toRandomGeneration() {
        c.generarAleatoriamente();
        
    }

    private void toMenus(int i) {

        String[] menus = {/*(0)*/"================MENU ARCHIVOS===============%n"
            + "[1] Exportar artists en formato de columnas%n"
            + "[2] Exportar albumes (SIN CANCIONES) a HTML%n",
            /*(1)*/ "===MENU ALBUM===%n"
            + "[1] Dar de Alta%n"
            + "[2] Dar de Baja%n"
            + "[3] Modificar%n"
            + "[4] Consultar%n",
            /*(2)*/ "============MENU ARTISTA============%n"
            + "[1] Dar de Alta%n"
            + "[2] Dar de Baja%n"
            + "[3] Modificar%n"
            + "[4] Mostrar Albumes de un artista%n",
            /*(3)*/ "=====MENU PLAYLIST====%n"
            + "[1] Dar de Alta%n"
            + "[2] Eliminar cancion%n"
            + "[3] Añadir cancion",};
        String suboption;
        boolean exitMenu = false;

        //====================END DE LOS SUBMENUS===============================
        switch (i) {

            //------------------SUBMENU DE ARCHIVOS-----------------------------
            case 2:
                do {
                    out.printf("%n" + menus[0] + "%nOPCION?");
                    suboption = readString("");
                    switch (suboption) {
                        case "1":
                            exportArtistsACol();
                            exitMenu = true;
                            break;
                        case "2":
                            exportAlbumesAHTML();
                            exitMenu = true;
                            break;
                        default:
                            out.printf("Error, no es valido");
                            break;
                    }
                } while (suboption.isEmpty() || !exitMenu);
                break;

            //------------------SUBMENU DE ALBUMES------------------------------        
            case 3:
                do {
                    out.printf("%n" + menus[1] + "%nOPCION?");
                    suboption = readString("");
                    switch (suboption) {
                        case "1":
                            addAlbum();
                            exitMenu = true;
                            break;
                        case "2":
                            deleteAlbum();
                            exitMenu = true;
                            break;
                        case "3":
                            modifyAlbum();
                            exitMenu = true;
                            break;
                        case "4":
                            askForAlbum();
                            exitMenu = true;
                            break;
                        default:
                            out.printf("Error, no es valido");
                            break;
                    }
                } while (suboption.isEmpty() || !exitMenu);
                break;

            //------------------SUBMENU DE ARTISTAS-----------------------------
            case 4:
                do {
                    out.printf("%n" + menus[2] + "%nOPCION?");
                    suboption = readString("");
                    switch (suboption) {
                        case "1":
                            addArtist();
                            exitMenu = true;
                            break;
                        case "2":
                            deleteArtist();
                            exitMenu = true;
                            break;
                        case "3":
                            modifyArtist();
                            exitMenu = true;
                            break;
                        case "4":
                            albumsfromArtist();
                            exitMenu = true;
                            break;
                        default:
                            out.printf("Error, no es valido");
                            break;
                    }
                } while (suboption.isEmpty() || !exitMenu);
                break;

            //------------------SUBMENU DE PLAYLIST-----------------------------
            case 5:
                do {
                    out.printf("%n" + menus[3] + "%nOPCION?");
                    suboption = readString("");
                    switch (suboption) {
                        case "1":
                            addPlaylist();
                            exitMenu = true;
                            break;
                        case "2":
                            deleteSongPlaylist();
                            exitMenu = true;
                            break;
                        case "3":
                            addSongPlaylist();
                            exitMenu = true;
                            break;
                        default:
                            out.printf("Error, no es valido");
                            break;
                    }
                } while (suboption.isEmpty() || !exitMenu);
                break;

        }
        //====================END DE LOS SUBMENUS===============================
    }

    private void addArtist() {
        c.agnadirArtista();
        
    }

    private void deleteArtist() {
        c.eliminarArtista();
    }

    private void modifyArtist() {
        c.modificarArtista();

    }

    private void albumsfromArtist() {
        c.albumesDeUnArtista();
    }

    private void addAlbum() {
        c.agnadirAlbum();
    }

    private void deleteAlbum() {
        c.eliminarAlbum();
        
    }

    private void modifyAlbum() {
        c.modificarAlbum();
    }

    private void askForAlbum(){
        
        c.preguntarPorAlbum();
    }

    private void exportArtistsACol() {
        try {
            c.exportarArtistaAColumnas();
            readString("Pulse enter para continuar...");
        } catch (IOException ex) {
            System.err.println("ERROR, los artistas no pudieron exportarse");
        }
        
    }

    private void exportAlbumesAHTML() {
        try {
            c.exportarAlbumesAHTML();
            readString("Pulse enter para continuar...");
        } catch (IOException ex) {
            System.err.println("ERROR, las canciones no pudieron exportarse");
        }
    }

    private void addPlaylist() {
        c.agnadirPlayList();
    }

    private void deleteSongPlaylist() {
        c.borrarCancionPlayList();
    }

    private void addSongPlaylist() {
        c.agnadirCancionPlayList();
    }

    private void sortedSongs() {
        c.mostrarCancionesOrdenadas();
        
        
        
    }

}
