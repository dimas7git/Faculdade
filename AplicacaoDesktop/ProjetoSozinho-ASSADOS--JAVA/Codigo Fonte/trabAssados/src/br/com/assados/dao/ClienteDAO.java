package br.com.assados.dao;

import br.com.assados.dto.ClienteDTO;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author DimasFerreira
 */
public class ClienteDAO {

    SimpleDateFormat data_forFormat = new SimpleDateFormat("dd/MM/yyyy");

    // atritubo do tipo resulset utlizado para realizar consultas   
    private ResultSet rs = null;

    // manipular o banco de dados
    private Statement stmt = null;

    public boolean inserirDados(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            //comando SQL que sera executado no banco de dados
            String comando = "Insert into Administrador (preco, qtdAssado, nomeAssados) values ("
                    + "'" + clienteDTO.getPreco() + "' ,"
                    + "'" + clienteDTO.getQtdAssado() + "' ,"
                    + "'" + clienteDTO.getNomeAssados() + "'); ";

//executa o comando SQL no banco de dados
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Problema na inserção dos dados no banco de dados" + e.getMessage());
            return false;
        } // independente de dar ero ou nao ele ira fechar o banco de dados
        finally {

            // chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }

    }

    /**
     * Método utilizado para alterar um objeto clienteDTO no banco de dados
     *
     * @param clienteDTO, que vem da calsse ClienteCTR
     * @return boolean
     */
    public boolean alterarDados(ClienteDTO clienteDTO) {
        try {
            // chama o metodo que esta na classe conexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            // criar um stetament que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //comando SQL que sera executada no banco de dados
            String comando = "Update Administrador set "
                    + "preco = '" + clienteDTO.getPreco() + "' ,"
                    + "qtdAssado = '" + clienteDTO.getQtdAssado() + "' ,"
                    + "nomeAssados = '" + clienteDTO.getNomeAssados() + "' "
                    + "where id_adm = " + clienteDTO.getId_adm();

            stmt.execute(comando.toUpperCase());
            //de um commit no banco de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            //chama o metodo da classe conexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }

    }

    /**
     * Metodo utilizado para exlcuir um objeto clienteDTO no banco de dados
     *
     * @param clienteDTO que vem da classe ClienteCTR
     * @return um boolean
     */
    public boolean excluirDados(ClienteDTO clienteDTO) {
        try {
            //chama o metodo que esta na calsse conexaoDAO para abrir o banco de daods
            ConexaoDAO.ConectDB();
            // intancia o statement que responsavel por executar alguma coisa no bacno de dados
            stmt = ConexaoDAO.con.createStatement();
            //comando SQL que sera executado no banco de dados
            String comando = "Delete from Administrador where id_adm = " + clienteDTO.getId_adm();

            //executa o comando SQL no banco de dados
            stmt.execute(comando);

            // da um commit no banco de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } // independente de dar erro ou não ele vai fechar o banco de dados 
        finally {
            // chama o metodo da classe conexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }

    /**
     * Método utilizado para consultar um objeto clienteDTO no banco de dados
     *
     * @param clienteDTO, que vem da classe ClieteCTR
     * @param opcao, que vem da calsse ClienteCTR
     * @return Um ResultSet com os dados do cliente
     */
    public ResultSet consultarDados(ClienteDTO clienteDTO, int opcao) {
        try {
            // Chama o metodo que esta na calsse ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            // Cria o Statement que responsavel por executar laguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            // Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "select id_adm, nomeAssados, preco, qtdAssado "
                            + "from Administrador "
                            + "where id_adm = " + clienteDTO.getId_adm() + " "
                            + "order by nomeAssados";
                    break;
                    
                    case 2:
                    comando =   "Select id_adm, nomeAssados, preco, qtdAssado "+
                                "from Administrador "+
                                "where nomeAssados ilike'" + clienteDTO.getNomeAssados()+ "%' "+
                                "order by nomeAssados";
                break;

            }
            // Executa o comando SQL no banco de dados
            //Executa o comando SQL no banco de dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }//Caso tenha algum erro
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
}
