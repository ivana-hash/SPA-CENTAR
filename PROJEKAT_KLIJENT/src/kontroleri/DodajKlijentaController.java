package kontroleri;

import cordinator.Cordinator;
import domen.Klijent;
import domen.Status;
import forme.DodajKlijentaForm;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class DodajKlijentaController {

    private final DodajKlijentaForm forma;
    private FormaMod mod;
    private  List<Status> statusi;
    public DodajKlijentaController(DodajKlijentaForm forma) {
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
            Klijent k = new Klijent();
           if (mod==FormaMod.IZMENI)
            k.setIdKlijent(Integer.parseInt(forma.getTxtId().getText().trim()));
            k.setIme(forma.getTxtIme().getText().trim());
            k.setPrezime(forma.getTxtPrezime().getText().trim());
            k.setEmailAdresa(forma.getTxtEmail().getText().trim());
            k.setKontaktTelefon(forma.getTxtTelefon().getText().trim());
            k.setStatus((Status) forma.getCmbStatus().getSelectedItem());

            if (mod==FormaMod.IZMENI) 
                Komunikacija.getInstanca().azurirajKlijenta(k);
            else Komunikacija.getInstanca().dodajKlijenta(k);

            JOptionPane.showMessageDialog(forma,
                    (mod==FormaMod.IZMENI) ? "Sistem je zapamtio kliejnta." :
                    "Sistem je kreirao klijenta.");
            Cordinator.getInstanca().osveziFormuKlijenti();
            forma.dispose();
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

            
        });
     
    } 
    

    
    
    public void otvoriFormu(FormaMod mod) {
        this.mod=mod;
        try {
            popuniStatuse();
            forma.getTxtId().setEnabled(false);
          

            if (mod == FormaMod.IZMENI) {
                Klijent k = (Klijent) Cordinator.getInstanca().vratiParam("klijent");
                if (k == null) throw new Exception("Nije izabran klijent.");
                forma.getTxtId().setText(String.valueOf(k.getIdKlijent()));
                forma.getTxtIme().setText(k.getIme());
                forma.getTxtPrezime().setText(k.getPrezime());
                forma.getTxtEmail().setText(k.getEmailAdresa());
                forma.getTxtTelefon().setText(k.getKontaktTelefon());
                forma.getCmbStatus().setSelectedItem(k.getStatus());
              
            }

            forma.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            forma.dispose();
        }
    }

    private void popuniStatuse() throws Exception {
        forma.getCmbStatus().removeAllItems();
       statusi = Komunikacija.getInstanca().ucitajStatuse();
        for (Status s : statusi) forma.getCmbStatus().addItem(s);
    }

  
       
         
        
}
