package genericExemplo;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class genericTestes {

	@Test
	void teste01() {
	ImprimirDouble impressaoD1 = new ImprimirDouble(777.77);
	impressaoD1.imprimir();
	}
	
	@Test
	void teste02() {
	ImprimirInteir impressaoI1 = new ImprimirInteir(777);
	impressaoI1.imprimir();
	}
	
	@Test
	void teste03() {
	ImprimirString impressaoS1 = new ImprimirString("IFSP");
	impressaoS1.imprimir();
	}
	
	@Test
	void teste04() {
	ImprimirGenerico<Integer> impressaoTG1 = new ImprimirGenerico<>(777);
	impressaoTG1.imprimir();
	}
	
	@Test
	void teste05() {
	ImprimirGenerico<Double> impressaoDG1 = new ImprimirGenerico<>(777.77);
	impressaoDG1.imprimir();
	}
	
	@Test
	void teste06() {
	ImprimirGenerico<String> impressaoSG1 = new ImprimirGenerico<>("IFSP");
	impressaoSG1.imprimir();
	}
	
	@Test
	void teste07() {
	List<Integer> intList = new ArrayList<>();
	intList.add(2022);
	ImprimirGenericoCoringa.imprimir(intList);
	}
	
	@Test
	void teste08() {
		List<Double> intList = new ArrayList<>();
		intList.add(2022.10);
		ImprimirGenericoCoringa.imprimir(intList);
	}
	
	@Test
	void teste09() {
		List<String> intList = new ArrayList<>();
		intList.add("dimas");
		ImprimirGenericoCoringa.imprimir(intList);
	}
}
