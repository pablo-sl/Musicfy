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
public class ComparadorDeAgnoSong
        implements Comparator <Song> , Serializable{
     

    @Override
    public int compare(Song song1, Song song2) {
        int agn1 = song1.getAgno();
        int agn2 = song2.getAgno();
        
        return agn1-agn2;
    }
    
}
