package forme;

import java.awt.event.ActionListener;

public class DodajStatusForm extends javax.swing.JFrame {

    public DodajStatusForm() {
        initComponents();
        setSize(520, 380);
        setLocationRelativeTo(null);
          txtDatumPostizanja.setToolTipText("Unesite datum postizanja u formatu: dd.MM.yyyy.");
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPodaci = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblDatumPostizanja = new javax.swing.JLabel();
        txtDatumPostizanja = new javax.swing.JTextField();
        lblPogodnosti = new javax.swing.JLabel();
        scrPogodnosti = new javax.swing.JScrollPane();
        txtPogodnosti = new javax.swing.JTextArea();
        pnlDugmad = new javax.swing.JPanel();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Status");

        pnlPodaci.setBackground(new java.awt.Color(255, 255, 153));
        pnlPodaci.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 20));
        pnlPodaci.setLayout(new java.awt.GridLayout(0, 2, 8, 8));

        lblId.setText("ID:");
        pnlPodaci.add(lblId);

        txtId.setColumns(20);
        pnlPodaci.add(txtId);

        lblNaziv.setText("Naziv:");
        pnlPodaci.add(lblNaziv);

        txtNaziv.setColumns(20);
        pnlPodaci.add(txtNaziv);

        lblDatumPostizanja.setText("Datum postizanja:");
        pnlPodaci.add(lblDatumPostizanja);

        txtDatumPostizanja.setColumns(20);
        pnlPodaci.add(txtDatumPostizanja);

        lblPogodnosti.setText("Pogodnosti:");
        pnlPodaci.add(lblPogodnosti);

        txtPogodnosti.setColumns(20);
        txtPogodnosti.setRows(5);
        txtPogodnosti.setLineWrap(true);
        txtPogodnosti.setWrapStyleWord(true);
        scrPogodnosti.setViewportView(txtPogodnosti);

        pnlPodaci.add(scrPogodnosti);

        getContentPane().add(pnlPodaci, java.awt.BorderLayout.CENTER);

        pnlDugmad.setBackground(new java.awt.Color(204, 204, 255));

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSacuvaj.setText("SAČUVAJ");
        btnSacuvaj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 255), 3, true));
        pnlDugmad.add(btnSacuvaj);

        getContentPane().add(pnlDugmad, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTextField getTxtId() { return txtId; }
    public javax.swing.JTextField getTxtNaziv() { return txtNaziv; }
    public javax.swing.JTextField getTxtDatumPostizanja() { return txtDatumPostizanja; }
    public javax.swing.JTextArea getTxtPogodnosti() { return txtPogodnosti; }
    public javax.swing.JButton getBtnSacuvaj() { return btnSacuvaj; }
  
    public void addSacuvajListener(ActionListener listener) { btnSacuvaj.addActionListener(listener); }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel lblDatumPostizanja;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblPogodnosti;
    private javax.swing.JPanel pnlDugmad;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JScrollPane scrPogodnosti;
    private javax.swing.JTextField txtDatumPostizanja;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextArea txtPogodnosti;
    // End of variables declaration//GEN-END:variables
}
