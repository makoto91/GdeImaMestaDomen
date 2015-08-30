package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Matija Veljkovic
 */
public interface AbstractDomainObject {

    /**
     *
     * @return ime tabele u bazi koja odgovara objektu
     */
    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public List<AbstractDomainObject> napuni(ResultSet rs, AbstractDomainObject odo) throws Exception;

    public String vratiVrednostiZaUpdate();

    public String vratiNazivPK();

    public String vratiVrednostPK();

    public void setPK(int sledeci);

    public String dajUslovZaSelect(AbstractDomainObject odo);

    public String vratiRedosledZaInsert();
    
    public void napuniJedanObjekat(ResultSet rs);
    
    public String ispisi();
    
}
