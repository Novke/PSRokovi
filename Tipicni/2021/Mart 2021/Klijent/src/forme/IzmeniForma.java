/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Reprezentacija;
import domen.Utakmica;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class IzmeniForma extends javax.swing.JDialog {

    Utakmica u;

    /**
     * Creates new form IzmeniForma
     */
    public IzmeniForma(java.awt.Frame parent, boolean modal, Utakmica u) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.u = u;
        popuniReprezentacije();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbGrupa = new javax.swing.JComboBox<>();
        cmbDomacin = new javax.swing.JComboBox();
        cmbGost = new javax.swing.JComboBox();
        txtBrojGolovaDomacina = new javax.swing.JFormattedTextField();
        txtBrojGolovaGosta = new javax.swing.JFormattedTextField();
        btnIzmeni = new javax.swing.JButton();
        btnIzmeni1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Grupa:");

        jLabel2.setText("Domacin:");

        jLabel3.setText("Gost:");

        jLabel4.setText("Broj golova domacina:");

        jLabel5.setText("Broj golova gosta:");

        cmbGrupa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F" }));

        cmbDomacin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbGost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtBrojGolovaDomacina.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        txtBrojGolovaGosta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btnIzmeni.setText("Izmeni utakmicu");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnIzmeni1.setText("Otkazi");
        btnIzmeni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeni1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIzmeni1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbGost, 0, 263, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbGrupa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDomacin, 0, 263, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtBrojGolovaDomacina)
                            .addComponent(txtBrojGolovaGosta))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbDomacin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbGost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBrojGolovaDomacina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrojGolovaGosta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIzmeni)
                    .addComponent(btnIzmeni1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeni1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnIzmeni1ActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        if (txtBrojGolovaDomacina.getText().isEmpty() || txtBrojGolovaGosta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Broj golova domacina i gosta moraju biti popunjeni!");
            return;
        }

        String grupa = (String) cmbGrupa.getSelectedItem();
        Reprezentacija domacin = (Reprezentacija) cmbDomacin.getSelectedItem();
        Reprezentacija gost = (Reprezentacija) cmbGost.getSelectedItem();
        int brojGolovaDomacina = Integer.parseInt(txtBrojGolovaDomacina.getText());
        int brojGolovaGosta = Integer.parseInt(txtBrojGolovaGosta.getText());

        if (domacin.getReprezentacijaID() == gost.getReprezentacijaID()) {
            JOptionPane.showMessageDialog(this, "Domacin i gost moraju biti razliciti!");
            return;
        }

        KlijentskaForma kf = (KlijentskaForma) getParent();
        
        // ovu validaciju smo izvrsili pre menjanja utakmice
        // zbog toga sto se utakmica nalazi na odredjenoj memorijskoj
        // lokaciji, pa ako uradimo ovaj u.set sto je ispod validacije
        // on ce tu utakmicu uvek izmeniti
        boolean uspesno = kf.validiraj(u.getUtakmicaID(), domacin, gost);

        if (!uspesno) {
            JOptionPane.showMessageDialog(this, "Vec postoji par " + domacin
                    + " - " + gost + " !");
            return;
        }

        u.setGrupa(grupa);
        u.setDomacin(domacin);
        u.setGost(gost);
        u.setGolovaDomacin(brojGolovaDomacina);
        u.setGolovaGost(brojGolovaGosta);

        kf.izmeniUtakmicu(u);
        this.dispose();

    }//GEN-LAST:event_btnIzmeniActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnIzmeni1;
    private javax.swing.JComboBox cmbDomacin;
    private javax.swing.JComboBox cmbGost;
    private javax.swing.JComboBox<String> cmbGrupa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JFormattedTextField txtBrojGolovaDomacina;
    private javax.swing.JFormattedTextField txtBrojGolovaGosta;
    // End of variables declaration//GEN-END:variables

    private void popuniReprezentacije() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.POPUNI_REPREZENTACIJE);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        ArrayList<Reprezentacija> reprezentacije = (ArrayList<Reprezentacija>) so.getOdgovor();

        cmbDomacin.removeAllItems();
        cmbGost.removeAllItems();

        for (Reprezentacija reprezentacija : reprezentacije) {
            cmbDomacin.addItem(reprezentacija);
            cmbGost.addItem(reprezentacija);
        }

    }
}
