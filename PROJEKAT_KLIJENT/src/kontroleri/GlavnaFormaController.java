package kontroleri;

import com.sun.java.accessibility.util.AWTEventMonitor;
import cordinator.Cordinator;
import domen.Radnik;
import forme.GlavnaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

public class GlavnaFormaController {

    private final GlavnaForma forma;

    public GlavnaFormaController(GlavnaForma forma) {
        this.forma = forma;
          addActionListeners();
                
    }
    
    private void addActionListeners() {
        forma.addKlijentiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cordinator.getInstanca().otvoriPrikazKlijenataFormu();
                } catch (Exception ex) {
                    Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        

        forma.addTretmaniListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cordinator.getInstanca().otvoriPrikazTretmanaFormu();
                } catch (Exception ex) {
                    Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        
          forma.addKvalifikacijeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cordinator.getInstanca().otvoriPrikazKvalifikacijaFormu();
                } catch (Exception ex) {
                    Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
         
          
        forma.addStatusiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cordinator.getInstanca().otvoriPrikazStatusaFormu();
                } catch (Exception ex) {
                    Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        
        
          forma.addRadniciListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cordinator.getInstanca().otvoriPrikazRadnikaFormu();
                } catch (Exception ex) {
                    Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
           
        
            forma.addRezervacijeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cordinator.getInstanca().otvoriPrikazRezervacijaFormu();
                } catch (Exception ex) {
                    Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
                   forma.addOdjavaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                odjava(e);
                
            }
            
            private void odjava(ActionEvent e) {
           Komunikacija.getInstanca().zatvoriKonekciju();
        Cordinator.getInstanca().setUlogovani(null);
        forma.dispose();
        Cordinator.getInstanca().otvoriLoginFormu();  }
        });
        
          
          

    }


    
  
    public void otvoriFormu() {
        Radnik r = Cordinator.getInstanca().getUlogovani();
        forma.setUlogovaniTekst(r == null ? "" : "Ulogovani radnik: " + r);
        forma.setVisible(true);
        forma.setLocationRelativeTo(null);
    }

   
}
