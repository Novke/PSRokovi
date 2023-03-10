/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.StavkaIzvestaja;
import domen.Studio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import modeli.ModelTabeleServer;
import niti.OsveziNit;
import niti.PokreniServer;

public class ServerskaForma extends javax.swing.JFrame {

    /**
     * Creates new form ServerskaForma
     */
    public ServerskaForma() {
        initComponents();
        setLocationRelativeTo(null);
        tblIzvestaj.setModel(new ModelTabeleServer());
        OsveziNit on = new OsveziNit(this);
        on.start();
        popuniStudija();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbStudio = new javax.swing.JComboBox();
        txtDatumOd = new javax.swing.JFormattedTextField();
        txtDatumDo = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIzvestaj = new javax.swing.JTable();
        cbStudio = new javax.swing.JCheckBox();
        cbDatumOd = new javax.swing.JCheckBox();
        cbDatumDo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbStudio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDatumOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumOd.setText("10.10.2020");

        txtDatumDo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumDo.setText("15.10.2020");

        tblIzvestaj.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblIzvestaj);

        cbStudio.setText("Studio:");

        cbDatumOd.setText("Datum od:");

        cbDatumDo.setText("Datum do:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbDatumDo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDatumDo, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDatumOd)
                            .addComponent(cbStudio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStudio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumOd))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStudio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDatumOd)
                    .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDatumDo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerskaForma().setVisible(true);
                PokreniServer ps = new PokreniServer();
                ps.start();
            }
        });
    }

    public void izvrsiUpit() {

        ArrayList<StavkaIzvestaja> listaBaza;
        ModelTabeleServer mt = (ModelTabeleServer) tblIzvestaj.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String dodatniUpit = "";

        //NARAVNO, IMA 8 KOMBINACIJA, URADIO SAM SAMO ZA 2 (ako nista nije seletkovano i ako je sve)
        //nisu naveli za datume koje konkretno gledamo, pa sam uradio da datum od bude isti ili veci
        //od DatumVremePocetka i datum do bude isti ili manji od DatumVremeKraja iz tabele Emisija
        
        if (cbDatumOd.isSelected() && cbDatumDo.isSelected() && cbStudio.isSelected()) {
            try {
                Date datumOd = sdf.parse(txtDatumOd.getText());
                Date datumDo = sdf.parse(txtDatumDo.getText());
                Studio studio = (Studio) cmbStudio.getSelectedItem();

                dodatniUpit = " WHERE e.datumVremePocetka >= '" + new java.sql.Date(datumOd.getTime()) + "' "
                        + "AND e.datumVremeKraja <= '" + new java.sql.Date(datumDo.getTime()) + "' "
                        + "AND s.studioID = " + studio.getStudioID()+ " ";

                listaBaza = Kontroler.getInstance().vratiIzvestaj(dodatniUpit);
                mt.dodajIzvestaj(listaBaza);

            } catch (ParseException ex) {
                Logger.getLogger(ServerskaForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (!cbDatumOd.isSelected() && !cbDatumDo.isSelected() && !cbStudio.isSelected()) {
            listaBaza = Kontroler.getInstance().vratiIzvestaj(dodatniUpit);
            mt.dodajIzvestaj(listaBaza);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbDatumDo;
    private javax.swing.JCheckBox cbDatumOd;
    private javax.swing.JCheckBox cbStudio;
    private javax.swing.JComboBox cmbStudio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIzvestaj;
    private javax.swing.JFormattedTextField txtDatumDo;
    private javax.swing.JFormattedTextField txtDatumOd;
    // End of variables declaration//GEN-END:variables

    private void popuniStudija() {
        ArrayList<Studio> aktivnaStudija = Kontroler.getInstance().vratiStudija();

        cmbStudio.removeAllItems();

        for (Studio studio : aktivnaStudija) {
            cmbStudio.addItem(studio);
        }
    }
}
