
package br.com.assados.ctr;
import java.sql.ResultSet;
import br.com.assados.dto.FornecedorDTO;
import br.com.assados.dao.ConexaoDAO;
import br.com.assados.dao.FornecedorDAO;
public class FornecedorCTR {
    
    
    /**
     * Método construtor
    */
    public FornecedorCTR(){
        
    }
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

    /**
     * Método utilizado para controlar acesso ao método inserirFornecedor da 
     * classe fornecedorDAO
     * @param fornecedorDTO
     * @return 
     */
    public String inserirFornecedor(FornecedorDTO fornecedorDTO){
        try{
        //chama o método que esta na classe DAO aguardando uma resposta (true ou false)
        if(fornecedorDAO.inserirFornecedor(fornecedorDTO)){
            return "Fornecedor Cadastrado com Sucesso!!";
        } else{
            return "Fornecedor Não Cadastrado";
        }
    }//Caso tenha algum erro:
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor não Cadastrado";
        }
    }//Fecha o método inserirFOrnecedor
    
    
    /*
    método utilizado para controlar o acesso ao método alterarFornecedor da classe FornecedorDAO
    */
    public String alterarFornecedor(FornecedorDTO fornecedorDTO){
        try{
            //Chama o método que sesta na classe FDAO aguardando uma resposta (true ou false)
            if(fornecedorDAO.alterarFornecedor(fornecedorDTO)){
                return "Fornecedor Alterado com Sucesso!!";
            } else {
                return "Fornecedor NÃO alterado!!";
            }
            
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO alterado";
        }
        
    }//Close método
    
    public String excluirFornecedor(FornecedorDTO fornecedorDTO){
        try {
            //Chama o método qu eesta na classe DAO aguardando uma resposta(true ou false)
            if (fornecedorDAO.excluirFornecedor(fornecedorDTO)){
                return "Fornecedor Excluído com suceddo!!";
            }else {
                return "Fornecedor NÂO excluido";
            }
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor não excluído";
        }
    }
    
    public ResultSet consultarFornecedor(FornecedorDTO forncedorDTO, int opcao){
        //É criado um atributo do tipo Result Sett, pois este m´[etodo recebo o resultado de uma consulta 
        ResultSet rs = null;
        // O atributo rs rtecebe a consulta realizada pelo método da classse DAP
        rs = fornecedorDAO.consultarFornecedor(forncedorDTO, opcao);
        return rs;
    }//Close método consultarFornecedor
    
    /*
    método utilizado para fechar o banco de dados
    */
    public void CloseDB(){
    ConexaoDAO.CloseDB();
    }
    
    
    
}
