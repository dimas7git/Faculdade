package aula01.interfaces;

public class EBook implements Sellable {

	@Override
	public String description() {
		return "Livro Eletrônico - A Fuga das Galinhas";
	}

	@Override
	public int listPrice() {
		return 290;
	}

	@Override
	public int lowestPrice() {
		return 188;
	}
}
