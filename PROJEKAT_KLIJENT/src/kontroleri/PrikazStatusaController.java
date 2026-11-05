package kontroleri;

import cordinator.Cordinator;
import domen.Kvalifikacija;
import domen.Status;
import forme.PrikazStatusaForm;
import forme.model.ModelTabeleKvalifikacija;
import forme.model.ModelTabeleStatus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class PrikazStatusaController {

    private final PrikazStatusaForm forma;

    public PrikazStatusaController(PrikazStatusaForm forma) {
        this.forma = forma;
        addActionListeners();
    }

     private void addActionListeners() {
         forma.addDodajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            Cordinator.getInstanca().otvoriDodajStatusFormu();
               
            }
            
        });
         
         
          forma.addIzmeniListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

           Status s = izabrani(); if (s == null) return;
        Cordinator.getInstanca().dodajParam("status", s);
        Cordinator.getInstanca().otvoriIzmeniStatusFormu();
            }

        });
           forma.addObrisiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

         Status s = izabrani(); if (s == null) return;
        if (JOptionPane.showConfirmDialog(forma, "Obrisati status?", "Potvrda",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try { Komunikacija.getInstanca().obrisiStatus(s); osveziFormu(); }
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
                ModelTabeleStatus mts = (ModelTabeleStatus) forma.getTabela().getModel();
                mts.pretrazi(kriterijumPretrage);
                if (mts.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(forma, "Sistem ne može da nađe statuse po zadatim kriterijumima", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(forma, "Sistem je našao statuse po zadatim kriterijumima", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
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

    public void osveziFormu() throws Exception{
       pripremiFormu();
        forma.getTxtPretraga().setText("");
    }
  private void pripremiFormu() throws Exception {
        
        List<Status> statusi=Komunikacija.getInstanca().ucitajStatuse();
        ModelTabeleStatus mts=new ModelTabeleStatus(statusi);
        forma.getTabela().setModel(mts);
          
    }
 

    private Status izabrani() {
        int red = forma.getTabela().getSelectedRow();
        if (red == -1) { JOptionPane.showMessageDialog(forma, "Izaberite status."); return null; }
        return ((ModelTabeleStatus) forma.getTabela().getModel()).get(red);
    }

    private void greska(Exception ex) {
        JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
    }
}
