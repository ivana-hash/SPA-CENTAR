package kontroleri;

import cordinator.Cordinator;
import domen.Klijent;
import domen.Radnik;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import domen.Tretman;
import forme.DodajRezervacijuForm;
import forme.FormaMod;
import forme.model.ModelTabeleStavkaRezervacije;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class DodajRezervacijuController {

    private final DodajRezervacijuForm forma;
    private Radnik radnikRezervacije;
    private FormaMod mod;

    public DodajRezervacijuController(DodajRezervacijuForm forma) {
        this.forma = forma;
        addActionListeners();
        
    }
private void addActionListeners() {

        forma.addDodajStavkuListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajStavku(e);
            }

            private void dodajStavku(ActionEvent e) {
              try {
            Tretman tretman = (Tretman) forma.getCmbTretman().getSelectedItem();
            if (tretman == null) throw new Exception("Morate izabrati tretman.");

            for (StavkaRezervacije postojeca : modelStavki().getLista()) {
                if (postojeca.getTretman().getIdTretman() == tretman.getIdTretman()) {
                    throw new Exception("Izabrani tretman već postoji u rezervaciji.");
                }
            }

            double cena = Double.parseDouble(forma.getTxtCena().getText().trim());
           
            try{
             int brojPaketa = Integer.parseInt(forma.getTxtBrojPaketa().getText().trim());
            
            StavkaRezervacije s = new StavkaRezervacije();
            s.setTretman(tretman);
            s.setCena(cena);
            s.setBrojPaketaTretmana(brojPaketa);
            s.setIznosStavke(cena * brojPaketa);
            
            modelStavki().dodaj(s);
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(forma, "Broj paketa mora biti ceo broj!", "GRESKA!", JOptionPane.WARNING_MESSAGE);
            }
            forma.getTxtBrojPaketa().setText("");
            forma.getCmbTretman().setSelectedItem(null);
            forma.getTxtCena().setText("");
            osveziUkupanIznos();
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
              
    }

            
        });
  
        
        forma.addObrisiStavkuListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiStavku(e);
            }

            private void obrisiStavku(ActionEvent e) {
        int red = forma.getTblStavke().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Izaberite stavku za uklanjanje.");
            return;
        }
        modelStavki().obrisi(red);
        osveziUkupanIznos();
    }

            
        });
        
        
             forma.addSacuvajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacuvaj(e);
            }

            private void sacuvaj(ActionEvent e) {
           try {
            if (modelStavki().getLista().isEmpty()) {
                if(mod==FormaMod.DODAJ)
                JOptionPane.showMessageDialog(forma, "Sistem ne može da kreira rezervaciju.","Rezervacija mora imati bar jednu stavku!", JOptionPane.ERROR_MESSAGE);
           else
                 JOptionPane.showMessageDialog(forma, "Sistem ne može da kreira rezervaciju.","Rezervacija mora imati bar jednu stavku!", JOptionPane.ERROR_MESSAGE);
              
                return;}
                if (forma.getCmbKlijent().getSelectedItem()==null) {
                JOptionPane.showMessageDialog(forma, "Sistem ne može da zapamti rezervaciju.","GREŠKA!", JOptionPane.ERROR_MESSAGE);
            return;}
            Rezervacija r = new Rezervacija();
            if (mod==FormaMod.IZMENI){ 
                r.setIdRezervacija(Integer.parseInt(forma.getTxtId().getText().trim()));
                try{
                String tekstDatum=forma.getTxtDatumKreiranja().getText().trim();
                SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
                Date datumKreiranja=format.parse(tekstDatum);
                r.setDatumKreiranja(datumKreiranja);
                }catch(ParseException pe){
                  JOptionPane.showMessageDialog(forma, "Pogrešan format datuma!","GREŠKA!", JOptionPane.ERROR_MESSAGE);
            return;  
                }
            
            
            }else{
            r.setDatumKreiranja(new Date());}
            r.setRadnik(radnikRezervacije);
            r.setKlijent((Klijent) forma.getCmbKlijent().getSelectedItem());
            r.setStavke(new ArrayList<>(modelStavki().getLista()));
            r.setUkupanIznos(modelStavki().izracunajUkupanIznos());

            if (mod==FormaMod.IZMENI)  {
                Komunikacija.getInstanca().azurirajRezervaciju(r);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio rezervaciju.");
            } else {
                int id = Komunikacija.getInstanca().dodajRezervaciju(r);
                JOptionPane.showMessageDialog(forma, "Sistem je zapamtio rezervaciju. ID=" + id);
            }

            forma.dispose();
            Cordinator.getInstanca().osveziFormuRezervacije();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, "Sistem ne može da zapamti rezervaciju.", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

            
        });
             forma.getCmbTretman().addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        Tretman izabraniTretman =
                (Tretman) forma.getCmbTretman().getSelectedItem();

        if (izabraniTretman != null) {
            forma.getTxtCena().setText(
                    String.valueOf(izabraniTretman.getCena())
            );
        } else {
            forma.getTxtCena().setText("");
        }
    }
});


    } 
    
    
    

 
    public void otvoriFormu(FormaMod mod) {
        this.mod=mod;
        try {
            forma.getTblStavke().setModel(new ModelTabeleStavkaRezervacije(new ArrayList<>()));
            popuniKlijente();
            popuniTretmane();

            forma.getTxtId().setEnabled(false);
            forma.getTxtRadnik().setEnabled(false);
            forma.getTxtCena().setEnabled(false);
            forma.getTxtCena().setText("");
            if (mod == FormaMod.DODAJ) {
                radnikRezervacije = Cordinator.getInstanca().getUlogovani();
                if (radnikRezervacije == null) throw new Exception("Nije prijavljen radnik.");
                forma.getTxtRadnik().setText(radnikRezervacije.toString());
                Date danasnjiDatum=new Date();
                SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
                String datumtekst=format.format(danasnjiDatum);
                forma.getTxtDatumKreiranja().setText(datumtekst);
               
                forma.getTxtDatumKreiranja().setEnabled(false);
                forma.getTxtUkupanIznos().setText("0.0");
                forma.getCmbKlijent().setSelectedItem(null);
                
            } else {
                Rezervacija r = (Rezervacija) Cordinator.getInstanca().vratiParam("rezervacija");
                if (r == null) throw new Exception("Nije izabrana rezervacija.");

                radnikRezervacije = r.getRadnik();
                forma.getTxtId().setText(String.valueOf(r.getIdRezervacija()));
                Date datumKreiranja=r.getDatumKreiranja();
                SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
                String datumtekst=format.format(datumKreiranja);
                forma.getTxtDatumKreiranja().setText(datumtekst);
                
               // forma.getTxtDatumKreiranja().setText(KontrolerUtils.formatirajDatum(r.getDatumKreiranja()));
                forma.getTxtRadnik().setText(radnikRezervacije != null ? radnikRezervacije.toString() : "");
                forma.getCmbKlijent().setSelectedItem(r.getKlijent());
                modelStavki().setLista(r.getStavke() != null
                        ? new ArrayList<>(r.getStavke()) : new ArrayList<>());
                osveziUkupanIznos();
            }

            forma.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            forma.dispose();
        }
    }

    private void popuniKlijente() throws Exception {
        forma.getCmbKlijent().removeAllItems();
        List<Klijent> lista = Komunikacija.getInstanca().ucitajKlijente();
        for (Klijent k : lista) forma.getCmbKlijent().addItem(k);
    }

    private void popuniTretmane() throws Exception {
        forma.getCmbTretman().removeAllItems();
        List<Tretman> lista = Komunikacija.getInstanca().ucitajTretmane();
        for (Tretman t : lista) forma.getCmbTretman().addItem(t);
        forma.getCmbTretman().setSelectedItem(null);
    }


 
    private void osveziUkupanIznos() {
        forma.getTxtUkupanIznos().setText(String.valueOf(modelStavki().izracunajUkupanIznos()));
    }

    private ModelTabeleStavkaRezervacije modelStavki() {
        return (ModelTabeleStavkaRezervacije) forma.getTblStavke().getModel();
    }
}
