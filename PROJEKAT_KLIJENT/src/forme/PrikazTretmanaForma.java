/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import com.formdev.flatlaf.util.SwingUtils;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import cordinator.Cordinator;
import domen.Kategorija;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tacaaa
 */
public class PrikazTretmanaForma extends javax.swing.JDialog {

    /**
     * Creates new form GlavnaForma
     */
    public PrikazTretmanaForma(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(900, 540);
        setLocationRelativeTo(null);
        setResizable(false);
//za benefite da se vidi ceo sadrzaj klikom na celiju

      tabela.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = tabela.rowAtPoint(evt.getPoint());
        int column = tabela.columnAtPoint(evt.getPoint());

        // Kolona 4 = Benefiti
        if (column == 4 && row >= 0) {

            Object vrednost = tabela.getValueAt(row, column);

            if (vrednost != null) {
                JOptionPane.showMessageDialog(
                    null,
                    vrednost.toString(),
                    "Benefiti tretmana",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
});
      tabela.getTableHeader().setReorderingAllowed(false);
        btnOsvezi.setToolTipText("Osveži");
        btnPretrazi.setToolTipText("Pretraži");

Color zlatna = new Color(197, 165, 90);
txtPretraga.setForeground(zlatna);
txtPretraga.setBackground(new Color(0,0,0));
cmbKategorije.setForeground(zlatna);
  
// centriranje nakon što je forma realizovana
javax.swing.SwingUtilities.invokeLater(() -> {
    int sirinaContentPane = getContentPane().getWidth();
    int sirinaTabele = 840;
    int x = (sirinaContentPane - sirinaTabele) / 2;
    scrTabela.setBounds(x, 90, sirinaTabele, 210);
});
      
        
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
        
       tabela.setBackground(new Color(255, 239, 180));
   txtPretraga.setToolTipText("Pretražite tretmane po nazivu:");
     cmbKategorije.setToolTipText("Izaberite kategoriju po kojoj želite da pretražite tretmane:");
   btnIzmeni.setFont(new Font("Times New Roman", Font.BOLD, 12));
       btnObrisi.setFont(new Font("Times New Roman", Font.BOLD, 12));
       
  btnIzmeni.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 239, 180), 3, true));
       btnObrisi.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 239, 180), 3, true));
  
    }
    public javax.swing.JTable getTabela() { return tabela; }
    public javax.swing.JTextField getTxtPretraga() { return txtPretraga; }
   
    public void addPretraziListener(ActionListener listener) { btnPretrazi.addActionListener(listener); }
    public void addOsveziListener(ActionListener listener) { btnOsvezi.addActionListener(listener); }
    public void addIzmeniListener(ActionListener listener) { btnIzmeni.addActionListener(listener); }
    public void addObrisiListener(ActionListener listener) { btnObrisi.addActionListener(listener); }
    public javax.swing.JComboBox<Kategorija> getCmbKategorije(){return cmbKategorije;}

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
        jLabel5 = new javax.swing.JLabel();
        scrTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        pnlFilter = new javax.swing.JPanel();
        lblPretraga = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        lblKategorija = new javax.swing.JLabel();
        cmbKategorije = new javax.swing.JComboBox<>();
        btnPretrazi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();

        setTitle("TRETMANI");
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
        getContentPane().add(btnObrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 150, 40));

        btnIzmeni.setText("IZMENI");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });
        getContentPane().add(btnIzmeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 150, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/slike/spadetails.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1490, 160));

        scrTabela.setViewportView(tabela);

        getContentPane().add(scrTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 750, 280));

        pnlFilter.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));

        lblPretraga.setText("Pretraga:");
        pnlFilter.add(lblPretraga);

        txtPretraga.setBackground(new java.awt.Color(204, 204, 204));
        txtPretraga.setColumns(20);
        pnlFilter.add(txtPretraga);

        lblKategorija.setText("Kategorija tretmana:");
        pnlFilter.add(lblKategorija);

        cmbKategorije.setBackground(new java.awt.Color(0, 0, 0));
        cmbKategorije.setPreferredSize(new java.awt.Dimension(150, 22));
        pnlFilter.add(cmbKategorije);
        pnlFilter.add(btnPretrazi);
        pnlFilter.add(btnOsvezi);

        getContentPane().add(pnlFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIzmeniActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JComboBox<Kategorija> cmbKategorije;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDatum;
    private javax.swing.JLabel jLabelVreme;
    private javax.swing.JLabel lblKategorija;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JScrollPane scrTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables


}
