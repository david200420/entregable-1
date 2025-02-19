class Triangle extends Figura{
    private float base;
    private float altura;

    public Triangle(float altura, float base) {
        this.altura = altura;
        this.base = base;
    }

    public float getBase() {
        return base;
    }

    public float getAltura() {
        return altura;
    }
    @Override
    public float calcularArea() {
        return (base * altura) / 2;
    }
}
