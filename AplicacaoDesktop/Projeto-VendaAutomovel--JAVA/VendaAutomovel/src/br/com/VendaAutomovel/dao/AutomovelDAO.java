package br.com.VendaAutomovel.dao;

import java.sql.*;
import br.com.VendaAutomovel.dto.AutomovelDTO;

/**
 *
 * @author Aluno
 */
public class AutomovelDAO {

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirAutomovel(AutomovelDTO automovelDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into automovel (tipo, marca, modelo, cor, ano, chassi, valor) values ("
                    + "'" + automovelDTO.getTipo() + "' ,"
                    + "'" + automovelDTO.getMarca() + "' ,"
                    + "'" + automovelDTO.getModelo() + "' ,"
                    + "'" + automovelDTO.getCor() + "' ,"
                    + automovelDTO.getAno() + " ,"
                    + automovelDTO.getChassi() + " ,"
                    + automovelDTO.getValor() + "' )";

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Problema na inserção dos dados no banco de dados" + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }

    }

    public boolean alterarAutomovel(AutomovelDTO automovelDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update automovel set "
                    + "nome = '" + automovelDTO.getTipo() + "' ,"
                    + "logradouro = '" + automovelDTO.getMarca() + "' ,"
                    + "numero = " + automovelDTO.getModelo() + " ,"
                    + "bairro = '" + automovelDTO.getCor() + "' ,"
                    + "estado = '" + automovelDTO.getAno() + "' ,"
                    + "cep = '" + automovelDTO.getChassi() + "' ,"
                    + "cpf = '" + automovelDTO.getValor() + "' "
                    + "where id = " + automovelDTO.getId();

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }

    }

    public boolean excluirCliente(AutomovelDTO automovelDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from automovel where id = " + automovelDTO.getId();

            stmt.execute(comando);

            ConexaoDAO.con.commit();
            stmt.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
    
        public ResultSet consultarAutomovel(AutomovelDTO automovelDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select a.*"
                            + "from automovel a "
                            + "where modelo like '" + automovelDTO.getModelo() + "%' "
                            + "order by a.modelo";
                    break;
                case 2:
                    comando = "Select a.* "
                            + "from automovel a "
                            + "where a.id = " + automovelDTO.getId();
                    break;
                case 3:
                    comando = "Select a.id, a.nome "
                            + "from automovel a ";

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
