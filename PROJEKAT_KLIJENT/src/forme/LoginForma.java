package forme;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class LoginForma extends javax.swing.JFrame {

    public LoginForma() {
        initComponents();
        setLocationRelativeTo(null);
 ImageIcon original = new ImageIcon(getClass().getResource("/slike/prijava.png"));

Image slika = original.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);

btnPrijava.setIcon(new ImageIcon(slika));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrijava = new javax.swing.JPanel();
        lblKorisnickoIme = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        lblSifra = new javax.swing.JLabel();
        txtSifra = new javax.swing.JPasswordField();
        lblPrazno = new javax.swing.JLabel();
        btnPrijava = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SPA centar - prijava");

        pnlPrijava.setBackground(new java.awt.Color(204, 255, 255));
        pnlPrijava.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 25, 20, 25));
        pnlPrijava.setLayout(new java.awt.GridLayout(3, 2, 8, 8));

        lblKorisnickoIme.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKorisnickoIme.setForeground(java.awt.Color.blue);
        lblKorisnickoIme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKorisnickoIme.setText("KORISNIČKO IME:");
        pnlPrijava.add(lblKorisnickoIme);

        txtKorisnickoIme.setColumns(20);
        txtKorisnickoIme.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKorisnickoIme.setText("jelena");
        txtKorisnickoIme.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        pnlPrijava.add(txtKorisnickoIme);

        lblSifra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSifra.setForeground(java.awt.Color.blue);
        lblSifra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSifra.setText("ŠIFRA:");
        pnlPrijava.add(lblSifra);

        txtSifra.setColumns(20);
        txtSifra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSifra.setText("jelena123");
        txtSifra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        pnlPrijava.add(txtSifra);
        pnlPrijava.add(lblPrazno);

        btnPrijava.setBackground(new java.awt.Color(51, 204, 255));
        btnPrijava.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        btnPrijava.setPreferredSize(new java.awt.Dimension(50, 40));
        pnlPrijava.add(btnPrijava);

        getContentPane().add(pnlPrijava, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTextField getTxtKorisnickoIme() { return txtKorisnickoIme; }
    public javax.swing.JPasswordField getTxtSifra() { return txtSifra; }
    public void addLoginActionListener(ActionListener listener) { btnPrijava.addActionListener(listener); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel lblKorisnickoIme;
    private javax.swing.JLabel lblPrazno;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JPanel pnlPrijava;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtSifra;
    // End of variables declaration//GEN-END:variables
}
