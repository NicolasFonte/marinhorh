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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        //setDefaultTextEmpty();
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

        lblPesquisar = new javax.swing.JLabel();
        jftPesquisar = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jRadioNome = new javax.swing.JRadioButton();
        jRadioOab = new javax.swing.JRadioButton();
        btnEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePesquisar = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(500, 300));

        lblPesquisar.setText("Pesquisar:");

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

        btnEditar.setText("Editar");

        jTablePesquisar.setAutoCreateRowSorter(true);
        jTablePesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "OAB", "Distribuição", "Associação", "E-mail"
            }
        ));
        jTablePesquisar.setColumnSelectionAllowed(true);
        jTablePesquisar.setName("");
        jScrollPane1.setViewportView(jTablePesquisar);
        jTablePesquisar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablePesquisar.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jRadioNome)
                        .addGap(14, 14, 14)
                        .addComponent(jRadioOab)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addGap(23, 23, 23))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioNome)
                    .addComponent(jRadioOab))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisar)
                    .addComponent(btnBuscar)
                    .addComponent(jftPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String nomeAdv = jftPesquisar.getText();
        List<Advogado> advs = null;
        try {
            advs = advController.porNome(nomeAdv);
        } catch (BackendException ex) {
            mostrarMensagem("erro na busca do nome");
            return;
        }

        if ((advs == null) || (advs.isEmpty())) {
            mostrarMensagem("advogado nao encontrado");
            //return
        }
    
                
        /* Implementar posteriormente a busca de advogado e filial.
         * Filial filialProcurada;
        try {
            filialProcurada = filialController.filialDeAdvogado(nomeAdvs);
        } catch (BackendException ex) {
            mostrarMensagem("este advogado nao esta numa filial devido a algum erro");
        }
        * 
        */
        DefaultTableModel m = (DefaultTableModel) jTablePesquisar.getModel();
        
        for (Advogado obj:advs){
           m.addRow(new Object [] {obj.getNome(), obj.getOab(), obj.getDistribuicao(),
               obj.getAssociacao(), obj.getEmail()
           }); 
        }
    
         
/*      lblMostrarNome.setText(adv.getNome());
        lblMostrarNome.setVisible(true);
        lblFilialMostrarNome.setText(filialProcurada.getNome());
        lblFilialMostrarNome.setVisible(true);
        btnEditarAdvogado.setVisible(true);
        btnRemoverAdvogado.setVisible(true);
        * 
        */
        

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JRadioButton jRadioNome;
    private javax.swing.JRadioButton jRadioOab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePesquisar;
    private javax.swing.JFormattedTextField jftPesquisar;
    private javax.swing.JLabel lblPesquisar;
    // End of variables declaration//GEN-END:variables
}
