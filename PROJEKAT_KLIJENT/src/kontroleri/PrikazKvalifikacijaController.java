package kontroleri;

import cordinator.Cordinator;
import domen.Klijent;
import domen.Kvalifikacija;
import domen.Status;
import forme.PrikazKvalifikacijaForm;
import forme.model.ModelTabeleKlijent;
import forme.model.ModelTabeleKvalifikacija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class PrikazKvalifikacijaController {

    private final PrikazKvalifikacijaForm forma;

    public PrikazKvalifikacijaController(PrikazKvalifikacijaForm forma) {
        this.forma = forma;
        addActionListeners();
    }

     private void addActionListeners() {
         forma.addDodajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            Cordinator.getInstanca().otvoriDodajKvalifikacijuFormu();
               
            }
            
        });
         
         
          forma.addIzmeniListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            Kvalifikacija k = izabrana(); if (k == null) return;
        Cordinator.getInstanca().dodajParam("kvalifikacija", k);
        Cordinator.getInstanca().otvoriIzmeniKvalifikacijuFormu();
            }

        });
           forma.addObrisiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

          Kvalifikacija k = izabrana(); if (k == null) return;
        if (JOptionPane.showConfirmDialog(forma, "Obrisati kvalifikaciju?", "Potvrda",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try { Komunikacija.getInstanca().obrisiKvalifikaciju(k); osveziFormu(); }
        catch (Exception ex) { greska(ex); }
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
                ModelTabeleKvalifikacija mtk = (ModelTabeleKvalifikacija) forma.getTabela().getModel();
                mtk.pretrazi(kriterijumPretrage);
                if (mtk.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(forma, "Sistem ne može da nađe kvalifikacije po zadatim kriterijumima", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(forma, "Sistem je našao kvalifikacije po zadatim kriterijumima", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
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
        
        List<Kvalifikacija> kvalifikacije=Komunikacija.getInstanca().ucitajKvalifikacije();
        ModelTabeleKvalifikacija mtk=new ModelTabeleKvalifikacija(kvalifikacije);
        forma.getTabela().setModel(mtk);
          
    }
    private Kvalifikacija izabrana() {
        int red = forma.getTabela().getSelectedRow();
        if (red == -1) { JOptionPane.showMessageDialog(forma, "Izaberite kvalifikaciju."); return null; }
        return ((ModelTabeleKvalifikacija) forma.getTabela().getModel()).get(red);
    }

    private void greska(Exception ex) {
        JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
    }
}
