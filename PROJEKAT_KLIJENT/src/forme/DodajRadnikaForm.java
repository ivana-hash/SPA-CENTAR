package forme;

import java.awt.event.ActionListener;

public class DodajRadnikaForm extends javax.swing.JFrame {

    public DodajRadnikaForm() {
        initComponents();
        setSize(600, 500);
        setLocationRelativeTo(null);
          txtDatumZaposlenja.setToolTipText("Unesite datum zaposlenja u formatu: dd.MM.yyyy.");
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
        lblDatumZaposlenja = new javax.swing.JLabel();
        txtDatumZaposlenja = new javax.swing.JTextField();
        lblPozicija = new javax.swing.JLabel();
        txtPozicija = new javax.swing.JTextField();
        lblKorisnickoIme = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        lblSifra = new javax.swing.JLabel();
        PfSifra = new javax.swing.JPasswordField();
        pnlDugmad = new javax.swing.JPanel();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Radnik");

        pnlPodaci.setBackground(new java.awt.Color(204, 204, 255));
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

        lblDatumZaposlenja.setText("Datum zaposlenja:");
        pnlPodaci.add(lblDatumZaposlenja);

        txtDatumZaposlenja.setColumns(20);
        pnlPodaci.add(txtDatumZaposlenja);

        lblPozicija.setText("Pozicija:");
        pnlPodaci.add(lblPozicija);

        txtPozicija.setColumns(20);
        pnlPodaci.add(txtPozicija);

        lblKorisnickoIme.setText("Korisničko ime:");
        pnlPodaci.add(lblKorisnickoIme);

        txtKorisnickoIme.setColumns(20);
        pnlPodaci.add(txtKorisnickoIme);

        lblSifra.setText("Šifra:");
        pnlPodaci.add(lblSifra);
        pnlPodaci.add(PfSifra);

        getContentPane().add(pnlPodaci, java.awt.BorderLayout.CENTER);

        pnlDugmad.setBackground(new java.awt.Color(255, 102, 255));
        pnlDugmad.setForeground(new java.awt.Color(255, 153, 255));

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSacuvaj.setText("SAČUVAJ");
        btnSacuvaj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 153), 3, true));
        pnlDugmad.add(btnSacuvaj);

        getContentPane().add(pnlDugmad, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTextField getTxtId() { return txtId; }
    public javax.swing.JTextField getTxtIme() { return txtIme; }
    public javax.swing.JTextField getTxtPrezime() { return txtPrezime; }
    public javax.swing.JTextField getTxtDatumZaposlenja() { return txtDatumZaposlenja; }
    public javax.swing.JTextField getTxtPozicija() { return txtPozicija; }
    public javax.swing.JTextField getTxtKorisnickoIme() { return txtKorisnickoIme; }
    public javax.swing.JPasswordField getPffSifra(){return PfSifra;}
    public javax.swing.JButton getBtnSacuvaj() { return btnSacuvaj; }

    public void addSacuvajListener(ActionListener listener) { btnSacuvaj.addActionListener(listener); }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PfSifra;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel lblDatumZaposlenja;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblKorisnickoIme;
    private javax.swing.JLabel lblPozicija;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblSifra;
    private javax.swing.JPanel pnlDugmad;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JTextField txtDatumZaposlenja;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JTextField txtPozicija;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables
}
