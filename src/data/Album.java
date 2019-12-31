/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class Album implements Serializable {

    private String titulo;
    private List<String> interpretes;
    private int agno;
    private String duracion;
    private int numero_canciones;
    private String tipo;
    private List<Song> canciones;
    Musicfy mf = new Musicfy();

    public Album(String titulo, List<String> interpretes, int agno, String duracion,
            int numero_canciones, String tipo, List<Song> canciones) {
        this.titulo = titulo;
        this.interpretes = interpretes;
        this.agno = agno;
        this.duracion = duracion;
        this.numero_canciones = numero_canciones;
        this.tipo = tipo;
        this.canciones = canciones;
    }

    public Album() {
    }

    public static Album instanceFromStringSingle(String album) {
        Album al = new Album();
        String[] a = album.split("\t");
        String[] interprets;
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        String cancion;
        List<Song> unica = new ArrayList<>();
        Song ca;
        try {
            al.titulo = a[0];
            interprets = a[1].split(";");
            al.interpretes = Arrays.asList(interprets);
            al.agno = nf.parse(a[2]).intValue();
            al.duracion = a[3];
            al.numero_canciones = nf.parse(a[4]).intValue();
            al.tipo = a[5];
            cancion = a[0] + "\t" + a[1] + "\t" + a[2] + "\t" + a[3];
            ca = Song.instanceFromStringFromAlbum(cancion);
            unica.add(ca);
            al.canciones = unica;
            return al;

        } catch (ParseException ex) {
            System.err.printf("Error: Album(single) descartado: %s%n", ex);
            return null;
        }
    }

    public String toStringSingle() {
        return String.format("%-30s|%-30s|%-5s|%-15s|%-3s|%-10s", titulo, interpretes, agno,
                duracion, numero_canciones, tipo);
    }

    public String toStringAlbum() {
        return String.format("%-30s|%-30s|%-5s|%-15s|%-3s|%-10s", titulo, interpretes, agno,
                duracion, numero_canciones, tipo);
    }

    public static Album instanceFromStringAlbum(String album) {
        Album al = new Album();
        List<Song> listacanciones = new ArrayList<Song>();
        Song ca = new Song();
        Song song = new Song();
        String[] a = album.split("\t");
        String[] interprets;
        String[] cancions;
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        String cancion;

        try {
            int i;
            al.titulo = a[0];
            interprets = a[1].split(";");
            al.interpretes = Arrays.asList(interprets);
            al.agno = nf.parse(a[2]).intValue();
            al.duracion = a[3];
            al.numero_canciones = nf.parse(a[4]).intValue();
            al.tipo = a[5];
            cancions = a[6].split(";");
            //System.out.printf(cancions[5] + "%n");

            for (i = 0; i < cancions.length; i++) {
                cancion = cancions[i] + "\t" + a[1] + "\t" + a[2] + "\t" + a[3];
                ca = Song.instanceFromStringFromAlbum(cancion);
                listacanciones.add(ca);

            }
            al.canciones = listacanciones;
            return al;

        } catch (ParseException ex) {
            System.err.printf("Error: Album(álbum) descartado: %s%n", ex);
            return null;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(List<String> interpretes) {
        this.interpretes = interpretes;
    }

    public int getAgno() {
        return agno;
    }

    public void setAgno(int agno) {
        this.agno = agno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getNumero_canciones() {
        return numero_canciones;
    }

    public void setNumero_canciones(int numero_canciones) {
        this.numero_canciones = numero_canciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Song> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Song> canciones) {
        this.canciones = canciones;
    }

    public String toHTMLString() {

        String[] titulos = getCancionesDeAlbum(this.canciones);
        return String.format("<TR><TD>%s</TD>"
                + "<TD>%s</TD>"
                + "<TD>%d</TD>"
                + "<TD>%s</TD>"
                + "<TD>%d</TD>"
                + "<TD>%s</TD>"
                + "<TD>%s</TD></TR>",
                this.titulo,
                this.interpretes.toString().replace("[", "").replace("]", ""),
                this.agno,
                this.duracion,
                this.numero_canciones,
                this.tipo,
                Arrays.toString(titulos).replace("[", "").replace("]", ""));

    }

    private String[] getCancionesDeAlbum(List<Song> canciones) {
        List<Song> songs = canciones;
        String[] titulos = new String[songs.size()];
        int i = 0;
        for (Song s : songs) {
            titulos[i++] = s.getTitulo();
        }

        return titulos;
    }

}
