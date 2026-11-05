package forme;

import java.awt.event.ActionListener;

public class DodajKlijentaForm extends javax.swing.JFrame {

    public DodajKlijentaForm() {
        initComponents();
        setSize(500, 360);
        setLocationRelativeTo(null);
       txtEmail.setToolTipText("Unesite email adresu u formatu: ime@gmail.com");
       txtTelefon.setToolTipText("Unesite kontakt telefon u formatu: 061-123-45-67");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPodaci = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblIme = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        lblPrezime = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTelefon = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        pnlDugmad = new javax.swing.JPanel();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Klijent");

        pnlPodaci.setBackground(new java.awt.Color(204, 255, 255));
        pnlPodaci.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 20));
        pnlPodaci.setLayout(new java.awt.GridLayout(0, 2, 8, 8));

        lblId.setText("ID:");
        pnlPodaci.add(lblId);

        txtId.setColumns(20);
        pnlPodaci.add(txtId);

        lblIme.setText("Ime:");
        pnlPodaci.add(lblIme);

        txtIme.setColumns(20);
        pnlPodaci.add(txtIme);

        lblPrezime.setText("Prezime:");
        pnlPodaci.add(lblPrezime);

        txtPrezime.setColumns(20);
        pnlPodaci.add(txtPrezime);

        lblEmail.setText("Email adresa:");
        pnlPodaci.add(lblEmail);

        txtEmail.setColumns(20);
        pnlPodaci.add(txtEmail);

        lblTelefon.setText("Kontakt telefon:");
        pnlPodaci.add(lblTelefon);

        txtTelefon.setColumns(20);
        pnlPodaci.add(txtTelefon);

        lblStatus.setText("Status:");
        pnlPodaci.add(lblStatus);
        pnlPodaci.add(cmbStatus);

        getContentPane().add(pnlPodaci, java.awt.BorderLayout.CENTER);

        pnlDugmad.setBackground(new java.awt.Color(51, 204, 255));

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSacuvaj.setText("SAČUVAJ");
        btnSacuvaj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        pnlDugmad.add(btnSacuvaj);

        getContentPane().add(pnlDugmad, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTextField getTxtId() { return txtId; }
    public javax.swing.JTextField getTxtIme() { return txtIme; }
    public javax.swing.JTextField getTxtPrezime() { return txtPrezime; }
    public javax.swing.JTextField getTxtEmail() { return txtEmail; }
    public javax.swing.JTextField getTxtTelefon() { return txtTelefon; }
    public javax.swing.JComboBox<domen.Status> getCmbStatus() { return cmbStatus; }
    public javax.swing.JButton getBtnSacuvaj() { return btnSacuvaj; }
   
    public void addSacuvajListener(ActionListener listener) { btnSacuvaj.addActionListener(listener); }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<domen.Status> cmbStatus;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JPanel pnlDugmad;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
