package br.com.assados.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.assados.dto.FornecedorDTO;
import br.com.assados.ctr.FornecedorCTR;

public class FornecedorVIEW extends javax.swing.JInternalFrame {

    FornecedorDTO fornecedorDTO = new FornecedorDTO();  // Cria um objeto DTO
    FornecedorCTR fornecedorCTR = new FornecedorCTR();  // Cria um objeto CTR

    int gravar_alterar;                                 //Variável usada para saber se esta alterando ou incluindo

    ResultSet rs;                                       // Variável usada para preenchimento da tabela e dos campos
    DefaultTableModel modelo_jtl_consultar_fornecedor;  //variável para guardar o modelo da tabela

    /**
     * Método utilizado para centralizar oa internal Frame
     */
// public void setPosicao(){
//        Dimension d = this.getDesktopPane().getSize();
//        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
//    }
    /**
     * Método utilizadoa para gravar os dados do foirbecedir
     */
    private void gravar() {
        try {
            fornecedorDTO.setNomeForne(nomeForne.getText());
            fornecedorDTO.setProdutoForne(produtoForne.getText());
            fornecedorDTO.setQtdProd(Double.parseDouble((qtdProd.getText())));
            fornecedorDTO.setPrecoTotal(Double.parseDouble((precoTotal.getText())));

            JOptionPane.showMessageDialog(null, fornecedorCTR.inserirFornecedor(fornecedorDTO));
        } catch (Exception e) {
            System.out.println("Erro ao gravar" + e.getMessage());
        }
    }

    private void alterar() {
        try {
            fornecedorDTO.setNomeForne(nomeForne.getText());
            fornecedorDTO.setProdutoForne(produtoForne.getText());
            fornecedorDTO.setQtdProd(Double.parseDouble((qtdProd.getText())));
            fornecedorDTO.setPrecoTotal(Double.parseDouble((precoTotal.getText())));

            JOptionPane.showMessageDialog(null,
                    fornecedorCTR.alterarFornecedor(fornecedorDTO));
        } catch (Exception e) {
            System.out.println("Erro ao Alterar" + e.getMessage());
        }

    }// Close Alterar

    private void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir o fornecedor?", "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    fornecedorCTR.excluirFornecedor(fornecedorDTO));
        }
    }//Close excluir

    private void liberaCampos(boolean a) {
        nomeForne.setEnabled(a);
        produtoForne.setEnabled(a);
        qtdProd.setEnabled(a);
        precoTotal.setEnabled(a);
    }// fecha liberaCampos

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }//Fecha método

    private void limpaCampos() {
        nomeForne.setText("");
        produtoForne.setText("");
        qtdProd.setText("");
        precoTotal.setText("");
    }// fecha método

    /**
     * Método utilizado para preencher/construir a Jtable
     */
    private void preencheTabela(String nome_forne) {
        try {
            //Limpa todas as linhas
            modelo_jtl_consultar_fornecedor.setNumRows(0);
            //Enquanto tiver linhas - faça
            fornecedorDTO.setNomeForne(nome_forne);
            rs = fornecedorCTR.consultarFornecedor(fornecedorDTO, 1);
            while (rs.next()) {
                modelo_jtl_consultar_fornecedor.addRow(new Object[]{
                    rs.getString("id_fornec"),
                    rs.getString("nomeForne"),
                    rs.getString("produtoForne"),
                    rs.getString("precoTotal"),
                    
                    });

            }
        } catch (Exception erTab) {
            System.out.println("Errp SQL" + erTab);
        } finally {
            fornecedorCTR.CloseDB();
        }
    }//Fecha o método preencheTabela

    /**
     * Método utilizado para preencher os campos da tela com valores do
     * fornecedor
     */
    private void preencheCampos(int IdFornec) {
        try {
            fornecedorDTO.setIdFornec(IdFornec);
            rs = fornecedorCTR.consultarFornecedor(fornecedorDTO, 2); //2 é a pesquisa no id na classe DAO
            if (rs.next()) {
                limpaCampos();

                nomeForne.setText(rs.getString("nomeForne"));
                produtoForne.setText(rs.getString("produtoForne"));
                qtdProd.setText(rs.getString("qtdProd"));
                precoTotal.setText(rs.getString("precoTotal"));

                gravar_alterar = 2;
                liberaCampos(true);

            }//Fecha if(rs.next)
        } //fecha try
        catch (Exception erTab) {
            System.out.println("Erro SQL" + erTab);
        } finally {
            fornecedorCTR.CloseDB();
        }
    }

    public FornecedorVIEW() {
        initComponents();

        //Chama todos os modelos liberaCampos
        liberaCampos(false);
        //Chama o método liberaBotões
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_fornecedor = (DefaultTableModel) jtl_tabela_fornecedor.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nnso = new javax.swing.JLabel();
        nomeForne = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        produtoForne = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pesquisa_nome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_tabela_fornecedor = new javax.swing.JTable();
        btnNovo = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        btnExcluir = new javax.swing.JToggleButton();
        btnSair = new javax.swing.JToggleButton();
        precoTotal = new javax.swing.JTextField();
        qtdProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Fornecedor");

        nnso.setText("Nome:");

        jLabel2.setText("Produto fornecido");

        jLabel4.setText("Preço total");

        jLabel5.setText("Consulta");

        jLabel6.setText("Nome:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jtl_tabela_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Produto", "PreçoTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_tabela_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_tabela_fornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_tabela_fornecedor);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(29, 29, 29)
                            .addComponent(qtdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(precoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nnso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeForne, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(produtoForne, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(162, 162, 162))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(pesquisa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSair)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nnso)
                    .addComponent(nomeForne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(pesquisa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(produtoForne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(precoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)
                            .addComponent(btnExcluir)
                            .addComponent(btnSair)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (gravar_alterar == 1) {
            gravar();
            gravar_alterar = 0;
        } else {
            if (gravar_alterar == 2) {
                alterar();
                gravar_alterar = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Erro no Sistema!!!");
            }
        }
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        preencheTabela(pesquisa_nome.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jtl_tabela_fornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_tabela_fornecedorMouseClicked

        preencheCampos(Integer.parseInt((String.valueOf(
                jtl_tabela_fornecedor.getValueAt(jtl_tabela_fornecedor.getSelectedRow(), 0)))));
        liberaBotoes(false, true, true, true, true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtl_tabela_fornecedorMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_fornecedor.setNumRows(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_fornecedor.setNumRows(0);
        liberaBotoes(true, false, false, false, true);
        gravar_alterar = 0;


    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JToggleButton btnNovo;
    private javax.swing.JToggleButton btnPesquisar;
    private javax.swing.JToggleButton btnSair;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtl_tabela_fornecedor;
    private javax.swing.JLabel nnso;
    private javax.swing.JTextField nomeForne;
    private javax.swing.JTextField pesquisa_nome;
    private javax.swing.JTextField precoTotal;
    private javax.swing.JTextField produtoForne;
    private javax.swing.JTextField qtdProd;
    // End of variables declaration//GEN-END:variables
}
