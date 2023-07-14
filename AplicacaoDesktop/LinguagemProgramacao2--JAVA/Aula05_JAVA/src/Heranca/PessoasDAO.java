package Heranca;

import Heranca.PessoasDTO;
import Heranca.FuncionarioDTO;
import Heranca.ProfessorDTO;
import Heranca.AlunoDTO;

public class PessoasDAO {
//testando classe pessoa

    public static void main(String[] args) {
        PessoasDTO pessoasDTO = new PessoasDTO("Jon Jones");
        System.out.println("Pessoa");
        System.out.println(" ");
        System.out.println(pessoasDTO.getNome());
        System.out.println("--------------------------");
        
        PessoasDTO pessoas1 = new PessoasDTO("Jon Jones");

        System.out.println(pessoasDTO.getNome().equals(pessoas1.getNome()));
        System.out.println(pessoas1.getNome().hashCode());
        System.out.println(pessoasDTO.getNome().hashCode());
        
        
        
        System.out.println(pessoasDTO.getNome());
        FuncionarioDTO funcinarioDTO = new FuncionarioDTO(123, 1000.00, "Pica Pau");
        System.out.println("Funcionario");
        System.out.println(" ");
        System.out.println(funcinarioDTO.getNome());
        System.out.println(funcinarioDTO.getNumMatricula());
        System.out.println(funcinarioDTO.getSalario());
        System.out.println("----------");

        ProfessorDTO professorDTO = new ProfessorDTO("Doctor", 123, 1000.00, "Pica Pau");
        System.out.println("Professor");
        System.out.println(" ");
        System.out.println(professorDTO.getNome());
        System.out.println(professorDTO.getNumMatricula());
        System.out.println(professorDTO.getSalario());
        System.out.println(professorDTO.getTitulo());
        System.out.println("----------");

        AlunoDTO alunoDTO = new AlunoDTO("VP30123", 10, "Roberto");
        System.out.println("Aluno");
        System.out.println(" ");
        System.out.println(alunoDTO.getNome());
        System.out.println(alunoDTO.getRA());
        System.out.println(alunoDTO.getNumDisciplinas());
    }
}
