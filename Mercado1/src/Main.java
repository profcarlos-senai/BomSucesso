import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int quant;
        double preco;
        Scanner teclas = new Scanner(System.in);

        System.out.print("Digite quantidade: ");
        quant = teclas.nextInt();
        System.out.print("Digite preço: ");
        preco = teclas.nextDouble();

        double total = quant * preco;
        System.out.printf("Total: R$ %.2f\n", total);
    }
}