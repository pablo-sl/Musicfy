/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ComparadorAlbumes 
        implements Comparator<Album>, Serializable{
        private List<Comparator<Album>> listComparators = null;
 
    @SafeVarargs
    public ComparadorAlbumes(Comparator<Album> ... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Album art1, Album art2) {
        for (Comparator<Album> comparator : listComparators) {
            int result = comparator.compare(art1, art2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
