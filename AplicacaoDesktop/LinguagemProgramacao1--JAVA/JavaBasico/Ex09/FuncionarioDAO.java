package Ex09;


public class FuncionarioDAO {
    public String mostrarCodTel(FuncionarioDTO funcionarioDTO) {
        return "O codigo informado foi : " + funcionarioDTO.getCod() + "\n O telefone informado foi : " + funcionarioDTO.getTel();
    }
}
