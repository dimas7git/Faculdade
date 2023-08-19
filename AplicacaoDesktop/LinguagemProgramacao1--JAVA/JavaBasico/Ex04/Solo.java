package Ex04;


public class Solo {
    private int ponto;
    private String resposta;
    public String Calcular(int ponto){
       this.ponto = ponto;
      
       if(this.ponto<=10){
          this.resposta = "O solo é rochoso ";
       } else if((this.ponto>10) && (this.ponto<=40)){
          this.resposta = "O solo é firme ";
       } else if((this.ponto>40) && (this.ponto<=80)){
          this.resposta = "O solo é pantonoso ";
       } else
           this.resposta = "Quantidade de agua invalida";
       
       
       
       
       
       return resposta;
    } 
}
