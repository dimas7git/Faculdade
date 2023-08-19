package Composite;

public class Main {
	public static void main (String[] args) {
		GraphicComponent picture = new Picture("teste");
		GraphicComponent text = new Text("teste");
		GraphicComponent line = new Line("-----");
		GraphicComponent rectangle = new Rectangle("| |");
		
		try {
			text.Add(line);
		} catch (Exception err) {
			System.out.println(err);
		}
		
		try {
			picture.Add(rectangle);
			picture.Add(line);
			picture.Add(text);
			picture.draw();
		} catch (Exception err) {
			System.out.println(err);
		}
	}
}
