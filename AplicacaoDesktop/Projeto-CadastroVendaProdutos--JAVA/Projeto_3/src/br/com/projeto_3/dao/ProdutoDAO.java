
package br.com.projeto_3.dao;
import java.sql. *;
import br.com.projeto_3.dto.ProdutoDTO;
import br.com.projeto_3.dto.FornecedorDTO;

public class ProdutoDAO {
    
    public ProdutoDAO(){
        
    }
    
    //Atributo do tipo ResultSet uytilizado pra realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    /**
     * Método utilizado para inserir um objeto produtoDTO no banco de dados
     * @param produtoDTO, que vem da classe ProdutoDTO
     * @param fornecedorDTO, que vem da classe FornecedorDTO
     * #return um boolean
     */
    public boolean inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            //Chama o metodo que esta na classe COnexaoDAO para abrie o banco de dados
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            //COmando SQL, que sera executado no banco de dados
            String comando = "Insert into produto (nome_prod, desc_prod, cod_bar_prod, "
                    +"p_custo_prod, p_venda_prod, id_for) values( "
                    + "'" + produtoDTO.getNome_prod()+ "', "
                    + "'" + produtoDTO.getDesc_prod()+ "', "
                    + "'" + produtoDTO.getCod_bar_prod()+ "', "
                    + produtoDTO.getP_custo_prod()+ ","
                    + produtoDTO.getP_venda_prod()+ ","
                    + fornecedorDTO.getId_for()+ ")";
            
            
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no bandco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement 
            stmt.close();
            return true;
        }//Se ocorrer algum erro no código acima é enviado uma mensagem no 
        //console para saber po quye está acontecendp
    
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            //fecha o banco de dados
            ConexaoDAO.CloseDB();
        }
    }
    
    /**
     * Método utilizado para alterar um objeto produtoDTO no banco de Dados
     * 
     * @param produtoDTO, que vem da classe ProdutoDTO
     * @param fornecedorDTO, que vem da classe FornecedorDTO
     * @return Um boolean
     */
    public boolean alterarCliente(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            //Chama o método que esta na classe COnexaoDAO para conectar ao banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement responsavek por executar algo no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            
            //Comando SQL que será executado no banco de dados
            String comando = "Update produto set "
                    + "nome_prod = '" + produtoDTO.getNome_prod()+ "', "
                    + "desc_prod = '" + produtoDTO.getDesc_prod()+ "', "
                    + "cod_bar_prod = '" + produtoDTO.getCod_bar_prod()+ "', "
                    + "p_custo_prod = " + produtoDTO.getP_custo_prod() + ", "
                    + "p_venda_prod = " + produtoDTO.getP_venda_prod() + ", "
                    + "id_for = " + fornecedorDTO.getId_for() + " "
                    + "where id_prod = " + produtoDTO.getId_prod();
            
            //Executa o comando SQL no banco
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }//Caso ocorra erro:
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }//De qualquer forma, ao final do método ele fechará o banco de dados:
        finally{
            ConexaoDAO.CloseDB();       
    }
}
    
public boolean excluirProduto(ProdutoDTO produtoDTO){
   try{
       //Conecta com o banco de dados
        ConexaoDAO.ConectDB();
    
        stmt = ConexaoDAO.con.createStatement();
        //Comando SQL a ser executado
        String comando = "Delete from produto where id_prod = "
                    + produtoDTO.getId_prod();
        //Executa o comando
        stmt.execute(comando);
        //Da um commit no banco
        ConexaoDAO.con.commit();
        //Fehcha o statement
        stmt.close();
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


public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao){
        try{
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            switch (opcao){
                case 1:
                    comando = "Select p.* "+
                              "from produto p "+
                              "where p.nome_prod ilike '"+ produtoDTO.getNome_prod()+ "%' "+
                              "order by p.nome_prod";
                break;
                case 2:
                    comando = "Select p.*, f.nome_for, f.id_for "+
                              "from produto p, fornecedor f "+
                              "where p.id_for = f.id_for and "+
                              "p.id_prod = " + produtoDTO.getId_prod();
                break;
            }

            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    
    }
}
