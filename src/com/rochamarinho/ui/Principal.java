package com.rochamarinho.ui;

import com.rochamarinho.begin.Begin;
import com.rochamarinho.controller.AdvogadoController;
import com.rochamarinho.model.Advogado;
import com.rochamarinho.model.Pagamento;
import com.rochamarinho.ui.relatorioui.RelatorioAdvogado;
import com.rochamarinho.ui.relatorioui.RelatorioAnualAdvogados;
import com.rochamarinho.utils.BackendException;
import java.awt.CardLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author nicolas
 */
public class Principal extends javax.swing.JFrame {

    
    AdvogadoController advController = new AdvogadoController();
    private Map <Integer,String> numeroMes = new HashMap<Integer, String>();
    
    /** Creates new form Principal */
    public Principal() {
        initComponents();
        preencherRelacaoNumeroMes();
        
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        lblLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdvogado = new javax.swing.JMenu();
        menuItemCadastrar = new javax.swing.JMenuItem();
        itemMenuBuscar = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itemMenuAlterarTaxa1 = new javax.swing.JMenuItem();
        itemMenuFilialCadastrar = new javax.swing.JMenuItem();
        itemMenuEfetuarPagamento = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        itemMenuAdvogadosPorFilial = new javax.swing.JMenuItem();
        itemMenuRelatorioAnual = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..:: Rocha, Marinho e Sales Advogados ::..");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/rochamarinho/utils/logo.png"))); // NOI18N
        lblLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuBar1.setName("Rocha Marinho"); // NOI18N

        menuAdvogado.setText("Advogados");

        menuItemCadastrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menuItemCadastrar.setText("Cadastrar");
        menuItemCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastrarActionPerformed(evt);
            }
        });
        menuAdvogado.add(menuItemCadastrar);

        itemMenuBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        itemMenuBuscar.setText("Gerenciar");
        itemMenuBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuBuscarActionPerformed(evt);
            }
        });
        menuAdvogado.add(itemMenuBuscar);

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        menuAdvogado.add(jMenuItemSair);

        jMenuBar1.add(menuAdvogado);

        jMenu1.setText("Administração");

        itemMenuAlterarTaxa1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        itemMenuAlterarTaxa1.setText("Definir Nova Taxa Padrão");
        itemMenuAlterarTaxa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAlterarTaxa1ActionPerformed(evt);
            }
        });
        jMenu1.add(itemMenuAlterarTaxa1);

        itemMenuFilialCadastrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        itemMenuFilialCadastrar.setText("Filiais");
        itemMenuFilialCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFilialCadastrarActionPerformed(evt);
            }
        });
        jMenu1.add(itemMenuFilialCadastrar);

        itemMenuEfetuarPagamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        itemMenuEfetuarPagamento.setText("Efetuar Pagamento");
        itemMenuEfetuarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuEfetuarPagamentoActionPerformed(evt);
            }
        });
        jMenu1.add(itemMenuEfetuarPagamento);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Relatórios");

        itemMenuAdvogadosPorFilial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        itemMenuAdvogadosPorFilial.setText("Mensal");
        itemMenuAdvogadosPorFilial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAdvogadosPorFilialActionPerformed(evt);
            }
        });
        jMenu4.add(itemMenuAdvogadosPorFilial);

        itemMenuRelatorioAnual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        itemMenuRelatorioAnual.setText("Anual");
        itemMenuRelatorioAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuRelatorioAnualActionPerformed(evt);
            }
        });
        jMenu4.add(itemMenuRelatorioAnual);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastrarActionPerformed

        CadastrarAdvogado advPanel = new CadastrarAdvogado();
        this.setContentPane(advPanel);
        this.pack();

    }//GEN-LAST:event_menuItemCadastrarActionPerformed

    private void itemMenuFilialCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFilialCadastrarActionPerformed
        CadastrarFilial filPanel = new CadastrarFilial();
        this.setContentPane(filPanel);
        this.pack();
    }//GEN-LAST:event_itemMenuFilialCadastrarActionPerformed

    private void itemMenuBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuBuscarActionPerformed
        
        
        
        BuscarAdvogado buscar = new BuscarAdvogado();        
        
        this.setContentPane(buscar);
        this.pack();
                
    }//GEN-LAST:event_itemMenuBuscarActionPerformed

    private void itemMenuAdvogadosPorFilialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAdvogadosPorFilialActionPerformed


        RelatorioAdvogado relatorioPorFilial = new RelatorioAdvogado();
        this.setContentPane(relatorioPorFilial);
        this.pack();


    }//GEN-LAST:event_itemMenuAdvogadosPorFilialActionPerformed

    private void itemMenuAlterarTaxa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAlterarTaxa1ActionPerformed
        AlterarTaxa alterarTaxaPanel = new AlterarTaxa();
        this.setContentPane(alterarTaxaPanel);
        this.pack();
    }//GEN-LAST:event_itemMenuAlterarTaxa1ActionPerformed

    private void itemMenuEfetuarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        
        
        Date selecionada = new Date();
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja efetuar o pagamento de " + numeroMes.get(calendar.get(Calendar.MONTH)) + " ?" );
        if (opcao != 0)
        {
            return;
        }
        
        if (Begin.verificarSeHouvePagamento())
        {
            JOptionPane.showMessageDialog(null, "Já houve pagamento este mês.");
            return;
        }
                
        List<Advogado> advogados = advController.listarAdvogados();

        
        calendar.setTime(selecionada);
        int month = calendar.get(Calendar.MONTH);

        for (Advogado each : advogados) {
            Pagamento pg = new Pagamento();
            pg.setDataPagamento(selecionada);
            pg.setValorPago(each.getValores().get(month).getValor());
            each.addPagamento(pg);
            try {
                advController.getBackend().update(each);
            } catch (BackendException ex) {

                JOptionPane.showMessageDialog(null, "Não foi possível efetuar pagamento");
                return;
            }

        }
        
        JOptionPane.showMessageDialog(null, "Pagamento do mês " + numeroMes.get(calendar.get(Calendar.MONTH)) + " efetuado com sucesso");
    }
    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void itemMenuRelatorioAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuRelatorioAnualActionPerformed
        RelatorioAnualAdvogados anual = new RelatorioAnualAdvogados();
        this.setContentPane(anual);
        this.pack();
        

    }//GEN-LAST:event_itemMenuRelatorioAnualActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemMenuAdvogadosPorFilial;
    private javax.swing.JMenuItem itemMenuAlterarTaxa1;
    private javax.swing.JMenuItem itemMenuBuscar;
    private javax.swing.JMenuItem itemMenuEfetuarPagamento;
    private javax.swing.JMenuItem itemMenuFilialCadastrar;
    private javax.swing.JMenuItem itemMenuRelatorioAnual;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JMenu menuAdvogado;
    private javax.swing.JMenuItem menuItemCadastrar;
    // End of variables declaration//GEN-END:variables

    private void preencherRelacaoNumeroMes() {

        numeroMes.put(0, "Janeiro");    
        numeroMes.put(1, "Fevereiro");
        numeroMes.put(2, "Março");
        numeroMes.put(3, "Abril");
        numeroMes.put(4, "Maio");
        numeroMes.put(5, "Junho");
        numeroMes.put(6, "Julho");
        numeroMes.put(7, "Agosto");
        numeroMes.put(8, "Setembro");
        numeroMes.put(9, "Outubro");
        numeroMes.put(10, "Novembro");
        numeroMes.put(11, "Dezembro");
        
    }
}
