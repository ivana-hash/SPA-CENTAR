package kontroleri;

import cordinator.Cordinator;
import domen.Klijent;
import domen.Kvalifikacija;
import domen.Status;
import forme.DodajKvalifikacijuForm;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class DodajKvalifikacijuController {

    private final DodajKvalifikacijuForm forma;
    private FormaMod mod;
    
    
    public DodajKvalifikacijuController(DodajKvalifikacijuForm forma) {
        this.forma = forma;
        addActionListeners();
    }

     private void addActionListeners() {

        forma.addSacuvajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sacuvaj(e);
            }

            private void sacuvaj(ActionEvent e) {
        try {
            Kvalifikacija k = new Kvalifikacija();
            if (mod==FormaMod.IZMENI) k.setIdKvalifikacija(Integer.parseInt(forma.getTxtId().getText().trim()));
            k.setNaziv(forma.getTxtNaziv().getText().trim());
            k.setOpis(forma.getTxtOpis().getText().trim());

            if (mod==FormaMod.IZMENI) Komunikacija.getInstanca().azurirajKvalifikaciju(k);
            else Komunikacija.getInstanca().dodajKvalifikaciju(k);

            JOptionPane.showMessageDialog(forma,
                    (mod==FormaMod.IZMENI) ? "Kvalifikacija je uspešno izmenjena." : "Kvalifikacija je uspešno dodata.");
            Cordinator.getInstanca().osveziFormuKvalifikacije();
            forma.dispose();
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

            
        });



    } 

    
    public void otvoriFormu(FormaMod mod) {
        this.mod=mod;
        
        forma.getTxtId().setEnabled(false);
       

        if (mod == FormaMod.IZMENI) {
            Kvalifikacija k = (Kvalifikacija) Cordinator.getInstanca().vratiParam("kvalifikacija");
            if (k == null) {
                JOptionPane.showMessageDialog(forma, "Nije izabrana kvalifikacija.");
                return;
            }
            forma.getTxtId().setText(String.valueOf(k.getIdKvalifikacija()));
            forma.getTxtNaziv().setText(k.getNaziv());
            forma.getTxtOpis().setText(k.getOpis());
        }
        forma.setVisible(true);
    }

 
}
