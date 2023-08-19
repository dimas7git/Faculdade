/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.assados.view;

import java.util.Locale;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.assados.dto.ClienteDTO;
import br.com.assados.ctr.ClienteCTR;

/**
 *
 * @author DimasFerreira
 */
public class ClienteVIEW extends javax.swing.JInternalFrame {

    ClienteDTO clienteDTO = new ClienteDTO(); //criar um objeto clientedto
    ClienteCTR clienteCTR = new ClienteCTR(); //criar um objeto clientectr
    DefaultTableModel modelo_jtl_consultar_cliente;
    int gravar_alterar; // variavel usada para saber se esta alterando ou incluindo  
    ResultSet rs; // variavel usada para preenchimento da tabela e dos campos

    /**
     * Creates new form clienteVIEW
     */
    public ClienteVIEW() {
        initComponents();
        modelo_jtl_consultar_cliente = (DefaultTableModel) jtl_consultar_cliente.getModel();
    }

    public void liberaCampos(boolean a) {
        nomeAssados.setEnabled(a);
        preco.setEnabled(a);
        qtdAssado.setEnabled(a);
    }

    private void preencheCampos(int id_adm) {
        try {
            clienteDTO.setId_adm(id_adm);
            rs = clienteCTR.consultarDados(clienteDTO, 2); //2 é a pesquisa no id na classe DAO
            if (rs.next()) {
                limpaCampos();

                nomeAssados.setText(rs.getString("nomeAssados"));
                preco.setText(rs.getString("preco"));
                qtdAssado.setText(rs.getString("qtdAssado"));
               

                gravar_alterar = 2;
                liberaCampos(true);

            }//Fecha if(rs.next)
        } //fecha try
        catch (Exception erTab) {
            System.out.println("Erro SQL" + erTab);
        } finally {
            clienteCTR.CloseDB();
        }
    }

    private void preencheTabela(String nomeAssados) {
        try {
            //Limpa todas as linhas
            modelo_jtl_consultar_cliente.setNumRows(0);
            //Enquanto tiver linhas - faça
            clienteDTO.setNomeAssados(nomeAssados);
            rs = clienteCTR.consultarDados(clienteDTO, 2);
            while (rs.next()) {
                modelo_jtl_consultar_cliente.addRow(new Object[]{
                    rs.getString("id_adm"),
                    rs.getString("nomeAssados"),
                    rs.getString("preco"),
                    rs.getString("qtdAssado"),});
            }
        } catch (Exception erTab) {
            System.out.println("Errp SQL" + erTab);
        } finally {
            clienteCTR.CloseDB();
        }
    }

    /**
     * Metodo utilizado para limpar os campos da tela
     */
    private void limpaCampos() {
        nomeAssados.setText("");
        preco.setText("");
        qtdAssado.setText("");
    }

    /**
     * Metodo utilizado para libear os botoes da tela
     *
     * @param a, boolean com true(libera) false(bloqueia) para btnNovo.
     * @param b, boolean com true(libera) false(bloqueia) para btnSalvar.
     * @param c, boolean com true(libera) false(bloqueia) para btnCancelar.
     * @param d, boolean com true(libera) false(bloqueia) para btnExcluir.
     * @param e, boolean com true(libera) false(bloqueia) para brnSair.
     */
    private void liberaBotoes(boolean a, boolean b, boolean c) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnSair.setEnabled(c);
    }

    private void gravar() {
        try {
            clienteDTO.setNomeAssados(nomeAssados.getText());
            clienteDTO.setPreco(Double.parseDouble(preco.getText()));
            clienteDTO.setQtdAssado(Double.parseDouble(qtdAssado.getText()));

            JOptionPane.showMessageDialog(null, clienteCTR.inserirDados(clienteDTO));
        } catch (Exception e) {
            System.out.println("Erro ao Gravar" + e.getMessage());
        }
    }

    /**
     * Método utiulizado para preencher os campos da tela com valores do
     * cliente.
     *
     * @param id_cliente, int com o id do cliente.
     */
    /**
     * Metodo utilizado para preencher/construir a Jtable.
     *
     * @param nome, String com o nome do cliente
     */
    private void alterar() {
        try {
            clienteDTO.setNomeAssados(nomeAssados.getText());
            clienteDTO.setPreco(Double.parseDouble(preco.getText()));
            clienteDTO.setQtdAssado(Double.parseDouble(qtdAssado.getText()));

            JOptionPane.showMessageDialog(null, clienteCTR.alterarDados(clienteDTO));
        } catch (Exception e) {
            System.out.println("Erro ao ALTERAR" + e.getMessage());
        }
    }
private void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir o fornecedor?", "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    clienteCTR.excluirDados(clienteDTO));
        }
    }//
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeAssados = new javax.swing.JTextField();
        preco = new javax.swing.JTextField();
        qtdAssado = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_cliente = new javax.swing.JTable();
        pesquisa_nome = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        jButton2.setText("jButton2");

        jLabel1.setText("Cadastrar Produto");

        jLabel2.setText("Nome do Assado");

        jLabel3.setText("Preço");

        jLabel4.setText("Quantidade");

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

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtl_consultar_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preco", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_cliente);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/assados/view/imagens/excluir.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(preco)
                                            .addComponent(qtdAssado, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(nomeAssados, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addGap(35, 35, 35)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pesquisa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(399, 399, 399))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeAssados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(qtdAssado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo)
                    .addComponent(jButton3))
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(pesquisa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(90, 90, 90))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true);
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
                JOptionPane.showMessageDialog(null, "Erro no SISTEMA!!!");
            }

        }
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void jtl_consultar_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_clienteMouseClicked
        preencheCampos(Integer.parseInt((String.valueOf(jtl_consultar_cliente.getValueAt(jtl_consultar_cliente.getSelectedRow(), 0)))));
    }//GEN-LAST:event_jtl_consultar_clienteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preencheTabela(pesquisa_nome.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        excluir();
        liberaCampos(false);
      //  liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_cliente.setNumRows(0);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable jtl_consultar_cliente;
    private javax.swing.JTextField nomeAssados;
    private javax.swing.JTextField pesquisa_nome;
    private javax.swing.JTextField preco;
    private javax.swing.JTextField qtdAssado;
    // End of variables declaration//GEN-END:variables
}
