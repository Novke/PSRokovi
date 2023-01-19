/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Intervencija;
import domen.StambenaZajednica;
import domen.VrstaIntervencije;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author PC
 */
public class DodajForma extends javax.swing.JDialog {

    /**
     * Creates new form DodajForma
     */
    public DodajForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        rbNe.setSelected(true);
        popuniStambeneZajednice();
        popuniVrsteIntervencija();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbStambenaZajednica = new javax.swing.JComboBox();
        cmbVrstaIntervencije = new javax.swing.JComboBox();
        txtDatumVremePocetka = new javax.swing.JFormattedTextField();
        txtDatumVremeZavrsetka = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        txtCena = new javax.swing.JFormattedTextField();
        rbDa = new javax.swing.JRadioButton();
        rbNe = new javax.swing.JRadioButton();
        cmbStatus = new javax.swing.JComboBox<>();
        btnDodaj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Stambena zajednica:");

        jLabel2.setText("Vrsta intervencije:");

        jLabel3.setText("Datum i vreme pocetka:");

        jLabel4.setText("Datum i vreme zavrsetka:");

        jLabel5.setText("Opis:");

        jLabel6.setText("Cena:");

        jLabel7.setText("Angaz. izvodjaca radova:");

        jLabel8.setText("Status:");

        cmbStambenaZajednica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbVrstaIntervencije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDatumVremePocetka.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumVremePocetka.setText("10.10.2020 10:00");

        txtDatumVremeZavrsetka.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumVremeZavrsetka.setText("15.10.2020 12:00");

        txtOpis.setColumns(20);
        txtOpis.setRows(5);
        txtOpis.setText("Poz od Arija");
        jScrollPane1.setViewportView(txtOpis);

        txtCena.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCena.setText("10000");

        rbDa.setText("Da");
        rbDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDaActionPerformed(evt);
            }
        });

        rbNe.setText("Ne");
        rbNe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNeActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktivna", "Ceka", "Zavrsena" }));

        btnDodaj.setText("Dodaj intervenciju");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStambenaZajednica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumVremePocetka)
                            .addComponent(txtDatumVremeZavrsetka)
                            .addComponent(cmbVrstaIntervencije, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(txtCena)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbDa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNe)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbStambenaZajednica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbVrstaIntervencije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatumVremePocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDatumVremeZavrsetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbDa)
                    .addComponent(rbNe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnOtkazi))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDaActionPerformed
        rbDa.setSelected(true);
        rbNe.setSelected(false);
    }//GEN-LAST:event_rbDaActionPerformed

    private void rbNeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNeActionPerformed
        rbNe.setSelected(true);
        rbDa.setSelected(false);
    }//GEN-LAST:event_rbNeActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        if (txtOpis.getText().isEmpty() || txtCena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Opis i cena moraju biti popunjeni!");
            return;
        }

        try {
            StambenaZajednica sz = (StambenaZajednica) cmbStambenaZajednica.getSelectedItem();
            VrstaIntervencije vi = (VrstaIntervencije) cmbVrstaIntervencije.getSelectedItem();

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

            Date datumVremePocetka;
            Date datumVremeZavrsetka;

            if (txtDatumVremePocetka.getText().isEmpty()) {
                datumVremePocetka = null;
            } else {
                datumVremePocetka = sdf.parse(txtDatumVremePocetka.getText());
            }

            if (txtDatumVremeZavrsetka.getText().isEmpty()) {
                datumVremeZavrsetka = null;
            } else {
                datumVremeZavrsetka = sdf.parse(txtDatumVremeZavrsetka.getText());
            }

            if (datumVremePocetka != null && datumVremeZavrsetka != null) {
                if (datumVremePocetka.after(datumVremeZavrsetka)) {
                    JOptionPane.showMessageDialog(this, "Datum i vreme zavrsetka mora biti "
                            + "posle datuma i vremena pocetka!");
                    return;
                }
            }

            String opis = txtOpis.getText();
            double cena = Double.parseDouble(txtCena.getText());
            boolean izvodjacRadova = rbDa.isSelected();
            String status = (String) cmbStatus.getSelectedItem();

            if (status.equals("Zavrsena")) {
                if (datumVremeZavrsetka == null) {
                    JOptionPane.showMessageDialog(this, "Ukoliko je status 'Zavrsena', "
                            + "datum i vreme zavrsetka je obavezno polje!");
                    return;
                }
            }

            Intervencija i = new Intervencija(-1, datumVremePocetka,
                    datumVremeZavrsetka, opis, izvodjacRadova, cena, status, vi, sz, null);

            KlijentskaForma kf = (KlijentskaForma) getParent();
            kf.dodajIntervenciju(i);
            this.dispose();

        } catch (ParseException ex) {
            Logger.getLogger(DodajForma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDodajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DodajForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DodajForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DodajForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DodajForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DodajForma dialog = new DodajForma(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JComboBox cmbStambenaZajednica;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox cmbVrstaIntervencije;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDa;
    private javax.swing.JRadioButton rbNe;
    private javax.swing.JFormattedTextField txtCena;
    private javax.swing.JFormattedTextField txtDatumVremePocetka;
    private javax.swing.JFormattedTextField txtDatumVremeZavrsetka;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration//GEN-END:variables

    private void popuniStambeneZajednice() {

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_STAMBENE_ZAJEDNICE);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        ArrayList<StambenaZajednica> stambeneZajednice = (ArrayList<StambenaZajednica>) so.getOdgovor();

        cmbStambenaZajednica.removeAllItems();

        for (StambenaZajednica stambenaZajednica : stambeneZajednice) {
            cmbStambenaZajednica.addItem(stambenaZajednica);
        }

    }

    private void popuniVrsteIntervencija() {

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_VRSTE_INTERVENCIJA);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        ArrayList<VrstaIntervencije> vrsteIntervencija = (ArrayList<VrstaIntervencije>) so.getOdgovor();

        cmbVrstaIntervencije.removeAllItems();

        for (VrstaIntervencije vrstaIntervencije : vrsteIntervencija) {
            cmbVrstaIntervencije.addItem(vrstaIntervencije);
        }

    }
}
