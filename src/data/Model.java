/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.coti.tools.Esdia;
import static com.coti.tools.Esdia.readInt;
import static com.coti.tools.Esdia.readString;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.System.out;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import utils.Constants;

/**
 *
 * @author Usuario
 */
public class Model implements Serializable{
    Musicfy mf = new Musicfy();
    Constants c = new Constants();
    
    public List<Artist> obtenerArtistas() {
        return mf.getArtists();
    }

    public List<Album> obtenerAlbumes() {
        return mf.getAlbums();
    }

    public List<Song> obtenerCanciones() {
        return mf.getSongs();
    }

    public List<PlayList> obtenerPlaylists() {
        return mf.getPlaylists();
    }

    public void addArtist(Artist artista) {
        mf.addArtist(artista);
    }

    public void addPlayList(PlayList playlist) {
        mf.addPlaylist(playlist);
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
    
    public void sortAndShowSongs() {
        readString("Canciones ordenadas. Pulse enter para verlas...");
        List<Song> canciones = obtenerCanciones();
        
        Collections.sort(canciones, new ComparadorCanciones(
                new ComparadorDeAgnoSong(),
                new ComparadorDeTituloSong())
        );
        String encabezado = String.format("%-50s%-20s%-15s%-20s", "TITULO", 
                    "AÑO", "DURACIÓN", "INTERPRETES");
        out.println(encabezado);
        out.println("--------------------------------------------------"
                    + "---------------------------------------------"
                    + "--------------------");
        for (Song a : canciones) {
            String l = String.format("%-50s%-20s%-15s%-20s", a.getTitulo(), 
                    a.getAgno(), a.getDuracion(), a.getInterpretes());
            out.println(l);
            
        }
        readString("Pulse enter para continuar...");
        
    }

    public void eliminarArtistas() {
        out.printf("%n%n------ ELIMINAR ARTISTA------%n%n");
        int i = 1;
        List<Artist> artistas = obtenerArtistas();
        List<Album> albumes = obtenerAlbumes();
        if (artistas == null || artistas.isEmpty()) {
            System.err.printf("ERROR. NO SE ENCONTRÓ LA LISTA DE\n");
            return;
        }
        boolean nosepuede = false;
        out.println("Listado de artistas: ");
        for (Artist artist : artistas) {
            out.println("[" + (i++) + "] " + artist.getNombre());
        }

        String aEliminar = Esdia.readString("¿Cual desea eliminar?: ");

        for (Album a : albumes) {
            if (a.getInterpretes().toString().toUpperCase().contains(aEliminar.toUpperCase())
                    && !aEliminar.isEmpty()) {
                out.println("ERROR: El artista " + aEliminar + " tiene al menos un álbum " + a.getTitulo());
                nosepuede = true;
            }
        }
        if (!nosepuede) {
            try {
                Artist artistaB = null;
                for (Artist a : artistas) {
                    if (a.getNombre().equalsIgnoreCase(aEliminar)) {
                        artistaB = a;
                    }
                }

                if (artistaB != null) {
                    deleteArtist(artistaB);
                } else {
                    if(!aEliminar.isEmpty()){
                    out.println("ERROR: no se pudo borrar a " +aEliminar + "porque: ");
                    out.println("\t1. no se encuantra en la base de datos Ó");
                    out.println("\t2. no se ha introducido el nombre correctamente");
                    }else{
                    out.println("\t2. no se ha introducido el nombre correctamente");    
                    }
                    
                }
            } catch (IndexOutOfBoundsException e) {
                out.println("Error: Indice no valido.");
            }
        }
        
        readString("Pulse enter para continuar...");
    }

    public void agnadirArtistas() {
        Artist artista = new Artist();
        String album = "a";
        List<String> albumes = new ArrayList<>();
        out.printf("%n%n------ AÑADIR ARTISTA------%n%n");

        artista.setNombre(readString("NOMBRE: "));
        artista.setBiografia(readString("BIOGRAIFA: "));
        artista.setInstagram(readString("INSTAGRAM: "));
        artista.setTwitter(readString("TWITTER: "));
        artista.setFacebook(readString("FACEBOOK: "));
        artista.setWikipedia(readString("WIKIPEDIA: "));

        while (!album.isEmpty()) {
            album = readString("ALBUMES (para dejar de añadir, pulse enter): ");
            if (!album.isEmpty()) {
                albumes.add(album);
            }
        }
        artista.setAlbumes(albumes);
        addArtist(artista);
        readString("Artista añadido. Pulse enter para continuar...");
        
    }

    public void modificarArtista() {
        out.printf("%n%n------ MODIFICAR ARTISTA------%n%n");
        int i = 1;
        List<Artist> artistas = obtenerArtistas();
        if (artistas == null || artistas.isEmpty()) {
            System.err.printf("ERROR. NO SE ENCONTRÓ LA LISTA DE\n");
            return;
        }

        out.println("Listado de artistas: ");
        for (Artist artist : artistas) {
            out.println("[" + (i++) + "] " + artist.getNombre());
        }

        String aModificar = Esdia.readString("¿Cual desea modificar?: ");
        try {
            for (Artist a : artistas) {
                if (a.getNombre().contains(aModificar)) {
                    Artist elegido = a;
                    String cambio = readString("Nueva Biografía (pulsar enter para no modificar):  ");
                    if (!cambio.isEmpty()) {
                        elegido.setBiografia(cambio);
                    }

                    cambio = readString("Instagram: " + elegido.getInstagram() + "(pulsar enter para no modificar):  ");
                    if (!cambio.isEmpty()) {
                        elegido.setInstagram(cambio);
                    }

                    cambio = readString("Twitter: " + elegido.getTwitter() + "(pulsar enter para no modificar):  ");
                    if (!cambio.isEmpty()) {
                        elegido.setTwitter(cambio);
                    }

                    cambio = readString("Facebook: " + elegido.getFacebook() + "(pulsar enter para no modificar):  ");
                    if (!cambio.isEmpty()) {
                        elegido.setFacebook(cambio);
                    }

                    cambio = readString("Wikipedia: " + elegido.getWikipedia() + "(pulsar enter para no modificar):  ");
                    if (!cambio.isEmpty()) {
                        elegido.setWikipedia(cambio);
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            out.println("Error: Indice no valido.");
        }
        
        readString("Pulse enter para continuar...");
    }

    public void albumesDeArtista() {
        
        out.printf("%n%n------ ALBUMES DE UN ARTISTA------%n%n");
        List<Album> albumes = obtenerAlbumes();
        int q = 1;
        ArrayList<String> interp = new ArrayList<>();
        for (Album l : albumes) {
            List<String> interpretes = l.getInterpretes();
            for (String i : interpretes) {
                interp.add(i);
            }
        }
        q = 1;
        ArrayList<String> sinRepes = removeDuplicates(interp);
        for (String a : sinRepes) {
            out.println("[" + (q++) + "] " + a);
        }
        String buscarArtista = readString("De que artista desea conocer los albumes: ");
        Collections.sort(albumes, new ComparadorAlbumes(
                new ComparadorDeAgnoAlbum(),
                new ComparadorDeTituloAlbum())
        );

        for (Album a : albumes) {
            List<String> interpretes = a.getInterpretes();
            for (String i : interpretes) {
                if (i.equalsIgnoreCase(buscarArtista) && a.getTipo().equalsIgnoreCase("álbum")) {
                    out.println(a.toStringAlbum());
                } else if (i.equalsIgnoreCase(buscarArtista)) {
                    out.println(a.toStringSingle());
                }
            }
        }
        readString("Pulse enter para continuar...");
    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new LinkedHashSet 
        Set<T> set = new LinkedHashSet<>();

        // Add the elements to set 
        set.addAll(list);

        // Clear the list 
        list.clear();

        // add the elements of set 
        // with no duplicates to the list 
        list.addAll(set);

        // return the list 
        return list;
    }

    public void agnadirAlbum() {
        int numcan = 0;
        Album album = new Album();
        String artista = "a";
        String tipo = "";
        List<String> interpretes = new ArrayList<>();
        List<String> canciones = new ArrayList<>();
        List<Artist> artistas = obtenerArtistas();
        List<Song> songs = new ArrayList<>();
        out.printf("%n%n------ AÑADIR ALBUM------%n%n");

        album.setTitulo(Esdia.readString("TITULO: "));
        String titulo = album.getTitulo();
        tipo = Esdia.readString("TIPO(sencillo o album): ");

        album.setTipo(tipo);
        if (tipo.equalsIgnoreCase("sencillo")) {

            while (!artista.isEmpty()) {
                Artist interprete = new Artist();
                artista = readString("ARTISTAS (para dejar de añadir, pulse enter): ");
                boolean exit = false;
                for (String a : interpretes) {
                    if (!exit) {
                        if (!interpretes.contains(artista)) {
                            exit = false;
                        } else {
                            out.println("Lo encontre");
                            artista = "";
                            exit = true;
                        }
                    }
                }
                if (!exit && !artista.isEmpty()) {
                    interprete.setNombre(artista);
                    interprete.setBiografia("-");
                    interprete.setInstagram("-");
                    interprete.setTwitter("-");
                    interprete.setFacebook("-");
                    interprete.setWikipedia("-");
                    interprete.setBiografia("-");
                    interprete.setAlbumes(Arrays.asList(titulo));
                    interpretes.add(artista);
                    interpretes.remove("");
                    out.println("ARTISTA AÑADIDO: " + interprete.getNombre());
                }

            }

            album.setInterpretes(interpretes);
            album.setNumero_canciones(1);
            album.setDuracion("3 min");
            album.setAgno(9999);
            Song song = new Song(album.getTitulo(), album.getAgno(), album.getDuracion(), album.getInterpretes());
            List<Song> songis = new ArrayList<>();
            songis.add(song);
            album.setCanciones(songis);
            addAlbum(album);

        }
        if (tipo.equalsIgnoreCase("álbum")) {

            while (!artista.isEmpty()) {
                Artist interprete = new Artist();
                artista = readString("ARTISTAS (para dejar de añadir, pulse enter): ");
                boolean exit = false;
                for (String a : interpretes) {
                    if (!exit) {
                        if (!interpretes.contains(artista)) {
                            exit = false;
                        } else {
                            out.println("Lo encontre");
                            artista = "aElim";
                            exit = true;
                        }
                    }
                }
                if (!exit && !artista.isEmpty()) {
                    interprete.setNombre(artista);
                    interprete.setBiografia("-");
                    interprete.setInstagram("-");
                    interprete.setTwitter("-");
                    interprete.setFacebook("-");
                    interprete.setWikipedia("-");
                    interprete.setBiografia("-");
                    interprete.setAlbumes(Arrays.asList(titulo));
                    artistas.add(interprete);
                    interpretes.add(artista);
                    interpretes.remove("");
                    interpretes.remove("aElim");
                }

            }

            album.setInterpretes(interpretes);
            album.setDuracion("3 min");
            String cancion = "a";
            boolean cans = false;
            while (!cancion.isEmpty()) {
                cancion = readString("Introduzca el titulo de una cancion: ");
                boolean exit = false;
                for (String a : canciones) {
                    if (!exit) {
                        if (!canciones.contains(cancion)) {
                            exit = false;
                            numcan++;
                        } else {
                            out.println("Lo encontre");
                            cancion = "aEliminar";
                            exit = true;
                            cans = true;
                        }
                    }
                }
                if (!cans) {
                    canciones.add(cancion);
                    canciones.remove("");
                    canciones.remove("aEliminar");
                    canciones.remove("");
                    Song song = new Song(cancion, album.getAgno(), album.getDuracion(), album.getInterpretes());
                    songs.add(song);
                    album.setNumero_canciones(songs.size());
                    album.setCanciones(songs);
                }
            }
            addAlbum(album);

        }
        
        readString("Pulse enter para continuar...");
    }

    public void eliminarAlbum() {
        
        out.printf("%n%n------ BORRAR ARTISTA------%n%n");
        int i = 1;
        Album a = new Album();
        List<Song> canciones = new ArrayList<>();
        List<Song> aBorrar = obtenerCanciones();
        List<Album> albumes = obtenerAlbumes();
        if (albumes == null || albumes.isEmpty()) {
            System.err.printf("ERROR. NO SE ENCONTRÓ LA LISTA DE\n");
            return;
        }

        out.println("Listado de albumes: ");
        for (Album album : albumes) {
            out.println("[" + (i++) + "] " + album.getTitulo());
        }

        String aEliminar = Esdia.readString("¿Cual desea eliminar?: ");
        try {
            for (Album l : albumes) {
                if (l.getTitulo().equalsIgnoreCase(aEliminar)) {
                    a = l;
                    
                }
            }
            readString("Pulse enter para continuar...");
            for (Song a2 : a.getCanciones()) {
                aBorrar.remove(a2);
            }
            readString("Album " + a.getTitulo() + " y sus canciones eliminados con exito. "
                    + "Pulse enter para continuar...");
            
            albumes.remove(a);
            mf.setAlbums(albumes);
            mf.setSongs(canciones);
        } catch (NullPointerException e) {
            out.println("Error: Album no válido.");
        }
        readString("Pulse enter para continuar...");
    }

    public void modificarAlbum() {
        
        out.printf("%n%n------ MODIFICAR ARTISTA------%n%n");
        int i = 1;
        List<Album> albumes = obtenerAlbumes();
        if (albumes == null || albumes.isEmpty()) {
            System.err.printf("ERROR, ALBUMES VACIOS\n");
            return;
        }

        out.println("Listado de albumes: ");
        for (Album album : albumes) {
            out.println("[" + (i++) + "] " + album.getTitulo());
        }

        String aModificar = Esdia.readString("¿Cual desea modificar?: ");
        for (Album a : albumes) {
            if (a.getTitulo().equalsIgnoreCase(aModificar)) {
                Album elegido = a;

                try {
                    String cambio = readString("Año: " + elegido.getAgno() + "(pulsar enter para no modificar):  ");
                    if (!cambio.isEmpty()) {
                        int cambiar = Integer.parseInt(cambio);
                        elegido.setAgno(cambiar);
                    }

                    cambio = readString("Duracion: " + elegido.getDuracion() + "(pulsar enter para no modificar):  ");
                    if (!cambio.isEmpty()) {
                        elegido.setDuracion(cambio);
                    }

                } catch (IndexOutOfBoundsException e) {
                    out.println("Error: Indice no valido.");
                }
            }
        }
        readString("%n%nPulse enter para continuar...");

    }

    public void preguntarPorAlbum() {
        
        int i = 1;
        String empty = "";
        List<Album> albumes = obtenerAlbumes();
        Album consultado;
        if (albumes == null || albumes.isEmpty()) {
            System.err.printf("ERROR. NO SE ENCONTRÓ LA LISTA DE ARTISTAS O ALBUMS\n");
            return;
        }

        out.println("Listado de albumes: ");
        for (Album album : albumes) {
            out.println("[" + (i++) + "] " + album.getTitulo());
        }

        String aAgnadir = Esdia.readString("¿Que album desea consultar?: ");
        int z = 0, valid = 0;
        boolean hay = false;
        String nombre = "";
        for (Album a : albumes) {
            if (a.getTitulo().equalsIgnoreCase(aAgnadir)) {
                consultado = a;
                hay = true;
                nombre = a.getTitulo();
                valid = z;
            }
            z++;
        }
        if (hay == false) {
            out.println("ERROR: No se pudo consultar ningún álbum...");

        } else {
            try {

                Album elegido = albumes.get(valid);
                if (elegido.getTipo().equalsIgnoreCase("álbum")) {
                    List<String> cantantes = elegido.getInterpretes();
                    List<Song> canciones = elegido.getCanciones();
                    int j = 0;
                    String[] songs = new String[canciones.size() + cantantes.size()];
                    String[] singers = new String[cantantes.size() + canciones.size()];
                    for (String cantante : cantantes) {
                        singers[j++] = cantante;
                    }
                    j = 0;
                    for (Song song : canciones) {

                        songs[j++] = song.getTitulo();

                    }

                    out.println("|TITULO                       |INTERPRETES         |AÑO   "
                            + "|DURACION       |NUMERO DE CANCIONES |TIPO      |CANCIONES                          |");
                    out.printf("|%-29s|%-20s|%-6d|%-15s|%-20d|%-10s|%-35s|%n", elegido.getTitulo(), singers[0],
                            elegido.getAgno(), elegido.getDuracion(), elegido.getNumero_canciones(),
                            elegido.getTipo(), songs[0]);
                    j = 1;
                    do {

                        if (singers[j] != null && songs[j] != null) {
                            out.printf("|                             |%-20s|      "
                                    + "|               |                    |          |%-35s|%n", singers[j], songs[j]);

                        } else if (singers[j] != null && songs[j] == null) {
                            out.printf("|                              |%-20s|      "
                                    + "|               |                    |          |%-35s|%n", singers[j], empty);

                        } else if (singers[j] == null && songs[j] != null) {
                            out.printf("|                             |%-20s|      "
                                    + "|               |                    |          |%-35s|%n", empty, songs[j]);
                        }

                        j++;
                    } while (j < elegido.getNumero_canciones() || j < singers.length);
                } else {

                    int j = 0;
                    List<String> cantantes = elegido.getInterpretes();
                    String blank = "";
                    String[] singers = new String[cantantes.size()];
                    for (String cantante : cantantes) {
                        singers[j++] = cantante;
                    }
                    out.println("|TITULO                        |INTERPRETES         |AÑO   "
                            + "|DURACION       |NUMERO DE CANCIONES |TIPO      |CANCIONES                          |");
                    out.printf("|%-30s|%-20s|%-6d|%-15s|%-20d|%-10s|%-35s|%n", elegido.getTitulo(), singers[0],
                            elegido.getAgno(), elegido.getDuracion(), elegido.getNumero_canciones(),
                            elegido.getTipo(), elegido.getTitulo());

                    for (j = 1; j < singers.length; j++) {
                        out.printf("                               |%-20s|      "
                                + "|               |                    |          |%-35s|%n", singers[j], blank);
                    }

                }
            } catch (IndexOutOfBoundsException e) {
                out.println("Error: Indice no valido.");
            }
        }
        readString("%n%nPulse enter para continuar...");
    }

    public void agnadirPlayList() {
        
        Random r = new Random();
        PlayList playlist = new PlayList();
        out.printf("%n%n------FUNCION AÑADIR PLAYLIST------%n%n");
        String nombrePlayList = readString("Nombre de la nueva PLaylist: ");
        int num_canciones = readInt("Numero total de canciones");
        List<Song> addsongs = new ArrayList<>();
        List<Song> totalSongs = obtenerCanciones();

        List<PlayList> totalplaylists = obtenerPlaylists();

        Song song;
        for (int i = 0; i < num_canciones; i++) {
            song = totalSongs.get(r.nextInt(totalSongs.size()));
            addsongs.add(song);

        }
        playlist.setCanciones(addsongs);
        playlist.setNombre(nombrePlayList);
        addPlayList(playlist);
        out.println(playlist.getNombre());
        out.println(playlist.getCanciones());
        mf.setPlaylists(totalplaylists);
        readString("Pulse enter para continuar...");

    }

    public void borrarCancionPlayList() {
        int i = 1;
        List<PlayList> playlists = obtenerPlaylists();
        if (playlists == null || playlists.isEmpty()) {
            System.err.printf("ERROR. NO SE ENCONTRÓ LA LISTA DE PLAYLISTS\n");
            return;
        }

        out.println("Listado de playlists: ");
        for (PlayList playlist : playlists) {
            out.println("[" + (i++) + "] " + playlist.getNombre());
        }

        String aEliminar = Esdia.readString("¿De cual desea eliminar una cancion?: ");
        PlayList elim;
        for (PlayList p : playlists) {
            if (p.getNombre().equalsIgnoreCase(aEliminar)) {
                elim = p;

                try {
                    Song a = new Song();
                    List<Song> songs = elim.getCanciones();

                    if (!songs.isEmpty()) {
                        out.println("Seleccione una cancion de la playlist " + elim.getNombre());
                        int j = 1;
                        for (Song s : songs) {
                            out.println("[" + (j++) + "] " + s.getTitulo());
                        }
                        String outSong = readString("Cancion que desea eliminar: ");
                        for (Song s : songs) {
                            if (s.getTitulo().equalsIgnoreCase(outSong)) {
                                a = s;
                            }
                        }
                        try {
                            deleteSongFromPlayList(elim, a);
                        } catch (IndexOutOfBoundsException ex) {
                            out.println("Error: cancion no valida: " + aEliminar);
                        }

                    } else {
                        out.printf("ERROR, playlist vacia. Añada alguna cancion...");
                    }
                } catch (IndexOutOfBoundsException e) {
                    out.println("Error: Indice no valido.");
                }
            }

        }
        
        readString("Pulse enter para continuar...");
    }

    public void agnadirCancionPlayList() {
         int i = 1;
        PlayList aAddSongTo = new PlayList();
        List<PlayList> playlists = obtenerPlaylists();
        List<Song> songs = obtenerCanciones();
        if (playlists == null || playlists.isEmpty()) {
            System.err.printf("ERROR. NO SE ENCONTRÓ LA LISTA DE PLAYLISTS\n");
            return;
        }

        out.println("Listado de playlists: ");
        //String [] playlistes = new String[playlists.size()];
        for (PlayList playlist : playlists) {
            //playlistes[i-1] = playlist.getNombre();
            out.println("[" + (i++) + "] " + playlist.getNombre());
        }

        String aAgnadir = Esdia.readString("¿a cual desea añadir una cancion?: ");
        boolean hay = false;
        String nombre = "";
        for (PlayList p : playlists) {
            if (p.getNombre().equalsIgnoreCase(aAgnadir)) {
                aAddSongTo = p;
                hay = true;
                nombre = p.getNombre();

            }
        }
        if (hay == false) {
            out.println("ERROR: No se pudo añadir ninguna cancion...");

        } else {
            String newSong = readString("Escriba el nombre de la cancion que desea añadir a : " + nombre);

            out.println("NEW SONG: " + newSong);
            for (Song s : songs) {
                if (s.getTitulo().equalsIgnoreCase(newSong)) {
                    out.println("Añadiendo " + newSong);
                    addSongToPlayList(aAddSongTo, s);
                }
            }

        }
        
        readString("Pulse enter para continuar...");
    }

    public void comienzo() throws IOException, FileNotFoundException, ClassNotFoundException {
        Musicfy music;
        Artist artist;
        Album album;
        String[] lineas;
        int i;
        String cancion;
        Song song;
        if (comprobarFichero(c.PATH_MUSICFY_BIN)) {
            try {
                music = binAMusicfy(c.PATH_MUSICFY_BIN);
                mf.setAlbums(music.getAlbums());
                mf.setSongs(music.getSongs());
                mf.setPlaylists(music.getPlaylists());
                mf.setArtists(music.getArtists());

            } catch (IOException ex) {
                out.println("Error: no se pudo importar el binario de musicfy. Leyendo texto...");

            }
        } else {
            if (comprobarFichero(c.PATH_ARTISTS_TXT)) {
                List<String> artistas = leerTxt(c.PATH_ARTISTS_TXT);
                for (String line : artistas) {
                    artist = Artist.instanceFromString(line);
                    mf.addArtist(artist);
                }
            } else {
                out.println("Error, no hay fichero de texto de artistas");
            }

            if (comprobarFichero(c.PATH_ALBUMES_TXT)) {
                List<String> albumes = leerTxt(c.PATH_ALBUMES_TXT);
                String[] cancions = new String[albumes.size()];
                for (String line : albumes) {
                    lineas = line.split("\t");
                    if (line.trim().contains("sencillo")) {
                        album = Album.instanceFromStringSingle(line);
                        mf.addAlbum(album);
                        cancions[0] = album.getTitulo();
                    }

                    if (line.trim().contains("álbum")) {
                        album = Album.instanceFromStringAlbum(line);
                        mf.addAlbum(album);
                        cancions = lineas[6].split(";");

                    }

                    for (i = 0; i < cancions.length; i++) {
                        if (!cancions[i].isEmpty()) {
                            cancion = cancions[i] + "\t" + line.split("\t")[1] + "\t" + line.split("\t")[2] + "\t" + line.split("\t")[3];
                            song = Song.instanceFromStringFromAlbum(cancion);
                            mf.addSong(song);
                            cancions[i] = "";
                        }
                    }
                }
            }
        }
        
        //Albumes y canciones
    }

    public static boolean comprobarFichero(String fichero) {
        boolean encontrado = false;
        try {
            File file = new File(fichero);
            if (file.exists() && file.isFile()) {
                encontrado = true;
            }
        } catch (Exception e) {
            out.println("No se encuentra el fichero...");
        }

        return encontrado;
    }

    private List<String> leerTxt(String p) throws IOException {
        File file = new File(p);
        List<String> leido = null;
        if (Files.exists(file.toPath())) {
            leido = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
        } else {
            throw new IOException("El archivo no existe. Saliendo...%n");
        }

        return leido;
    }


    
    private Musicfy binAMusicfy(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        Musicfy music;
        File f = new File(path);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
        music = (Musicfy) ois.readObject();
        ois.close();
        return music;
    }
    public List<Album> generarAlbumesRandom(List<Artist> aleatorios) {
        return mf.generateRandomAlbums(aleatorios);
    }

    public List<PlayList> generarPlaylistsRandom() {
        return mf.generateRandomPlaylists();
    }

    public List<Artist> generarArtistasRandom() {
        return mf.generateRandomArtists();
    }
    
    public void generarAleatoriamente() {
        List<Artist> artistasAleatorios = generarArtistasRandom();
        List<Album> albumesAleatorios = generarAlbumesRandom(artistasAleatorios);
        List<PlayList> playlistsAleatorias = generarPlaylistsRandom();
        List<Song> listaDeCanciones = obtenerCanciones();
        Musicfy music = new Musicfy();
        music.setAlbums(albumesAleatorios);
        music.setArtists(artistasAleatorios);
        music.setPlaylists(playlistsAleatorias);
        music.setSongs(listaDeCanciones);
        out.println("ARTISTAS, ALBUMES, CANCIONES Y PLAYLISTS GENERADOS ALEATORIAMENTE");
        readString("Pulse enter para continuar...");
    
    }

    public void exportarArtistas() throws IOException {
        
        List<String> artistas = getArtistsInColumns();

        if (artistas == null) {
            artistas = new ArrayList<>();
            artistas.add("No hay datos disponibles");
        } else {
            artistas.add(0, String.format("%-20s|%-400s|%-30s|%-30s|%-30s|%-80s|%-200s" + "%n",
                    "NOMBRE", "BIOGRAFIA", "INSTAGRAM", "TWITTER", "FACEBOOK",
                    "WIKIPEDIA", "ALBUMES"));
        }

        File f = new File(c.PATH_ARTISTS_COL);
        Files.write(f.toPath(), artistas, Charset.forName("UTF-8"));
    }

    public void exportarAlbumes()  throws IOException {
        
        List<String> albumes = mf.getAlbumesInHMTL();

        if (albumes == null) {
            albumes = new ArrayList<>();
            albumes.add("<TR><TD>NO SE PUDO EXPORTAR.</TD></TR>%n");
        }

        albumes.add(0, c.HTML_HEADER);
        albumes.add(c.HTML_FOOTER);

        File f = new File(c.PATH_ALBUMES_HTML);
        Files.write(f.toPath(), albumes, Charset.forName("UTF-8"));
    }
    

        public List<String> getArtistsInColumns() {
        if (mf.getArtists() == null || mf.getArtists().isEmpty()) {
            return null;
        }
        List<String> artistasColumnados = new ArrayList<>();
        for (Artist artista : mf.getArtists()) {
            artistasColumnados.add(artista.toColumnedString());
        }

        return artistasColumnados;
    }

    public void salida() throws IOException {
        
        List<Album> albums = mf.getAlbums();
        List<Song> songs = mf.getSongs();
        List<PlayList> playlists = mf.getPlaylists();
        List<Artist> artistas = mf.getArtists();
        Musicfy musicfy = new Musicfy();
        musicfy.setAlbums(albums);
        musicfy.setSongs(songs);
        musicfy.setPlaylists(playlists);
        musicfy.setArtists(artistas);

        try {
            musicfyToBin(c.PATH_MUSICFY_BIN, musicfy);

        } catch (NullPointerException ex) {
            out.println("No se puede exportar a binarios");
        }
    }
        
    private void musicfyToBin(String path, Musicfy musicfy) throws FileNotFoundException, IOException {

        File f = new File(path);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
        oos.writeObject(musicfy);
        oos.close();

    }    
    
}
