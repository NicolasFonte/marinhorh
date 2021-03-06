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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
        txtDataDesativacao.setVisible(false);
        lblDataDesativacao.setVisible(false);
        btnDesativarOK.setVisible(false);
        btnDesativarCancelar.setVisible(false);
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
        lblDataDesativacao = new javax.swing.JLabel();
        txtDataDesativacao = new javax.swing.JFormattedTextField();
        btnDesativarOK = new javax.swing.JButton();
        btnDesativarCancelar = new javax.swing.JButton();

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePesquisar.setColumnSelectionAllowed(true);
        jTablePesquisar.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTablePesquisar);
        jTablePesquisar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablePesquisar.getAccessibleContext().setAccessibleName("");

        btnDeletar.setText("desativar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        lblDataDesativacao.setText("Data Desativação:");

        txtDataDesativacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataDesativacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataDesativacaoFocusLost(evt);
            }
        });

        btnDesativarOK.setText("OK");
        btnDesativarOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarOKActionPerformed(evt);
            }
        });

        btnDesativarCancelar.setText("Cancelar");
        btnDesativarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jftPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioNome)
                .addGap(14, 14, 14)
                .addComponent(jRadioOab)
                .addGap(11, 11, 11)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar)
                        .addGap(29, 29, 29)
                        .addComponent(lblDataDesativacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataDesativacao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesativarOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesativarCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisar)
                    .addComponent(jftPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar)
                    .addComponent(jRadioNome)
                    .addComponent(jRadioOab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnDeletar)
                    .addComponent(lblDataDesativacao)
                    .addComponent(txtDataDesativacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesativarOK)
                    .addComponent(btnDesativarCancelar))
                .addGap(60, 60, 60))
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

            
            NumberFormat format = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR"));
            format.setMaximumFractionDigits(2);
            
            String distribuicaoText = format.format(obj.getDistribuicao());
            
            
            
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
       
        
        this.setVisible(false);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEditarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnEditarItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarItemStateChanged

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed

        txtDataDesativacao.setVisible(true);
        lblDataDesativacao.setVisible(true);
        btnDesativarOK.setVisible(true);
        btnDesativarCancelar.setVisible(true);
        
       /* 
        * Teste com o botão "OK"
        int rowIndex = jTablePesquisar.getSelectedRow();
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Primeiro deve ser buscado um advogado");
            return;
        }

        String oabFormatada = (String) jTablePesquisar.getValueAt(rowIndex, 1);
        String oab = oabFormatada.replace("-", "");
        
        Advogado adv = null;

        try {
        
            Date desativacaoData = formatter.parse(txtDataDesativacao.getText());
            adv = advController.byOab(oab);
            adv.setAtivo(false);
            adv.setDesativacao(desativacaoData);
            advController.getBackend().update(adv);
        
        }   catch (ParseException ex) {
            JOptionPane.showMessageDialog(null," Data no formato inválido!");
            Logger.getLogger(BuscarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } 
            catch (BackendException ex) {
            JOptionPane.showMessageDialog(null, "Problema de conexão ao buscar/deletar advogado pela oab: " + oab);
            Logger.getLogger(BuscarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }  
        
        JOptionPane.showMessageDialog(null, "Advogado desativado com sucesso!");
        this.setVisible(false);
            */

    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtDataDesativacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataDesativacaoFocusGained
        txtDataDesativacao.setBorder(BorderFactory.createLineBorder(Color.yellow));
        try {
         txtDataDesativacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                        new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtDataDesativacaoFocusGained

    private void txtDataDesativacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataDesativacaoFocusLost
        txtDataDesativacao.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_txtDataDesativacaoFocusLost

    private void btnDesativarOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarOKActionPerformed
         int rowIndex = jTablePesquisar.getSelectedRow();
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Primeiro deve ser buscado um advogado");
            return;
        }

        String oabFormatada = (String) jTablePesquisar.getValueAt(rowIndex, 1);
        String oab = oabFormatada.replace("-", "");
        
        Advogado adv = null;

        try {
        
            Date desativacaoData = formatter.parse(txtDataDesativacao.getText());
            adv = advController.byOab(oab);
            adv.setAtivo(false);
            adv.setDesativacao(desativacaoData);
            advController.getBackend().update(adv);
        
        }   catch (ParseException ex) {
            JOptionPane.showMessageDialog(null," Data no formato inválido!");
            Logger.getLogger(BuscarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } 
            catch (BackendException ex) {
            JOptionPane.showMessageDialog(null, "Problema de conexão ao buscar/deletar advogado pela oab: " + oab);
            Logger.getLogger(BuscarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }  
        
        JOptionPane.showMessageDialog(null, "Advogado desativado com sucesso!");
        this.setVisible(false);
    }//GEN-LAST:event_btnDesativarOKActionPerformed

    private void btnDesativarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarCancelarActionPerformed
        txtDataDesativacao.setVisible(false);
        lblDataDesativacao.setVisible(false);
        btnDesativarOK.setVisible(false);
        btnDesativarCancelar.setVisible(false);
    }//GEN-LAST:event_btnDesativarCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnDesativarCancelar;
    private javax.swing.JButton btnDesativarOK;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioNome;
    private javax.swing.JRadioButton jRadioOab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePesquisar;
    private javax.swing.JFormattedTextField jftPesquisar;
    private javax.swing.JLabel lblDataDesativacao;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JFormattedTextField txtDataDesativacao;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
