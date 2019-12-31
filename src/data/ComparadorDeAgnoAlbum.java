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
public class ComparadorDeAgnoAlbum
        implements Comparator <Album> , Serializable{
     

    @Override
    public int compare(Album album1, Album album2) {
        int agn1 = album1.getAgno();
        int agn2 = album2.getAgno();
        
        return agn1-agn2;
    }
    
}
