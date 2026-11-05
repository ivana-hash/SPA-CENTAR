package kontroleri;

import cordinator.Cordinator;
import domen.Kvalifikacija;
import domen.Radnik;
import forme.DodajRadnikaForm;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class DodajRadnikaController {

    private final DodajRadnikaForm forma;
    private FormaMod mod;
    
    
    public DodajRadnikaController(DodajRadnikaForm forma) {
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
            Radnik r = new Radnik();
            if  (mod==FormaMod.IZMENI)  {
                r.setIdRadnik(Integer.parseInt(forma.getTxtId().getText().trim()));
            }

            r.setIme(forma.getTxtIme().getText().trim());
            r.setPrezime(forma.getTxtPrezime().getText().trim());
            
            try{
                String datumTekst=forma.getTxtDatumZaposlenja().getText().trim();
                SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
                Date datumZaposlenja=format.parse(datumTekst);
                r.setDatumZaposlenja(datumZaposlenja);
            }catch(ParseException pe){
                    JOptionPane.showMessageDialog(forma, "Pogrešan format datuma!","GREŠKA!", JOptionPane.ERROR_MESSAGE);
           return;
            }
           
            r.setPozicija(forma.getTxtPozicija().getText().trim());
            r.setKorisnickoIme(forma.getTxtKorisnickoIme().getText().trim());
            
            r.setSifra(String.valueOf(forma.getPffSifra().getPassword()));

            if (mod==FormaMod.IZMENI) {
                Komunikacija.getInstanca().azurirajRadnika(r);
                JOptionPane.showMessageDialog(forma, "Radnik je uspešno izmenjen.");
            } else {
                int id = Komunikacija.getInstanca().dodajRadnika(r);
                JOptionPane.showMessageDialog(
                        forma, "Radnik je uspešno dodat. ID=" + id
                );
            }
 Cordinator.getInstanca().osveziFormuRadnici();
            forma.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE
            );
        }
    
 }

            
        });



    } 
    
    public void otvoriFormu(FormaMod mod) {
        this.mod=mod;
        try {
            forma.getTxtId().setEnabled(false);
           

            if (mod == FormaMod.DODAJ) {
                //isprazniPolja();
            } else {
                Radnik r = (Radnik) Cordinator.getInstanca().vratiParam("radnik");
                if (r == null) {
                    throw new Exception("Nije izabran radnik.");
                }

                forma.getTxtId().setText(String.valueOf(r.getIdRadnik()));
                forma.getTxtIme().setText(r.getIme());
                forma.getTxtPrezime().setText(r.getPrezime());
                Date datumZaposlenja=r.getDatumZaposlenja();
                SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
                String datumTekst=format.format(datumZaposlenja);
                forma.getTxtDatumZaposlenja().setText(datumTekst);
                forma.getTxtPozicija().setText(r.getPozicija());
                forma.getTxtKorisnickoIme().setText(r.getKorisnickoIme());
                forma.getPffSifra().setText(r.getSifra());
            }

            forma.setLocationRelativeTo(null);
            forma.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE
            );
            forma.dispose();
        }
    }

 
}
