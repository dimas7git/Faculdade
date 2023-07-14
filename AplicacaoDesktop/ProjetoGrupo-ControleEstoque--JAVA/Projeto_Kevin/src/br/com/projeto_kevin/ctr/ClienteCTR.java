/*
 * The MIT License
 *
 * Copyright 2022 Aluno.
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
import java.sql.ResultSet;
import br.com.projeto_kevin.dto.ClienteDTO;
import br.com.projeto_kevin.dao.ClienteDAO;
import br.com.projeto_kevin.dao.ConexaoDAO;
public class ClienteCTR {
    
    public ClienteCTR() {
    }

    ClienteDAO clienteDAO = new ClienteDAO();
    ClienteDTO clienteDTO = new ClienteDTO();
    ConexaoDAO conexaoDAO = new ConexaoDAO();

    public String inserirCliente(ClienteDTO clienteDTO) {
        try {
            //chama o metodo que esta na calsse DAO agurdando uma repsota (true ou false)

            if (clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente cadastrado com sucesso!!!";
            } else {
                return "Cliente NÃO cadastrado";
            }
        } //caso tenhaalgum erro no codigo é enviado uma mensagem no console o que esta acontecendo
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO cadastrado";
        }
    }
    
     public String alterarCliente(ClienteDTO clienteDTO) {
        try {
            // chama o metodo que esta na calsse DAO aguardando uma resposta (true ou false)
            if (clienteDAO.alterarCliente(clienteDTO)) {
                return "Cliente ALTERADO com sucesso!!! ";
            } else {
                return "Cliente NÃO alterado!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO alterado!!!";
        }
    }
 public String excluirCliente(ClienteDTO clienteDTO) {
        try {
            //chama o metodo que essta na classe DAO aguardando uma repsosta true ou false

            if (clienteDAO.excluirCliente(clienteDTO))   {
                return "Cliente excluido com sucesso!!!";
            } else {
                return "Cliente NAO excluido!";
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO excluido";
        } 
    }
 
 public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        // É Criado um atributo do tipo REsultSet, pois este metodo recebe o resultado de uma consulta
        ResultSet rs = null;
        // O Atributo rs recevbe a consulta realizada pelo metodo da calsse DAO
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        return rs;
    }// fecha o metodo consultarCliente
 public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
