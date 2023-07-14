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
package br.com.projeto_kevin.ctr;

import br.com.projeto_kevin.dao.ConexaoDAO;
import br.com.projeto_kevin.dao.VendaDAO;
import br.com.projeto_kevin.dto.ClienteDTO;
import br.com.projeto_kevin.dto.VendaDTO;
import javax.swing.JTable;
import br.com.projeto_kevin.dto.ProdutoDTO;
/**
 *
 * @author aluno
 */
public class VendaCTR {
    VendaDAO vendaDAO = new VendaDAO();
    
    
    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos, ProdutoDTO produtoDTO) {
    try{
        if(vendaDAO.inserirVenda(vendaDTO, clienteDTO, produtos, produtoDTO))
            return "Venda cadastrada com sucesso";
        
        else
            return "venda NÃO cadastrada";
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Venda NÃO cadastrada";
        } 
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}