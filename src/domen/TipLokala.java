/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija1
 */
public class TipLokala implements Serializable, AbstractDomainObject {
    private int tipID;
    private String naziv;

    public TipLokala(int tipID, String naziv) {
        this.tipID = tipID;
        this.naziv = naziv;
    }

    public TipLokala() {
    }

    public void setTipID(int tipID) {
        this.tipID = tipID;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTipID() {
        return tipID;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "tipovilokala";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AbstractDomainObject> napuni(ResultSet rs, AbstractDomainObject odo) throws Exception {
        List<AbstractDomainObject> ltl = new ArrayList<>();
        while (rs.next()) {
            
            TipLokala t = new TipLokala();
            t.setTipID(rs.getInt("tipID"));
            t.setNaziv(rs.getString("naziv"));
            
            
            ltl.add(t);
        }
        rs.close();
        return ltl;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";    
    }

    @Override
    public String vratiNazivPK() {
        return "tipID";
    }

    @Override
    public String vratiVrednostPK() {
        return tipID+"";
    }

    @Override
    public void setPK(int sledeci) {
        
    }

    @Override
    public String dajUslovZaSelect(AbstractDomainObject odo) {
        return "";
    }

    @Override
    public String vratiRedosledZaInsert() {
        return "";
    }

    @Override
    public void napuniJedanObjekat(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ispisi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
