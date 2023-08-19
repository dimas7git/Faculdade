package Composite;

public class GraphicComponent {
	String graphic;
	
	public void draw() {
		System.out.println(this.graphic);
	}
	
	public void Add(GraphicComponent graphicComponent) throws Exception {
		throw new Exception("Não pode desenhar");
	}
	
	public void Remove(GraphicComponent graphicComponent) throws Exception {
		throw new Exception("Não pode remover");
	}
	
	public GraphicComponent GetChild(int child) throws Exception {
		throw new Exception("Não pode pegar filho");
	}
}
