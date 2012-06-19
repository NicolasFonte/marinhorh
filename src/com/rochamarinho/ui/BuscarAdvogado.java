/*
 * BuscarAdvogado.java
 *
 * Created on 18/05/2012, 22:48:25
 */
package com.rochamarinho.ui;

import com.rochamarinho.controller.AdvogadoController;
import com.rochamarinho.controller.FilialController;
import com.rochamarinho.controller.TaxaController;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Filial;
import com.rochamarinho.utils.BackendException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class BuscarAdvogado extends javax.swing.JPanel {

    private AdvogadoController advController = new AdvogadoController();
    private FilialController filialController = new FilialController();

    /** Creates new form BuscarAdvogado */
    public BuscarAdvogado() {
        initComponents();
        setDefaultTextEmpty();
    }

    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    protected void setDefaultTextEmpty() {
        txtDistribuicao.setVisible(false);
        txtNome.setVisible(false);
        txtTaxa.setVisible(false);
        lblDistribuicao.setVisible(false);
        lblNome.setVisible(false);
        lblTaxa.setVisible(false);
        btnEditarAdvogado.setVisible(false);
        btnRemoverAdvogado.setVisible(false);
        btnGravar.setVisible(false);
        lblFilialMostrarNome.setVisible(false);
        lblMostrarNome.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCpf = new javax.swing.JLabel();
        jftCpf = new javax.swing.JFormattedTextField();
        lblMostrarNome = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblFilialMostrarNome = new javax.swing.JLabel();
        btnRemoverAdvogado = new javax.swing.JButton();
        btnEditarAdvogado = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtDistribuicao = new javax.swing.JTextField();
        txtTaxa = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblDistribuicao = new javax.swing.JLabel();
        lblTaxa = new javax.swing.JLabel();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(getMinimumSize());

        lblCpf.setText("Digite o Cpf: ");

        lblMostrarNome.setText("advNome");

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblFilialMostrarNome.setText("advFilial");

        btnRemoverAdvogado.setText("remover");
        btnRemoverAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverAdvogadoActionPerformed(evt);
            }
        });

        btnEditarAdvogado.setText("editar");
        btnEditarAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAdvogadoActionPerformed(evt);
            }
        });

        lblNome.setText("Nome:");

        lblDistribuicao.setText("Distribuicao:");

        lblTaxa.setText("Taxa:");

        btnGravar.setText("gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
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
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCpf)
                            .addComponent(lblMostrarNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFilialMostrarNome)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jftCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGravar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoverAdvogado)
                            .addComponent(lblNome)
                            .addComponent(lblDistribuicao)
                            .addComponent(lblTaxa))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditarAdvogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNome)
                            .addComponent(txtDistribuicao)
                            .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(btnBuscar)
                    .addComponent(jftCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFilialMostrarNome)
                    .addComponent(lblMostrarNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverAdvogado)
                    .addComponent(btnEditarAdvogado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDistribuicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDistribuicao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTaxa)
                    .addComponent(btnGravar))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String maybeCpf = jftCpf.getText();
        Advogado adv = null;
        try {
            adv = advController.byOab(maybeCpf);
        } catch (BackendException ex) {
            mostrarMensagem("erro na busca do cpf");
            return;
        }

        if (adv == null) {
            mostrarMensagem("advogado nao encontrado");
            return;
        }
        
        Filial filialProcurada;
        try {
            filialProcurada = filialController.filialDeAdvogado(maybeCpf);
        } catch (BackendException ex) {
            mostrarMensagem("este advogado nao esta numa filial devido a algum erro");
            return;
        }
         
        lblMostrarNome.setText(adv.getNome());
        lblMostrarNome.setVisible(true);
        lblFilialMostrarNome.setText(filialProcurada.getNome());
        lblFilialMostrarNome.setVisible(true);
        btnEditarAdvogado.setVisible(true);
        btnRemoverAdvogado.setVisible(true);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAdvogadoActionPerformed
        
        String oab = jftCpf.getText().replace(".", "").replace("-", "");
        
        txtDistribuicao.setVisible(true);
        txtNome.setVisible(true);
        txtTaxa.setVisible(true);
        
        Advogado adv = null;
        try {
            adv = advController.byOab(oab);
        } catch (BackendException ex) {
            
        }
        
        lblDistribuicao.setVisible(true);
        lblNome.setVisible(true);
        lblTaxa.setVisible(true);
        btnGravar.setVisible(true);
        
        txtDistribuicao.setText(String.valueOf(adv.getDistribuicao()));
        txtNome.setText(adv.getNome());
        
        
    }//GEN-LAST:event_btnEditarAdvogadoActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed

        String cpf = jftCpf.getText().replace(".", "").replace("-", "");
        
        double distribuicao = Double.parseDouble(txtDistribuicao.getText());
        double taxa = Double.parseDouble(txtTaxa.getText());
        String nome = txtNome.getText();       
        try {
            advController.atualizarAdvogado(cpf, nome , distribuicao, taxa);
        } catch (BackendException ex) {
            mostrarMensagem("nao foi possivel atualizar o advogado");
        }
        
        JOptionPane.showMessageDialog(null, " atualizado com sucesso");
        this.setVisible(false);
        
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnRemoverAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverAdvogadoActionPerformed
        
        String cpf = jftCpf.getText().replace(".", "").replace("-", "");
        try {
            advController.deletarAdvogado(cpf);
        } catch (BackendException ex) {
            Logger.getLogger(BuscarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
            mostrarMensagem("advogado nao foi removido!");
            this.setVisible(false);
        }
        
        mostrarMensagem("advogado removido com sucesso!");
        this.setVisible(false);
        
    }//GEN-LAST:event_btnRemoverAdvogadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarAdvogado;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnRemoverAdvogado;
    private javax.swing.JFormattedTextField jftCpf;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDistribuicao;
    private javax.swing.JLabel lblFilialMostrarNome;
    private javax.swing.JLabel lblMostrarNome;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTaxa;
    private javax.swing.JTextField txtDistribuicao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTaxa;
    // End of variables declaration//GEN-END:variables
}
