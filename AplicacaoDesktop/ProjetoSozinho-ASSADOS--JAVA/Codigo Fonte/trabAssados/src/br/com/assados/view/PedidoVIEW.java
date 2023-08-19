package br.com.assados.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import br.com.assados.dto.PedidoDTO;
import br.com.assados.dto.ClienteDTO;
import br.com.assados.ctr.ClienteCTR;
import br.com.assados.ctr.PedidoCTR;
import br.com.assados.dto.FornecedorDTO;
import br.com.assados.ctr.FornecedorCTR;

public class PedidoVIEW extends javax.swing.JInternalFrame {

    PedidoCTR pedidoCTR = new PedidoCTR();
    PedidoDTO pedidoDTO = new PedidoDTO();
    ClienteCTR clienteCTR = new ClienteCTR();
    ClienteDTO clienteDTO = new ClienteDTO();
    FornecedorCTR fornecedorCTR = new FornecedorCTR();
    FornecedorDTO fornecedorDTO = new FornecedorDTO();

    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_cli;
    DefaultTableModel modelo_jtl_consultar_pro;
    DefaultTableModel modelo_jtl_consultar_pro_selecionado;

    public PedidoVIEW() {
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, true);
        modelo_jtl_consultar_pro_selecionado = (DefaultTableModel) jtl_consultar_pro_selecionado.getModel();
        modelo_jtl_consultar_pro = (DefaultTableModel) jtl_consultar_pro.getModel();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void gravar() {
        pedidoDTO.setNomeCli(nomeCli.getText());
        pedidoDTO.setEnd(endereco.getText());
        pedidoDTO.setPrecoTotal(Double.parseDouble(TotalVenda.getText()));        
        pedidoDTO.setAssadosComprados(String.valueOf(jtl_consultar_pro.getValueAt(jtl_consultar_pro.getSelectedRow(), 0)));
        
        JOptionPane.showMessageDialog(null, pedidoCTR.inserirPedido(pedidoDTO, jtl_consultar_pro_selecionado));

    }

    private void preencheTabelaProduto(String nomeAssados) {
        try {
           if(clienteDTO.getQtdAssado() > 0){
            //Limpa todas as linhas
            modelo_jtl_consultar_pro.setNumRows(0);
            //Enquanto tiver linhas - faça
            clienteDTO.setNomeAssados(nomeAssados);
            rs = clienteCTR.consultarDados(clienteDTO, 2);
            while (rs.next()) {
                modelo_jtl_consultar_pro.addRow(new Object[]{
                    rs.getString("id_adm"),
                    rs.getString("nomeAssados"),
                    rs.getString("preco"),
                    rs.getString("qtdAssado"),});
            }
           }
        } catch (Exception erTab) {
            System.out.println("Errp SQL" + erTab);
        } finally {
            clienteCTR.CloseDB();
        }
    }

    private void adicionaProdutoSelecionado(int id_prod, String nome_prod, double p_venda_prod) {
        try {
            modelo_jtl_consultar_pro_selecionado.addRow(new Object[]{
                id_prod,
                nome_prod,
                p_venda_prod
            });
        } catch (Exception erTab) {
            System.out.println("Erro SQL" + erTab.getMessage());
        }
    }

    private void removeProdutoSelecionado(int linha_selecionada) {
        try {
            if (linha_selecionada >= 0) {
                modelo_jtl_consultar_pro_selecionado.removeRow(linha_selecionada);
                calculaTotalVenda();
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    private void calculaTotalVenda() {
        try {
            double total = 0;
            double qtd=0;
            for (int cont = 0; cont < modelo_jtl_consultar_pro_selecionado.getRowCount(); cont++) {
                total += (Double.parseDouble(String.valueOf(modelo_jtl_consultar_pro_selecionado.getValueAt(cont, 2))) * Integer.parseInt(String.valueOf(modelo_jtl_consultar_pro_selecionado.getValueAt(cont, 3))));
               
                //qtd = (Double.parseDouble(String.valueOf(modelo_jtl_consultar_pro_selecionado.getValueAt(cont, 3))) - clienteDTO.getQtdAssado());
              //  JOptionPane.showMessageDialog(null, qtd);
            }
            TotalVenda.setText(String.valueOf(total));
        } catch (Exception erTab) {
            System.out.println("Erro SQL " + erTab);
        }

    }

    private void liberaCampos(boolean a) {
        nomeCli.setEnabled(a);
        endereco.setEnabled(a);
        btnPesquisarPro.setEnabled(a);
        pesquisa_nome_pro.setEnabled(a);
        jtl_consultar_pro.setEnabled(a);
        jtl_consultar_pro_selecionado.setEnabled(a);
        TotalVenda.setText("0.00");
    }

    private void limpaCampos() {
        nomeCli.setText("");
        pesquisa_nome_pro.setText("");
        endereco.setText("");
        modelo_jtl_consultar_pro.setNumRows(0);
        modelo_jtl_consultar_pro_selecionado.setNumRows(0);
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnSair.setEnabled(d);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesquisa_nome_pro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_pro = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtl_consultar_pro_selecionado = new javax.swing.JTable();
        btnPesquisarPro = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nomeCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TotalVenda = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Vendas"));

        jLabel1.setText("Descrição: ");

        jtl_consultar_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "QTD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_pro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_proMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtl_consultar_pro);
        if (jtl_consultar_pro.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_pro.getColumnModel().getColumn(0).setResizable(false);
            jtl_consultar_pro.getColumnModel().getColumn(1).setResizable(false);
            jtl_consultar_pro.getColumnModel().getColumn(2).setResizable(false);
            jtl_consultar_pro.getColumnModel().getColumn(3).setResizable(false);
        }

        jtl_consultar_pro_selecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "QTD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_pro_selecionado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtl_consultar_pro_selecionadoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtl_consultar_pro_selecionado);
        if (jtl_consultar_pro_selecionado.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_pro_selecionado.getColumnModel().getColumn(0).setResizable(false);
            jtl_consultar_pro_selecionado.getColumnModel().getColumn(2).setResizable(false);
        }

        btnPesquisarPro.setText("Pesquisar");
        btnPesquisarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/prod_rem.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/prod_add.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisa_nome_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarPro))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jButton2)
                .addGap(85, 85, 85)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pesquisa_nome_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarPro))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Dados"));

        jLabel2.setText("Nome Cliente");

        jLabel3.setBackground(new java.awt.Color(255, 0, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("TOTAL VENDA: ");

        TotalVenda.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        TotalVenda.setForeground(new java.awt.Color(102, 255, 102));
        TotalVenda.setText("0.00");

        jLabel4.setText("Endereço");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(TotalVenda))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endereco))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TotalVenda))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/novo.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("SAIR");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(btnNovo)
                        .addGap(70, 70, 70)
                        .addComponent(btnSalvar)
                        .addGap(106, 106, 106)
                        .addComponent(btnCancelar)
                        .addGap(94, 94, 94)
                        .addComponent(btnSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSair))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_cli.setNumRows(0);
        modelo_jtl_consultar_pro.setNumRows(0);
        liberaBotoes(true, false, false, true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProActionPerformed
        preencheTabelaProduto(pesquisa_nome_pro.getText());
    }//GEN-LAST:event_btnPesquisarProActionPerformed

    private void jtl_consultar_proMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_proMouseClicked

    }//GEN-LAST:event_jtl_consultar_proMouseClicked

    private void jtl_consultar_pro_selecionadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtl_consultar_pro_selecionadoKeyReleased
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            calculaTotalVenda();
        };
    }//GEN-LAST:event_jtl_consultar_pro_selecionadoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        adicionaProdutoSelecionado(
                Integer.parseInt(String.valueOf(jtl_consultar_pro.getValueAt(
                        jtl_consultar_pro.getSelectedRow(), 0))),
                String.valueOf(jtl_consultar_pro.getValueAt(jtl_consultar_pro.getSelectedRow(), 1)),
                Double.parseDouble(String.valueOf(jtl_consultar_pro.getValueAt(
                        jtl_consultar_pro.getSelectedRow(), 2)))
        );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        removeProdutoSelecionado(jtl_consultar_pro_selecionado.getSelectedRow());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        gravar();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, true);
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalVenda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarPro;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField endereco;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtl_consultar_pro;
    private javax.swing.JTable jtl_consultar_pro_selecionado;
    private javax.swing.JTextField nomeCli;
    private javax.swing.JTextField pesquisa_nome_pro;
    // End of variables declaration//GEN-END:variables
}
