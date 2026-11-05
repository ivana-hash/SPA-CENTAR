package cordinator;

import domen.Radnik;
import forme.DodajKlijentaForm;
import forme.DodajKvalifikacijuForm;
import forme.DodajRadnikaForm;
import forme.DodajRezervacijuForm;
import forme.DodajStatusForm;
import forme.DodajTretmanForm;
import forme.FormaMod;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazKlijenataForm;
import forme.PrikazKvalifikacijaForm;
import forme.PrikazRadnikaForm;
import forme.PrikazRezervacijaForm;
import forme.PrikazStatusaForm;
import forme.PrikazTretmanaForm;
import java.util.HashMap;
import java.util.Map;
import kontroleri.DodajKlijentaController;
import kontroleri.DodajKvalifikacijuController;
import kontroleri.DodajRadnikaController;
import kontroleri.DodajRezervacijuController;
import kontroleri.DodajStatusController;
import kontroleri.DodajTretmanController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;
import kontroleri.PrikazKlijenataController;
import kontroleri.PrikazKvalifikacijaController;
import kontroleri.PrikazRadnikaController;
import kontroleri.PrikazRezervacijaController;
import kontroleri.PrikazStatusaController;
import kontroleri.PrikazTretmanaController;

public class Cordinator {

    private static Cordinator instanca;

    private Radnik ulogovani;
    private final Map<String, Object> parametri = new HashMap<>();

    private GlavnaForma glavnaForma;
    private GlavnaFormaController glavnaController;

    private PrikazKlijenataController klijentiController;
    private PrikazStatusaController statusiController;
    private PrikazTretmanaController tretmaniController;
    private PrikazKvalifikacijaController kvalifikacijeController;
    private PrikazRadnikaController radniciController;
    private PrikazRezervacijaController rezervacijeController;

    private Cordinator() {
    }

    public static Cordinator getInstanca() {
        if (instanca == null) {
            instanca = new Cordinator();
        }
        return instanca;
    }

    public void dodajParam(String kljuc, Object vrednost) {
        parametri.put(kljuc, vrednost);
    }

    public Object vratiParam(String kljuc) {
        return parametri.get(kljuc);
    }

    public Radnik getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Radnik ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void otvoriLoginFormu() {
        new LoginController(new LoginForma()).otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        if (glavnaForma == null) {
            glavnaForma = new GlavnaForma();
            glavnaController = new GlavnaFormaController(glavnaForma);
        }
        glavnaController.otvoriFormu();
    }

    public void otvoriPrikazKlijenataFormu() throws Exception {
        klijentiController = new PrikazKlijenataController(new PrikazKlijenataForm());
        klijentiController.otvoriFormu();
    }

    public void otvoriDodajKlijentaFormu() {
        new DodajKlijentaController(new DodajKlijentaForm()).otvoriFormu(FormaMod.DODAJ);
    }

    public void otvoriIzmeniKlijentaFormu() {
        new DodajKlijentaController(new DodajKlijentaForm()).otvoriFormu(FormaMod.IZMENI);
    }

    public void otvoriPrikazStatusaFormu() throws Exception {
        statusiController = new PrikazStatusaController(new PrikazStatusaForm());
        statusiController.otvoriFormu();
    }

    public void otvoriDodajStatusFormu() {
        new DodajStatusController(new DodajStatusForm()).otvoriFormu(FormaMod.DODAJ);
    }

    public void otvoriIzmeniStatusFormu() {
        new DodajStatusController(new DodajStatusForm()).otvoriFormu(FormaMod.IZMENI);
    }

    public void otvoriPrikazTretmanaFormu() throws Exception {
        tretmaniController = new PrikazTretmanaController(new PrikazTretmanaForm());
        tretmaniController.otvoriFormu();
    }

    public void otvoriDodajTretmanFormu() {
        new DodajTretmanController(new DodajTretmanForm()).otvoriFormu(FormaMod.DODAJ);
    }

    public void otvoriIzmeniTretmanFormu() {
        new DodajTretmanController(new DodajTretmanForm()).otvoriFormu(FormaMod.IZMENI);
    }

    public void otvoriPrikazKvalifikacijaFormu() throws Exception {
        kvalifikacijeController = new PrikazKvalifikacijaController(new PrikazKvalifikacijaForm());
        kvalifikacijeController.otvoriFormu();
    }

    public void otvoriDodajKvalifikacijuFormu() {
        new DodajKvalifikacijuController(new DodajKvalifikacijuForm()).otvoriFormu(FormaMod.DODAJ);
    }

    public void otvoriIzmeniKvalifikacijuFormu() {
        new DodajKvalifikacijuController(new DodajKvalifikacijuForm()).otvoriFormu(FormaMod.IZMENI);
    }

    public void otvoriPrikazRadnikaFormu() throws Exception {
        radniciController = new PrikazRadnikaController(new PrikazRadnikaForm());
        radniciController.otvoriFormu();
    }

    public void otvoriDodajRadnikaFormu() {
        new DodajRadnikaController(new DodajRadnikaForm()).otvoriFormu(FormaMod.DODAJ);
    }

    public void otvoriIzmeniRadnikaFormu() {
        new DodajRadnikaController(new DodajRadnikaForm()).otvoriFormu(FormaMod.IZMENI);
    }

    public void otvoriPrikazRezervacijaFormu() throws Exception {
        rezervacijeController = new PrikazRezervacijaController(new PrikazRezervacijaForm());
        rezervacijeController.otvoriFormu();
    }

    public void otvoriDodajRezervacijuFormu() {
        new DodajRezervacijuController(new DodajRezervacijuForm()).otvoriFormu(FormaMod.DODAJ);
        
    }

    public void otvoriIzmeniRezervacijuFormu() {
        new DodajRezervacijuController(new DodajRezervacijuForm()).otvoriFormu(FormaMod.IZMENI);
    }

  
    public void osveziFormuKlijenti() throws Exception {
        klijentiController.osveziFormu();
         }

    public void osveziFormuTretmani() throws Exception {
        tretmaniController.osveziFormu();
       }

    public void osveziFormuKvalifikacije() throws Exception {
        kvalifikacijeController.osveziFormu();
       }

    public void osveziFormuStatusi() throws Exception {
        statusiController.osveziFormu();
    }

    public void osveziFormuRezervacije() throws Exception {
        rezervacijeController.osveziFormu();
       }

    public void osveziFormuRadnici() throws Exception {
    radniciController.osveziFormu();
    }
}
