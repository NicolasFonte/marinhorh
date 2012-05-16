/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AlterarTaxa.java
 *
 * Created on 13/05/2012, 19:51:34
 */
package com.rochamarinho.ui;

import com.rochamarinho.controller.TaxaController;
import com.rochamarinho.utils.BackendException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class AlterarTaxa extends javax.swing.JPanel {

    TaxaController taxaController = new TaxaController();
    
    /** Creates new form AlterarTaxa */
    public AlterarTaxa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNovoValor = new javax.swing.JLabel();
        txtTaxaNovoValor = new javax.swing.JTextField();
        btnAlterarValorTaxa = new javax.swing.JButton();
        btnCancelarAlteracaoTaxa = new javax.swing.JButton();

        lblNovoValor.setText("Digite o novo valor: ");

        btnAlterarValorTaxa.setText("alterar");
        btnAlterarValorTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarValorTaxaActionPerformed(evt);
            }
        });

        btnCancelarAlteracaoTaxa.setText("cancelar");
        btnCancelarAlteracaoTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlteracaoTaxaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNovoValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlterarValorTaxa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnCancelarAlteracaoTaxa)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTaxaNovoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(149, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNovoValor)
                    .addComponent(txtTaxaNovoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterarValorTaxa)
                    .addComponent(btnCancelarAlteracaoTaxa))
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarValorTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarValorTaxaActionPerformed

        String novoValorTaxaString = txtTaxaNovoValor.getText();        
        double novoValorTaxa = 0.0;
        try {
            novoValorTaxa = Double.valueOf(novoValorTaxaString); 
        } catch ( NumberFormatException ex )
        {
            JOptionPane.showMessageDialog(null, "put a correct real number");
        }
        try {
            taxaController.atualizaTaxa(novoValorTaxa);
        } catch (BackendException ex) {            
            JOptionPane.showMessageDialog(null, "error on update");            
        }

        JOptionPane.showMessageDialog(null, "taxa atualizada com sucesso");        
        this.setVisible(false);

    }//GEN-LAST:event_btnAlterarValorTaxaActionPerformed

    private void btnCancelarAlteracaoTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlteracaoTaxaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarAlteracaoTaxaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarValorTaxa;
    private javax.swing.JButton btnCancelarAlteracaoTaxa;
    private javax.swing.JLabel lblNovoValor;
    private javax.swing.JTextField txtTaxaNovoValor;
    // End of variables declaration//GEN-END:variables
}
