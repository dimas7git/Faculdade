package aula01.interfaces;

public class TraditionalBook implements Sellable, Transportable {

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Livro A Terra Prometida";
	}

	@Override
	public int listPrice() {
		// TODO Auto-generated method stub
		return 97;
	}

	@Override
	public int lowestPrice() {
		// TODO Auto-generated method stub
		return 23;
	}
	
	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return 238;
	}

	@Override
	public boolean isHazardous() {
		// TODO Auto-generated method stub
		return false;
	}

}
