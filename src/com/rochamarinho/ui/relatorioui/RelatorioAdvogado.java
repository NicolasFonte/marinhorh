/*
 * RelatorioPorFilial.java
 *
 * Created on 10/06/2012, 17:58:01
 */
package com.rochamarinho.ui.relatorioui;

import com.rochamarinho.controller.FilialController;
import com.rochamarinho.model.Filial;
import com.rochamarinho.model.Report;
import com.rochamarinho.utils.BackendException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class RelatorioAdvogado extends javax.swing.JPanel {

    FilialController filialController = new FilialController();
    
    /** Creates new form RelatorioPorFilial */
    public RelatorioAdvogado() {
        initComponents();
        setFiliaisNoComboBox();
        setMesesNoComboBox();
    }
    
    public void setMesesNoComboBox()
    {
        ArrayList<String> nomeMeses = new ArrayList<String>(Arrays.asList("janeiro",
                    "fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"));
        mesComboBox.setModel(new javax.swing.DefaultComboBoxModel(nomeMeses.toArray()));
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
        filiaisNomes.add("Todos");
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
        jLabel1 = new javax.swing.JLabel();
        mesComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtNomeRelatorio = new javax.swing.JTextField();

        filialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));

        lblEscolherFilial.setText("Escolha a Filial:");

        btnGerarRelatorio.setText("Gerar");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        jLabel1.setText("Escolha o mês:");

        mesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));

        jLabel2.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGerarRelatorio)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEscolherFilial)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomeRelatorio)
                            .addComponent(filialComboBox, 0, 167, Short.MAX_VALUE)
                            .addComponent(mesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEscolherFilial)
                    .addComponent(filialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btnGerarRelatorio)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        
        String nomeFilial = (String) filialComboBox.getSelectedItem();
        String nomeAdvogado = txtNomeRelatorio.getText();
        String nomeMes = (String) mesComboBox.getSelectedItem();
        
        Report.gerarRelatorioAdvogadosMensal(nomeAdvogado,nomeFilial,nomeMes); // ajeitar relatorios
        
        
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JComboBox filialComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblEscolherFilial;
    private javax.swing.JComboBox mesComboBox;
    private javax.swing.JTextField txtNomeRelatorio;
    // End of variables declaration//GEN-END:variables
}
