/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import com.formdev.flatlaf.util.SwingUtils;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import cordinator.Cordinator;
import domen.Klijent;
import domen.Radnik;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Tacaaa
 */
public class DodajRezervacijuForma extends javax.swing.JDialog {

    /**
     * Creates new form GlavnaForma
     */
    public DodajRezervacijuForma(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(1200, 700);
        tblStavke.getTableHeader().setReorderingAllowed(false);
        setResizable(false);
        setLocationRelativeTo(null);
           javax.swing.SwingUtilities.invokeLater(() -> {
        int sirinaContentPane = getContentPane().getWidth();
        int sirinaPanela = 1040;
        int x = (sirinaContentPane - sirinaPanela) / 2;
     pnlStavke.setBounds(x, 300, sirinaPanela, 260);
    });

    
        
        ImageIcon originalSacuvaj = new ImageIcon(getClass().getResource("/slike/save.jpg"));
        Image slikaSacuvaj = originalSacuvaj.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnSacuvaj.setIcon(new ImageIcon(slikaSacuvaj));
       
jDateChooserDatumTermina.setDateFormatString("dd.MM.yyyy.");
jDateChooserDatumTermina.setToolTipText("Izaberite datum termina:");
cmbTermini.setToolTipText("Izaberite vreme termina:");
      
btnKreiraj.setBackground(new Color(212, 175, 55));
btnKreiraj.setForeground(Color.WHITE);
btnKreiraj.setFont(new Font("Times New Roman", Font.BOLD, 12));
btnSacuvaj.setFont(new Font("Times New Roman", Font.BOLD, 12));
  
Color zlatna = new Color(197, 165, 90);
Color tamnoZelena = new Color(20, 46, 34);

        lblId.setForeground(zlatna);
        lblDatumKreiranja.setForeground(zlatna);
        lblDatumTerminaStvarni.setForeground(zlatna);
        lblVremeTermina.setForeground(zlatna);
        lblRadnik.setForeground(zlatna);
        lblKlijent.setForeground(zlatna);
        lblUkupanIznos.setForeground(zlatna);
        lblPopust.setForeground(zlatna);

TitledBorder border = BorderFactory.createTitledBorder(
    BorderFactory.createLineBorder(zlatna, 2),
    "PODACI O REZERVACIJI"
);
border.setTitleColor(zlatna);
border.setTitleFont(new Font("Times New Roman", Font.BOLD, 14));
pnlPodaci.setBorder(border);
pnlPodaci.setBackground(tamnoZelena);


         ImageIcon originalDodaj = new ImageIcon(getClass().getResource("/slike/dodajstavkuzlatna.png"));
        Image slikaDodaj = originalDodaj.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnDodajStavku.setIcon(new ImageIcon(slikaDodaj));
         
         ImageIcon originalUkloni= new ImageIcon(getClass().getResource("/slike/uklonistavkuzlatna.png"));
         Image slikaUkloni = originalUkloni.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnObrisiStavku.setIcon(new ImageIcon(slikaUkloni));


  ImageIcon originalIzmeni= new ImageIcon(getClass().getResource("/slike/izmenistavkuzlatna.png"));
         Image slikaIzmeni = originalIzmeni.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnIzmeniStavku.setIcon(new ImageIcon(slikaIzmeni));
        

    }
    
    public javax.swing.JTextField getTxtId() { return txtId; }
    public javax.swing.JComboBox<Klijent> getCmbKlijent() { return cmbKlijent; }
    public javax.swing.JComboBox<Radnik> getCmbRadnik() { return cmbRadnik; }
    public javax.swing.JComboBox<String> getCmbTermini() { return cmbTermini;}
    public javax.swing.JButton getBtnSacuvaj() { return btnSacuvaj; }
    public javax.swing.JButton getBtnDodajStavku() { return btnDodajStavku; }
    public javax.swing.JButton getBtnObrisiStavku() { return btnObrisiStavku; }
    public javax.swing.JButton getBtnIzmeniStavku() { return btnIzmeniStavku; }
    public javax.swing.JButton getBtnKreiraj() { return btnKreiraj; }
    
    public void addSacuvajListener(ActionListener listener) { btnSacuvaj.addActionListener(listener); }
    public void addKreirajListener(ActionListener listener) { btnKreiraj.addActionListener(listener); }
   
  
    public JDateChooser getjDateChooserDatumKreiranja() {
        return jDateChooserDatumKreiranja;
    }
       public JDateChooser getjDateChooserDatumTermina() {
        return jDateChooserDatumTermina;
    }
    
    
    public javax.swing.JTextField getTxtUkupanIznos() { return txtUkupanIznos; }
    public javax.swing.JComboBox<domen.Tretman> getCmbTretman() { return cmbTretman; }
    public javax.swing.JTextField getTxtCena() { return txtCena; }
    public javax.swing.JTextField getTxtBrojPaketa() { return txtBrojPaketa; }
    public javax.swing.JTextField getTxtPopust() { return txtPopust; }
    public javax.swing.JTable getTblStavke() { return tblStavke; }
    
    public void addDodajStavkuListener(ActionListener listener) { btnDodajStavku.addActionListener(listener); }
    public void addObrisiStavkuListener(ActionListener listener) { btnObrisiStavku.addActionListener(listener); }
    public void addIzmeniStavkuListener(ActionListener listener) { btnIzmeniStavku.addActionListener(listener); }
    public void addTretmanListener(ActionListener listener) { cmbTretman.addActionListener(listener); }
    
    
    public javax.swing.JPanel getPnlPodaci(){return pnlPodaci;}
    public javax.swing.JPanel getPnlStavke(){return pnlStavke;}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelVreme = new javax.swing.JLabel();
        jLabelDatum = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        btnKreiraj = new javax.swing.JButton();
        pnlPodaci = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblDatumKreiranja = new javax.swing.JLabel();
        jDateChooserDatumKreiranja = new com.toedter.calendar.JDateChooser();
        lblDatumTerminaStvarni = new javax.swing.JLabel();
        jDateChooserDatumTermina = new com.toedter.calendar.JDateChooser();
        lblVremeTermina = new javax.swing.JLabel();
        cmbTermini = new javax.swing.JComboBox<>();
        lblRadnik = new javax.swing.JLabel();
        cmbRadnik = new javax.swing.JComboBox<>();
        lblKlijent = new javax.swing.JLabel();
        cmbKlijent = new javax.swing.JComboBox<>();
        lblUkupanIznos = new javax.swing.JLabel();
        txtUkupanIznos = new javax.swing.JTextField();
        lblPopust = new javax.swing.JLabel();
        txtPopust = new javax.swing.JTextField();
        pnlStavke = new javax.swing.JPanel();
        pnlUnosStavke = new javax.swing.JPanel();
        lblTretman = new javax.swing.JLabel();
        cmbTretman = new javax.swing.JComboBox<>();
        lblCena = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        lblBrojPaketa = new javax.swing.JLabel();
        txtBrojPaketa = new javax.swing.JTextField();
        btnDodajStavku = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();
        btnIzmeniStavku = new javax.swing.JButton();
        scrStavke = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setTitle("REZERVACIJA");
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelVreme.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVreme.setText("jLabel5");
        getContentPane().add(jLabelVreme, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 20, -1, -1));

        jLabelDatum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDatum.setText("jLabel5");
        getContentPane().add(jLabelDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 50, -1, -1));

        btnSacuvaj.setText("SAČUVAJ");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });
        getContentPane().add(btnSacuvaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, 230, 50));

        btnKreiraj.setText("KREIRAJ REZERVACIJU");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });
        getContentPane().add(btnKreiraj, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, 200, 50));

        pnlPodaci.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pnlPodaci.setLayout(new java.awt.GridLayout(0, 2, 8, 8));

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("ID:");
        pnlPodaci.add(lblId);

        txtId.setColumns(18);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        pnlPodaci.add(txtId);

        lblDatumKreiranja.setForeground(new java.awt.Color(255, 255, 255));
        lblDatumKreiranja.setText("Datum kreiranja:");
        pnlPodaci.add(lblDatumKreiranja);
        pnlPodaci.add(jDateChooserDatumKreiranja);

        lblDatumTerminaStvarni.setForeground(new java.awt.Color(255, 255, 255));
        lblDatumTerminaStvarni.setText("Datum termina:");
        pnlPodaci.add(lblDatumTerminaStvarni);

        jDateChooserDatumTermina.setMaximumSize(new java.awt.Dimension(120, 30));
        jDateChooserDatumTermina.setMinimumSize(new java.awt.Dimension(120, 22));
        pnlPodaci.add(jDateChooserDatumTermina);

        lblVremeTermina.setForeground(new java.awt.Color(255, 255, 255));
        lblVremeTermina.setText("Vreme termina:");
        pnlPodaci.add(lblVremeTermina);

        pnlPodaci.add(cmbTermini);

        lblRadnik.setForeground(new java.awt.Color(255, 255, 255));
        lblRadnik.setText("Radnik:");
        pnlPodaci.add(lblRadnik);

        pnlPodaci.add(cmbRadnik);

        lblKlijent.setForeground(new java.awt.Color(255, 255, 255));
        lblKlijent.setText("Klijent:");
        pnlPodaci.add(lblKlijent);

        cmbKlijent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKlijentActionPerformed(evt);
            }
        });
        pnlPodaci.add(cmbKlijent);

        lblUkupanIznos.setForeground(new java.awt.Color(255, 255, 255));
        lblUkupanIznos.setText("Ukupan iznos:");
        pnlPodaci.add(lblUkupanIznos);

        txtUkupanIznos.setEditable(false);
        txtUkupanIznos.setColumns(18);
        pnlPodaci.add(txtUkupanIznos);

        lblPopust.setForeground(new java.awt.Color(255, 255, 255));
        lblPopust.setText("Popust:");
        pnlPodaci.add(lblPopust);

        txtPopust.setPreferredSize(new java.awt.Dimension(30, 22));
        pnlPodaci.add(txtPopust);

        getContentPane().add(pnlPodaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 560, 260));

        pnlStavke.setLayout(new java.awt.BorderLayout(5, 5));

        lblTretman.setText("Tretman:");
        pnlUnosStavke.add(lblTretman);
        pnlUnosStavke.add(cmbTretman);

        lblCena.setText("Cena:");
        pnlUnosStavke.add(lblCena);

        txtCena.setColumns(10);
        pnlUnosStavke.add(txtCena);

        lblBrojPaketa.setText("Broj paketa:");
        pnlUnosStavke.add(lblBrojPaketa);

        txtBrojPaketa.setColumns(8);
        pnlUnosStavke.add(txtBrojPaketa);

        btnDodajStavku.setText("Dodaj stavku");
        pnlUnosStavke.add(btnDodajStavku);

        btnObrisiStavku.setText("Ukloni stavku");
        pnlUnosStavke.add(btnObrisiStavku);

        btnIzmeniStavku.setText("Izmeni stavku");
        pnlUnosStavke.add(btnIzmeniStavku);

        pnlStavke.add(pnlUnosStavke, java.awt.BorderLayout.PAGE_START);

        scrStavke.setViewportView(tblStavke);

        pnlStavke.add(scrStavke, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlStavke, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 1040, 260));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/slike/naturalspa3.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, -10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void cmbKlijentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKlijentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKlijentActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnIzmeniStavku;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<domen.Klijent> cmbKlijent;
    private javax.swing.JComboBox<Radnik> cmbRadnik;
    private javax.swing.JComboBox<String> cmbTermini;
    private javax.swing.JComboBox<domen.Tretman> cmbTretman;
    private com.toedter.calendar.JDateChooser jDateChooserDatumKreiranja;
    private com.toedter.calendar.JDateChooser jDateChooserDatumTermina;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDatum;
    private javax.swing.JLabel jLabelVreme;
    private javax.swing.JLabel lblBrojPaketa;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblDatumKreiranja;
    private javax.swing.JLabel lblDatumTerminaStvarni;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JLabel lblPopust;
    private javax.swing.JLabel lblRadnik;
    private javax.swing.JLabel lblTretman;
    private javax.swing.JLabel lblUkupanIznos;
    private javax.swing.JLabel lblVremeTermina;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JPanel pnlStavke;
    private javax.swing.JPanel pnlUnosStavke;
    private javax.swing.JScrollPane scrStavke;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtBrojPaketa;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPopust;
    private javax.swing.JTextField txtUkupanIznos;
    // End of variables declaration//GEN-END:variables


}
