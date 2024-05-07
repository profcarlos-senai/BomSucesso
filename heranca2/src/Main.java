public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Somador(1,2);
        System.out.println("Soma: "+calc.calcular());

        calc = new Multiplicador(3,4);
        System.out.println("Produto: "+calc.calcular());

    }
}