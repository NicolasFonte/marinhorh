/*
 * CadastrarAdvogado.java
 *
 * Created on 06/05/2012, 17:22:24
 */
package com.rochamarinho.ui;

import com.rochamarinho.controller.AdvogadoController;
import com.rochamarinho.controller.FilialController;
import com.rochamarinho.controller.TaxaController;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Filial;
import com.rochamarinho.model.Taxa;
import com.rochamarinho.utils.BackendException;
import com.rochamarinho.utils.IeValidator;
import java.awt.Color;
import java.awt.TextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author nicolas
 */
public class EditarAdvogadoPanel extends javax.swing.JPanel {

    AdvogadoController advController = new AdvogadoController();
    TaxaController taxaController = new TaxaController();
    FilialController filialController = new FilialController();
    Advogado adv;
    
    /** Creates new form CadastrarAdvogado */
    public EditarAdvogadoPanel() {
        initComponents();
    }
    
    public EditarAdvogadoPanel(Advogado adv)
    {
        this();
        this.adv = adv;
        setDefaultTaxaText();
        setFiliaisNoComboBox();
        setAdvogadoValores();
       // setDefaultMasks();
        
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        lblNomeAdvogado = new javax.swing.JLabel();
        lblDistribuicao = new javax.swing.JLabel();
        btnAtualizarAdvogado = new javax.swing.JButton();
        lblOab = new javax.swing.JLabel();
        filialComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        fmtOab = new javax.swing.JFormattedTextField();
        lblAssociacao = new javax.swing.JLabel();
        UfOabComboBox = new javax.swing.JComboBox();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        fmtAssociacao = new javax.swing.JFormattedTextField();
        lblDominio = new javax.swing.JLabel();
        txtDistribuicao = new javax.swing.JFormattedTextField();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setNextFocusableComponent(txtNome);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setRequestFocusEnabled(false);

        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });

        lblNomeAdvogado.setText("Nome:");

        lblDistribuicao.setText("Distribuição:");

        btnAtualizarAdvogado.setText("atualizar");
        btnAtualizarAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarAdvogadoActionPerformed(evt);
            }
        });

        lblOab.setText("Oab:");

        filialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "default" }));

        jLabel2.setText("Filial:");

        fmtOab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fmtOabMouseClicked(evt);
            }
        });
        fmtOab.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fmtOabFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fmtOabFocusLost(evt);
            }
        });

        lblAssociacao.setText("Associacao:");

        UfOabComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UF","AC","AL","AM","AP","BA","CE","DF","ES","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO","RR","RS","SC","SE","SP","TO" }));

        lblEmail.setText("E-mail:");

        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        fmtAssociacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fmtAssociacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fmtAssociacaoFocusLost(evt);
            }
        });

        lblDominio.setText("@rochamarinho.adv.br");

        txtDistribuicao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDistribuicaoFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail)
                            .addComponent(lblDistribuicao)
                            .addComponent(lblOab)
                            .addComponent(lblNomeAdvogado)
                            .addComponent(lblAssociacao))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtualizarAdvogado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(UfOabComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fmtOab, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtNome)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDistribuicao)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblDominio))
                        .addComponent(fmtAssociacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAdvogado)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
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
                    .addComponent(txtDistribuicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAssociacao)
                    .addComponent(fmtAssociacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnAtualizarAdvogado)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarAdvogadoActionPerformed

        boolean existeFilial = existeFilial();
        if (existeFilial == false) {
            return;
        }

        boolean usaTaxa = true;//checkBoxTaxa.isSelected();
        
        String advNomeText = txtNome.getText();
        String advOabText = fmtOab.getText().replace(".", "").replace(" ", "");

        String advDistribuicaoText = txtDistribuicao.getText().replace(".", "").replace(",", ".");
        String nomeFilial = (String) filialComboBox.getSelectedItem();

        String dataAssociacaoTexto = fmtAssociacao.getText();
        String dataNascimentoTexto = "02/12/2000";//fmtNascimento.getText();
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
            advController.atualizarAdvogado(advOabText, advNomeText,
                    distribuicaoDouble, nomeFilial, dataAssociacaoTexto, dataNascimentoTexto, email, ufTexto,usaTaxa);

        } catch (NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(null, "Erro - Distribuiçao incorreta ou inválida");
            return;
        }
            
        catch (ParseException pex) {

            JOptionPane.showMessageDialog(null, "Advogado nao Atualizado devido a data incorreta");
            return;
        } catch (BackendException ex) {
            JOptionPane.showMessageDialog(null, "Advogado nao Atualizado");
            return;
        }

        JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        this.setVisible(false);

    }//GEN-LAST:event_btnAtualizarAdvogadoActionPerformed

    private void fmtAssociacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fmtAssociacaoFocusGained
        
            fmtAssociacao.setBorder(BorderFactory.createLineBorder(Color.yellow));
        try {
            fmtAssociacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("##/##/####")));
            fmtAssociacao.setText(new SimpleDateFormat("dd/MM/yyyy").format(adv.getAssociacao()));
        } catch (ParseException ex) {
            Logger.getLogger(EditarAdvogadoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_fmtAssociacaoFocusGained

    private void fmtAssociacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fmtAssociacaoFocusLost
        fmtAssociacao.setBorder(BorderFactory.createLineBorder(Color.gray));
    }//GEN-LAST:event_fmtAssociacaoFocusLost

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        txtNome.setBorder(BorderFactory.createLineBorder(Color.yellow));
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        txtNome.setBorder(BorderFactory.createLineBorder(Color.gray));
    }//GEN-LAST:event_txtNomeFocusLost

    private void fmtOabFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fmtOabFocusGained
       fmtOab.setBorder(BorderFactory.createLineBorder(Color.yellow));
       try{
            fmtOab.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("###.###")));
            
            String advOab = adv.getOab().substring(2);
            String formattingOab = advOab.substring(0, 3) + "." + advOab.substring(3, 6);
            
            fmtOab.setText(formattingOab);
       } catch (ParseException ex) {
            Logger.getLogger(EditarAdvogadoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fmtOabFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.yellow));
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.gray));
    }//GEN-LAST:event_txtEmailFocusLost

    private void fmtOabFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fmtOabFocusLost
        fmtOab.setBorder(BorderFactory.createLineBorder(Color.gray));
    }//GEN-LAST:event_fmtOabFocusLost

    private void txtDistribuicaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDistribuicaoFocusGained
        txtDistribuicao.setBorder(BorderFactory.createLineBorder(Color.yellow));
        try{
            txtDistribuicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("##.###,##")));            
            txtDistribuicao.setText(String.valueOf(adv.getDistribuicao()));
        } catch (ParseException ex) {
            Logger.getLogger(EditarAdvogadoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtDistribuicaoFocusGained

    private void fmtOabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fmtOabMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fmtOabMouseClicked

    protected void setDefaultTaxaText() {
        Taxa taxa = null;

        try {
            taxa = taxaController.getTaxa();
        } catch (BackendException ex) {
            Logger.getLogger(EditarAdvogadoPanel.class.getName()).log(Level.SEVERE, "taxa nao foi carregada", ex);
            taxa = new Taxa(0);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox UfOabComboBox;
    private javax.swing.JButton btnAtualizarAdvogado;
    private javax.swing.JComboBox filialComboBox;
    private javax.swing.JFormattedTextField fmtAssociacao;
    private javax.swing.JFormattedTextField fmtOab;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAssociacao;
    private javax.swing.JLabel lblDistribuicao;
    private javax.swing.JLabel lblDominio;
    private javax.swing.JLabel lblEmail;
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
        //UfOabComboBox.setToolTipText("TESTE");
        fmtOab.setText("");
        txtEmail.setText("");
        txtDistribuicao.setText("");
        //fmtNascimento.setText("");
        fmtAssociacao.setText("");
        //filialComboBox.setToolTipText("Escolha a Filial:");
        //setDefaultMasks();
    }

    public void setAdvogadoValores() {
        txtNome.setText(adv.getNome());
        String email = adv.getEmail();
        String [] partes = email.split("@");
        txtEmail.setText(partes[0]);
        
        
        try{
            txtDistribuicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("##.###,##")));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarAdvogado.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtDistribuicao.setText(String.valueOf(adv.getDistribuicao()));
        
        
        fmtAssociacao.setText(new SimpleDateFormat("dd/MM/yyyy").format(adv.getAssociacao()));
        
        
        String oab = adv.getOab().substring(2);
        String formattingOab = oab.substring(0, 3) + "." + oab.substring(3, 6);
        fmtOab.setText(formattingOab);
        
        
        UfOabComboBox.setSelectedIndex(descobrirIndiceDaUF(adv.getUf()));
        
        
        
    }
    
    public int descobrirIndiceDaUF(String uf)
    {
        
        for (int i = 0; i < UfOabComboBox.getItemCount(); i ++)
        {
            String item = (String) UfOabComboBox.getItemAt(i);
            if (  uf.equals(item)  )
            {
                return i;
            }
        }
        return -1;
    }
    
    
    
}
