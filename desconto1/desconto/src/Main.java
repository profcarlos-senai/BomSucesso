import java.util.Scanner;

class CalcDesconto {
    private double valorReais;
    private double descPerc;

    public CalcDesconto(double reais, double perc){
        this.valorReais = reais;
        this.descPerc = perc/100;
    }

    public double descontoReais(){
        return valorReais * descPerc;
    }

    public double valorTotal(){
        return valorReais - descontoReais();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner jurema = new Scanner(System.in);

        System.out.print("Valor em R$: ");
        double valor = jurema.nextDouble();

        System.out.print("Desconto %: ");
        double descPerc = jurema.nextDouble();

        CalcDesconto calculadora = new CalcDesconto(valor, descPerc);

        System.out.printf("Desconto em R$: %.2f\n", calculadora.descontoReais());
        System.out.printf("Total com desconto R$ %.2f\n", calculadora.valorTotal());
    }
}