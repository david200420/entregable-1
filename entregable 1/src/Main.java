public class Main {
    public static void main(String[] args) {

        Triangle t = new Triangle(5,5);
        System.out.println(t.calcularArea());
        Quadrat q = new Quadrat(5);
        System.out.println(q.calcularArea());
        Rectangle r = new Rectangle(5,5);
        System.out.println(r.calcularArea());
    }

}