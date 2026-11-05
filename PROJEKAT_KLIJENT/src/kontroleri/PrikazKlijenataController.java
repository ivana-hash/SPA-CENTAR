package kontroleri;

import cordinator.Cordinator;
import domen.Klijent;
import domen.Status;
import forme.PrikazKlijenataForm;
import forme.model.ModelTabeleKlijent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class PrikazKlijenataController {

    private final PrikazKlijenataForm forma;

    public PrikazKlijenataController(PrikazKlijenataForm forma) {
        this.forma = forma;
        addActionListeners();
    }

     private void addActionListeners() {
         forma.addDodajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            Cordinator.getInstanca().otvoriDodajKlijentaFormu();
               
            }
            
        });
         
         
          forma.addIzmeniListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               Klijent k = izabrani();
        if (k == null) return;
        Cordinator.getInstanca().dodajParam("klijent", k);
        Cordinator.getInstanca().otvoriIzmeniKlijentaFormu();
            }

        });
           forma.addObrisiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Klijent k = izabrani();
        if (k == null) return;
        int odgovor = JOptionPane.showConfirmDialog(forma, "Obrisati izabranog klijenta?",
                "Potvrda", JOptionPane.YES_NO_OPTION);
        if (odgovor != JOptionPane.YES_OPTION) return;
        try {
            Komunikacija.getInstanca().obrisiKlijenta(k);
            osveziFormu();
        } catch (Exception ex) {
            greska(ex);
        }
            }

        });
              forma.addPretraziListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String kriterijumPretrage = forma.getTxtPretraga().getText().trim();
                Status izabraniStatus=(Status) forma.getCmbStatus().getSelectedItem();
                if((kriterijumPretrage=="" || kriterijumPretrage.isEmpty()) &&(izabraniStatus==null)){
                    JOptionPane.showMessageDialog(forma, "Niste uneli nijedan kriterijum pretrage!", "PRETRAGA NIJE MOGUĆA", JOptionPane.WARNING_MESSAGE);
              return;
                }
                ModelTabeleKlijent mtk = (ModelTabeleKlijent) forma.getTabela().getModel();
                mtk.pretrazi(kriterijumPretrage,izabraniStatus);
                if (mtk.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(forma, "Sistem ne može da nađe klijente po zadatim kriterijumima", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(forma, "Sistem je našao klijente po zadatim kriterijumima", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
              
                    forma.addOsveziListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    osveziFormu();
                } catch (Exception ex) {
                    Logger.getLogger(PrikazKlijenataController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }

        });
        
    }
    
    public void otvoriFormu() throws Exception {
        pripremiFormu();
        popuniStatuse();
       forma.setVisible(true);
    }

    private void pripremiFormu() throws Exception {
        
        List<Klijent> klijenti=Komunikacija.getInstanca().ucitajKlijente("ORDER BY idKlijent");
        ModelTabeleKlijent mtk=new ModelTabeleKlijent(klijenti);
        forma.getTabela().setModel(mtk);
          
        
    }
    public void osveziFormu() throws Exception {
        pripremiFormu();
        forma.getTxtPretraga().setText("");
        forma.getCmbStatus().setSelectedItem(null);
    }

  

    private Klijent izabrani() {
        int red = forma.getTabela().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Izaberite klijenta.");
            return null;
        }
        return ((ModelTabeleKlijent) forma.getTabela().getModel()).get(red);
    }

    private void greska(Exception ex) {
        JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
    }

    private void popuniStatuse() {
        try {
            List<Status>statusi=Komunikacija.getInstanca().ucitajStatuse();
            forma.getCmbStatus().removeAllItems();
            for(Status s:statusi){
                forma.getCmbStatus().addItem(s);
            }
            forma.getCmbStatus().setSelectedItem(null);
        } catch (Exception ex) {
            greska(ex);
             }
        
       }
}
