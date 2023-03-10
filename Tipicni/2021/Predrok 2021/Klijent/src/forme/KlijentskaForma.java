/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Aerodrom;
import domen.Interkonekcija;
import domen.Let;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import modeli.ModelTabeleKlijent;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class KlijentskaForma extends javax.swing.JFrame {

    /**
     * Creates new form Forma1
     */
    public KlijentskaForma() {
        initComponents();
        setLocationRelativeTo(null);
        popuniAerodrome();
        rbNe.setSelected(true);
        tblInterkonekcije.setModel(new ModelTabeleKlijent());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbPocetni = new javax.swing.JComboBox();
        cmbKrajnji = new javax.swing.JComboBox();
        cmbTipAviona = new javax.swing.JComboBox();
        txtDatumPocetka = new javax.swing.JFormattedTextField();
        txtDatumKraja = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        rbDa = new javax.swing.JRadioButton();
        rbNe = new javax.swing.JRadioButton();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInterkonekcije = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos leta"));

        jLabel1.setText("Pocetni aerodrom:");

        jLabel2.setText("Krajnji aerodrom:");

        jLabel3.setText("Tip aviona:");

        jLabel4.setText("Datum i vreme pocetka leta:");

        jLabel5.setText("Datum i vreme kraja leta:");

        jLabel6.setText("Opis:");

        jLabel7.setText("Redovan let:");

        cmbPocetni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbKrajnji.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTipAviona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boeing", "Airbus", "ATR", "Sukhoi", "Embraer" }));

        txtDatumPocetka.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumPocetka.setText("10.10.2020 13:00");

        txtDatumKraja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumKraja.setText("12.10.2020 17:00");

        txtOpis.setColumns(20);
        txtOpis.setRows(5);
        txtOpis.setText("Safe flight!");
        jScrollPane1.setViewportView(txtOpis);

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

        btnDodaj.setText("Dodaj interkonekciju");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi interkonekciju");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        tblInterkonekcije.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblInterkonekcije);

        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSacuvaj.setText("Sacuvaj let");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipAviona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKrajnji, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumPocetka)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPocetni, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumKraja)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbDa)
                                .addGap(18, 18, 18)
                                .addComponent(rbNe)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnDodaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisi)
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbPocetni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKrajnji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipAviona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumKraja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbDa)
                        .addComponent(rbNe)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        DodajForma d = new DodajForma(this, true);
        d.setVisible(true);

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int selectedRow = tblInterkonekcije.getSelectedRow();

        if (selectedRow >= 0) {
            ModelTabeleKlijent mt = (ModelTabeleKlijent) tblInterkonekcije.getModel();
            mt.obrisiInterkonekciju(selectedRow);
        }


    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        if (txtDatumKraja.getText().isEmpty() || txtDatumPocetka.getText().isEmpty()
                || txtOpis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
            return;
        }

        Aerodrom pocetniAerodrom = (Aerodrom) cmbPocetni.getSelectedItem();
        Aerodrom krajnjiAerodrom = (Aerodrom) cmbKrajnji.getSelectedItem();

        if (pocetniAerodrom.equals(krajnjiAerodrom)) {
            JOptionPane.showMessageDialog(this, "Pocetni i krajnji aerodromi "
                    + "moraju biti razliciti!");
            return;
        }

        String tipAviona = (String) cmbTipAviona.getSelectedItem();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        try {
            Date datumVremePocetka = sdf.parse(txtDatumPocetka.getText());
            Date datumVremeKraja = sdf.parse(txtDatumKraja.getText());

            if (datumVremePocetka.after(datumVremeKraja)) {
                JOptionPane.showMessageDialog(this, "Pocetak leta mora biti pre kraja leta!");
                return;
            }

            String opis = txtOpis.getText();
            boolean redovanLet = rbDa.isSelected();

            ModelTabeleKlijent mt = (ModelTabeleKlijent) tblInterkonekcije.getModel();
            ArrayList<Interkonekcija> interkonekcije = mt.getLista();

            if (interkonekcije.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Let mora imati barem jednu interkonekciju!");
                return;
            }

            for (Interkonekcija i : interkonekcije) {

                if (i.getAerodrom().getAerodromID() == pocetniAerodrom.getAerodromID()
                        || i.getAerodrom().getAerodromID() == krajnjiAerodrom.getAerodromID()) {
                    JOptionPane.showMessageDialog(this, "Interkonektni aerodromi moraju "
                            + "biti razliciti od pocetnog i krajnjeg!");
                    return;
                }

                if (i.getDatumVremeLeta().before(datumVremePocetka)
                        || i.getDatumVremeLeta().after(datumVremeKraja)) {
                    JOptionPane.showMessageDialog(this, "Datumi interkonekcije leta moraju "
                            + "biti posle pocetnog i pre krajnjeg datuma!");
                    return;
                }

            }

            Let let = new Let(-1, datumVremePocetka, datumVremeKraja,
                    opis, tipAviona, redovanLet, pocetniAerodrom, krajnjiAerodrom, interkonekcije);

            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.SACUVAJ_LET);
            kz.setParametar(let);

            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            boolean uspesno = (boolean) so.getOdgovor();
            
            if (uspesno) {
                JOptionPane.showMessageDialog(this, "Uspesno sacuvano!");
            } else {
                JOptionPane.showMessageDialog(this, "Greska pri cuvanju...");
            }

        } catch (ParseException ex) {
            Logger.getLogger(KlijentskaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void rbDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDaActionPerformed
        rbDa.setSelected(true);
        rbNe.setSelected(false);
    }//GEN-LAST:event_rbDaActionPerformed

    private void rbNeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNeActionPerformed
        rbNe.setSelected(true);
        rbDa.setSelected(false);
    }//GEN-LAST:event_rbNeActionPerformed

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
            java.util.logging.Logger.getLogger(KlijentskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KlijentskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KlijentskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KlijentskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KlijentskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbKrajnji;
    private javax.swing.JComboBox cmbPocetni;
    private javax.swing.JComboBox cmbTipAviona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbDa;
    private javax.swing.JRadioButton rbNe;
    private javax.swing.JTable tblInterkonekcije;
    private javax.swing.JFormattedTextField txtDatumKraja;
    private javax.swing.JFormattedTextField txtDatumPocetka;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration//GEN-END:variables

    private void popuniAerodrome() {

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_AERODROME);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        ArrayList<Aerodrom> aerodromi = (ArrayList<Aerodrom>) so.getOdgovor();

        cmbPocetni.removeAllItems();
        cmbKrajnji.removeAllItems();

        for (Aerodrom aerodrom : aerodromi) {
            cmbPocetni.addItem(aerodrom);
            cmbKrajnji.addItem(aerodrom);
        }

    }

    void dodajInterkonekciju(Aerodrom aerodrom, Date datumVremeLeta) {

        ModelTabeleKlijent mt = (ModelTabeleKlijent) tblInterkonekcije.getModel();
        
        if(mt.postojiAerodrom(aerodrom)){
            JOptionPane.showMessageDialog(this, "Vec ste uneli interkonekciju za taj aerodrom!");
            return;
        }
        
        mt.dodajInterkonekciju(aerodrom, datumVremeLeta);

    }

}
