package util;

/**
 *
 * @author Matija Veljkovic
 */
public interface Akcija {

    //0-9 POMOCNE
    public static final int KRAJ = 0;
    public static final int LOGIN = 1;
    public static final int LOGOUT = 2;
    public static final int REGISTRACIJA = 3;
    
    //10+ PREGLED SVIH
    public static final int VRATI_SVA_MESTA = 10;
    public static final int VRATI_SVE_TIPOVE = 11;
    public static final int VRATI_SVE_POSTOVE = 12;
    public static final int VRATI_SVE_KORISNIKE = 13;
    public static final int VRATI_SVE_LOKALE = 14;

    //20+ PRETRAGA PO KRITERIJUMU
//    public static final int PRETRAZI_PILOTE_PO_KRITERIJUMU = 20;
//    public static final int PRETRAZI_ZAPOSLENE_PO_KRITERIJUMU = 21;
//    public static final int PRETRAZI_MEHANICARE_PO_KRITERIJUMU = 22;
//    public static final int PRETRAZI_ULOGE_PO_KRITERIJUMU = 23;
//    public static final int PRETRAZI_LICENCE_PO_KRITERIJUMU = 24;

    //30+ INSERT
    public static final int NOVI_LOKALI = 30;
    public static final int NOVI_POSTOVI = 31;
//    public static final int NOVA_ULOGA = 32;
//    public static final int NOVA_LICENCA = 33;

    //40+ UPDATE
//    public static final int SACUVAJ_IZMENU_AVIONA = 40;
    public static final int SACUVAJ_IZMENU_LOKALA = 40;
    public static final int SACUVAJ_IZMENU_KORISNIKA = 41;
//    public static final int SACUVAJ_IZMENU_MEHANICARA = 43;
//    public static final int SACUVAJ_IZMENU_ULOGE = 44;
//    public static final int SACUVAJ_IZMENU_LICENCE = 45;

    //50+ DELETE
    public static final int BRISI_KORISNIKA = 50;
    public static final int BRISI_LOKAL = 51;
//    public static final int BRISI_MEHANICARA = 52;
//    public static final int BRISI_PILOTA = 53;
//    public static final int BRISI_ULOGU = 54;
//    public static final int BRISI_LICENCU = 55;
    
    
}