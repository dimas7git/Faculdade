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

import br.com.projeto_kevin.ctr.FuncionarioCTR;
import br.com.projeto_kevin.ctr.ProdutoCTR;
import br.com.projeto_kevin.dao.ConexaoDAO;
import br.com.projeto_kevin.dto.FuncionarioDTO;
import br.com.projeto_kevin.dto.ProdutoDTO;
import java.sql.ResultSet;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Painel para alteração/exclusão de Produtos.
 *
 * @author Kevin
 */
public class AlterarVIEW extends javax.swing.JInternalFrame {
    BufferedImage imagem;
    
    /**
     * Cria um novo formulário AlterarVIEW.
     * 
     * @param id_produto, vindo da classe PrincipalVIEW.
     */
    public AlterarVIEW(int id_produto) {
        initComponents();
    }
    
    /**
     * Método responsável por setar a posição do internalFrame.
     */
    public void setarPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }// Fecha setarPosicao.
    
    /**
     * Método responsável por limpar os campos após operações.
     */
    private void limpaCampos() {
        produto.setText("");
        data.setText("");
        tipo.setText("");
        valor.setText("");
        responsavel.setSelectedItem("Funcionario 1");
        descricao.setText("");
        caminhoImagem.setText("");
        imagemPreview.setIcon(null);
        produto.requestFocus();
    }// Fecha o método limpaCampos.
    
    /**
     * Método responsável por importar a imagem do produto.
     */
    private void importarImagem() {
        
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        if (res == 0) {
            File arquivo = fc.getSelectedFile();
        try {
            this.imagem = ManipularImagemVIEW.setImagemDimensao(arquivo.getAbsolutePath(), 419, 258);
            this.imagemPreview.setIcon(new ImageIcon(this.imagem));
            
            String filename = arquivo.getAbsolutePath();
            caminhoImagem.setText(filename);
        } 
        catch (Exception exception) {
        // Sem tratamento.
        }
    } else {
      JOptionPane.showMessageDialog(null, "Voce não selecionou nenhum arquivo.");
    }
    }// Fecha método importarImagem.
    
    /**
     * Método responsável por setar os Funcionários.
     */
    public void setarFuncionarios() {
        try {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
            FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
            
            ConexaoDAO.ConectDB();
            funcionarioDTO.setNome(funcionarioDTO.getNome());
            ResultSet rs = funcionarioCTR.consultarProduto(funcionarioDTO, 1);
            while (rs.next()) {
                responsavel.addItem(rs.getString("nome"));
            }
        }// Fecha try. 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }// Fecha catch.
    }// Fecha método setarFuncionarios.
    
    /**
     * Método responsável por setar os campos do formulário.
     * 
     * @param id_produto, vindo da classe PrincipalVIEW.
     */
    public void setarCampos(int id_produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        ProdutoCTR produtoCTR = new ProdutoCTR();
        
        /**
         * Bug encontrado ao tentar trazer os dados do Banco de Dados de acordo 
         * com a linha selecionada na tabela, sendo assim, o sistema sempre trás 
         * os dados do primeiro item exibido na tabela
         */
        try {
            produtoDTO.setId_produto(id_produto);
            ResultSet rs = produtoCTR.consultarProduto(produtoDTO, 2);
            if (rs.next()) {
                produto.setText(rs.getString("produto"));
                data.setText(rs.getString("data"));
                idProduto.setText(rs.getString("id_produto"));
                tipo.setText(rs.getString("tipo"));
                valor.setText(rs.getString("valor"));
                responsavel.setSelectedItem(rs.getString("responsavel"));
                descricao.setText(rs.getString("descricao"));
                ManipularImagemVIEW.exibeImagemLabel(rs.getBytes("imagem"), imagemPreview);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                produto.setText("");
                data.setText("");
                tipo.setText("");
                valor.setText("");
                responsavel.setSelectedItem("Funcionario 1");
                descricao.setText("");
                imagemPreview.setIcon(new ImageIcon(""));
            }
        }
        catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        finally {
            produtoCTR.CloseDB();
        }
    }// Fecha o método setarCampos.
    
    /**
     * Método responsável por alterar os dados do produto.
     */
    private void alterarProduto() {
        try{
            ProdutoCTR produtoCTR = new ProdutoCTR();
            ProdutoDTO produtoDTO = new ProdutoDTO();
            
            produtoDTO.setProduto(produto.getText());
            produtoDTO.setData(data.getText());
            produtoDTO.setId_produto(Integer.parseInt(idProduto.getText()));
            produtoDTO.setTipo(tipo.getText());
            produtoDTO.setValor(Integer.parseInt(valor.getText()));
            produtoDTO.setResponsavel(responsavel.getSelectedItem().toString());
            produtoDTO.setDescricao(descricao.getText());
            produtoDTO.setProduto_img(ManipularImagemVIEW.getImgBytes(imagem));
        
            JOptionPane.showMessageDialog(null, produtoCTR.alterarProduto(produtoDTO));
            
            this.dispose();
        } // Fecha try.
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }// Fecha catch.
    }// Fecha o método alterarProduto.
    
    /**
     * Método responsável por excluir o produto.
     */
    private void excluirProduto() {
        try{
            ProdutoCTR produtoCTR = new ProdutoCTR();
            ProdutoDTO produtoDTO = new ProdutoDTO();
            
            produtoDTO.setId_produto(Integer.parseInt(idProduto.getText()));
            
            JOptionPane.showMessageDialog(null, produtoCTR.excluirProduto(produtoDTO));
            
            limpaCampos();
        } // Fecha try.
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }// Fecha catch.
    }// Fecha o método excluirProduto.

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        produto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        data = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        responsavel = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JEditorPane();
        painel = new javax.swing.JPanel();
        labelInfo1 = new javax.swing.JLabel();
        labelInfo2 = new javax.swing.JLabel();
        imagemPreview = new javax.swing.JLabel();
        caminhoImagem = new javax.swing.JTextField();
        btnSelecionarImagem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        idProduto = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Alteração/Exclusão de Produtos");

        jLabel1.setText("Produto:");

        jLabel2.setText("Data:");

        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Tipo:");

        jLabel4.setText("Valor:");

        jLabel5.setText("Responsavel por cadastrar:");

        jLabel6.setText("Descrição");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(descricao);

        painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelInfo1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelInfo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInfo1.setText("Inserir imagem do Produto");

        labelInfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInfo2.setText("Caso seja de sua preferência, você pode inserir uma imagem");

        imagemPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        caminhoImagem.setEditable(false);

        btnSelecionarImagem.setText("Selecionar Imagem");
        btnSelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarImagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelInfo2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagemPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnSelecionarImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caminhoImagem)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addComponent(labelInfo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caminhoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarImagem))
                .addContainerGap())
        );

        jLabel7.setText("ID do Produto:");

        idProduto.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(responsavel, 0, 161, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(produto, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(tipo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idProduto))))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(idProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlterar)
                            .addComponent(btnExcluir)
                            .addComponent(btnCancelar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarImagemActionPerformed
        importarImagem();
    }//GEN-LAST:event_btnSelecionarImagemActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarProduto();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirProduto();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSelecionarImagem;
    private javax.swing.JTextField caminhoImagem;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JEditorPane descricao;
    private javax.swing.JTextField idProduto;
    private javax.swing.JLabel imagemPreview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelInfo1;
    private javax.swing.JLabel labelInfo2;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField produto;
    private javax.swing.JComboBox<String> responsavel;
    private javax.swing.JTextField tipo;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
