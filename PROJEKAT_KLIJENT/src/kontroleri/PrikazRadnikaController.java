package kontroleri;

import cordinator.Cordinator;
import domen.Radnik;
import domen.Status;
import forme.PrikazRadnikaForm;
import forme.model.ModelTabeleRadnik;
import forme.model.ModelTabeleStatus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class PrikazRadnikaController {

    private final PrikazRadnikaForm forma;

    public PrikazRadnikaController(PrikazRadnikaForm forma) {
        this.forma = forma;
       addActionListeners();
    }

    
     private void addActionListeners() {
         forma.addDodajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            Cordinator.getInstanca().otvoriDodajRadnikaFormu();
               
            }
            
        });
         
         
          forma.addIzmeniListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            Radnik r = izabrani();
        if (r == null) {
            return;
        }
        Cordinator.getInstanca().dodajParam("radnik", r);
        Cordinator.getInstanca().otvoriIzmeniRadnikaFormu();
            }

        });
           forma.addObrisiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

        Radnik r = izabrani();
        if (r == null) {
            return;
        }
        if (JOptionPane.showConfirmDialog(
                forma, "Obrisati radnika?", "Potvrda", JOptionPane.YES_NO_OPTION
        ) != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            Komunikacija.getInstanca().obrisiRadnika(r);
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
             
                if((kriterijumPretrage=="" || kriterijumPretrage.isEmpty())){
                    JOptionPane.showMessageDialog(forma, "Niste uneli nijedan kriterijum pretrage!", "PRETRAGA NIJE MOGUĆA", JOptionPane.WARNING_MESSAGE);
              return;
                }
                ModelTabeleRadnik mtr = (ModelTabeleRadnik) forma.getTabela().getModel();
                mtr.pretrazi(kriterijumPretrage);
                if (mtr.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(forma, "Sistem ne može da nađe radnike po zadatim kriterijumima", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(forma, "Sistem je našao radnike po zadatim kriterijumima", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
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
        forma.setVisible(true); 
    }

    public void osveziFormu() throws Exception {
        pripremiFormu();
        forma.getTxtPretraga().setText("");
    }
private void pripremiFormu() throws Exception {
        
        List<Radnik> radnici=Komunikacija.getInstanca().ucitajRadnike();
        ModelTabeleRadnik mtr=new ModelTabeleRadnik(radnici);
        forma.getTabela().setModel(mtr);
          
    }
 
    private Radnik izabrani() {
        int red = forma.getTabela().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Izaberite radnika.");
            return null;
        }
        return ((ModelTabeleRadnik) forma.getTabela().getModel()).get(red);
    }

    private void greska(Exception ex) {
        JOptionPane.showMessageDialog(
                forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE
        );
    }
}
