package forme;

import java.awt.event.ActionListener;

public class DodajKvalifikacijuForm extends javax.swing.JFrame {

    public DodajKvalifikacijuForm() {
        initComponents();
        setSize(500, 350);
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
        lblOpis = new javax.swing.JLabel();
        scrOpis = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        pnlDugmad = new javax.swing.JPanel();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kvalifikacija");

        pnlPodaci.setBackground(new java.awt.Color(255, 153, 153));
        pnlPodaci.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 20));
        pnlPodaci.setLayout(new java.awt.GridLayout(0, 2, 8, 8));

        lblId.setBackground(new java.awt.Color(204, 255, 204));
        lblId.setText("ID:");
        pnlPodaci.add(lblId);

        txtId.setColumns(20);
        pnlPodaci.add(txtId);

        lblNaziv.setText("Naziv:");
        pnlPodaci.add(lblNaziv);

        txtNaziv.setColumns(20);
        pnlPodaci.add(txtNaziv);

        lblOpis.setBackground(new java.awt.Color(204, 255, 153));
        lblOpis.setText("Opis:");
        pnlPodaci.add(lblOpis);

        txtOpis.setColumns(20);
        txtOpis.setRows(5);
        txtOpis.setLineWrap(true);
        txtOpis.setWrapStyleWord(true);
        scrOpis.setViewportView(txtOpis);

        pnlPodaci.add(scrOpis);

        getContentPane().add(pnlPodaci, java.awt.BorderLayout.CENTER);

        pnlDugmad.setBackground(new java.awt.Color(204, 255, 153));

        btnSacuvaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSacuvaj.setText("SAČUVAJ");
        btnSacuvaj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 3, true));
        pnlDugmad.add(btnSacuvaj);

        getContentPane().add(pnlDugmad, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTextField getTxtId() { return txtId; }
    public javax.swing.JTextField getTxtNaziv() { return txtNaziv; }
    public javax.swing.JTextArea getTxtOpis() { return txtOpis; }
    public javax.swing.JButton getBtnSacuvaj() { return btnSacuvaj; }
    
    public void addSacuvajListener(ActionListener listener) { btnSacuvaj.addActionListener(listener); }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JPanel pnlDugmad;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JScrollPane scrOpis;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration//GEN-END:variables
}
