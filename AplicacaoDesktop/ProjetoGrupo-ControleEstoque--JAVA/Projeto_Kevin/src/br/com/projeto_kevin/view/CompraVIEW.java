/*
 * The MIT License
 *
 * Copyright 2022 DimasFerreira.
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

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.projeto_kevin.ctr.ClienteCTR;
import br.com.projeto_kevin.dto.ClienteDTO;
import br.com.projeto_kevin.ctr.ProdutoCTR;
import br.com.projeto_kevin.ctr.VendaCTR;
import br.com.projeto_kevin.dao.ConexaoDAO;
import br.com.projeto_kevin.dto.ProdutoDTO;
import br.com.projeto_kevin.dto.VendaDTO;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.awt.Dimension;

/**
 *
 * @author DimasFerreira
 */
public class CompraVIEW extends javax.swing.JInternalFrame {

    private ResultSet rs = null;
    Statement stmt = null;
    Statement stmt1 = null;
    DefaultTableModel modelo_jtl_cliente;
    DefaultTableModel modelo_jtl_produto;
    DefaultTableModel modelo_jtl_produto_venda;
    ClienteDTO clienteDTO = new ClienteDTO();
    ClienteCTR clienteCTR = new ClienteCTR();
    ProdutoDTO produtoDTO = new ProdutoDTO();
    VendaCTR vendaCTR = new VendaCTR();
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    ProdutoCTR produtoCTR = new ProdutoCTR();
    VendaDTO vendaDTO = new VendaDTO();


    public CompraVIEW() {
        initComponents();
        modelo_jtl_cliente = (DefaultTableModel) jtl_cliente.getModel();
        modelo_jtl_produto = (DefaultTableModel) jtl_produto.getModel();
        modelo_jtl_produto_venda = (DefaultTableModel) jtl_produto_venda.getModel();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    private void limpaCampos(){
        nome.setText("");
        modelo_jtl_cliente.setNumRows(0);
        produto.setText("");
        modelo_jtl_produto.setNumRows(0);
        modelo_jtl_produto_venda.setNumRows(0);
    }
    
    private void gravar(){
        vendaDTO.setDat_vend(new java.util.Date());
        vendaDTO.setVal_vend(Double.parseDouble(TotalVenda.getText()));
        vendaDTO.setQtd_vend(Integer.parseInt( String.valueOf(jtl_produto_venda.getValueAt(jtl_produto_venda.getSelectedRow(), 3))  ));
        clienteDTO.setId_cliente(Integer.parseInt(String.valueOf(jtl_cliente.getValueAt(jtl_cliente.getSelectedRow(), 0))));
        produtoDTO.setId_produto(Integer.parseInt(String.valueOf(jtl_produto.getValueAt(jtl_produto.getSelectedRow(), 0))));

        JOptionPane.showMessageDialog(null, vendaCTR.inserirVenda(vendaDTO, clienteDTO, jtl_produto_venda, produtoDTO));
        
    
    }


    public void salvarCliente(int id_cliente) {

        try {
            clienteDTO.setId_cliente(id_cliente);
            ResultSet rs = clienteCTR.consultarCliente(clienteDTO, 1);
            if (rs.next()) {
                rs.getString("id_cliente");
                rs.getString("nome");
                rs.getString("telefone");
                rs.getString("cpf");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }

        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            clienteCTR.CloseDB();
        }
    }
    
    private void adicionaProdutoSelecionada(int id_prod, String produto, double p_venda_prod) {
        try {
            modelo_jtl_produto_venda.addRow(new Object[] {
                id_prod,
                produto,
                p_venda_prod
            });
        } 
        catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }
    
    private void removeProdutoSelecionado(int linha_selecionada){
        try{
            if(linha_selecionada >= 0){
                modelo_jtl_produto_venda.removeRow(linha_selecionada);
                //calculaTotalVenda();
                TotalVenda.setText("0.0");
            }
        }
        catch(Exception erTab){
            System.out.println("Erro SQL: "+ erTab);
        }
    }
    
    private void calculaTotalVenda(){
        try{
            double total = 0;
            for(int cont=0; cont<jtl_produto_venda.getRowCount();cont++){
                total += (Double.parseDouble(String.valueOf(
                          jtl_produto_venda.getValueAt(cont, 2))) *
                          Integer.parseInt(String.valueOf(
                          jtl_produto_venda.getValueAt(cont, 3))));
                TotalVenda.setText(String.valueOf(total));        
        }
        }
        catch(Exception erTab){
            System.out.println("Erro SQL: "+ erTab);
        }
    }

    public boolean inserirVenda() {
        try {
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();

            String comando1 = "Insert into Comprou (id_cliente) values ( "
                      +"to_date('" + date.format(vendaDTO.getDat_vend()) + "', 'DD/MM/YYYY'), "
                    + clienteDTO.getId_cliente() + ")";

            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();

            for (int cont = 0; cont < modelo_jtl_produto.getRowCount(); cont++) {
                String comando2 = "Insert into Venda (id_vend, id_prod, "
                        + ") values ("
                        + rs.getInt("id_vend") + ", "
                        + modelo_jtl_produto.getValueAt(cont, 0) + ", "

                        + modelo_jtl_produto.getValueAt(cont, 2) + "); ";
                stmt1.execute(comando2);
            }

            ConexaoDAO.con.commit();
            stmt.close();
            rs.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    private void preencheTabela(String nome) {
        try {
            //Limpa todas as linhas
            modelo_jtl_cliente.setNumRows(0);
            //Enquanto tiver linhas - faça
            clienteDTO.setNome(nome);
            rs = clienteCTR.consultarCliente(clienteDTO, 1);
            while (rs.next()) {
                modelo_jtl_cliente.addRow(new Object[]{
                    rs.getString("id_cliente"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("cpf"),});

            }
        } catch (Exception erTab) {
            System.out.println("Errp SQL" + erTab);
        } finally {
            clienteCTR.CloseDB();
        }
    }

    private void preencheTabelaProduto(String produto) {
        try {
            //Limpa todas as linhas
            modelo_jtl_produto.setNumRows(0);
            //Enquanto tiver linhas - faça
            produtoDTO.setProduto(produtoDTO.getProduto());
            rs = produtoCTR.consultarProduto(produtoDTO, 1);
            while (rs.next()) {
                modelo_jtl_produto.addRow(new Object[]{
                    rs.getString("id_produto"),
                    rs.getString("produto"),
                    rs.getString("valor"),
                });

            }
        } catch (Exception erTab) {
            System.out.println("Errp SQL" + erTab);
        } finally {
            clienteCTR.CloseDB();
        }
    }
    
    private boolean verificaPreencimento(){
        if(jtl_cliente.getSelectedRow()<= 0){
            JOptionPane.showMessageDialog(null, "Deve ser selecionado um Cliente");
            jtl_cliente.requestFocus();
            return false;
        }
        else{
            if(jtl_produto_venda.getRowCount() <= 0){
                JOptionPane.showMessageDialog(null, "É necessário adicionar pelo menos um produto no pedido");
                jtl_produto_venda.requestFocus();
                return false;
            }
            int verifica=0;
            for(int cont=0; cont<jtl_produto_venda.getRowCount();cont++){
                if(String.valueOf(jtl_produto_venda.getValueAt(
                    cont, 3)).equalsIgnoreCase("null")){
                    verifica++;
                }
            }
            if(verifica >0){
                JOptionPane.showMessageDialog(null, "A quantidade de cada produto vendido deve ser informado");
                jtl_produto_venda.requestFocus();
                return false;
            }
            else{
                return true;
            }//Close else2
        }//Close else1
        
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_cliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_produto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        pesquisa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        produto = new javax.swing.JTextField();
        pesquisar_produto = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtl_produto_venda = new javax.swing.JTable();
        AddPro = new javax.swing.JButton();
        RemPro = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        painel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TotalVenda = new javax.swing.JLabel();

        setTitle("Compras");

        jtl_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Telefone", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtl_cliente);
        if (jtl_cliente.getColumnModel().getColumnCount() > 0) {
            jtl_cliente.getColumnModel().getColumn(0).setResizable(false);
            jtl_cliente.getColumnModel().getColumn(1).setResizable(false);
            jtl_cliente.getColumnModel().getColumn(2).setResizable(false);
            jtl_cliente.getColumnModel().getColumn(3).setResizable(false);
        }

        jtl_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtl_produto);
        if (jtl_produto.getColumnModel().getColumnCount() > 0) {
            jtl_produto.getColumnModel().getColumn(0).setResizable(false);
            jtl_produto.getColumnModel().getColumn(1).setResizable(false);
            jtl_produto.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Pesquisar nome:");

        pesquisa.setText("OK");
        pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisa produto:");

        pesquisar_produto.setText("OK");
        pesquisar_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisar_produtoActionPerformed(evt);
            }
        });

        jtl_produto_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_produto_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtl_produto_vendaKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtl_produto_venda);
        if (jtl_produto_venda.getColumnModel().getColumnCount() > 0) {
            jtl_produto_venda.getColumnModel().getColumn(0).setResizable(false);
            jtl_produto_venda.getColumnModel().getColumn(1).setResizable(false);
            jtl_produto_venda.getColumnModel().getColumn(2).setResizable(false);
            jtl_produto_venda.getColumnModel().getColumn(3).setResizable(false);
        }

        AddPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_kevin/view/imagens/prod_add.png"))); // NOI18N
        AddPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProActionPerformed(evt);
            }
        });

        RemPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_kevin/view/imagens/prod_rem.png"))); // NOI18N
        RemPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemProActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel3.setText("Total da Venda:");

        TotalVenda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TotalVenda.setText("0.00");

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TotalVenda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddPro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RemPro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(produto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisa)
                    .addComponent(jLabel2)
                    .addComponent(produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar_produto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddPro)
                            .addComponent(RemPro))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSalvar)
                                .addComponent(btnSair)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaActionPerformed
        preencheTabela(nome.getText());
    }//GEN-LAST:event_pesquisaActionPerformed

    private void pesquisar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisar_produtoActionPerformed
        preencheTabelaProduto(produto.getText());
    }//GEN-LAST:event_pesquisar_produtoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void AddProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProActionPerformed
        adicionaProdutoSelecionada(
        Integer.parseInt(String.valueOf(jtl_produto.getValueAt(
                jtl_produto.getSelectedRow(), 0))),
        String.valueOf(jtl_produto.getValueAt(jtl_produto.getSelectedColumn(), 1)),
        Double.parseDouble(String.valueOf(jtl_produto.getValueAt(
                jtl_produto.getSelectedRow(), 2 )))
        );
    }//GEN-LAST:event_AddProActionPerformed

    private void RemProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemProActionPerformed
        removeProdutoSelecionado(jtl_produto_venda.getSelectedRow());
    }//GEN-LAST:event_RemProActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(verificaPreencimento())
            gravar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtl_produto_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtl_produto_vendaKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
	    calculaTotalVenda();
        }
    }//GEN-LAST:event_jtl_produto_vendaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPro;
    private javax.swing.JButton RemPro;
    private javax.swing.JLabel TotalVenda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtl_cliente;
    private javax.swing.JTable jtl_produto;
    private javax.swing.JTable jtl_produto_venda;
    private javax.swing.JTextField nome;
    private javax.swing.JPanel painel;
    private javax.swing.JButton pesquisa;
    private javax.swing.JButton pesquisar_produto;
    private javax.swing.JTextField produto;
    // End of variables declaration//GEN-END:variables

}
