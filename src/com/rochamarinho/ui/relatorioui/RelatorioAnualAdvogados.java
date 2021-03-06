/*
 * RelatorioAnualAdvogados.java
 *
 * Created on 14/07/2012, 19:08:26
 */
package com.rochamarinho.ui.relatorioui;

import com.rochamarinho.backend.impl.MySQLAdvogadoBackend;
import com.rochamarinho.model.Report;
import com.rochamarinho.utils.BackendException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class RelatorioAnualAdvogados extends javax.swing.JPanel {

    Report report = new Report();
    MySQLAdvogadoBackend backend = new MySQLAdvogadoBackend();
    /** Creates new form RelatorioAnualAdvogados */
    public RelatorioAnualAdvogados() {
        initComponents();
        report.setBackend(this.backend);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAno = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        lblAno.setText("Indique o ano:");

        jButton1.setText("gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAno)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCancelar))
                .addContainerGap(178, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int ano = 0;
        String anoStr = txtAno.getText();
        
        
        if (!anoStr.equals("")){
        
        ano = Integer.parseInt(anoStr);
        } else {
            JOptionPane.showMessageDialog(null, "Necessário digitar um ano.");
        }
        try {
            report.gerarRelatorioAnual(ano);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Localização inexistente para criação do relatório.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de escrita em arquivo.");
        } catch (BackendException ex) {
            JOptionPane.showMessageDialog(null, "Erro, Verifique a conexão com o banco.");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JTextField txtAno;
    // End of variables declaration//GEN-END:variables
}
