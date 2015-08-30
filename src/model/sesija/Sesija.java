/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sesija;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author student1
 */
public class Sesija {

    static Sesija sesija;
    
    /*omogucava cuvanje parova kljuc vrednost
        svi kljucevi moraju biti razliciti
        
    
    */
    
    Map<String, Object> mapa;

    public Map<String, Object> getMapa() {
        return mapa;
    }
    
    public static Sesija vratiInstancu() {
        if(sesija==null)
            sesija = new Sesija();
        return sesija;
    }   

    private Sesija() {   
        mapa = new HashMap<>();
    }
  
    
    
}
