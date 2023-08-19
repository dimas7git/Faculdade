package br.com.assados.ctr;

import br.com.assados.dao.AdminDAO;
import br.com.assados.dao.ConexaoDAO;
import br.com.assados.dto.AdminDTO;

/**
 *
 * @author  
 */
public class AdminCTR {
    public AdminCTR() {
    }
    
    AdminDAO adminDAO = new AdminDAO();
    
    public int logarAdmin(AdminDTO adminDTO) {       
        return adminDAO.logarAdmin(adminDTO);
    }
    
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
    
}
