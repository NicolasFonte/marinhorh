/*
 * EfetuarPagamento.java
 *
 * Created on 24/06/2012, 15:17:34
 */
package com.rochamarinho.ui;

import com.rochamarinho.controller.AdvogadoController;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Pagamento;
import com.rochamarinho.utils.BackendException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class EfetuarPagamento extends javax.swing.JPanel {
    
    AdvogadoController advController = new AdvogadoController();
    
    /** Creates new form EfetuarPagamento */
    public EfetuarPagamento() {
        initComponents();
        setMesesNoComboBox();
    }

    public void setMesesNoComboBox()
    {
        ArrayList<String> nomeMeses = new ArrayList<String>(Arrays.asList("janeiro",
                    "fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"));
        mesComboBox.setModel(new javax.swing.DefaultComboBoxModel(nomeMeses.toArray()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMes = new javax.swing.JLabel();
        mesComboBox = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();

        lblMes.setText("Escolha o mẽs: ");

        mesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "default" }));

        btnSalvar.setText("salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblMes)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(mesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(mesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        List<Advogado> advogados = advController.listarAdvogados();
        
        Calendar calendar = Calendar.getInstance();
        Date atual = new Date();
        calendar.setTime(atual);
        int month = calendar.get(Calendar.MONTH);
        
        for ( Advogado each : advogados )
        {
            Pagamento pg = new Pagamento();
            pg.setDataPagamento(atual);
            pg.setValorPago(each.getValores().get(month).getValor());            
            each.addPagamento(pg);
            try {
                advController.getBackend().update(each);
            } catch (BackendException ex) {
                
                JOptionPane.showMessageDialog(null, "Nao foi possivel efetuar pagamento");
                
            }
            
        }
        
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblMes;
    private javax.swing.JComboBox mesComboBox;
    // End of variables declaration//GEN-END:variables
}
