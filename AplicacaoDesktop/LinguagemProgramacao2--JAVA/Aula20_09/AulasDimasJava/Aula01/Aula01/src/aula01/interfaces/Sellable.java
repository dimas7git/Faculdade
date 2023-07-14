package aula01.interfaces;

public interface Sellable {
	
	// retorna a descricao do objeto
	public String description();

	// retorna o preco em centavos
	public int listPrice();

	// retorna o menor preco em centavos
	public int lowestPrice();
}
