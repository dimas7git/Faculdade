package Heranca;

public class ProfessorDTO extends FuncionarioDTO {
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

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

    public ProfessorDTO(String titulo, int NumMatricula, Double salario, String nome) {
        super(NumMatricula, salario, nome);
        this.titulo = titulo;
    }

    public ProfessorDTO() {
    }

    @Override
    public String toString() {
        return "ProfessorDTO{" + "titulo=" + titulo + '}';
    }
    
}
