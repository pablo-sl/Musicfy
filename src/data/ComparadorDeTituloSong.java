/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class ComparadorDeTituloSong 
        implements Comparator <Song>, Serializable{
     

    @Override
    public int compare(Song song1, Song song2) {
        String tit1 = song1.getTitulo().toLowerCase();
        String tit2 = song2.getTitulo().toLowerCase();
        
        return tit1.compareTo(tit2);
    }
    
}


