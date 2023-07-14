package br.com.VendaAutomovel.ctr;

import br.com.VendaAutomovel.dto.AutomovelDTO;
import br.com.VendaAutomovel.dao.AutomovelDAO;
import br.com.VendaAutomovel.dao.ConexaoDAO;
import java.sql.ResultSet;

public class AutomovelCTR {

    AutomovelDAO automovelDAO = new AutomovelDAO();

    public String inserirAutomovel(AutomovelDTO automovelDTO) {
        try {

            if (automovelDAO.inserirAutomovel(automovelDTO)) {
                return "Automovel cadastrado com sucesso!!!";
            } else {
                return "Automovel NÃO cadastrado";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Automovel NÃO cadastrado";
        }
    }

    public String alterarAutomovel(AutomovelDTO automovelDTO) {
        try {
            if (automovelDAO.alterarAutomovel(automovelDTO)) {
                return "Automovel ALTERADO com sucesso!!! ";
            } else {
                return "Automovel NÃO alterado!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Automovel NÃO alterado!!!";
        }
    }

    public String excluirAutomovel(AutomovelDTO automovelDTO) {
        try {

            if (automovelDAO.excluirCliente(automovelDTO)) {
                return "Automovel excluido com sucesso!!!";
            } else {
                return "Automovel NAO excluido!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Automovel NÃO excluido";
        }
    }

    public ResultSet consultarAutomovel(AutomovelDTO automovelDTO, int opcao) {
        ResultSet rs = null;
        rs = automovelDAO.consultarAutomovel(automovelDTO, opcao);
        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
