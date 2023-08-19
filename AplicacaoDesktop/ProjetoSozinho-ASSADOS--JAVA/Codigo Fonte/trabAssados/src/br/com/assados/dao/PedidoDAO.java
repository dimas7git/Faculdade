package br.com.assados.dao;
import br.com.assados.dto.PedidoDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;

/**
 *
 * @author DimasFerreira
 */
public class PedidoDAO {
    
     private ResultSet rs = null;

    Statement stmt = null;
    Statement stmt1 = null;

    
    public boolean inserirPedido(PedidoDTO pedidoDTO, JTable pedido) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into Pedidos (nomeCli, assadosComprados, precoTotal, endereco) values ( "                    
                    + "'" + pedidoDTO.getNomeCli() + "' ,"
                    + "'" + pedidoDTO.getAssadosComprados() + "' ,"
                    + "'" + pedidoDTO.getPrecoTotal() + "' ,"
                    + "'" + pedidoDTO.getEnd() + "')";
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;        
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        } finally {
        ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarPedido(PedidoDTO pedidoDTO, int opcao) {
        try {
            // Chama o metodo que esta na calsse ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            // Cria o Statement que responsavel por executar laguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            // Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select p.*"
                            + "from Pedidos p "
                            + "where nomeCli like '" + pedidoDTO.getNomeCli() + "%' "
                            + "order by p.nomeCli";
                    break;

            }
            // Executa o comando SQL no banco de dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } // caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontencdo
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
}
