/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Album;
import data.Artist;
import data.Model;
import data.Musicfy;
import data.PlayList;
import data.Song;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import utils.Constants;

/**
 *
 * @author Usuario
 */
public class Controller implements Serializable {
    Model m = new Model();
    Musicfy mf = new Musicfy();
    Constants c = new Constants();
    Artist ar = new Artist();

    public void comienzo() throws IOException, FileNotFoundException, ClassNotFoundException {

        //Artistas
        m.comienzo();
        
    }

    public void deleteArtist(Artist artist) {
        mf.removeArtist(artist);
    }

    public void addAlbum(Album album) {
        mf.addAlbum(album);
    }

    public void deleteAlbum(Album album) {
        mf.removeAlbum(album);
    }

    public void addSongToPlayList(PlayList aAddSongTo, Song s) {
        mf.addSongToPlayList(aAddSongTo, s);
    }

    public void deleteSongFromPlayList(PlayList playlist, Song song) {
        mf.removeSongFromPlayList(playlist, song);
    }

    public void exportarArtistaAColumnas() throws IOException{
        m.exportarArtistas();
    }


    public void exportarAlbumesAHTML() throws IOException {
        
        m.exportarAlbumes();
        
    }

    public void salida() throws FileNotFoundException, IOException {
        m.salida();
    }



    public void mostrarCancionesOrdenadas() {
        m.sortAndShowSongs();
    }

    public void eliminarArtista() {
        
        m.eliminarArtistas();        
    }

    public void agnadirArtista() {
        m.agnadirArtistas();
    }

    public void modificarArtista() {
        m.modificarArtista();
    }

    public void albumesDeUnArtista() {
        m.albumesDeArtista();
    }

    public void agnadirAlbum() {
        m.agnadirAlbum();
    }

    public void eliminarAlbum() {
        m.eliminarAlbum();
    }

    public void modificarAlbum() {
        m.modificarAlbum();
    }

    public void preguntarPorAlbum() {
        m.preguntarPorAlbum();
    }

    public void agnadirPlayList() {
        m.agnadirPlayList();
    }

    public void borrarCancionPlayList() {
        m.borrarCancionPlayList();
    }

    public void agnadirCancionPlayList() {
        m.agnadirCancionPlayList();
    }

    public List<Song> obtenerCanciones() {
        return m.obtenerCanciones();
    }

    public void generarAleatoriamente() {
        m.generarAleatoriamente();
    }
    

}
