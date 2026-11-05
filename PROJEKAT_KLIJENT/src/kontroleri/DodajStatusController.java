package kontroleri;

import cordinator.Cordinator;
import domen.Klijent;
import domen.Status;
import forme.DodajStatusForm;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class DodajStatusController {

    private final DodajStatusForm forma;
      private FormaMod mod;
      
    public DodajStatusController(DodajStatusForm forma) {
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
            Status s = new Status();
            if (mod==FormaMod.IZMENI) s.setIdStatus(Integer.parseInt(forma.getTxtId().getText().trim()));
            s.setNaziv(forma.getTxtNaziv().getText().trim());
            
            try{
                String tekstDatum=forma.getTxtDatumPostizanja().getText().trim();
                SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
                
                Date datum=format.parse(tekstDatum);
                s.setDatumPostizanja(datum);
            }  catch(ParseException pe){
                JOptionPane.showMessageDialog(forma, "Pogrešan format datuma!","GREŠKA!", JOptionPane.ERROR_MESSAGE);
            return;
            } 
            s.setPogodnosti(forma.getTxtPogodnosti().getText().trim());

            if (mod==FormaMod.IZMENI) Komunikacija.getInstanca().azurirajStatus(s);
            else Komunikacija.getInstanca().dodajStatus(s);

            JOptionPane.showMessageDialog(forma,
                    (mod==FormaMod.IZMENI) ? "Status je uspešno izmenjen." : "Status je uspešno dodat.");
           Cordinator.getInstanca().osveziFormuStatusi();
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
            Status s = (Status) Cordinator.getInstanca().vratiParam("status");
            if (s == null) {
                JOptionPane.showMessageDialog(forma, "Nije izabran status.");
                return;
            }
            forma.getTxtId().setText(String.valueOf(s.getIdStatus()));
            forma.getTxtNaziv().setText(s.getNaziv());
            Date datumPostizanja=s.getDatumPostizanja();
            SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
            String datumTekst=format.format(datumPostizanja);
            forma.getTxtDatumPostizanja().setText(datumTekst);
            forma.getTxtPogodnosti().setText(s.getPogodnosti());
        }
        forma.setVisible(true);
    }

}
