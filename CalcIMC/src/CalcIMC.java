public class CalcIMC {
    private double peso;
    private double altura;
    public CalcIMC(double peso, double altura){
        this.peso = peso;
        this.altura = altura;
    }
    public double calcular(){
        return this.peso/(this.altura*this.altura);
    }
}
