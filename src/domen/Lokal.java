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
public class Lokal implements Serializable, AbstractDomainObject{
    private String maticniBroj;

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    
    private int lokalID;
    private String email;
    private String naziv;
    private String sifra;
    private Mesto mesto;
    private String adresa;
    private TipLokala tip;
    private String brojTelefona;
    private boolean ulogovan;
    private Date lastLogin;
    

    public Lokal(int lokalID,String email, String naziv,String sifra, Mesto mesto, String adresa, TipLokala tip, String brojTelefona, boolean ulogovan) {
        this.lokalID = lokalID;
        this.email = email;
        this.naziv = naziv;
        this.sifra = sifra;
        this.mesto = mesto;
        this.adresa = adresa;
        this.tip = tip;
        this.brojTelefona = brojTelefona;
        this.ulogovan = ulogovan;
    }

    public Lokal() {
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setLokalID(int lokalID) {
        this.lokalID = lokalID;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSifra() {
        return sifra;
    }


    public String getNaziv() {
        return naziv;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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

    public TipLokala getTip() {
        return tip;
    }

    public void setTip(TipLokala tip) {
        this.tip = tip;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    @Override
    public String vratiNazivTabele() {
        return "lokali";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return lokalID+", '"+email + "', '" + naziv + "', '" + sifra + "', " + mesto.getPtt() + ", '" + adresa + "', " + tip.getTipID()+ ", '" + brojTelefona+"'";
        
    }

    @Override
    public List<AbstractDomainObject> napuni(ResultSet rs, AbstractDomainObject odo) throws Exception {
        List<AbstractDomainObject> lLok = new ArrayList<>();
        while (rs.next()) {
            Lokal l = new Lokal();
            l.setLokalID(rs.getInt("lokalID"));
            l.setEmail(rs.getString("email"));
            l.setNaziv(rs.getString("naziv"));
            l.setBrojTelefona(rs.getString("brojTelefona"));
            l.setSifra(rs.getString("sifra"));
            l.setAdresa(rs.getString("adresa"));
            l.setLastLogin(rs.getTimestamp("lastLogin"));
            
            Mesto m = new Mesto();
            m.setPtt(rs.getLong("ptt"));
            m.setNaziv(rs.getString("mesta.naziv"));
            l.setMesto(m);
            
            TipLokala tl = new TipLokala();
            tl.setTipID(rs.getInt("tipID"));
            tl.setNaziv(rs.getString("tipovilokala.naziv"));
            l.setTip(tl);
            
            lLok.add(l);
        }
        rs.close();
        return lLok;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "email= '" + email + "', naziv= '" + naziv + "', sifra= '" + sifra + "', mesto= " + mesto.getPtt() + ", adresa= '" + adresa+ "', tip= " + tip.getTipID()+ ", brojTelefona= '" + brojTelefona+"'";
    }

    @Override
    public String vratiNazivPK() {
        return "lokalID";
    }

    @Override
    public String vratiVrednostPK() {
        return lokalID+"";
    }

    @Override
    public void setPK(int sledeci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajUslovZaSelect(AbstractDomainObject odo) {
        return "LEFT JOIN mesta ON lokali.mesto = mesta.ptt LEFT JOIN tipovilokala ON lokali.tip = tipovilokala.tipID";
    }

    @Override
    public String vratiRedosledZaInsert() {
        return "(lokalID, email, naziv, sifra, mesto, adresa, tip, brojTelefona)";
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void napuniJedanObjekat(ResultSet rs) {
        try {
            setLokalID(rs.getInt("lokalID"));
            setEmail(rs.getString("email"));
            setNaziv(rs.getString("lokali.naziv"));
            setBrojTelefona(rs.getString("brojTelefona"));
            setSifra(rs.getString("sifra"));
            setAdresa(rs.getString("adresa"));
            
            Mesto m = new Mesto();
            m.setPtt(rs.getLong("ptt"));
            m.setNaziv(rs.getString("mesta.naziv"));
            setMesto(m);
            
            TipLokala tl = new TipLokala();
            tl.setTipID(rs.getInt("tipID"));
            tl.setNaziv(rs.getString("tipovilokala.naziv"));
            setTip(tl);
            
        } catch (SQLException ex) {
            Logger.getLogger(Lokal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String ispisi() {
        return naziv;
    }

    public int getLokalID() {
        return lokalID;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
