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

import java.awt.Dimension;
import br.com.projeto_kevin.dao.ConexaoDAO;
import br.com.projeto_kevin.ctr.FuncionarioCTR;
import br.com.projeto_kevin.dto.FuncionarioDTO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Tela para gerenciamento de funcionários.
 *
 * @author Kevin
 * @version 1.0
 */
public class GerenciarFuncionarioVIEW extends javax.swing.JInternalFrame {
    FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
    FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
    
    private ResultSet rs = null;
    DefaultTableModel modelo_jtl_consultar_funcionario;
    BufferedImage imagem = null;
    
    /**
     * Creates new form GerenciarFuncionarioVIEW
     */
    public GerenciarFuncionarioVIEW() {
        initComponents();
        modelo_jtl_consultar_funcionario = (DefaultTableModel) mdl_tbl_funcionarios.getModel();
    }
    
    /**
     * Método responsável por importar a imagem do produto.
     */
    private void importarImagem() {
        
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        if (res == 0) {
            File arquivo = fc.getSelectedFile();
        try {
            this.imagem = ManipularImagemVIEW.setImagemDimensao(arquivo.getAbsolutePath(), 357, 258);
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
     * Método responsávle por atualizar a tabela.
     */
    public void atualizarTabela(){
        try {
            //Limpa todas as linhas.
            modelo_jtl_consultar_funcionario.setNumRows(0);
            //Enquanto tiver linhas - faça.
            funcionarioDTO.setNome(funcionarioDTO.getNome());
            rs = funcionarioCTR.consultarFuncionarios(funcionarioDTO, 1); //1 = faz a pesquisa por nome na classe DAO.
            while (rs.next()) {
                modelo_jtl_consultar_funcionario.addRow(new Object[] {
                rs.getString("id_funcionario"),
                rs.getString("nome"),
                rs.getString("dataNascimento"),
            });
            }
        }// Fecha try. 
        catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }// Fecha catch.
        finally{
            funcionarioCTR.CloseDB();
        }// Fecha finally.
    }// Fecha método atualizarTabela
    
    /**
     * Método responsável por setar a posição do internalFrame.
     */
//    public void setarPosicao() {
//        Dimension d = this.getDesktopPane().getSize();
//        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
//    }// Fecha setarPosicao.
    
    /**
     * Método responsável por setar os campos do formulário.
     * 
     * @param id_funcionario, vindo da classe PrincipalVIEW.
     */
//    public void setarCampos(int id_funcionario) {
//        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
//        FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
//        
//        /**
//         * Bug encontrado ao tentar trazer os dados do Banco de Dados de acordo 
//         * com a linha selecionada na tabela, sendo assim, o sistema sempre trás 
//         * os dados do primeiro item exibido na tabela
//         */
//        try {
//            funcionarioDTO.setId_funcionario(id_funcionario);
//            ResultSet rs = funcionarioCTR.consultarProduto(funcionarioDTO, 2);
//            if (rs.next()) {
//                nome.setText(rs.getString("nome"));
//                dataNascimento.setText(rs.getString("dataNascimento"));
//                idFuncionario.setText(rs.getString("id_funcionario"));
//                idade.setText(rs.getString("idade"));
//                ManipularImagemVIEW.exibeImagemLabel(rs.getBytes("imagem"), imagemPreview);
//            } else {
//                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
//                nome.setText("");
//                dataNascimento.setText("");
//                idFuncionario.setText("");
//                idade.setText("");
//                imagemPreview.setIcon(new ImageIcon(""));
//            }
//        }
//        catch (Exception ex) {
//            System.out.println("Erro: " + ex.getMessage());
//        }
//        finally {
//            funcionarioCTR.CloseDB();
//        }
//    }// Fecha o método setarCampos.
//    
//    /**
//     * Método responsável por alterar os dados do produto.
//     */
//    private void alterarFuncionario() {
//        try{
//            FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
//            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
//            
//            funcionarioDTO.setNome(nome.getText());
//            funcionarioDTO.setDataNascimento(dataNascimento.getText());
//            funcionarioDTO.setId_funcionario(Integer.parseInt(idFuncionario.getText()));
//            funcionarioDTO.setIdade(Integer.parseInt(idade.getText()));
//            funcionarioDTO.setFuncionario_img(ManipularImagemVIEW.getImgBytes(imagem));
//        
//            JOptionPane.showMessageDialog(null, funcionarioCTR.alterarFuncionario(funcionarioDTO));
//            
//            limpaCampos();
//            atualizarTabela();
//        } // Fecha try.
//        catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }// Fecha catch.
//    }// Fecha o método alterarProduto.
//    
//    /**
//     * Método responsável por excluir o produto.
//     */
//    private void excluirFuncionario() {
//        try{
//            FuncionarioCTR funcionarioCTR = new FuncionarioCTR();
//            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
//            
//            funcionarioDTO.setId_funcionario(Integer.parseInt(idFuncionario.getText()));
//            
//            JOptionPane.showMessageDialog(null, funcionarioCTR.excluirFuncionario(funcionarioDTO));
//            
//            limpaCampos();
//            atualizarTabela();
//        } // Fecha try.
//        catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }// Fecha catch.
//    }// Fecha o método excluirProduto.
//    
//    /**
//     * Método responsável por limpar os campos.
//     */
//    private void limpaCampos() {
//        nome.setText("");
//        dataNascimento.setText("");
//        idFuncionario.setText("");
//        idade.setText("");
//        imagemPreview.setIcon(null);
//        caminhoImagem.setText("");
//    }// Fecha método limpaCampos.

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane();
        mdl_tbl_funcionarios = new javax.swing.JTable();
        labelNome = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        labelDataNascimento = new javax.swing.JLabel();
        labelIdade = new javax.swing.JLabel();
        idade = new javax.swing.JTextField();
        painel = new javax.swing.JPanel();
        btnSelecionarImagem = new javax.swing.JButton();
        caminhoImagem = new javax.swing.JTextField();
        imagemPreview = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idFuncionario = new javax.swing.JTextField();
        dataNascimento = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerenciamento de Funcionarios");

        mdl_tbl_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Funcionario", "Nome", "Data de Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mdl_tbl_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mdl_tbl_funcionariosMouseClicked(evt);
            }
        });
        scrollPanel.setViewportView(mdl_tbl_funcionarios);

        labelNome.setText("Nome:");

        labelDataNascimento.setText("Data de Nascimento:");

        labelIdade.setText("Idade:");

        painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSelecionarImagem.setText("Selecionar Imagem");
        btnSelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarImagemActionPerformed(evt);
            }
        });

        caminhoImagem.setEditable(false);

        imagemPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagemPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(btnSelecionarImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caminhoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagemPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarImagem)
                    .addComponent(caminhoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Funcionario:");

        idFuncionario.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair))
                    .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataNascimento)
                            .addComponent(labelNome)
                            .addComponent(labelIdade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idade, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNome)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDataNascimento)
                            .addComponent(jLabel1)
                            .addComponent(idFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdade)
                            .addComponent(idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setBounds(0, 0, 810, 515);
    }// </editor-fold>//GEN-END:initComponents
//
    private void mdl_tbl_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mdl_tbl_funcionariosMouseClicked
//        setarCampos(Integer.parseInt(String.valueOf(
//                mdl_tbl_funcionarios.getValueAt(
//                mdl_tbl_funcionarios.getSelectedRow(), 0))));
    }//GEN-LAST:event_mdl_tbl_funcionariosMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
//        alterarFuncionario();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarImagemActionPerformed
        importarImagem();
    }//GEN-LAST:event_btnSelecionarImagemActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//        limpaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        excluirFuncionario();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionarImagem;
    private javax.swing.JTextField caminhoImagem;
    private javax.swing.JFormattedTextField dataNascimento;
    private javax.swing.JTextField idFuncionario;
    private javax.swing.JTextField idade;
    private javax.swing.JLabel imagemPreview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelIdade;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTable mdl_tbl_funcionarios;
    private javax.swing.JTextField nome;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
