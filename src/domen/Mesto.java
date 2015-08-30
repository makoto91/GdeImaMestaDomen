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
public class Mesto implements Serializable, AbstractDomainObject{
    private long ptt;
    private String naziv;

    public Mesto() {
        this.ptt = 0;
        this.naziv = "N/A";
    }

    @Override
    public String toString() {
        return naziv;
    }

    public Mesto(long ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }
    
    public long getPtt() {
        return ptt;
    }

    public void setPtt(long ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String ispisi() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        Mesto mesto = (Mesto) obj;
        return getPtt() == mesto.getPtt();
    }

    @Override
    public String vratiNazivTabele() {
        return "mesta";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AbstractDomainObject> napuni(ResultSet rs, AbstractDomainObject odo) throws Exception {
        List<AbstractDomainObject> lm = new ArrayList<>();
        while (rs.next()) {
//            Korisnik k = new Korisnik();
//            k.setImePrezime(rs.getString("imePrezime"));
//            k.setEmail(rs.getString("email"));
//            k.setSifra(rs.getString("sifra"));
//            k.setAdresa(rs.getString("adresa"));
            
            Mesto m = new Mesto();
            m.setPtt(rs.getLong("ptt"));
            m.setNaziv(rs.getString("naziv"));
            
            
            lm.add(m);
        }
        rs.close();
        return lm;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";    
    }

    @Override
    public String vratiNazivPK() {
        return "ptt";
    }

    @Override
    public String vratiVrednostPK() {
        return ptt+"";
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
}
