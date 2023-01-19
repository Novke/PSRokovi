/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Kategorija;
import domen.Moderator;
import domen.RasporedSekcije;
import domen.Sekcija;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import modeli.ModelTabeleRadovi;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

public class KlijentskaForma extends javax.swing.JFrame {

    Moderator moderator;

    /**
     * Creates new form Forma1
     */
    public KlijentskaForma(Moderator moderator) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FON Konferencija - Klijentski program");
        this.moderator = moderator;
        popuniKategorije();
        txtModerator.setText(moderator.toString());
        txtModerator.setEditable(false);
        tblRadovi.setModel(new ModelTabeleRadovi());
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
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRadovi = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();
        cmbNadredjenaKategorija = new javax.swing.JComboBox();
        cmbPotkategorija = new javax.swing.JComboBox();
        txtNazivSekcije = new javax.swing.JTextField();
        txtDatumVremeOd = new javax.swing.JFormattedTextField();
        txtDatumVremeDo = new javax.swing.JFormattedTextField();
        txtSala = new javax.swing.JTextField();
        txtModerator = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos sekcije"));

        jLabel1.setText("Kategorija:");

        jLabel2.setText("Potkategorija:");

        jLabel3.setText("Naziv sekcije:");

        jLabel4.setText("Datum i vreme od:");

        jLabel5.setText("Datum i vreme do:");

        jLabel6.setText("Sala:");

        jLabel7.setText("Moderator:");

        btnDodaj.setText("Dodaj rad u raspored");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi rad iz rasporeda");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        tblRadovi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRadovi);

        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSacuvaj.setText("Sacuvaj sekciju");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        cmbNadredjenaKategorija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbNadredjenaKategorija.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNadredjenaKategorijaItemStateChanged(evt);
            }
        });

        cmbPotkategorija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNazivSekcije.setText("Brutalna sekcija");

        txtDatumVremeOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumVremeOd.setText("10.10.2020 10:00");

        txtDatumVremeDo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
        txtDatumVremeDo.setText("10.10.2020 15:00");

        txtSala.setText("Sala 1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(79, 79, 79)
                        .addComponent(cmbNadredjenaKategorija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(63, 63, 63)
                        .addComponent(cmbPotkategorija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(64, 64, 64)
                        .addComponent(txtNazivSekcije))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatumVremeOd)
                            .addComponent(txtDatumVremeDo)
                            .addComponent(txtSala)
                            .addComponent(txtModerator)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbNadredjenaKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbPotkategorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNazivSekcije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDatumVremeOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDatumVremeDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtModerator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbNadredjenaKategorijaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNadredjenaKategorijaItemStateChanged

        // ovde sam morao ovaj if da uradim jer se u initComponents()
        // odmah pozove ova metoda pa zato baca null pointer
        // dakle prvo mora da se popuni comboBox, pa onda moze da radi
        if (cmbNadredjenaKategorija.getSelectedItem() != null) {
            Kategorija nadKategorija = (Kategorija) cmbNadredjenaKategorija.getSelectedItem();
            popuniPotkategorije(nadKategorija);
        }


    }//GEN-LAST:event_cmbNadredjenaKategorijaItemStateChanged

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int row = tblRadovi.getSelectedRow();

        if (row >= 0) {
            ModelTabeleRadovi mt = (ModelTabeleRadovi) tblRadovi.getModel();
            mt.obrisiRad(row);
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        new DodajRadForma(this, true).setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        if(txtNazivSekcije.getText().isEmpty() || txtSala.getText().isEmpty()
                || txtDatumVremeOd.getText().isEmpty() || txtDatumVremeDo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
            return;
        }
        
        try {
            Kategorija potkategorija = (Kategorija) cmbPotkategorija.getSelectedItem();
            String nazivSekcije = txtNazivSekcije.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date datumVremeOd = sdf.parse(txtDatumVremeOd.getText());
            Date datumVremeDo = sdf.parse(txtDatumVremeDo.getText());
            String sala = txtSala.getText();
            ModelTabeleRadovi mt = (ModelTabeleRadovi) tblRadovi.getModel();
            
            if(mt.getLista().isEmpty()){
                JOptionPane.showMessageDialog(this, "U sekciji mora postojati barem jedan rad!");
                return;
            }
            
            // NISAM URADIO DVE VALIDACIJE, A TO SU DA NAZIV SEKCIJE MORA BITI JEDNISTVEN
            // I DA U JEDNOJ SALI U JEDNOM TERMINU MOZE DA SE IZVODI SAMO JEDNA SEKCIJA
            // TREBA DA SE SALJE ZAHTEV SERVERU I PROVERE TE DVE STVARI, ODNOSNO 
            // UPOREDILI BISMO SEKCIJU S DRUGIM SEKCIJAMA IZ BAZE, ALI TO NISAM URADIO OVDE
            // JER BI PREPLAVILO KOD, BITNIJE SU VAM OVE OSTALE STVARI

            Sekcija s = new Sekcija(-1, nazivSekcije, datumVremeOd, datumVremeDo,
                    sala, moderator.getUsername(), potkategorija, mt.getLista());

            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.SACUVAJ_SEKCIJU);
            kz.setParametar(s);

            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

            boolean uspesno = (boolean) so.getOdgovor();
            
            if (uspesno) {
                JOptionPane.showMessageDialog(this, "Uspesno sacuvana sekcija!");
            } else {
                JOptionPane.showMessageDialog(this, "Doslo je do greske...");
            }

        } catch (ParseException ex) {
            Logger.getLogger(KlijentskaForma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbNadredjenaKategorija;
    private javax.swing.JComboBox cmbPotkategorija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRadovi;
    private javax.swing.JFormattedTextField txtDatumVremeDo;
    private javax.swing.JFormattedTextField txtDatumVremeOd;
    private javax.swing.JTextField txtModerator;
    private javax.swing.JTextField txtNazivSekcije;
    private javax.swing.JTextField txtSala;
    // End of variables declaration//GEN-END:variables

    private void popuniKategorije() {

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_NADREDJENE_KATEGORIJE);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        ArrayList<Kategorija> kategorije = (ArrayList<Kategorija>) so.getOdgovor();

        cmbNadredjenaKategorija.removeAllItems();

        for (Kategorija kategorija : kategorije) {
            cmbNadredjenaKategorija.addItem(kategorija);
        }

    }

    private void popuniPotkategorije(Kategorija nadKategorija) {

        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_POTKATEGORIJE);
        kz.setParametar(nadKategorija);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        ArrayList<Kategorija> potkategorije = (ArrayList<Kategorija>) so.getOdgovor();

        cmbPotkategorija.removeAllItems();

        for (Kategorija kategorija : potkategorije) {
            cmbPotkategorija.addItem(kategorija);
        }

    }

    void dodajRad(RasporedSekcije rs) {
        ModelTabeleRadovi mt = (ModelTabeleRadovi) tblRadovi.getModel();
        
        if(mt.postojiRad(rs.getRad())){
            JOptionPane.showMessageDialog(this, "Vec postoji ovaj rad u ovoj sekciji!");
            return;
        }
        
        mt.dodajRad(rs);
    }
}