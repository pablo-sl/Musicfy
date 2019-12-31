/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class Song implements Serializable {

    private String titulo;
    private int agno;
    private String duracion;
    private List<String> interpretes;

    public Song(String titulo, int agno, String duracion, List<String> interpretes) {
        this.titulo = titulo;
        this.agno = agno;
        this.duracion = duracion;
        this.interpretes = interpretes;
    }

    public Song() {
    }

    public static Song instanceFromStringFromSingle(String s) {

        Song son = new Song();
        String[] a = s.split("\t");
        String[] singers;
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        try {

            son.titulo = a[0];
            singers = a[1].split(";");
            son.interpretes = Arrays.asList(singers);
            son.agno = nf.parse(a[2]).intValue();
            son.duracion = a[3];

            return son;

        } catch (ParseException ex) {
            System.err.printf("Line Discarded: %s\n", ex);
            return null;
        }
    }

    @Override
    public String toString() {

        return titulo + "\t" + agno + "\t" + duracion + "\t" + interpretes;
    }

    public static Song instanceFromStringFromAlbum(String s) {
        Song son = new Song();
        String[] a = s.split("\t");
        String[] singers;
        Locale spanish = new Locale("es", "ES");
        NumberFormat nf = NumberFormat.getInstance(spanish);
        try {

            son.titulo = a[0];
            singers = a[1].split(";");
            son.interpretes = Arrays.asList(singers);
            son.agno = nf.parse(a[2]).intValue();
            son.duracion = a[3];

            return son;

        } catch (ParseException ex) {
            System.err.printf("Line Discarded: %s\n", ex);
            return null;
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public List<String> getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(List<String> interpretes) {
        this.interpretes = interpretes;
    }

}
