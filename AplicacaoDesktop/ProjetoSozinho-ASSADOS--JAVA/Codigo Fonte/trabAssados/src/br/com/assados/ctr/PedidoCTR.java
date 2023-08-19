package br.com.assados.ctr;

import br.com.assados.dao.ConexaoDAO;
import br.com.assados.dao.PedidoDAO;
import br.com.assados.dto.PedidoDTO;
import java.sql.ResultSet;
import javax.swing.JTable;


public class PedidoCTR {

    PedidoDAO pedidoDAO = new PedidoDAO();

    public PedidoCTR() {
    }

    public String inserirPedido(PedidoDTO pedidoDTO, JTable pedido) {
        try {
            if (pedidoDAO.inserirPedido(pedidoDTO, pedido)) {
                return "Venda Cadstrada com Sucesso!!!";
            } else {
                return "Venda não CADASTRADA";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Venda NÃO Cadstrada";
        }
    }

    public ResultSet consultarPedido(PedidoDTO pedidoDTO, int opcao) {
        //É criado um atributo do tipo Result Sett, pois este m´[etodo recebo o resultado de uma consulta 
        ResultSet rs = null;
        // O atributo rs rtecebe a consulta realizada pelo método da classse DAP
        rs = pedidoDAO.consultarPedido(pedidoDTO, opcao);
        return rs;
    }//Close método consultarFornecedor

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
