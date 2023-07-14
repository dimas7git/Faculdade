package composite;

public class Main {
    public static void main(String[] args) {
        Triangulo t = new Triangulo();
        Quadrado q = new Quadrado();
        Drawing d1 = new Drawing();
        d1.add(t);
        d1.add(q);
        d1.draw();
        System.out.println("-------------");
        Drawing d2 = new Drawing();
        d2.add(t);
        d1.add(d2);
        d1.draw();
    }
}
