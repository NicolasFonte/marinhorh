/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RelatorioPorFilial.java
 *
 * Created on 10/06/2012, 17:58:01
 */
package com.rochamarinho.ui;

import com.rochamarinho.controller.FilialController;
import com.rochamarinho.model.Filial;
import com.rochamarinho.model.Report;
import com.rochamarinho.utils.BackendException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class RelatorioPorFilial extends javax.swing.JPanel {

    FilialController filialController = new FilialController();
    
    /** Creates new form RelatorioPorFilial */
    public RelatorioPorFilial() {
        initComponents();
        setFiliaisNoComboBox();
    }
    
    public void setFiliaisNoComboBox() {
        List<Filial> filiais = null;
        try {
            filiais = filialController.listarFiliais();
        } catch (BackendException ex) {
            JOptionPane.showConfirmDialog(null, "Nao foi possivel carregar a lista de filiais");
            filiais = new ArrayList<Filial>();
        }


        List<String> filiaisNomes = new ArrayList<String>();
        for (Filial f : filiais) {
            filiaisNomes.add(f.getNome());
        }
        filialComboBox.setModel(new javax.swing.DefaultComboBoxModel(filiaisNomes.toArray()));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filialComboBox = new javax.swing.JComboBox();
        lblEscolherFilial = new javax.swing.JLabel();
        btnGerarRelatorio = new javax.swing.JButton();

        filialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "default" }));

        lblEscolherFilial.setText("Escolha a Filial:");

        btnGerarRelatorio.setText("Gerar");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblEscolherFilial)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGerarRelatorio)
                    .addComponent(filialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEscolherFilial)
                    .addComponent(filialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(btnGerarRelatorio)
                .addGap(67, 67, 67))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        
        String nomeFilial = (String) filialComboBox.getSelectedItem();
        Report.gerarRelatorioAdvogadosPorFilial(nomeFilial);
        
        
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JComboBox filialComboBox;
    private javax.swing.JLabel lblEscolherFilial;
    // End of variables declaration//GEN-END:variables
}
