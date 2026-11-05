package forme;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class GlavnaForma extends javax.swing.JFrame {

    public GlavnaForma() {
        initComponents();
        setSize(620, 390);
        setLocationRelativeTo(null);
         ImageIcon original = new ImageIcon(getClass().getResource("/slike/odjava.png"));

Image slika = original.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
btnOdjava.setIcon(new ImageIcon(slika));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUlogovani = new javax.swing.JLabel();
        pnlMeni = new javax.swing.JPanel();
        btnRezervacije = new javax.swing.JButton();
        btnKlijenti = new javax.swing.JButton();
        btnRadnici = new javax.swing.JButton();
        btnTretmani = new javax.swing.JButton();
        btnStatusi = new javax.swing.JButton();
        btnKvalifikacije = new javax.swing.JButton();
        pnlOdjava = new javax.swing.JPanel();
        btnOdjava = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SPA centar");

        lblUlogovani.setBackground(new java.awt.Color(204, 255, 204));
        lblUlogovani.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUlogovani.setText("PRIJAVLJENI RADNIK:");
        lblUlogovani.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));
        getContentPane().add(lblUlogovani, java.awt.BorderLayout.NORTH);

        pnlMeni.setBackground(new java.awt.Color(153, 255, 153));
        pnlMeni.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 35, 20, 35));
        pnlMeni.setLayout(new java.awt.GridLayout(3, 2, 12, 12));

        btnRezervacije.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRezervacije.setText("REZERVACIJE");
        btnRezervacije.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        pnlMeni.add(btnRezervacije);

        btnKlijenti.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKlijenti.setText("KLIJENTI");
        btnKlijenti.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        btnKlijenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlijentiActionPerformed(evt);
            }
        });
        pnlMeni.add(btnKlijenti);

        btnRadnici.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRadnici.setText("RADNICI");
        btnRadnici.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        pnlMeni.add(btnRadnici);

        btnTretmani.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTretmani.setText("TRETMANI");
        btnTretmani.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        pnlMeni.add(btnTretmani);

        btnStatusi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnStatusi.setText("STATUSI");
        btnStatusi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        pnlMeni.add(btnStatusi);

        btnKvalifikacije.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKvalifikacije.setText("KVALIFIKACIJE");
        btnKvalifikacije.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        pnlMeni.add(btnKvalifikacije);

        getContentPane().add(pnlMeni, java.awt.BorderLayout.CENTER);

        pnlOdjava.setBackground(new java.awt.Color(255, 153, 153));

        btnOdjava.setPreferredSize(new java.awt.Dimension(40, 40));
        pnlOdjava.add(btnOdjava);

        getContentPane().add(pnlOdjava, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKlijentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlijentiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKlijentiActionPerformed

    public void setUlogovaniTekst(String tekst) { lblUlogovani.setText(tekst); }
    public void addRezervacijeListener(ActionListener listener) { btnRezervacije.addActionListener(listener); }
    public void addKlijentiListener(ActionListener listener) { btnKlijenti.addActionListener(listener); }
    public void addRadniciListener(ActionListener listener) { btnRadnici.addActionListener(listener); }
    public void addTretmaniListener(ActionListener listener) { btnTretmani.addActionListener(listener); }
    public void addStatusiListener(ActionListener listener) { btnStatusi.addActionListener(listener); }
    public void addKvalifikacijeListener(ActionListener listener) { btnKvalifikacije.addActionListener(listener); }
    public void addOdjavaListener(ActionListener listener) { btnOdjava.addActionListener(listener); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKlijenti;
    private javax.swing.JButton btnKvalifikacije;
    private javax.swing.JButton btnOdjava;
    private javax.swing.JButton btnRadnici;
    private javax.swing.JButton btnRezervacije;
    private javax.swing.JButton btnStatusi;
    private javax.swing.JButton btnTretmani;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JPanel pnlMeni;
    private javax.swing.JPanel pnlOdjava;
    // End of variables declaration//GEN-END:variables
}
