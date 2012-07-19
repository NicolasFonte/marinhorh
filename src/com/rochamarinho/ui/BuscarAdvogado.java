/*
 * BuscarAdvogado.java
 *
 * Created on 18/05/2012, 22:48:25
 */
package com.rochamarinho.ui;

import com.rochamarinho.controller.AdvogadoController;
import com.rochamarinho.controller.FilialController;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.utils.BackendException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicolas
 */
public class BuscarAdvogado extends javax.swing.JPanel implements ItemListener {

    private AdvogadoController advController = new AdvogadoController();
    private FilialController filialController = new FilialController();

    /** Creates new form BuscarAdvogado */
    public BuscarAdvogado() {
        initComponents();
        jRadioNome.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioNome);
        group.add(jRadioOab);
        //setDefaultTextEmpty();I
    }

    private void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    protected void setDefaultTextEmpty() {
        /* txtDistribuicao.setVisible(false);
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
         * 
         */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblPesquisar = new javax.swing.JLabel();
        jftPesquisar = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jRadioNome = new javax.swing.JRadioButton();
        jRadioOab = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePesquisar = new javax.swing.JTable();
        btnDeletar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        lblPesquisar.setText("Pesquisar:");

        jftPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jftPesquisarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftPesquisarFocusLost(evt);
            }
        });

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jRadioNome.setText("Nome");

        jRadioOab.setText("OAB");

        btnEditar.setText("editar");
        btnEditar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnEditarItemStateChanged(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jTablePesquisar.setAutoCreateRowSorter(true);
        jTablePesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "OAB", "Distribuição", "Associação", "E-mail"
            }
        ));
        jTablePesquisar.setColumnSelectionAllowed(true);
        jTablePesquisar.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTablePesquisar);
        jTablePesquisar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablePesquisar.getAccessibleContext().setAccessibleName("");

        btnDeletar.setText("deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jRadioNome)
                        .addGap(14, 14, 14)
                        .addComponent(jRadioOab)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar))
                    .addComponent(btnDeletar))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioNome)
                            .addComponent(jRadioOab))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisar)
                    .addComponent(btnBuscar)
                    .addComponent(jftPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String nomeAdv = jftPesquisar.getText();
        List<Advogado> advs = null;
        try {
            if (jRadioNome.isSelected()) {
                advs = advController.porNome(nomeAdv);
            } else if (jRadioOab.isSelected()) {
                Advogado pesquisado = advController.byOab(nomeAdv);
                advs = new ArrayList<Advogado>();
                advs.add(pesquisado);
            }

        } catch (BackendException ex) {
            mostrarMensagem("erro na busca do nome");
            return;
        }

        if ((advs == null) || (advs.isEmpty())) {
            mostrarMensagem("advogado nao encontrado");
            //return
        }

        DefaultTableModel m = (DefaultTableModel) jTablePesquisar.getModel();

        int i = 0;
        while (i < jTablePesquisar.getRowCount()) {
            m.removeRow(0);
        }

        for (Advogado obj : advs) {

            String distribuicaoText = String.valueOf(obj.getDistribuicao());
            String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(obj.getAssociacao());
            String oabFormatado = obj.getOab().substring(0, 2) + "-" + obj.getOab().substring(2);

            m.addRow(new Object[]{obj.getNome(), oabFormatado, distribuicaoText,
                        dataFormatada, obj.getEmail()
                    });
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jftPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftPesquisarFocusGained
        jftPesquisar.setBorder(BorderFactory.createLineBorder(Color.yellow));
    }//GEN-LAST:event_jftPesquisarFocusGained

    private void jftPesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftPesquisarFocusLost
        jftPesquisar.setBorder(BorderFactory.createLineBorder(Color.gray));
    }//GEN-LAST:event_jftPesquisarFocusLost

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed


        int rowIndex = jTablePesquisar.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Primeiro deve ser buscado um advogado");
            return;
        }

        String oabFormatada = (String) jTablePesquisar.getValueAt(rowIndex, 1);
        String oab = oabFormatada.replace("-", "");

        Advogado adv = null;
        try {
            adv = advController.byOab(oab);
        } catch (BackendException ex) {
            Logger.getLogger(BuscarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        }


        EditarAdvogadoFrame frame = new EditarAdvogadoFrame();
        frame.setPreferredSize(new Dimension(400, 600));
        frame.setContentPane(new EditarAdvogadoPanel(adv));
        frame.setVisible(true);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEditarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnEditarItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarItemStateChanged

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed

        int rowIndex = jTablePesquisar.getSelectedRow();

        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Primeiro deve ser buscado um advogado");
            return;
        }
        
        String oabFormatada = (String) jTablePesquisar.getValueAt(rowIndex, 1);
        String oab = oabFormatada.replace("-", "");
        Advogado adv = null;
        
        try {
            adv = advController.byOab(oab);
            advController.getBackend().remove(adv);
        } catch (BackendException ex) {
            JOptionPane.showMessageDialog(null, "Problema de conexão ao buscar/deletar advogado pela oab: " + oab);
            Logger.getLogger(BuscarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDeletarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioNome;
    private javax.swing.JRadioButton jRadioOab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePesquisar;
    private javax.swing.JFormattedTextField jftPesquisar;
    private javax.swing.JLabel lblPesquisar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
