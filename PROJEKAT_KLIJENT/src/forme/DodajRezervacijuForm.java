package forme;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class DodajRezervacijuForm extends javax.swing.JFrame {

    public DodajRezervacijuForm() {
        initComponents();
        setSize(930, 650);
        setLocationRelativeTo(null);
           txtDatumKreiranja.setToolTipText("Unesite datum kreiranja u formatu: dd.MM.yyyy.");
  
         ImageIcon originalDodaj = new ImageIcon(getClass().getResource("/slike/dodajstavku.png"));
        Image slikaDodaj = originalDodaj.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnDodajStavku.setIcon(new ImageIcon(slikaDodaj));
         
         ImageIcon originalUkloni= new ImageIcon(getClass().getResource("/slike/ukloni.jpg"));
         Image slikaUkloni = originalUkloni.getImage().getScaledInstance(
        30, 30,
        Image.SCALE_SMOOTH
);
        btnObrisiStavku.setIcon(new ImageIcon(slikaUkloni));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPodaci = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblDatumKreiranja = new javax.swing.JLabel();
        txtDatumKreiranja = new javax.swing.JTextField();
        lblRadnik = new javax.swing.JLabel();
        txtRadnik = new javax.swing.JTextField();
        lblKlijent = new javax.swing.JLabel();
        cmbKlijent = new javax.swing.JComboBox<>();
        lblUkupanIznos = new javax.swing.JLabel();
        txtUkupanIznos = new javax.swing.JTextField();
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
        scrStavke = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        pnlDugmad = new javax.swing.JPanel();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rezervacija");

        pnlPodaci.setBackground(new java.awt.Color(204, 255, 255));
        pnlPodaci.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PODACI O REZERVACIJI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 255, 255))); // NOI18N
        pnlPodaci.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pnlPodaci.setLayout(new java.awt.GridLayout(0, 2, 8, 8));

        lblId.setText("ID:");
        pnlPodaci.add(lblId);

        txtId.setColumns(18);
        pnlPodaci.add(txtId);

        lblDatumKreiranja.setText("Datum kreiranja:");
        pnlPodaci.add(lblDatumKreiranja);

        txtDatumKreiranja.setColumns(18);
        pnlPodaci.add(txtDatumKreiranja);

        lblRadnik.setText("Radnik:");
        pnlPodaci.add(lblRadnik);

        txtRadnik.setColumns(18);
        txtRadnik.setEditable(false);
        pnlPodaci.add(txtRadnik);

        lblKlijent.setText("Klijent:");
        pnlPodaci.add(lblKlijent);
        pnlPodaci.add(cmbKlijent);

        lblUkupanIznos.setText("Ukupan iznos:");
        pnlPodaci.add(lblUkupanIznos);

        txtUkupanIznos.setColumns(18);
        txtUkupanIznos.setEditable(false);
        pnlPodaci.add(txtUkupanIznos);

        getContentPane().add(pnlPodaci, java.awt.BorderLayout.NORTH);
        pnlPodaci.getAccessibleContext().setAccessibleName("PODACI O REZERVACIJI");

        pnlStavke.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STAVKE REZERVACIJE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 153, 255))); // NOI18N
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

        pnlStavke.add(pnlUnosStavke, java.awt.BorderLayout.NORTH);

        tblStavke.setBackground(new java.awt.Color(102, 204, 255));
        scrStavke.setViewportView(tblStavke);

        pnlStavke.add(scrStavke, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlStavke, java.awt.BorderLayout.CENTER);

        pnlDugmad.setBackground(new java.awt.Color(255, 255, 204));
        pnlDugmad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, new java.awt.Color(255, 255, 0), java.awt.Color.yellow, java.awt.Color.yellow));

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSacuvaj.setText("SAČUVAJ");
        btnSacuvaj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 3, true));
        pnlDugmad.add(btnSacuvaj);

        getContentPane().add(pnlDugmad, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTextField getTxtId() { return txtId; }
    public javax.swing.JTextField getTxtDatumKreiranja() { return txtDatumKreiranja; }
    public javax.swing.JTextField getTxtRadnik() { return txtRadnik; }
    public javax.swing.JComboBox<domen.Klijent> getCmbKlijent() { return cmbKlijent; }
    public javax.swing.JTextField getTxtUkupanIznos() { return txtUkupanIznos; }
    public javax.swing.JComboBox<domen.Tretman> getCmbTretman() { return cmbTretman; }
    public javax.swing.JTextField getTxtCena() { return txtCena; }
    public javax.swing.JTextField getTxtBrojPaketa() { return txtBrojPaketa; }
    public javax.swing.JTable getTblStavke() { return tblStavke; }
    public javax.swing.JButton getBtnSacuvaj() { return btnSacuvaj; }

    public void addSacuvajListener(ActionListener listener) { btnSacuvaj.addActionListener(listener); }
  
    public void addDodajStavkuListener(ActionListener listener) { btnDodajStavku.addActionListener(listener); }
    public void addObrisiStavkuListener(ActionListener listener) { btnObrisiStavku.addActionListener(listener); }
    public void addTretmanListener(ActionListener listener) { cmbTretman.addActionListener(listener); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<domen.Klijent> cmbKlijent;
    private javax.swing.JComboBox<domen.Tretman> cmbTretman;
    private javax.swing.JLabel lblBrojPaketa;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblDatumKreiranja;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblKlijent;
    private javax.swing.JLabel lblRadnik;
    private javax.swing.JLabel lblTretman;
    private javax.swing.JLabel lblUkupanIznos;
    private javax.swing.JPanel pnlDugmad;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JPanel pnlStavke;
    private javax.swing.JPanel pnlUnosStavke;
    private javax.swing.JScrollPane scrStavke;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtBrojPaketa;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtDatumKreiranja;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtRadnik;
    private javax.swing.JTextField txtUkupanIznos;
    // End of variables declaration//GEN-END:variables
}
