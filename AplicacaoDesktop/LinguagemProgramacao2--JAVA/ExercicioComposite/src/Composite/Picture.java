package Composite;

import java.util.*;

public class Picture extends GraphicComponent {
	ArrayList<GraphicComponent> graficos = new ArrayList<>();
	
	public Picture(String graphic) {
		this.graphic = graphic;
	}
	
	@Override
	public void draw() {
		for (GraphicComponent gc : graficos) {
			gc.draw();
		}
	}
	
	@Override
	public void Add(GraphicComponent graphicComponent) {
		this.graficos.add(graphicComponent);
	}
	
	@Override
	public void Remove(GraphicComponent graphicComponent) throws Exception {
		for (GraphicComponent gc : graficos) {
			if (gc == graphicComponent) {
				this.graficos.remove(gc);
				return;
			}
		}
		throw new Exception("Não existe esse arquivo");
	}
	
	@Override
	public GraphicComponent GetChild(int child) {
		return this.graficos.get(child);
	}
}
