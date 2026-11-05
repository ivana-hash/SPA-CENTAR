package kontroleri;

import cordinator.Cordinator;
import domen.Klijent;
import domen.Radnik;
import domen.Rezervacija;
import domen.Tretman;
import forme.PrikazRezervacijaForm;
import forme.model.ModelTabeleRezervacija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class PrikazRezervacijaController {

    private final PrikazRezervacijaForm forma;

    public PrikazRezervacijaController(PrikazRezervacijaForm forma) {
        this.forma = forma;
       addActionListeners();
    }

    
     private void addActionListeners() {
         forma.addDodajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(forma,"Sistem je kreirao rezervaciju.", "USPEH",JOptionPane.INFORMATION_MESSAGE);
               
            Cordinator.getInstanca().otvoriDodajRezervacijuFormu();
               
            }
            
        });
         
         
          forma.addIzmeniListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

       Rezervacija r = izabrana(); if (r == null) return;
        Cordinator.getInstanca().dodajParam("rezervacija", r);
        Cordinator.getInstanca().otvoriIzmeniRezervacijuFormu();
            }

        });
           forma.addObrisiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

      Rezervacija r = izabrana(); if (r == null) return;
        if (JOptionPane.showConfirmDialog(forma, "Obrisati rezervaciju?", "Potvrda",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try { Komunikacija.getInstanca().obrisiRezervaciju(r); osveziFormu(); }
        catch (Exception ex) { greska(ex); }
            }

        });
              forma.addPretraziListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String kriterijumPretrage = forma.getTxtPretraga().getText().trim();
                Radnik izabraniRadnik=(Radnik) forma.getCmbRadnik().getSelectedItem();
                Klijent izabraniKlijent=(Klijent) forma.getCmbKlijent().getSelectedItem();
                Tretman izabraniTretman=(Tretman) forma.getCmbTretman().getSelectedItem();
                        
                if((kriterijumPretrage=="" || kriterijumPretrage.isEmpty()) && izabraniKlijent==null && izabraniRadnik==null && izabraniTretman==null){
                    JOptionPane.showMessageDialog(forma, "Niste uneli nijedan kriterijum pretrage!", "PRETRAGA NIJE MOGUĆA", JOptionPane.WARNING_MESSAGE);
              return;
                }
                ModelTabeleRezervacija mtr = (ModelTabeleRezervacija) forma.getTabela().getModel();
                mtr.pretrazi(kriterijumPretrage,izabraniKlijent,izabraniRadnik,izabraniTretman);
                if (mtr.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(forma, "Sistem ne može da nađe rezervacije po zadatim kriterijumima.", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(forma, "Sistem je našao rezervacije po zadatim kriterijumima.", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
             
                }
            }

        });
              
                    forma.addOsveziListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    osveziFormu();
                } catch (Exception ex) {
                    greska(ex);
                     }
               
                
            }

        });
        
    }

    public void otvoriFormu() throws Exception {
         pripremiFormu();  
         popuniComboBoxeve();
        forma.setVisible(true); 
    }

    public void osveziFormu() throws Exception {
        pripremiFormu();
        forma.getTxtPretraga().setText("");
        forma.getCmbKlijent().setSelectedItem(null);
         forma.getCmbTretman().setSelectedItem(null);
          forma.getCmbRadnik().setSelectedItem(null);
    }

    private Rezervacija izabrana() {
        int red = forma.getTabela().getSelectedRow();
        if (red == -1) { JOptionPane.showMessageDialog(forma, "Sistem ne može da nađe rezervaciju.", "Izaberite rezervaciju!", JOptionPane.ERROR_MESSAGE);  
        return null;}else{
         JOptionPane.showMessageDialog(forma, "Sistem je našao rezervaciju.", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
             
        }
        return ((ModelTabeleRezervacija) forma.getTabela().getModel()).get(red);
    }
    private void greska(Exception ex) {
        JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
    }

    private void pripremiFormu() throws Exception {
        List<Rezervacija>rezervacije=Komunikacija.getInstanca().ucitajRezervacije();
        ModelTabeleRezervacija mtr=new ModelTabeleRezervacija(rezervacije);
        forma.getTabela().setModel(mtr);
       }

    private void popuniComboBoxeve() throws Exception {
         forma.getCmbKlijent().removeAllItems();
        List<Klijent> klijenti = Komunikacija.getInstanca().ucitajKlijente();
        for (Klijent k : klijenti) forma.getCmbKlijent().addItem(k);
        forma.getCmbKlijent().setSelectedItem(null);
        
         forma.getCmbTretman().removeAllItems();
        List<Tretman> tretmani= Komunikacija.getInstanca().ucitajTretmane();
        for (Tretman t : tretmani) forma.getCmbTretman().addItem(t);
       forma.getCmbTretman().setSelectedItem(null);
        
        forma.getCmbRadnik().removeAllItems();
       List<Radnik> radnici = Komunikacija.getInstanca().ucitajRadnike();
        for (Radnik r: radnici) forma.getCmbRadnik().addItem(r);
        forma.getCmbRadnik().setSelectedItem(null);
       }
    
}
