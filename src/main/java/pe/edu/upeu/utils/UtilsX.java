package pe.edu.upeu.utils;

import java.net.URL;

public class UtilsX {
    
    public int fibonaciRecur(final int numero) {
        if (numero < 2) {
        return numero;
        } else {
        return fibonaciRecur(numero - 1) + fibonaciRecur(numero - 2);
        }
    }

    public URL getFile(String ruta){
        return this.getClass().getResource("/"+ruta);
    }
}