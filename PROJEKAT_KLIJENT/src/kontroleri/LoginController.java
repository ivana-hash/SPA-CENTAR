package kontroleri;

import cordinator.Cordinator;
import domen.Radnik;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class LoginController {

    private final LoginForma forma;

    public LoginController(LoginForma forma) {
        this.forma = forma;
        addActionListeners();
    }
   
    
    private void addActionListeners() {
        
        forma.addLoginActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
                
            }
            
            private void prijava(ActionEvent e) {
                 String korisnickoIme = forma.getTxtKorisnickoIme().getText().trim();
                 String sifra = String.valueOf(forma.getTxtSifra().getPassword());

        if (korisnickoIme.isEmpty() || sifra.isEmpty()) {
            JOptionPane.showMessageDialog(forma, "Unesite korisničko ime i šifru.",
                    "Greška", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Komunikacija.getInstanca().konekcija();
            Radnik radnik = Komunikacija.getInstanca().login(korisnickoIme, sifra);

            if (radnik == null) {
                JOptionPane.showMessageDialog(forma, "Prijava na sistem nije uspešna.",
                        "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cordinator.getInstanca().setUlogovani(radnik);
            Cordinator.getInstanca().otvoriGlavnuFormu();
            forma.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, ex.getMessage(),
                    "Greška", JOptionPane.ERROR_MESSAGE);
        }
            }
        });
        
    }
    public void otvoriFormu() {
        forma.setVisible(true);
    }
}
