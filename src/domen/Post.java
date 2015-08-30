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
public class Post implements Serializable, AbstractDomainObject {

    private int postID;
    private Lokal lokal;
    private int stoloviZaDvoje;
    private int stoloviZaCetvoro;
    private int separe;
    private String prateciTekst;
    private Date vreme;
    

    public Post(int postID, int stoloviZaDvoje, int stoloviZaCetvoro, int separei, String prateciTekst, Date vreme, Lokal lokal) {
        this.postID = postID;
        this.stoloviZaDvoje = stoloviZaDvoje;
        this.stoloviZaCetvoro = stoloviZaCetvoro;
        this.separe = separei;
        this.prateciTekst = prateciTekst;
        this.vreme = vreme;
        this.lokal = lokal;
    }

    public Post() {
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setLokal(Lokal lokal) {
        this.lokal = lokal;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setStoloviZaDvoje(int stoloviZaDvoje) {
        this.stoloviZaDvoje = stoloviZaDvoje;
    }

    public void setStoloviZaCetvoro(int stoloviZaCetvoro) {
        this.stoloviZaCetvoro = stoloviZaCetvoro;
    }

    public void setSepare(int separe) {
        this.separe = separe;
    }

    public void setPrateciTekst(String prateciTekst) {
        this.prateciTekst = prateciTekst;
    }

    public int getStoloviZaDvoje() {
        return stoloviZaDvoje;
    }

    public int getStoloviZaCetvoro() {
        return stoloviZaCetvoro;
    }

    public int getSepare() {
        return separe;
    }

    public String getPrateciTekst() {
        return prateciTekst;
    }

    @Override
    public String vratiNazivTabele() {
        return "postovi";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+ postID + "', '" + lokal.getLokalID() + "', '" + stoloviZaDvoje + "', '" + stoloviZaCetvoro + "', '" + separe + "', '" + prateciTekst + "', NOW()";

    }

    @Override
    public List<AbstractDomainObject> napuni(ResultSet rs, AbstractDomainObject odo) throws Exception {
        List<AbstractDomainObject> lp = new ArrayList<>();
        while (rs.next()) {
            Post p = new Post();
            p.setStoloviZaDvoje(rs.getInt("stoloviZaDvoje"));
            p.setStoloviZaCetvoro(rs.getInt("stoloviZaCetvoro"));
            p.setSepare(rs.getInt("separei"));

            p.setPrateciTekst(rs.getString("prateciTekst"));
            p.setVreme(rs.getTimestamp("vreme"));

            Lokal l = new Lokal();
            l.napuniJedanObjekat(rs);
            p.setLokal(l);

            lp.add(p);
        }
        rs.close();
        return lp;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "lokalID= '" + lokal.getLokalID() + "', stoloviZaDvoje= " + stoloviZaDvoje + ", stoloviZaCetvoro= " + stoloviZaCetvoro + ", separei= " + separe + ", prateciTekst= " + prateciTekst + ", vreme= " + vreme;
    }

    @Override
    public String vratiNazivPK() {
        return "postID";
    }

    @Override
    public String vratiVrednostPK() {
        return postID + "";
    }

    @Override
    public void setPK(int sledeci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajUslovZaSelect(AbstractDomainObject odo) {
        return "LEFT JOIN lokali ON postovi.lokalID = lokali.lokalID LEFT JOIN mesta ON lokali.mesto = mesta.ptt LEFT JOIN tipovilokala ON lokali.tip = tipovilokala.tipID";
    }

    @Override
    public String vratiRedosledZaInsert() {
        return "(postID, lokalID, stoloviZaDvoje, stoloviZaCetvoro, separei, prateciTekst, vreme)";
    }

    @Override
    public void napuniJedanObjekat(ResultSet rs) {
//        try {
//            setImePrezime(rs.getString("imePrezime"));
//            setEmail(rs.getString("email"));
//            setSifra(rs.getString("sifra"));
//            setAdresa(rs.getString("adresa"));
//
//            Mesto m = new Mesto();
//            m.setPtt(rs.getLong("ptt"));
//            m.setNaziv(rs.getString("naziv"));
//            setMesto(m);
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @Override
    public String ispisi() {
        throw new UnsupportedOperationException("Not supported majku mu."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Vreme=" + vreme + " Stolovi za dvoje: " + stoloviZaDvoje + "/n StoloviZaCetvoro=" + stoloviZaCetvoro + ", separe=" + separe + ", prateciTekst=" + prateciTekst;
    }

    public Lokal getLokal() {
        return lokal;
    }

    

}
