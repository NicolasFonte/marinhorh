/*
 * AlterarTaxa.java
 *
 * Created on 13/05/2012, 19:51:34
 */
package com.rochamarinho.ui;

import com.rochamarinho.controller.TaxaController;
import com.rochamarinho.model.Taxa;
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
        Taxa taxa = null;
        try {
            taxa = taxaController.getBackend().read(1L);
        } catch (BackendException ex) {
            Logger.getLogger(AlterarTaxa.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblExibirValorAtual.setText(Double.toString(taxa.getValor()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNovoValor = new javax.swing.JLabel();
        txtTaxaNovoValor = new javax.swing.JTextField();
        btnAlterarValorTaxa = new javax.swing.JButton();
        btnCancelarAlteracaoTaxa = new javax.swing.JButton();
        lblValorAtual = new javax.swing.JLabel();
        lblExibirValorAtual = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));

        lblNovoValor.setText("Digite o novo valor:");

        txtTaxaNovoValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTaxaNovoValorFocusGained(evt);
            }
        });

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

        lblValorAtual.setText("Valor Atual:");

        lblExibirValorAtual.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNovoValor)
                            .addComponent(lblValorAtual, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExibirValorAtual)
                            .addComponent(txtTaxaNovoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlterarValorTaxa)
                        .addGap(44, 44, 44)
                        .addComponent(btnCancelarAlteracaoTaxa)))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorAtual)
                    .addComponent(lblExibirValorAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNovoValor)
                    .addComponent(txtTaxaNovoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterarValorTaxa)
                    .addComponent(btnCancelarAlteracaoTaxa))
                .addContainerGap(135, Short.MAX_VALUE))
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

    private void txtTaxaNovoValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTaxaNovoValorFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaxaNovoValorFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarValorTaxa;
    private javax.swing.JButton btnCancelarAlteracaoTaxa;
    private javax.swing.JLabel lblExibirValorAtual;
    private javax.swing.JLabel lblNovoValor;
    private javax.swing.JLabel lblValorAtual;
    private javax.swing.JTextField txtTaxaNovoValor;
    // End of variables declaration//GEN-END:variables
}
