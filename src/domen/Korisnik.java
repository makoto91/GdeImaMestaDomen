/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matija1
 */
public class Korisnik implements Serializable, AbstractDomainObject{
    private int korisnikID;
    private String imePrezime;
    private String email;
    private String sifra;
    private Mesto mesto;
    private String adresa;
    private int uloga;
    private Date lastLogin;

    public Korisnik(String imePrezime, String email, String sifra, Mesto mesto, String adresa, int uloga) {
        this.imePrezime = imePrezime;
        this.email = email;
        this.sifra = sifra;
        this.mesto = mesto;
        this.adresa = adresa;
        this.uloga = uloga;
        korisnikID = -1;
        
    }

    public Korisnik() {
    }

    @Override
    public String ispisi() {
        return imePrezime;
    }
    
    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setUloga(int uloga) {
        this.uloga = uloga;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public String getSifra() {
        return sifra;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public String getAdresa() {
        return adresa;
    }
    
    public int getUloga() {
        return uloga;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    @Override
    public String vratiNazivTabele() {
        return "korisnici";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+imePrezime + "', '" + email + "', '" + sifra + "', " + mesto.getPtt() + ", '" + adresa + "', " + uloga;
        
    }

    @Override
    public List<AbstractDomainObject> napuni(ResultSet rs, AbstractDomainObject odo) throws Exception {
        List<AbstractDomainObject> lk = new ArrayList<>();
        while (rs.next()) {
            Korisnik k = new Korisnik();
            k.setKorisnikID(rs.getInt("korisnikID"));
            k.setImePrezime(rs.getString("imePrezime"));
            k.setEmail(rs.getString("email"));
            k.setSifra(rs.getString("sifra"));
            k.setAdresa(rs.getString("adresa"));
            k.setUloga(rs.getInt("korisnici.uloga"));
            k.setLastLogin(rs.getTimestamp("lastLogin"));
            
            Mesto m = new Mesto();
            m.setPtt(rs.getLong("ptt"));
            m.setNaziv(rs.getString("naziv"));
            k.setMesto(m);
            
            lk.add(k);
        }
        rs.close();
        return lk;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "imePrezime= '" + imePrezime + "', email= '" + email + "', sifra= '" + sifra + "', mesto= " + mesto.getPtt() + ", adresa= '" + adresa+ "', uloga= " + uloga;
    }

    @Override
    public String vratiNazivPK() {
        return "korisnikID";
    }

    @Override
    public String vratiVrednostPK() {
        return korisnikID+"";
    }

    @Override
    public void setPK(int sledeci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajUslovZaSelect(AbstractDomainObject odo) {
        return "LEFT JOIN mesta ON korisnici.mesto = mesta.ptt LEFT JOIN uloge ON korisnici.uloga = uloge.id";
    }

    @Override
    public String vratiRedosledZaInsert() {
        return "(imePrezime, email, sifra, mesto, adresa, uloga)";
    }

    @Override
    public void napuniJedanObjekat(ResultSet rs) {
        try {
            setImePrezime(rs.getString("imePrezime"));
            setEmail(rs.getString("email"));
            setSifra(rs.getString("sifra"));
            setAdresa(rs.getString("adresa"));
            setUloga(rs.getInt("uloga"));
            Mesto m = new Mesto();
            m.setPtt(rs.getLong("ptt"));
            m.setNaziv(rs.getString("naziv"));
            setMesto(m);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
    }

    
}
