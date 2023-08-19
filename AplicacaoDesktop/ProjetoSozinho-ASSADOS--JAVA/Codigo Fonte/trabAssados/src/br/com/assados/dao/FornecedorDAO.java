package br.com.assados.dao;
import br.com.assados.dto.FornecedorDTO;
import java.sql.*;

/**
 *
 * @author DimasFerreira
 */
public class FornecedorDAO {
    
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o Banco de dados
    private Statement stmt = null;
    
    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            //chama o m[etodo que esta na classe COnexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //comando SQL que sera executado no banco de dados
            String comando = "Insert into Fornecedor (nomeForne, produtoForne, "
                    + "qtdProd, precoTotal ) values ("
                    + "'" + fornecedorDTO.getNomeForne()+ "', "
                    + "'" + fornecedorDTO.getProdutoForne()+ "', "
                    + "'" + fornecedorDTO.getQtdProd()+ "', "
                    + "'" + fornecedorDTO.getPrecoTotal() + "' ) ";
            
            //Executa o comando SQL no banco de dados
            stmt.execute(comando.toUpperCase());
            //Da um Commit no Banco de DAdos
            ConexaoDAO.con.commit();
            //Fecha o Statement
            stmt.close();
            return true;
            
        }//Caso tenha algum erro no código acima, é enviado uma mensagem no Console com o que está acontecendo
        catch(Exception e){
            System.out.println("Erro ao gravar no Banco de dados do fornecedor!" + e.getMessage());
            return false;
        }// Independentemente de dar erro ou não ele vai fechar o banco de dados:
        finally{
            //Chama o método da classe conexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método InserirFornecedor



    /**
     * Método utilizado para alterar um objeto fornecedorDTO no banco de dados
     */
    public boolean alterarFornecedor(FornecedorDTO fornecedorDTO){
        try{
            //Chama o método que esta na classe COnexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que é responsável por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no Banco de Dados
            String comando = "Update fornecedor set "
            + "nomeForne = '" + fornecedorDTO.getNomeForne()+ "', "
            + "produtoForne = '" + fornecedorDTO.getProdutoForne()+ "', "
            + "qtdProd = '"  + fornecedorDTO.getQtdProd()+  "', "
            + "precoTotal = '" + fornecedorDTO.getPrecoTotal()  + "' " 
            + "where id_fornec = " + fornecedorDTO.getIdFornec();
        
            //Executa o comando SQL no banco de dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        }//Caso tenha algum erro:
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }//Independentemente de dar erro ou não, ele vai fechar o banco de dados
        finally{
            //chgama o método da classe ConexaoDAO para fechar o Banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método alterarFornecedor
    
    
    /**
     * Método utilizado para excluir um objeto fornecedorDTO no banco de dadops
     */
    public boolean excluirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            //Chama o método da classe ConexaoDAO para abrir o banco
            ConexaoDAO.ConectDB();
            //Instancia o Statement que executará alguma coisa no banco
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from fornecedor where id_fornec = "
                            +fornecedorDTO.getIdFornec();
            
            //Executa o comando SQL no banco de dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        }//Caso tenha algum erro
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }// com erro ou não, ele fecha o banco de dados:
        finally{
            //Chama o m[etodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método excluirFornecedor
    
    /**
     * Método utilizado para cosultar um objeto fornecedorDTO no banco de dados
     */
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao){
        try{
            //Chama o método que abre o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o statement que executa algo no banco
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco
            String comando = "";
            
            switch (opcao){
                case 1:
                    comando =   "Select id_fornec, precoTotal, nomeForne, produtoForne "+
                                "from Fornecedor "+
                                "where nomeForne ilike'" + fornecedorDTO.getNomeForne()+ "%' "+
                                "order by nomeForne";
                break;
                        
                case 2:
                    comando =   "Select Fornecedor.nomeForne, Fornecedor.produtoForne, Fornecedor.precoTotal, Fornecedor.qtdProd "+                                
                                "from Fornecedor "+
                                "where Fornecedor.id_fornec = " +fornecedorDTO.getIdFornec();
                break; 
            }
            //Executa o comando SQL no banco de dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }//Caso tenha algum erro
        catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
}
