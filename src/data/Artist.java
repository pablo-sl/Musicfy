/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class Artist  implements Serializable{
    private String nombre;
    private String biografia;
    private String instagram;
    private String twitter;
    private String facebook;
    private String wikipedia;
    private List <String> albumes;

    public Artist(String nombre, String biografia, String instagram, String twitter,
                  String facebook, String wikipedia, List<String> albumes) {
        this.nombre = nombre;
        this.biografia = biografia;
        this.instagram = instagram;
        this.twitter = twitter;
        this.facebook = facebook;
        this.wikipedia = wikipedia;
        this.albumes = albumes;
    }

    public Artist() {
    }
    
    public Artist(String nombre){
        this.nombre = nombre;
        this.biografia="";
        this.instagram="";
        this.twitter="";
        this.facebook="";
        this.wikipedia="";
        this.albumes=null;
    }

        public static Artist instanceFromString(String artista){
        
        Artist ar = new Artist();
        String [] a = artista.split("#");
        String [] albus;
        
        try{
        ar.nombre = a[0];
        ar.biografia = a[1];
        ar.instagram = a[2];
        ar.twitter = a[3];
        ar.facebook = a[4];
        ar.wikipedia = a[5];
        albus = a[6].split(";");
        ar.albumes = Arrays.asList(albus);
        return ar;
        
        }catch(Exception ex){
            System.err.printf("Error: Artista descartado: %s%n", ex);
            return null;
        }
   }    
    
    
    public String toColumnedString(){
        return String.format("%-20s|%-400s|%-30s|%-30s|%-30s|%-80s|%-200s", this.nombre,
                this.biografia, this.instagram, this.twitter, this.facebook, 
                this.wikipedia, this.albumes);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public List<String> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<String> albumes) {
        this.albumes = albumes;
    }
    
    
    
}

