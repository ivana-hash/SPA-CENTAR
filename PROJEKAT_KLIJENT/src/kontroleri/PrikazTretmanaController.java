package kontroleri;

import cordinator.Cordinator;
import domen.Kvalifikacija;
import domen.Tretman;
import forme.PrikazTretmanaForm;
import forme.model.ModelTabeleKvalifikacija;
import forme.model.ModelTabeleTretman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class PrikazTretmanaController {

    private final PrikazTretmanaForm forma;

    public PrikazTretmanaController(PrikazTretmanaForm forma) {
        this.forma = forma;
          addActionListeners();
      
    }
 private void addActionListeners() {
         forma.addDodajListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            Cordinator.getInstanca().otvoriDodajTretmanFormu();
               
            }
            
        });
         
         
          forma.addIzmeniListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              Tretman t = izabrani(); if (t == null) return;
        Cordinator.getInstanca().dodajParam("tretman", t);
        Cordinator.getInstanca().otvoriIzmeniTretmanFormu();
            }

        });
           forma.addObrisiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

       Tretman t = izabrani(); if (t == null) return;
        if (JOptionPane.showConfirmDialog(forma, "Obrisati tretman?", "Potvrda",
                JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        try { Komunikacija.getInstanca().obrisiTretman(t); osveziFormu(); }
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
                ModelTabeleTretman mtt = (ModelTabeleTretman) forma.getTabela().getModel();
                mtt.pretrazi(kriterijumPretrage);
                if (mtt.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(forma, "Sistem ne može da nađe tretmane po zadatim kriterijumima", "NEUSPEŠNO", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(forma, "Sistem je našao tretmane po zadatim kriterijumima", "USPEŠNO", JOptionPane.INFORMATION_MESSAGE);
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
        
        List<Tretman> tretmani=Komunikacija.getInstanca().ucitajTretmane();
        ModelTabeleTretman mtt=new ModelTabeleTretman(tretmani);
        forma.getTabela().setModel(mtt);
          
    }
    
    private Tretman izabrani() {
        int red = forma.getTabela().getSelectedRow();
        if (red == -1) { JOptionPane.showMessageDialog(forma, "Izaberite tretman."); return null; }
        return ((ModelTabeleTretman) forma.getTabela().getModel()).get(red);
    }

    private void greska(Exception ex) {
        JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
    }
}
