package Factory;

public class FactoryCarro {
	public Carro getCarro(String modeloCarro) {
		if (modeloCarro == "A8 L" || modeloCarro == "Audi R8 5.2 FSI") {
			return new Audi();
		} else if (modeloCarro == "BMW M8" || modeloCarro == "BMW X3") {
			return new Bmw();
		}
		return new Carro();
	}
}
