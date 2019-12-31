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
public class ComparadorCanciones 
        implements Comparator<Song>, Serializable{
        private final List<Comparator<Song>> listComparators;
 
    @SafeVarargs
    public ComparadorCanciones(Comparator<Song> ... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Song emp1, Song emp2) {
        for (Comparator<Song> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
