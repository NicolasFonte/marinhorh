/*
 * CadastrarAdvogado.java
 *
 * Created on 06/05/2012, 17:22:24
 */
package com.rochamarinho.ui;

import com.rochamarinho.controller.AdvogadoController;
import com.rochamarinho.controller.FilialController;
import com.rochamarinho.controller.TaxaController;
import com.rochamarinho.model.Filial;
import com.rochamarinho.model.Taxa;
import com.rochamarinho.utils.BackendException;
import com.rochamarinho.utils.ValidaCpf;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class CadastrarAdvogado extends javax.swing.JPanel {

    AdvogadoController advController = new AdvogadoController();
    TaxaController taxaController = new TaxaController();
    FilialController filialController = new FilialController();

    /** Creates new form CadastrarAdvogado */
    public CadastrarAdvogado() {
        initComponents();
        setDefaultTaxaText();
        setFiliaisNoComboBox();
        setDefaultMaskCpf();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        lblNomeAdvogado = new javax.swing.JLabel();
        txtDistribuicao = new javax.swing.JTextField();
        lblDistribuicao = new javax.swing.JLabel();
        btnCadastrarAdvogado = new javax.swing.JButton();
        lblCpf = new javax.swing.JLabel();
        txtTaxa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        filialComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnCancelarCadastro = new javax.swing.JButton();
        jftCpf = new javax.swing.JFormattedTextField();

        lblNomeAdvogado.setText("Nome:");

        lblDistribuicao.setText("Distribuição:");

        btnCadastrarAdvogado.setText("cadastrar");
        btnCadastrarAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAdvogadoActionPerformed(evt);
            }
        });

        lblCpf.setText("cpf:");

        txtTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaxaActionPerformed(evt);
            }
        });

        jLabel1.setText("Taxa:");

        filialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "default" }));
        filialComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filialComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Filial:");

        btnCancelarCadastro.setText("cancelar");
        btnCancelarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroActionPerformed(evt);
            }
        });

        jftCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftCpfActionPerformed(evt);
            }
        });
        jftCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftCpfFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDistribuicao)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTaxa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(txtDistribuicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(filialComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNomeAdvogado)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jftCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(202, 202, 202))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCpf)
                .addContainerGap(413, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(btnCadastrarAdvogado)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarCadastro)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(jftCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeAdvogado))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDistribuicao)
                    .addComponent(txtDistribuicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarAdvogado)
                    .addComponent(btnCancelarCadastro))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaxaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaxaActionPerformed

    private void filialComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filialComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filialComboBoxActionPerformed

    private void btnCadastrarAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAdvogadoActionPerformed

        String advNomeText = txtNome.getText();
        String advTaxaText = txtTaxa.getText();
        String advPinText = jftCpf.getText();
        String advDistribuicaoText = txtDistribuicao.getText();

        double distribuicaoDouble = Double.valueOf(advDistribuicaoText);
        double taxaDouble = Double.valueOf(advTaxaText);

        try {

            advController.cadastrarAdvogado(advPinText, advNomeText, distribuicaoDouble, taxaDouble, "");
        } catch (BackendException ex) {
            JOptionPane.showMessageDialog(null, "advogado nao cadastrado");

        }

        JOptionPane.showMessageDialog(null, "advogado cadastrado com sucesso");
        this.setVisible(false);

    }//GEN-LAST:event_btnCadastrarAdvogadoActionPerformed

    private void btnCancelarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarCadastroActionPerformed

    private void jftCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftCpfActionPerformed
    }//GEN-LAST:event_jftCpfActionPerformed

    private void jftCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftCpfFocusLost
        String advCpf = jftCpf.getText();
        advCpf = advCpf.replace(".", "");
        advCpf = advCpf.replace("-", "");

        boolean validar = new ValidaCpf().isCpf(advCpf);
        if (!(validar)) {

            JOptionPane.showMessageDialog(null, "CPF inválido! Favor digitar um CPF Válido, obedecendo o formato: (xxx.xxx.xxx.-xx)!");
            jftCpf.requestFocus();
        }

    }//GEN-LAST:event_jftCpfFocusLost

    private void setDefaultMaskCpf() {
        try {
            jftCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Por gentileza, Digite um CPF Válido!");
        }
    }

    protected void setDefaultTaxaText() {
        Taxa taxa;

        try {
            taxa = taxaController.getTaxa();
        } catch (BackendException ex) {
            Logger.getLogger(CadastrarAdvogado.class.getName()).log(Level.SEVERE, "taxa nao foi carregada", ex);
            taxa = new Taxa(0);
        }

        txtTaxa.setText(String.valueOf(taxa.getValor()));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarAdvogado;
    private javax.swing.JButton btnCancelarCadastro;
    private javax.swing.JComboBox filialComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField jftCpf;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDistribuicao;
    private javax.swing.JLabel lblNomeAdvogado;
    private javax.swing.JTextField txtDistribuicao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTaxa;
    // End of variables declaration//GEN-END:variables

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
}
