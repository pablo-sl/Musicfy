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
public class ComparadorDeTituloAlbum 
        implements Comparator <Album>, Serializable{
     

    @Override
    public int compare(Album album1, Album album2) {
        String tit1 = album1.getTitulo().toLowerCase();
        String tit2 = album2.getTitulo().toLowerCase();
        
        return tit1.compareTo(tit2);
    }
    
}


