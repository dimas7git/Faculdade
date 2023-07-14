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

import br.com.projeto_kevin.ctr.ProdutoCTR;
import br.com.projeto_kevin.dao.ConexaoDAO;
import br.com.projeto_kevin.dto.ProdutoDTO;
import br.com.projeto_kevin.dto.FuncionarioDTO;
import br.com.projeto_kevin.ctr.FuncionarioCTR;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Painel para cadastro de Produtos.
 * 
 * @author Kevin
 * @version 1.0
 */
public class ProdutoVIEW extends javax.swing.JInternalFrame {
    FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
    FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
    
    private ResultSet rs = null;
    BufferedImage imagem;
    
    /**
     * Cria um novo formulário ProdutoVIEW.
     */
    public ProdutoVIEW() {
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
     * Método responsável por importar a imagem do produto.
     */
    private void importarImagem() {
        
    JFileChooser fc = new JFileChooser();
    int res = fc.showOpenDialog(null);
    if (res == 0) {
            File arquivo = fc.getSelectedFile();
        try {
            this.imagem = ManipularImagemVIEW.setImagemDimensao(arquivo.getAbsolutePath(), 417, 254);
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
//        JFileChooser arquivo = new JFileChooser();
//        arquivo.setDialogTitle("Selecione a imagem");
//        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        
//        int opcao = arquivo.showOpenDialog(this);
//        if (opcao == JFileChooser.APPROVE_OPTION) {
//            File file = new File("Caminho");
//            file = arquivo.getSelectedFile(); // Recebe o caminho.
//            String filename = file.getAbsolutePath();
//            caminhoImagem.setText(filename);
//            
//            ImageIcon imagem = new ImageIcon(arquivo.getSelectedFile().getPath());
//            imagemPreview.setIcon(new ImageIcon(imagem.getImage().getScaledInstance
//            (imagemPreview.getWidth(), imagemPreview.getHeight(), Image.SCALE_DEFAULT)));
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao importar imagem!");
//        }
    }// Fecha o método importarImagem.
    
    /**
     * Método responsável por setar os Funcionários.
     */
    public void setarFuncionarios() {
        try {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            
            ConexaoDAO.ConectDB();
            funcionarioDTO.setNome(funcionarioDTO.getNome());
            rs = funcionarioCTR.consultarProduto(funcionarioDTO, 1);
            while (rs.next()) {
                responsavel.addItem(rs.getString("nome"));
            }
        }// Fecha try. 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }// Fecha catch.
    }// Fecha método setarFuncionarios.
    
    /**
     * Método responsável por cadastrar o produto no Banco de Dados.
     */
    private void inserirProduto() {
        try{
            ProdutoCTR produtoCTR = new ProdutoCTR();
            ProdutoDTO produtoDTO = new ProdutoDTO();
            
            produtoDTO.setProduto(produto.getText());
            produtoDTO.setData(data.getText());
            produtoDTO.setTipo(tipo.getText());
            produtoDTO.setValor(Integer.parseInt(valor.getText()));
            produtoDTO.setResponsavel(responsavel.getSelectedItem().toString());
            produtoDTO.setDescricao(descricao.getText());
            produtoDTO.setProduto_img(ManipularImagemVIEW.getImgBytes(imagem));
        
            JOptionPane.showMessageDialog(null, produtoCTR.inserirProduto(produtoDTO));
            
            limpaCampos();
        } // Fecha try.
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }// Fecha catch.
    }// Fecha o método inserirProduto.
    
    /**
     * Método responsável por limpar os campos e cancelar a operação.
     */
    private void limpaCampos() {
        produto.setText("");
        data.setText("");
        tipo.setText("");
        valor.setText("");
        responsavel.setSelectedItem("Funcionario 1");
        descricao.setText("");
        imagemPreview.setIcon(null);
        caminhoImagem.setText("");
        produto.requestFocus();
    }// Fecha o método cancelaCadastro.

    /**
     * Esse método é chamado de dentro do construtor para inicializar o formulário.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        produto = new javax.swing.JTextField();
        labelData = new javax.swing.JLabel();
        data = new javax.swing.JFormattedTextField();
        labelTipo = new javax.swing.JLabel();
        tipo = new javax.swing.JTextField();
        labelValor = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        labelResponsavel = new javax.swing.JLabel();
        responsavel = new javax.swing.JComboBox<>();
        labelDescricao = new javax.swing.JLabel();
        painelRolagem = new javax.swing.JScrollPane();
        descricao = new javax.swing.JEditorPane();
        painel = new javax.swing.JPanel();
        labelInfo = new javax.swing.JLabel();
        labelInfo2 = new javax.swing.JLabel();
        imagemPreview = new javax.swing.JLabel();
        btnSelecionarImagem = new javax.swing.JButton();
        caminhoImagem = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Produtos");

        labelNome.setText("Produto:");

        labelData.setText("Data:");

        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelTipo.setText("Tipo:");

        labelValor.setText("Valor:");

        labelResponsavel.setText("Responsável por cadastrar:");

        labelDescricao.setText("Descrição");

        painelRolagem.setViewportView(descricao);

        painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelInfo.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInfo.setText("Inserir imagem do Produto");

        labelInfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInfo2.setText("Caso seja de sua preferência, você pode inserir uma imagem");

        imagemPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnSelecionarImagem.setText("Selecionar Imagem");
        btnSelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarImagemActionPerformed(evt);
            }
        });

        caminhoImagem.setEditable(false);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(imagemPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addComponent(labelInfo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(59, 59, 59))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnSelecionarImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caminhoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addComponent(labelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarImagem)
                    .addComponent(caminhoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelDescricao)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar)
                            .addGap(18, 18, 18)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelResponsavel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelNome)
                                .addComponent(labelData))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(produto, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(painelRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTipo)
                    .addComponent(labelValor))
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
                            .addComponent(labelNome)
                            .addComponent(produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelData)
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTipo)
                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelValor)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelResponsavel)
                            .addComponent(responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)
                            .addComponent(btnSair)))
                    .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarImagemActionPerformed
        importarImagem();
    }//GEN-LAST:event_btnSelecionarImagemActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        inserirProduto();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSelecionarImagem;
    private javax.swing.JTextField caminhoImagem;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JEditorPane descricao;
    private javax.swing.JLabel imagemPreview;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelInfo2;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelResponsavel;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelValor;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane painelRolagem;
    private javax.swing.JTextField produto;
    private javax.swing.JComboBox<String> responsavel;
    private javax.swing.JTextField tipo;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
