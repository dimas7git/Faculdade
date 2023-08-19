package br.com.assados.ctr;
import java.sql.ResultSet;
import br.com.assados.dto.ClienteDTO;
import br.com.assados.dao.ClienteDAO;
import br.com.assados.dao.ConexaoDAO;
public class ClienteCTR {
      public ClienteCTR() {
    }

    ClienteDAO clienteDAO = new ClienteDAO();

    public String inserirDados(ClienteDTO clienteDTO) {
        try {
            //chama o metodo que esta na calsse DAO agurdando uma repsota (true ou false)

            if (clienteDAO.inserirDados(clienteDTO)) {
                return "Dados cadastrado com sucesso!!!";
            } else {
                return "Dados NÃO cadastrado";
            }
        } //caso tenhaalgum erro no codigo é enviado uma mensagem no console o que esta acontecendo
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Dados NÃO cadastrado";
        }
    }

    public String alterarDados(ClienteDTO clienteDTO) {
        try {
            // chama o metodo que esta na calsse DAO aguardando uma resposta (true ou false)
            if (clienteDAO.alterarDados(clienteDTO)) {
                return "Dados ALTERADO com sucesso!!! ";
            } else {
                return "Dados NÃO alterado!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Dados NÃO alterado!!!";
        }
    }

    public String excluirDados(ClienteDTO clienteDTO) {
        try {
            //chama o metodo que essta na classe DAO aguardando uma repsosta true ou false

            if (clienteDAO.excluirDados(clienteDTO))   {
                return "Dados excluido com sucesso!!!";
            } else {
                return "Dados NAO excluido!";
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            return "Dados NÃO excluido";
        } 
    }

    /**
     * Metodo utilizado para controlar o acaesso ao metodo consultarCliente da
     * classe ClienteDAO
     *
     * @param clienteDTO que vem da calsse da pagina (VIEW)
     * @param opcao que vem da calsse da pagina (VIEW)
     * @return ResultSet com os dados do cliente
     */
    public ResultSet consultarDados(ClienteDTO clienteDTO, int opcao) {
        // É Criado um atributo do tipo REsultSet, pois este metodo recebe o resultado de uma consulta
        ResultSet rs = null;
        // O Atributo rs recevbe a consulta realizada pelo metodo da calsse DAO
        rs = clienteDAO.consultarDados(clienteDTO, opcao);
        return rs;
    }// fecha o metodo consultarCliente

    /**
     * Metodo utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//fecha o metodo closeDB
}
