/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Kvalifikacija;
import domen.Radnik;
import domen.RadnikKvalifikacija;
import forme.KvalifikacijeRadnikaForma;
import forme.model.ModelTabeleRadnikKvalifikacija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author HomePC
 */
public class KvalifikacijeRadnikaController {
    
    private KvalifikacijeRadnikaForma forma;
    private Radnik radnik;
    
    
      public KvalifikacijeRadnikaController(KvalifikacijeRadnikaForma forma) {
        this.forma = forma;
        addActionListeners();
    }
  private void addActionListeners() {

        forma.addDodajKvalifikaciju(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kvalifikacija k = (Kvalifikacija) forma.getCmbKvalifikacije().getSelectedItem();
                Date datum = forma.getjDateChooserDatumPostizanja().getDate();

                if (k == null) {
                    JOptionPane.showMessageDialog(forma, "Izaberite kvalifikaciju.", "NEUSPEŠNO!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(datum==null){
                    JOptionPane.showMessageDialog(forma, "Izaberite datum.", "NEUSPEŠNO!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if ( datum.after(new Date())) {
                    JOptionPane.showMessageDialog(forma, "Datum postizanja kvalifikacije ne može biti u budućnosti.", "NEUSPEŠNO!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for (RadnikKvalifikacija rk : model().getLista()) {
                    if (rk.getKvalifikacija().getIdKvalifikacija() == k.getIdKvalifikacija()) {
                        JOptionPane.showMessageDialog(forma, "Radnik već ima tu kvalifikaciju.", "NEUSPEŠNO", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }

                model().dodaj(new RadnikKvalifikacija(radnik, k, datum));
                forma.getCmbKvalifikacije().setSelectedItem(null);
                forma.getjDateChooserDatumPostizanja().setDate(null);
            }
        });
    
         forma.addUkloniKvalifikacijuListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = forma.getTabela().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(forma, "Izaberite kvalifikaciju za uklanjanje.", "NEUSPEŠNO", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                model().obrisi(red);
            }
        });

          forma.addSacuvajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    radnik.setKvalifikacije(new ArrayList<>(model().getLista()));
                    Komunikacija.getInstanca().azurirajRadnika(radnik);

                    JOptionPane.showMessageDialog(forma,
                            "Sistem je zapamtio kvalifikacije radnika.", "USPEŠNO!", JOptionPane.INFORMATION_MESSAGE);

                    Cordinator.getInstanca().osveziFormuRadnici();
                    forma.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(forma,
                            "Sistem ne može da zapamti kvalifikacije radnika.\nRazlog: " + ex.getMessage(),
                            "GREŠKA!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    
    public void otvoriFormu() {
        try {
            radnik = (Radnik) Cordinator.getInstanca().vratiParam("radnik");
            if (radnik == null) {
                throw new Exception("Nije izabran radnik.");
            }

            forma.getLblIzabrani().setText(radnik.getIme() + " " + radnik.getPrezime());

            forma.getCmbKvalifikacije().removeAllItems();
            for (Kvalifikacija k : Komunikacija.getInstanca().ucitajKvalifikacije()) {
                forma.getCmbKvalifikacije().addItem(k);
            }
            forma.getCmbKvalifikacije().setSelectedItem(null);
            forma.getjDateChooserDatumPostizanja().setDate(null);

            forma.getTabela().setModel(new ModelTabeleRadnikKvalifikacija(
                    new ArrayList<>(radnik.getKvalifikacije())));

            forma.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            forma.dispose();
        }
    }

    private ModelTabeleRadnikKvalifikacija model() {
        return (ModelTabeleRadnikKvalifikacija) forma.getTabela().getModel();
    }
}
