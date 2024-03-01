import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclas = new Scanner(System.in);
        double num1, num2, soma;

        System.out.print("Digite um numero: ");
        num1 = teclas.nextDouble();
        System.out.print("Digite outro numero: ");
        num2 = teclas.nextDouble();

        soma = num1 + num2;
        System.out.printf("Resultado: %.3f\n", soma);
    }
}