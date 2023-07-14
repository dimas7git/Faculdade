/*
 * The MIT License
 *
 * Copyright 2022 Kevin.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.projeto_kevin.view;

import java.text.DateFormat;
import java.util.Date;
import br.com.projeto_kevin.dao.ConexaoDAO;
import br.com.projeto_kevin.ctr.ProdutoCTR;
import br.com.projeto_kevin.dto.ProdutoDTO;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Painel principal do sistema.
 * 
 * @author Kevin
 * @version 1.0
 */
public class PrincipalVIEW extends javax.swing.JFrame {
    ProdutoDTO produtoDTO = new ProdutoDTO(); //Cria um objeto clienteDTO
    ProdutoCTR produtoCTR = new ProdutoCTR(); //Cria um objeto clienteCTR
    
    private ResultSet rs = null;
    DefaultTableModel modelo_jtl_consultar_produto;
    
    /**
     * Cria um novo formulário PrincipalVIEW.
     */
    public PrincipalVIEW() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo_jtl_consultar_produto = (DefaultTableModel) mdl_tbl_produtos.getModel();
        
        ConexaoDAO.ConectDB();
        // Estrutura de decisão para verificar a conexão com o Banco de Dados.
        if (ConexaoDAO.con != null) {
            labelStatus2.setText("Conectado!");
            labelStatus2.setForeground(Color.green);
        } else {
            labelStatus2.setText("Desconectado!");
            labelStatus2.setForeground(Color.red);
        }
        ConexaoDAO.CloseDB();
    }
    
    /**
     * Método responsável por sair do sistema.
     */
    private void sair(){
        Object[] options = { "Sair", "Cancelar" };
        if(JOptionPane.showOptionDialog(null, "Deseja Sair do Sistema", "InformaÃ§Ã£o",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0){
             System.exit(0);
        }
    }// Fecha o método sair.
    
    
    /**
     * Método responsável por abrir a tela de cadastro de produtos.
     */
    private void abreProdutoVIEW() {
        ProdutoVIEW produtoVIEW = new ProdutoVIEW();
        painelDesktop.add(produtoVIEW);
        produtoVIEW.setVisible(true);
        produtoVIEW.setarPosicao();
        produtoVIEW.setarFuncionarios();
    }// Fecha método abreProdutoVIEW.
    
    /**
     * Método responsável por abrir a tela de cadastro de funcionários.
     */
    private void abreFuncionarioVIEW() {
        FuncionarioVIEW funcionarioVIEW = new FuncionarioVIEW();
        painelDesktop.add(funcionarioVIEW);
        funcionarioVIEW.setVisible(true);
        funcionarioVIEW.setarPosicao();
    }// Fecha método abreFuncionarioVIEW.
    
    private void abreClienteVIEW() {
        ClienteVIEW clienteVIEW = new ClienteVIEW();
        painelDesktop.add(clienteVIEW);
        clienteVIEW.setVisible(true);
        clienteVIEW.setarPosicao();
    }
     private void abreCompraVIEW() {
        CompraVIEW compraVIEW = new CompraVIEW();
        painelDesktop.add(compraVIEW);
        compraVIEW.setVisible(true);
        compraVIEW.setPosicao();
    }
//    private void atualizarTabela(String nome) {
//        ProdutoCTR produtoCTR = new ProdutoCTR();
//        ProdutoDTO produtoDTO = new ProdutoDTO();
//        
//        try {
//            tbl_produtos.setNumRows(0);
//            produtoDTO.setProduto(nome);
//            rs = produtoCTR.consultarProduto(produtoDTO, 1);
//            while (rs.next()) {
//                tbl_produtos.addRow(new Object[] {
//                rs.getString("produto"),
//                rs.getString("data"),
//                rs.getString("valor"),
//                rs.getString("responsavel"),
//            });
//        } 
//        } catch (Exception erTab) {
//            System.out.println("Erro SQL: " + erTab);
//        }
//        finally{
//            produtoCTR.CloseDB();
//        }
    // Fecha o método atualizarTabela.
    
    /**
     * Método responsávle por atualizar a tabela.
     */
    private void atualizarTabela(){
        try {
            //Limpa todas as linhas.
            modelo_jtl_consultar_produto.setNumRows(0);
            //Enquanto tiver linhas - faça.
            produtoDTO.setProduto(produtoDTO.getProduto());
            rs = produtoCTR.consultarProduto(produtoDTO, 1); //1 = Ã© a pesquisa por nome na classe DAO.
            while (rs.next()) {
                modelo_jtl_consultar_produto.addRow(new Object[] {
                rs.getString("id_produto"),
                rs.getString("produto"),
                rs.getString("data"),
                rs.getString("valor"),
                rs.getString("responsavel"),
                rs.getString("descricao"),
            });
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
        finally{
            produtoCTR.CloseDB();
        }
    }
    
    /**
     * Método responsável por abrir a classe AlterarVIEW.
     */
    private void abreAlterarVIEW(int id_produto) {
        AlterarVIEW alterarVIEW = new AlterarVIEW(id_produto);
        painelDesktop.add(alterarVIEW);
        alterarVIEW.setVisible(true);
        alterarVIEW.setarPosicao();
        alterarVIEW.setarFuncionarios();
        alterarVIEW.setarCampos(id_produto);
    }// Fecha o método abreAlterarVIEW.
    
    /**
     * Método responsável por abrir a classe GerenciarFuncionarioVIEW.
     */
    private void abreGerenciarFuncionarioVIEW() {
        GerenciarFuncionarioVIEW gerenciarFuncionarioVIEW = new GerenciarFuncionarioVIEW();
        painelDesktop.add(gerenciarFuncionarioVIEW);
        gerenciarFuncionarioVIEW.setVisible(true);
//        gerenciarFuncionarioVIEW.setarPosicao();
        gerenciarFuncionarioVIEW.atualizarTabela();
    }// Fecha abreGerenciarFuncionarioVIEW.
    
    /**
     * Esse método é chamado de dentro do construtor para inicializar o formulário.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDesktop = new javax.swing.JDesktopPane();
        painel = new javax.swing.JPanel();
        labelData = new javax.swing.JLabel();
        labelInfo = new javax.swing.JLabel();
        painelRolagem = new javax.swing.JScrollPane();
        mdl_tbl_produtos = new javax.swing.JTable();
        btnAtualizarTabela = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        labelStatus2 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuItemProduto = new javax.swing.JMenuItem();
        subMenuFuncionario = new javax.swing.JMenu();
        menuItemCadastro = new javax.swing.JMenuItem();
        menuItemGerenciar = new javax.swing.JMenuItem();
        itemMenuCliente = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Stock");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        labelData.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        labelData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelInfo.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        labelInfo.setText("Smart Stock - Sistema para Controle de Estoque");

        mdl_tbl_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produto", "Produto", "Data", "Valor", "Funcionario", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mdl_tbl_produtos.getTableHeader().setReorderingAllowed(false);
        mdl_tbl_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mdl_tbl_produtosMouseClicked(evt);
            }
        });
        painelRolagem.setViewportView(mdl_tbl_produtos);

        btnAtualizarTabela.setText("Atualizar");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelRolagem)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(labelInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
                        .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnAtualizarTabela)
                        .addGap(0, 1112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelInfo)
                    .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtualizarTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDesktop.add(painel);
        painel.setBounds(0, 0, 1200, 630);

        labelStatus.setText("Status da Conexão com o Banco de Dados:");

        menuCadastro.setText("Cadastro");

        menuItemProduto.setText("Produto");
        menuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuItemProduto);

        subMenuFuncionario.setText("Funcionario");

        menuItemCadastro.setText("Cadastro");
        menuItemCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastroActionPerformed(evt);
            }
        });
        subMenuFuncionario.add(menuItemCadastro);

        menuItemGerenciar.setText("Gerenciar");
        menuItemGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciarActionPerformed(evt);
            }
        });
        subMenuFuncionario.add(menuItemGerenciar);

        menuCadastro.add(subMenuFuncionario);

        itemMenuCliente.setText("Cliente");
        itemMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuCliente);

        barraMenu.add(menuCadastro);

        jMenu1.setText("Compra");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Compra");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        barraMenu.add(jMenu1);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        barraMenu.add(menuSair);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatus)
                    .addComponent(labelStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
        labelData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowOpened

    private void menuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdutoActionPerformed
        abreProdutoVIEW();
    }//GEN-LAST:event_menuItemProdutoActionPerformed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void mdl_tbl_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mdl_tbl_produtosMouseClicked
        abreAlterarVIEW(Integer.parseInt(String.valueOf(
                mdl_tbl_produtos.getValueAt(
                mdl_tbl_produtos.getSelectedRow(), 0))));
    }//GEN-LAST:event_mdl_tbl_produtosMouseClicked

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        sair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void menuItemCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastroActionPerformed
        abreFuncionarioVIEW();
    }//GEN-LAST:event_menuItemCadastroActionPerformed

    private void menuItemGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciarActionPerformed
        abreGerenciarFuncionarioVIEW();
    }//GEN-LAST:event_menuItemGerenciarActionPerformed

    private void itemMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuClienteActionPerformed
             abreClienteVIEW();
    }//GEN-LAST:event_itemMenuClienteActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
           abreCompraVIEW();
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
           abreCompraVIEW();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JMenuItem itemMenuCliente;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelStatus2;
    public javax.swing.JTable mdl_tbl_produtos;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuItemCadastro;
    private javax.swing.JMenuItem menuItemGerenciar;
    private javax.swing.JMenuItem menuItemProduto;
    private javax.swing.JMenu menuSair;
    private javax.swing.JPanel painel;
    private javax.swing.JDesktopPane painelDesktop;
    private javax.swing.JScrollPane painelRolagem;
    private javax.swing.JMenu subMenuFuncionario;
    // End of variables declaration//GEN-END:variables

}
