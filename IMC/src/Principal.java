import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        char continuar = 'S';
        int contador = 0;
        float peso, altura, imc, somaImc = 0;

        // Scanner é um objeto que lê coisas do teclado
        Scanner scanner = new Scanner(System.in);

        do {
            // Solicita o peso e altura
            System.out.print("Informe o peso (em kg): ");
            peso = scanner.nextFloat();

            System.out.print("Informe a altura (em metros): ");
            altura = scanner.nextFloat();

            // Calcula o IMC
            imc = peso / (altura * altura);

            // Imprime o IMC
            System.out.printf("IMC: %.2f\n", imc);

            // Atualiza a soma dos IMCs e incrementa o contador
            somaImc += imc;
            contador++;

            // Pergunta se deseja continuar
            System.out.print("Deseja continuar? (S/N): ");
            continuar = scanner.next().charAt(0);  // pega o caractere [0] da string

        } while (continuar == 'S' || continuar == 's');

        // Calcula a média dos IMCs e imprime
        if (contador > 0) {
            float mediaImc = somaImc / contador;
            System.out.printf("Média dos IMCs: %.2f\n", mediaImc);
        } else {
            System.out.print("Nenhum dado inserido.\n");
        }
    }
}
