package forme;

import java.awt.event.ActionListener;

public class DodajTretmanForm extends javax.swing.JFrame {

    public DodajTretmanForm() {
        initComponents();
        setSize(520, 410);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPodaci = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        lblCena = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        lblTrajanje = new javax.swing.JLabel();
        txtTrajanje = new javax.swing.JTextField();
        lblBenefiti = new javax.swing.JLabel();
        scrBenefiti = new javax.swing.JScrollPane();
        txtBenefiti = new javax.swing.JTextArea();
        pnlDugmad = new javax.swing.JPanel();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tretman");

        pnlPodaci.setBackground(new java.awt.Color(204, 255, 204));
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

        lblCena.setText("Cena:");
        pnlPodaci.add(lblCena);

        txtCena.setColumns(20);
        pnlPodaci.add(txtCena);

        lblTrajanje.setText("Trajanje u minutima:");
        pnlPodaci.add(lblTrajanje);

        txtTrajanje.setColumns(20);
        pnlPodaci.add(txtTrajanje);

        lblBenefiti.setText("Benefiti:");
        pnlPodaci.add(lblBenefiti);

        txtBenefiti.setColumns(20);
        txtBenefiti.setRows(5);
        txtBenefiti.setLineWrap(true);
        txtBenefiti.setWrapStyleWord(true);
        scrBenefiti.setViewportView(txtBenefiti);

        pnlPodaci.add(scrBenefiti);

        getContentPane().add(pnlPodaci, java.awt.BorderLayout.CENTER);

        pnlDugmad.setBackground(new java.awt.Color(0, 204, 204));

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSacuvaj.setText("SAČUVAJ");
        btnSacuvaj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 3, true));
        pnlDugmad.add(btnSacuvaj);

        getContentPane().add(pnlDugmad, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTextField getTxtId() { return txtId; }
    public javax.swing.JTextField getTxtNaziv() { return txtNaziv; }
    public javax.swing.JTextField getTxtCena() { return txtCena; }
    public javax.swing.JTextField getTxtTrajanje() { return txtTrajanje; }
    public javax.swing.JTextArea getTxtBenefiti() { return txtBenefiti; }
    public javax.swing.JButton getBtnSacuvaj() { return btnSacuvaj; }
   
    public void addSacuvajListener(ActionListener listener) { btnSacuvaj.addActionListener(listener); }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel lblBenefiti;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblTrajanje;
    private javax.swing.JPanel pnlDugmad;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JScrollPane scrBenefiti;
    private javax.swing.JTextArea txtBenefiti;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtTrajanje;
    // End of variables declaration//GEN-END:variables
}
