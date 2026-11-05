package forme;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class PrikazRadnikaForm extends javax.swing.JFrame {

    public PrikazRadnikaForm() {
        initComponents();
        setSize(900, 540);
        setLocationRelativeTo(null);
         ImageIcon originalPretraga = new ImageIcon(getClass().getResource("/slike/pretrazi.png"));
        Image slikaPretraga = originalPretraga.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnPretrazi.setIcon(new ImageIcon(slikaPretraga));
         
         ImageIcon originalOsvezi= new ImageIcon(getClass().getResource("/slike/refresh.png"));
         Image slikaOsvezi = originalOsvezi.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnOsvezi.setIcon(new ImageIcon(slikaOsvezi));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFilter = new javax.swing.JPanel();
        lblPretraga = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnOsvezi = new javax.swing.JButton();
        scrTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        pnlDugmad = new javax.swing.JPanel();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Radnici");

        pnlFilter.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));

        lblPretraga.setText("Pretraga:");
        pnlFilter.add(lblPretraga);

        txtPretraga.setBackground(new java.awt.Color(204, 204, 204));
        txtPretraga.setColumns(20);
        pnlFilter.add(txtPretraga);

        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });
        pnlFilter.add(btnPretrazi);
        pnlFilter.add(btnOsvezi);

        getContentPane().add(pnlFilter, java.awt.BorderLayout.NORTH);

        tabela.setBackground(new java.awt.Color(204, 204, 255));
        scrTabela.setViewportView(tabela);

        getContentPane().add(scrTabela, java.awt.BorderLayout.CENTER);

        pnlDugmad.setBackground(new java.awt.Color(255, 255, 204));

        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setText("DODAJ");
        btnDodaj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 3, true));
        pnlDugmad.add(btnDodaj);

        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzmeni.setText("IZMENI");
        btnIzmeni.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 3, true));
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });
        pnlDugmad.add(btnIzmeni);

        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisi.setText("OBRIŠI");
        btnObrisi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 3, true));
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });
        pnlDugmad.add(btnObrisi);

        getContentPane().add(pnlDugmad, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObrisiActionPerformed

    public javax.swing.JTable getTabela() { return tabela; }
    public javax.swing.JTextField getTxtPretraga() { return txtPretraga; }

    public void addPretraziListener(ActionListener listener) { btnPretrazi.addActionListener(listener); }
    public void addOsveziListener(ActionListener listener) { btnOsvezi.addActionListener(listener); }
    public void addDodajListener(ActionListener listener) { btnDodaj.addActionListener(listener); }
    public void addIzmeniListener(ActionListener listener) { btnIzmeni.addActionListener(listener); }
    public void addObrisiListener(ActionListener listener) { btnObrisi.addActionListener(listener); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOsvezi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JPanel pnlDugmad;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JScrollPane scrTabela;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables
}
