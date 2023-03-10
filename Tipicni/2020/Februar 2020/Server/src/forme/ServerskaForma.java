/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.StavkaIzvestaja;
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

/**
 *
 * @author USER
 */
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbDatumOd = new javax.swing.JCheckBox();
        cbDatumDo = new javax.swing.JCheckBox();
        txtDatumOd = new javax.swing.JFormattedTextField();
        txtDatumDo = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIzvestaj = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbDatumOd.setText("Intervjui od datuma:");

        cbDatumDo.setText("Intervjui do datuma:");

        txtDatumOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumOd.setText("10.09.2020");

        txtDatumDo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumDo.setText("10.11.2020");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbDatumOd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDatumOd))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbDatumDo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDatumDo, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDatumOd)
                    .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDatumDo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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

    public void osvezi() {
        
        ArrayList<StavkaIzvestaja> listaBaza;
        ModelTabeleServer mt = (ModelTabeleServer) tblIzvestaj.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String dodatniUpit = "";
        
        if(!cbDatumOd.isSelected() && !cbDatumDo.isSelected()){
            listaBaza = Kontroler.getInstance().vratiIzvestaj(dodatniUpit);
            mt.dodaj(listaBaza);
        }
        
        if(cbDatumOd.isSelected() && cbDatumDo.isSelected()){
            
            try {
                Date datumOd = sdf.parse(txtDatumOd.getText());
                Date datumDo = sdf.parse(txtDatumDo.getText());
                
                dodatniUpit = "WHERE i.datum BETWEEN '" + new java.sql.Date(datumOd.getTime()) 
                        + "' AND '" + new java.sql.Date(datumDo.getTime()) + "' ";
                
                listaBaza = Kontroler.getInstance().vratiIzvestaj(dodatniUpit);
                mt.dodaj(listaBaza);
            } catch (ParseException ex) {
                Logger.getLogger(ServerskaForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(cbDatumOd.isSelected() && !cbDatumDo.isSelected()){
            
            try {
                Date datumOd = sdf.parse(txtDatumOd.getText());
                
                dodatniUpit = "WHERE i.datum >= '" + new java.sql.Date(datumOd.getTime()) + "' ";
                
                listaBaza = Kontroler.getInstance().vratiIzvestaj(dodatniUpit);
                mt.dodaj(listaBaza);
            } catch (ParseException ex) {
                Logger.getLogger(ServerskaForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(!cbDatumOd.isSelected() && cbDatumDo.isSelected()){
            
            try {
                Date datumDo = sdf.parse(txtDatumDo.getText());
                
                dodatniUpit = "WHERE i.datum <= '" + new java.sql.Date(datumDo.getTime()) + "' ";
                
                listaBaza = Kontroler.getInstance().vratiIzvestaj(dodatniUpit);
                mt.dodaj(listaBaza);
            } catch (ParseException ex) {
                Logger.getLogger(ServerskaForma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbDatumDo;
    private javax.swing.JCheckBox cbDatumOd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIzvestaj;
    private javax.swing.JFormattedTextField txtDatumDo;
    private javax.swing.JFormattedTextField txtDatumOd;
    // End of variables declaration//GEN-END:variables
}
