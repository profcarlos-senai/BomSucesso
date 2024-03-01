import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner letras = new Scanner(System.in);
        double num1, num2, soma;

        System.out.print("Digite um numero: ");
        num1 = letras.nextDouble();
        System.out.print("Digite outro numero: ");
        num2 = letras.nextDouble();

        Calculadora calc = new Calculadora(num1, num2);
        soma = calc.soma();

        System.out.printf("Resultado: %.3f\n", soma);
    }
}