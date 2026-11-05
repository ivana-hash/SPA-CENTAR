/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

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
import domen.Tretman;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Tacaaa
 */
public class PrikazRezervacijaForma extends javax.swing.JDialog {

    /**
     * Creates new form GlavnaForma
     */
    public PrikazRezervacijaForma(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        //za mail da se vidi sadrzaj
      //za mail da se vidi sadrzaj - primeni tooltip svaki put kad se model promeni
tabela.addPropertyChangeListener("model", evt -> {
    if (tabela.getColumnModel().getColumnCount() > 3) {
        tabela.getColumnModel().getColumn(3).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (c instanceof javax.swing.JComponent) {
                    ((javax.swing.JComponent) c).setToolTipText(value != null ? value.toString() : null);
                }
                return c;
            }
        });
    }
});
tabela.getTableHeader().setReorderingAllowed(false);
        
      setSize(1050, 540);
      setLocationRelativeTo(null);
        setResizable(false);
javax.swing.SwingUtilities.invokeLater(() -> {
    int sirinaContentPane = getContentPane().getWidth();
    int sirinaTabele = 840;
    int x = (sirinaContentPane - sirinaTabele) / 2;
    scrTabela.setBounds(x, 90, sirinaTabele, 210);
});
        
        btnOsvezi.setToolTipText("Osveži");
        btnPretrazi.setToolTipText("Pretraži");
        
         ImageIcon originalPretraga = new ImageIcon(getClass().getResource("/slike/pretrazi.jpg"));
        Image slikaPretraga = originalPretraga.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnPretrazi.setIcon(new ImageIcon(slikaPretraga));
         
         ImageIcon originalOsvezi= new ImageIcon(getClass().getResource("/slike/osvezi.jpg"));
         Image slikaOsvezi = originalOsvezi.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
       btnOsvezi.setIcon(new ImageIcon(slikaOsvezi));
       
        ImageIcon originalObrisi = new ImageIcon(getClass().getResource("/slike/deletegold.jpg"));
        Image slikaObrisi = originalObrisi.getImage().getScaledInstance(
        60, 60,
        Image.SCALE_SMOOTH
);
        btnObrisi.setIcon(new ImageIcon(slikaObrisi));
       
       ImageIcon originalIzmeni= new ImageIcon(getClass().getResource("/slike/izmeni_1.jpg"));
        Image slikaIzmeni = originalIzmeni.getImage().getScaledInstance(
        60, 60,
        Image.SCALE_SMOOTH
);
        btnIzmeni.setIcon(new ImageIcon(slikaIzmeni)); 
        
             ImageIcon originalOdstampaj= new ImageIcon(getClass().getResource("/slike/print.jpg"));
        Image slikaOdstampaj = originalOdstampaj.getImage().getScaledInstance(
        60, 60,
        Image.SCALE_SMOOTH
);
        btnOdstampaj.setIcon(new ImageIcon(slikaOdstampaj)); 
        
        
       tabela.setBackground(new Color(255, 239, 180));
  
       txtPretraga.setToolTipText("Pretražite rezervacije po imenu/prezimenu/nazivu radnika/klijenta/tretmana:");
       cmbKlijent.setToolTipText("Izaberite klijenta po kom želite da pretražite rezervacije:");
       cmbRadnik.setToolTipText("Izaberite radnika po kom želite da pretražite rezervacije:");
       cmbTretman.setToolTipText("Izaberite tretman po kom želite da pretražite rezervacije:");
       
        btnIzmeni.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 239, 180), 3, true));
       btnObrisi.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 239, 180), 3, true));
  
       
       btnIzmeni.setFont(new Font("Times New Roman", Font.BOLD, 12));
       btnObrisi.setFont(new Font("Times New Roman", Font.BOLD, 12));
       btnOdstampaj.setFont(new Font("Times New Roman", Font.BOLD, 12));
       
Color zlatna = new Color(197, 165, 90);
txtPretraga.setForeground(zlatna);
cmbRadnik.setForeground(zlatna);
cmbKlijent.setForeground(zlatna);
cmbTretman.setForeground(zlatna);
txtPretraga.setBackground(new Color(0,0,0));
cmbKlijent.setBackground(new Color(0,0,0));
cmbRadnik.setBackground(new Color(0,0,0));
cmbTretman.setBackground(new Color(0,0,0));
    }
    public javax.swing.JTable getTabela() { return tabela; }
    public javax.swing.JTextField getTxtPretraga() { return txtPretraga; }
    public javax.swing.JComboBox<Klijent> getCmbKlijent() { return cmbKlijent; }
    public javax.swing.JComboBox<Radnik> getCmbRadnik() { return cmbRadnik; }
    public javax.swing.JComboBox<Tretman> getCmbTretman() { return cmbTretman; }
    public void addPretraziListener(ActionListener listener) { btnPretrazi.addActionListener(listener); }
    public void addOsveziListener(ActionListener listener) { btnOsvezi.addActionListener(listener); }
    public void addIzmeniListener(ActionListener listener) { btnIzmeni.addActionListener(listener); }
    public void addObrisiListener(ActionListener listener) { btnObrisi.addActionListener(listener); }
    public void addOdstampajListener(ActionListener listener) { btnOdstampaj.addActionListener(listener); }
    public javax.swing.JButton getBtnOdstampaj(){return btnOdstampaj;}
    public javax.swing.JButton getBtnIzmeni(){return btnIzmeni;}
    public javax.swing.JButton getBtnObrisi(){return btnObrisi;}


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
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnOdstampaj = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pnlFilter = new javax.swing.JPanel();
        lblPretraga = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        lblKlijent = new javax.swing.JLabel();
        cmbKlijent = new javax.swing.JComboBox<>();
        lblRadnik = new javax.swing.JLabel();
        cmbRadnik = new javax.swing.JComboBox<>();
        lblTretman = new javax.swing.JLabel();
        cmbTretman = new javax.swing.JComboBox<>();
        scrTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setTitle("REZERVACIJE");
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelVreme.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVreme.setText("jLabel5");
        getContentPane().add(jLabelVreme, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 20, -1, -1));

        jLabelDatum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDatum.setText("jLabel5");
        getContentPane().add(jLabelDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 50, -1, -1));

        btnObrisi.setText("OBRIŠI");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });
        getContentPane().add(btnObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 160, 40));

        btnIzmeni.setText("IZMENI");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });
        getContentPane().add(btnIzmeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 160, 40));

        btnOdstampaj.setText("ODŠTAMPAJ");
        btnOdstampaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdstampajActionPerformed(evt);
            }
        });
        getContentPane().add(btnOdstampaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 180, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/slike/spadetails.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1490, 160));

        pnlFilter.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));

        lblPretraga.setText("Pretraga:");
        pnlFilter.add(lblPretraga);

        txtPretraga.setBackground(new java.awt.Color(204, 204, 204));
        txtPretraga.setColumns(20);
        txtPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPretragaActionPerformed(evt);
            }
        });
        pnlFilter.add(txtPretraga);
        pnlFilter.add(btnPretrazi);
        pnlFilter.add(btnOsvezi);

        lblKlijent.setText("Klijent:");
        pnlFilter.add(lblKlijent);

        cmbKlijent.setPreferredSize(new java.awt.Dimension(150, 22));
        pnlFilter.add(cmbKlijent);

        lblRadnik.setText("Radnik:");
        pnlFilter.add(lblRadnik);

        cmbRadnik.setPreferredSize(new java.awt.Dimension(150, 22));
        pnlFilter.add(cmbRadnik);

        lblTretman.setText("Tretman:");
        pnlFilter.add(lblTretman);

        cmbTretman.setPreferredSize(new java.awt.Dimension(140, 22));
        pnlFilter.add(cmbTretman);

        getContentPane().add(pnlFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        scrTabela.setViewportView(tabela);

        getContentPane().add(scrTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 840, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnOdstampajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdstampajActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOdstampajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void txtPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPretragaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPretragaActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOdstampaj;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JComboBox<domen.Klijent> cmbKlijent;
    private javax.swing.JComboBox<domen.Radnik> cmbRadnik;
    private javax.swing.JComboBox<domen.Tretman> cmbTretman;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDatum;
    private javax.swing.JLabel jLabelVreme;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JLabel lblRadnik;
    private javax.swing.JLabel lblTretman;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JScrollPane scrTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables


}
