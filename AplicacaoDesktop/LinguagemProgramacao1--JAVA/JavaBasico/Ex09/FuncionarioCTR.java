package Ex09;


public class FuncionarioCTR {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public String mostrarCodTel(FuncionarioDTO funcionarioDTO){
     return funcionarioDAO.mostrarCodTel(funcionarioDTO);
    }
}
