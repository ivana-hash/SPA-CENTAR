package kontroleri;

import cordinator.Cordinator;
import domen.Status;
import domen.Tretman;
import forme.DodajTretmanForm;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class DodajTretmanController {

    private final DodajTretmanForm forma;
    private FormaMod mod;
    
    public DodajTretmanController(DodajTretmanForm forma) {
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
            Tretman t = new Tretman();
            if (mod==FormaMod.IZMENI) t.setIdTretman(Integer.parseInt(forma.getTxtId().getText().trim()));
            t.setNaziv(forma.getTxtNaziv().getText().trim());
            t.setCena(Double.parseDouble(forma.getTxtCena().getText().trim()));
            t.setTrajanjeUMin(Integer.parseInt(forma.getTxtTrajanje().getText().trim()));
            t.setBenefitiTretmana(forma.getTxtBenefiti().getText().trim());

            if (mod==FormaMod.IZMENI)  Komunikacija.getInstanca().azurirajTretman(t);
            else Komunikacija.getInstanca().dodajTretman(t);

            JOptionPane.showMessageDialog(forma,
                    (mod==FormaMod.IZMENI) ? "Tretman je uspešno izmenjen." : "Tretman je uspešno dodat.");
           Cordinator.getInstanca().osveziFormuTretmani();
            forma.dispose();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    

                     
            }   });

        

    
                }
    
                
    public void otvoriFormu(FormaMod mod) {
        this.mod=mod;
        forma.getTxtId().setEnabled(false);
     
        if (mod == FormaMod.IZMENI) {
            Tretman t = (Tretman) Cordinator.getInstanca().vratiParam("tretman");
            if (t == null) {
                JOptionPane.showMessageDialog(forma, "Nije izabran tretman.");
                return;
            }
            forma.getTxtId().setText(String.valueOf(t.getIdTretman()));
            forma.getTxtNaziv().setText(t.getNaziv());
            forma.getTxtCena().setText(String.valueOf(t.getCena()));
            forma.getTxtTrajanje().setText(String.valueOf(t.getTrajanjeUMin()));
            forma.getTxtBenefiti().setText(t.getBenefitiTretmana());
        }
        forma.setVisible(true);
    }

 
}
