package Heranca;

public class FuncionarioDTO extends PessoasDTO{
    int NumMatricula;
     Double salario;

    public int getNumMatricula() {
        return NumMatricula;
    }

    public void setNumMatricula(int NumMatricula) {
        this.NumMatricula = NumMatricula;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FuncionarioDTO(int NumMatricula, Double salario, String nome) {
        super(nome);
        this.NumMatricula = NumMatricula;
        this.salario = salario;
    }

    public FuncionarioDTO() {
    }
    
}
