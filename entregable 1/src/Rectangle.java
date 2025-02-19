public class Rectangle extends Figura {

    protected float base;
    protected float altura;

    public float getAltura() {
        return altura;
    }

    public float getBase() {
        return base;
    }

    public void Rectangle(float altura, float base) {
        this.altura = altura;
        this.base = base;
    }

    @Override
    public float calcularArea() {
        return (base * altura);
    }
}
