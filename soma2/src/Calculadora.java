public class Calculadora {
    private double valor1;
    private double valor2;

    public Calculadora(double v1, double v2){
        this.valor1 = v1;
        this.valor2 = v2;
    }

    public double soma(){
        return this.valor1 + this.valor2;
    }
}