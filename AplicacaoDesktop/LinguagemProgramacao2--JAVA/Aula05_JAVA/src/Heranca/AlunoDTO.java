package Heranca;

public class AlunoDTO extends PessoasDTO{
  private String RA;
   private int numDisciplinas;

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public int getNumDisciplinas() {
        return numDisciplinas;
    }

    public void setNumDisciplinas(int numDisciplinas) {
        this.numDisciplinas = numDisciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AlunoDTO(String RA, int numDisciplinas, String nome) {
        super(nome);
        this.RA = RA;
        this.numDisciplinas = numDisciplinas;
    }

    public AlunoDTO(String RA, int numDisciplinas) {
        this.RA = RA;
        this.numDisciplinas = numDisciplinas;
    }
   
}
