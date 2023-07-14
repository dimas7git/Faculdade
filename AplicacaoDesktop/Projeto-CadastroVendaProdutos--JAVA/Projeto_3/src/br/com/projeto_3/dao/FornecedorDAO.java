
package br.com.projeto_3.dao;
import br.com.projeto_3.dto.FornecedorDTO;
import java.text.SimpleDateFormat;
import java.sql.*;
public class FornecedorDAO {
/*
    Método construtor da classe
    */    
    public FornecedorDAO(){
        
    }
    
    
    SimpleDateFormat data_forFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o Banco de dados
    private Statement stmt = null;
    
    
    /**
     * Método utilizado para inserir um objeto fornecedorDTO no banco de dados
     */
    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            //chama o m[etodo que esta na classe COnexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //comando SQL que sera executado no banco de dados
            String comando = "Insert into fornecedor (nome_for, cnpj_for, "
                    + "tel_for, data_cad_for ) values ("
                    + "'" + fornecedorDTO.getNome_for()+ "', "
                    + "'" + fornecedorDTO.getCnpj_for()+ "', "
                    + "'" + fornecedorDTO.getTel_for()+ "', "
                    + "to_date('" +data_forFormat.format(fornecedorDTO.getData_cad_for()) + "','dd//MM//yyyy')) ";
            
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
            + "nome_for = '" + fornecedorDTO.getNome_for()+ "', "
            + "cnpj_for = '" + fornecedorDTO.getCnpj_for()+ "', "
            + "tel_for = '"  + fornecedorDTO.getTel_for()+ "', "
            + "data_cad_for = to_date('"+ data_forFormat.format(fornecedorDTO.getData_cad_for()) + "','dd/MM/yyyy') " 
            + "where id_for = " + fornecedorDTO.getId_for();
        
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
            String comando = "Delete from fornecedor where id_for = "
                            +fornecedorDTO.getId_for();
            
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
                    comando =   "Select f.id_for, f.nome_for "+
                                "from fornecedor f "+
                                "where f.nome_for ilike'" + fornecedorDTO.getNome_for()+ "%' "+
                                "order by f.nome_for";
                break;
                        
                case 2:
                    comando =   "Select f.nome_for, f.cnpj_for, f.tel_for, "+
                                "to_char(f.data_cad_for, 'dd/MM/yyyy') as data_cad_for "+
                                "from fornecedor f "+
                                "where f.id_for = " +fornecedorDTO.getId_for();
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
    }//Fecha o método consultarFornecedor
    


}














