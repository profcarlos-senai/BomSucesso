public class Multiplicador extends Calculadora {
    public Multiplicador(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public double calcular() {
        return getNum1() * getNum2();
    }
}
