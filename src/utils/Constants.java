/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Artist;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Constants  implements Serializable{
    
    public final String PATH_DESKTOP = System.getProperty("user.home") + "/Desktop";
    public final String PATH_MUSICFY = PATH_DESKTOP + File.separator + "musicfy";
    
    //FICHEROS TXT Y BIN
    
    
    public final String PATH_ARTISTS_TXT = PATH_MUSICFY + File.separator + "datos" + File.separator + "artistas.txt";
    public final String PATH_ALBUMES_TXT = PATH_MUSICFY + File.separator + "datos" + File.separator + "albumes.txt";
    public final String PATH_MUSICFY_BIN = PATH_MUSICFY + File.separator + "binarios" + File.separator + "musicfy.bin";
    
    //FICHEROS EXPORTADOS
    
    public final String PATH_ARTISTS_COL = PATH_MUSICFY + File.separator + "salida" + File.separator + "artistas.col";
    public final String PATH_ALBUMES_HTML = PATH_MUSICFY + File.separator + "salida" + File.separator + "albumes.html";
    
    //HTML
    
    public final String HTML_HEADER = String.format("<!DOCTYPE html>%n"
            + "<html>%n"
            + "<head>\t<title>Tabla de peliculas</title>"
            + "<style>"
            + "table {\n" 
            + "  font-family: arial, sans-serif;\n" 
            + "  border-collapse: collapse;\n" 
            + "}\n" 
            + "\n" 
            + "td, th {\n" 
            + "  border: 1px solid #E6E6E6;\n" 
            + "  text-align: left;\n" 
            + "  padding: 8px;\n" 
            + "}\n" 
            + "\n" 
            + "tr:nth-child(even) {\n" 
            + "  background-color: #E6E6E6;\n" 
            + "}"
            + "</style></head><body>%n"
            + "<table><thead>%n"
            + "<TR><TH>%50s</TH>"
            + "<TH>%50s</TH>"
            + "<TH>%50s</TH>"
            + "<TH>%50s</TH>"
            + "<TH>%50s</TH>"
            + "<TH>%50s</TH>"
            + "<TH>%50s</TH></TR>"
            + "</thead>", "TITULO", "INTERPRETES", "AÑO", "DURACION", "NUMERO DE CANCIONES", "TIPO", "CANCIONES");
    public String  HTML_FOOTER= "</body></html>";

    public void deleteArtist(Artist artistaB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void comienzo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
