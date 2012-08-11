/*
 * RelatorioPorFilial.java
 *
 * Created on 10/06/2012, 17:58:01
 */
package com.rochamarinho.ui.relatorioui;

import com.rochamarinho.controller.AdvogadoController;
import com.rochamarinho.controller.FilialController;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Filial;
import com.rochamarinho.model.Report;
import com.rochamarinho.utils.BackendException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class RelatorioAdvogado extends javax.swing.JPanel {

    FilialController filialController = new FilialController();
    AdvogadoController advogadoController = new AdvogadoController();
    Report report = new Report();
    /** Creates new form RelatorioPorFilial */
    public RelatorioAdvogado() {
        initComponents();
        setFiliaisNoComboBox();
        setMesesNoComboBox();
        setAdvogadosNoComboBox();
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
            Collections.sort(filiais);
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
        advogadoComboBox = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();

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

        jLabel2.setText("Nome Advogado :");

        advogadoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default" }));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(btnGerarRelatorio)
                        .addGap(60, 60, 60)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEscolherFilial)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(advogadoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filialComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mesComboBox, 0, 167, Short.MAX_VALUE))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
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
                    .addComponent(advogadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGerarRelatorio)
                    .addComponent(btnCancelar))
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        
        String nomeFilial = (String) filialComboBox.getSelectedItem();
        String nomeAdvogado = (String) advogadoComboBox.getSelectedItem();
        String nomeMes = (String) mesComboBox.getSelectedItem();
        
        report.gerarRelatorioAdvogadosMensal(nomeAdvogado,nomeFilial,nomeMes); // ajeitar relatorios
                
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.setVisible(false);

    }//GEN-LAST:event_btnCancelarActionPerformed
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox advogadoComboBox;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JComboBox filialComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblEscolherFilial;
    private javax.swing.JComboBox mesComboBox;
    // End of variables declaration//GEN-END:variables

    public void setAdvogadosNoComboBox() {
        List<Advogado> advogados = null;
        try {
            advogados = advogadoController.listarAdvogados();
            Collections.sort(advogados);
        } catch (BackendException ex) {
            JOptionPane.showConfirmDialog(null, "Não foi possível carregar a lista de advogados");
            advogados = new ArrayList<Advogado>();
        }


        List<String> advogadoNomes = new ArrayList<String>();
        advogadoNomes.add("Todos");
        for (Advogado adv : advogados) {
            advogadoNomes.add(adv.getNome());
        }
        
        advogadoComboBox.setModel(new javax.swing.DefaultComboBoxModel(advogadoNomes.toArray()));

    }
}
