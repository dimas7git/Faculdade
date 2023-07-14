
package br.com.projeto_3.dao;
/*
Importar pacote para trabalhar com sql
*/
import java.sql.*;
    /*
    Essa classe contem os métodos necessarios para abrir e fechar o banco de dados
    */
public class ConexaoDAO {

    /*
    Criando um atributo do tipo Connection que servirá para guardar a conexao com o banco
    */
public static Connection con = null;
    

    /*
    Método construtor da Classe
    */
    public ConexaoDAO(){
        
    }
    
    public static void ConectDB(){
        try{
            //Dados para conectar com o banco de dados Postgres
            String dsn = "projeto_3"; // Nome do banco de dados (igual o criado no Postgres)
            String user = "postgres"; //Nome de usuario utilizado para se conectar
            String senha = "postdba"; //Senha do usuario acima informado
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/" + dsn;
            
            con = DriverManager.getConnection(url, user, senha);
            
            con.setAutoCommit(false);
            if(con == null){
                System.out.println("Erro ao abrir o banco");
            }
        }//Fecha try
        
       //caso ocorra algum erro:
       catch (Exception e){
           System.out.println("Problema ao abrir a base de dados!" +e.getMessage());
       } //fecha catch
    }//Fecha o método ConectDB
    
    
    /*
    Método que fecha a conexap com o banco de dados é do tipo static para que 
    não seja necessario instanciar ujm objeto da classe, chamando os metodos 
    de forma direta Ex: classe.nome_do_metodo
    */
    public static void CloseDB(){
        try{
            con.close();
        }//fecha o try
        //caso tenha erro
        catch (Exception e){
            System.out.println("Problema ao fechar a base de dados" + e.getMessage());
        }//fecha catch
    }    //Fecha o método CloseDB
}//Fecha a classe COnexaoDAO