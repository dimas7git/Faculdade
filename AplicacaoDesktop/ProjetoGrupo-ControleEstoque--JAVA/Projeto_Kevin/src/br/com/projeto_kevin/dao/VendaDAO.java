/*
 * The MIT License
 *
 * Copyright 2022 aluno.
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

package br.com.projeto_kevin.dao;

import br.com.projeto_kevin.dto.ClienteDTO;
import br.com.projeto_kevin.dto.VendaDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import br.com.projeto_kevin.dto.ProdutoDTO;
/**
 *
 * @author aluno
 */
public class VendaDAO {
    
    public VendaDAO() {
    }
    
    //Atibuto do tipo nResultSet utilizado para arealizar consultas
    private ResultSet rs = null;
    //Manipular o anco de dados
    Statement stmt = null;
    Statement stmt1 = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");



    public boolean inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos, ProdutoDTO produtoDTO){
    try{
        ConexaoDAO.ConectDB();
        stmt = ConexaoDAO.con.createStatement();
        stmt1 = ConexaoDAO.con.createStatement();
        
        
        String comando1 = "Insert into venda(data_vend, val_vend, "
                + "fk_id_cliente, qtd_venda) values ("
                + "to_date('" +date.format(vendaDTO.getDat_vend()) + "', 'DD//MM/YYYY' ), "
                + vendaDTO.getVal_vend()+ ", "
                + clienteDTO.getId_cliente() + ", " 
                + vendaDTO.getQtd_vend() + ") " ;
                

        stmt.execute(comando1.toUpperCase(),Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();
        rs.next();

        /*for(int cont=0; cont < produtos.getRowCount(); cont++){
            String comando2 = "Insert into produto_venda (id_vend, "
                    + "val_prod, qtd_prod) values ( "
                    + rs.getInt("id_vend") + ", "
                    + produtos.getValueAt(cont, 0) + ", "
                    + produtos.getValueAt(cont, 2) + ", "
                    + produtos.getValueAt(cont, 3) + "); ";
            
            stmt1.execute(comando2);

            }
        */
        ConexaoDAO.con.commit();
        stmt.close();
        rs.close();
        return true;
    }    
    catch(Exception e){
                System.out.println(e.getMessage());
                return false;
    }
    finally{
                ConexaoDAO.CloseDB();
    }
    }
}