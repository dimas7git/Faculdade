package adapter;

public class CotacaoAdapter extends Cotacao {
    
    @Override
    public void setValor(double valor){
        super.setValor(valor/5.50);
    }

    @Override
    public double getValor(){
        return(super.getValor() * 5.50);
    }

    public double getValorDolar(){
        return super.getValor();
    }
}
