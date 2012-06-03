/*
 * Principal.java
 *
 * Created on 29/04/2012, 16:31:28 pelo Nicolas
 */
package com.rochamarinho.ui;

import com.rochamarinho.model.Report;

/**
 *
 * @author nicolas
 */
public class Principal extends javax.swing.JFrame {

    /** Creates new form Principal */
    public Principal() {
        initComponents();
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
        menuFilial = new javax.swing.JMenu();
        itemMenuFilialCadastrar = new javax.swing.JMenuItem();
        itemMenuFilialBusca = new javax.swing.JMenuItem();
        menuTaxa = new javax.swing.JMenu();
        itemMenuAlterarTaxa = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItemSalarioAdvogados = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..:: Rocha, Marinho e Sales Advogados ::..");
        setMinimumSize(new java.awt.Dimension(500, 350));
        setPreferredSize(getMinimumSize());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/rochamarinho/utils/logo.png"))); // NOI18N
        lblLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuBar1.setName("Rocha Marinho"); // NOI18N

        menuAdvogado.setText("Advogados");

        menuItemCadastrar.setText("Cadastrar");
        menuItemCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastrarActionPerformed(evt);
            }
        });
        menuAdvogado.add(menuItemCadastrar);

        itemMenuBuscar.setText("Buscar");
        itemMenuBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuBuscarActionPerformed(evt);
            }
        });
        menuAdvogado.add(itemMenuBuscar);

        jMenuBar1.add(menuAdvogado);

        menuFilial.setText("Filiais");

        itemMenuFilialCadastrar.setText("Cadastrar");
        itemMenuFilialCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFilialCadastrarActionPerformed(evt);
            }
        });
        menuFilial.add(itemMenuFilialCadastrar);

        itemMenuFilialBusca.setText("Buscar");
        menuFilial.add(itemMenuFilialBusca);

        jMenuBar1.add(menuFilial);

        menuTaxa.setText("Taxas");

        itemMenuAlterarTaxa.setText("Setar Nova Taxa Padrao");
        itemMenuAlterarTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAlterarTaxaActionPerformed(evt);
            }
        });
        menuTaxa.add(itemMenuAlterarTaxa);

        jMenuBar1.add(menuTaxa);

        jMenu4.setText("Relatorios");

        menuItemSalarioAdvogados.setText("Salario Advogados");
        menuItemSalarioAdvogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalarioAdvogadosActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemSalarioAdvogados);

        jMenuItem3.setText("Advogados Por Filial");
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(lblLogo)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lblLogo)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastrarActionPerformed

        CadastrarAdvogado advPanel = new CadastrarAdvogado();
        this.setContentPane(advPanel);
        this.pack();

    }//GEN-LAST:event_menuItemCadastrarActionPerformed

    private void itemMenuAlterarTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAlterarTaxaActionPerformed
        AlterarTaxa alterarTaxaPanel = new AlterarTaxa();
        this.setContentPane(alterarTaxaPanel);
        this.pack();
    }//GEN-LAST:event_itemMenuAlterarTaxaActionPerformed

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

    private void menuItemSalarioAdvogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalarioAdvogadosActionPerformed

        Report.gerarRelatorioTodosAdvogados();


    }//GEN-LAST:event_menuItemSalarioAdvogadosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemMenuAlterarTaxa;
    private javax.swing.JMenuItem itemMenuBuscar;
    private javax.swing.JMenuItem itemMenuFilialBusca;
    private javax.swing.JMenuItem itemMenuFilialCadastrar;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JMenu menuAdvogado;
    private javax.swing.JMenu menuFilial;
    private javax.swing.JMenuItem menuItemCadastrar;
    private javax.swing.JMenuItem menuItemSalarioAdvogados;
    private javax.swing.JMenu menuTaxa;
    // End of variables declaration//GEN-END:variables
}
