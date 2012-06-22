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
import java.awt.Color;
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
        setDefaultMasks();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        lblNomeAdvogado = new javax.swing.JLabel();
        lblDistribuicao = new javax.swing.JLabel();
        btnCadastrarAdvogado = new javax.swing.JButton();
        lblOab = new javax.swing.JLabel();
        filialComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnCancelarCadastro = new javax.swing.JButton();
        fmtOab = new javax.swing.JFormattedTextField();
        lblNascimento = new javax.swing.JLabel();
        lblAssociacao = new javax.swing.JLabel();
        UfOabComboBox = new javax.swing.JComboBox();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        fmtNascimento = new javax.swing.JFormattedTextField();
        fmtAssociacao = new javax.swing.JFormattedTextField();
        lblDominio = new javax.swing.JLabel();
        btnLimparCadastro = new javax.swing.JButton();
        txtDistribuicao = new javax.swing.JFormattedTextField();
        checkBoxTaxa = new javax.swing.JCheckBox();

        setMinimumSize(new java.awt.Dimension(500, 350));
        setNextFocusableComponent(txtNome);

        lblNomeAdvogado.setText("Nome:");

        lblDistribuicao.setText("Distribuição:");

        btnCadastrarAdvogado.setText("cadastrar");
        btnCadastrarAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAdvogadoActionPerformed(evt);
            }
        });

        lblOab.setText("Oab:");

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

        fmtOab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmtOabActionPerformed(evt);
            }
        });
        fmtOab.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fmtOabFocusLost(evt);
            }
        });

        lblNascimento.setText("Nascimento:");

        lblAssociacao.setText("Associacao:");

        UfOabComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UF","AC","AL","AM","AP","BA","CE","DF","ES","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO","RR","RS","SC","SE","SP","TO" }));
        UfOabComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UfOabComboBoxActionPerformed(evt);
            }
        });

        lblEmail.setText("E-mail:");

        fmtNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fmtNascimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fmtNascimentoFocusLost(evt);
            }
        });

        lblDominio.setText("@rochamarinho.adv.br");

        btnLimparCadastro.setText("Limpar");
        btnLimparCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadastroActionPerformed(evt);
            }
        });

        checkBoxTaxa.setText("Taxa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnCadastrarAdvogado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(btnLimparCadastro)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarCadastro))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNascimento)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEmail)
                                    .addComponent(lblDistribuicao)
                                    .addComponent(lblOab)
                                    .addComponent(lblNomeAdvogado))))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDominio))
                            .addComponent(filialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fmtNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(txtDistribuicao))
                                .addGap(28, 28, 28)
                                .addComponent(lblAssociacao)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fmtAssociacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxTaxa)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UfOabComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fmtOab, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNome))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAdvogado)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOab)
                    .addComponent(UfOabComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fmtOab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDominio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDistribuicao)
                    .addComponent(txtDistribuicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxTaxa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNascimento)
                    .addComponent(fmtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAssociacao)
                    .addComponent(fmtAssociacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarCadastro)
                    .addComponent(btnCadastrarAdvogado)
                    .addComponent(btnLimparCadastro))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filialComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filialComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filialComboBoxActionPerformed

    private void btnCadastrarAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAdvogadoActionPerformed

        boolean existeFilial = existeFilial();
        if (existeFilial == false) {
            return;
        }

        boolean usaTaxa = checkBoxTaxa.isSelected();
        
        String advNomeText = txtNome.getText();
        String advOabText = fmtOab.getText().replace(".", "").replace(" ", "");

        String advDistribuicaoText = txtDistribuicao.getText().replace(".", "").replace(",", ".");
        String nomeFilial = (String) filialComboBox.getSelectedItem();

        String dataAssociacaoTexto = fmtAssociacao.getText();
        String dataNascimentoTexto = fmtNascimento.getText();
        String email = txtEmail.getText() + lblDominio.getText();
        
        String ufTexto = (String) UfOabComboBox.getSelectedItem();

        advOabText = ufTexto + advOabText;
        
        if (advNomeText.equals("") || advOabText.equals("") || advDistribuicaoText.equals("")
                    || dataAssociacaoTexto.equals("") || dataNascimentoTexto.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Preencher todos os campos");
            return;
        }
        
        if ( ufTexto.equals("UF") )
        {
            JOptionPane.showMessageDialog(null, "Escolher UF");
            return;
        }
        
        
        try {
            double distribuicaoDouble = Double.valueOf(advDistribuicaoText);
            advController.cadastrarAdvogado(advOabText, advNomeText,
                    distribuicaoDouble, nomeFilial, dataAssociacaoTexto, dataNascimentoTexto, email, ufTexto,usaTaxa);

        } catch (NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(null, "Erro - Distribuiçao incorreta ou inválida");
            return;
        }
            
        catch (ParseException pex) {

            JOptionPane.showMessageDialog(null, "Advogado nao cadastrado devido a data incorreta");
            return;
        } catch (BackendException ex) {
            JOptionPane.showMessageDialog(null, "Advogado nao cadastrado");
            return;
        }

        JOptionPane.showMessageDialog(null, "advogado cadastrado com sucesso");
        this.setVisible(false);

    }//GEN-LAST:event_btnCadastrarAdvogadoActionPerformed

    private void btnCancelarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarCadastroActionPerformed

    private void fmtOabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmtOabActionPerformed
    }//GEN-LAST:event_fmtOabActionPerformed

    private void fmtOabFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fmtOabFocusLost
    }//GEN-LAST:event_fmtOabFocusLost

    private void UfOabComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UfOabComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UfOabComboBoxActionPerformed

    private void btnLimparCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastroActionPerformed

        limpar();

    }//GEN-LAST:event_btnLimparCadastroActionPerformed

    private void fmtNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fmtNascimentoFocusLost
     /**   try {
            fmtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                        new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       fmtNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
    }//GEN-LAST:event_fmtNascimentoFocusLost

    private void fmtNascimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fmtNascimentoFocusGained
       try {
           fmtNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
            fmtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                        new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fmtNascimentoFocusGained

    private void setDefaultMasks() {
        try {
            //fmtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
              //      new javax.swing.text.MaskFormatter("##/##/####")));

            fmtAssociacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("##/##/####")));

            fmtOab.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("##.####")));

            txtDistribuicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("##.###,##")));

            filialComboBox.setToolTipText("Escolha a Filial:");

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Por gentileza, Preecha os campos corretamente!");
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

       

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox UfOabComboBox;
    private javax.swing.JButton btnCadastrarAdvogado;
    private javax.swing.JButton btnCancelarCadastro;
    private javax.swing.JButton btnLimparCadastro;
    private javax.swing.JCheckBox checkBoxTaxa;
    private javax.swing.JComboBox filialComboBox;
    private javax.swing.JFormattedTextField fmtAssociacao;
    private javax.swing.JFormattedTextField fmtNascimento;
    private javax.swing.JFormattedTextField fmtOab;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAssociacao;
    private javax.swing.JLabel lblDistribuicao;
    private javax.swing.JLabel lblDominio;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNomeAdvogado;
    private javax.swing.JLabel lblOab;
    private javax.swing.JFormattedTextField txtDistribuicao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
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

    private boolean existeFilial() {
        if (filialComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "um advogado precisa estar associado a uma filial, cadastre uma filial.");
            return false;
        }
        return true;
    }

    private void limpar() {
        txtNome.setText("");
        UfOabComboBox.setToolTipText("TESTE");
        fmtOab.setText("");
        txtEmail.setText("");
        txtDistribuicao.setText("");
        fmtNascimento.setText("");
        fmtAssociacao.setText("");
        filialComboBox.setToolTipText("Escolha a Filial:");
        setDefaultMasks();
    }
}
