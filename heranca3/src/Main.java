import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        double valor;
        ContaBancaria conta;
        Scanner teclas = new Scanner(System.in);

        // pergunta o tipo de conta
        do {
            System.out.println("Tipo de conta: [1] Normal [2] Executiva:");
            opcao = teclas.nextInt();
            if ((opcao != 1) && (opcao != 2)) {
                System.out.println("Opção inválida.");
            }
        }while((opcao != 1) && (opcao != 2));

        // cria a conta do tipo escolhido
        if(opcao==1) {
            conta = new ContaBancaria();
        } else {
            System.out.println("Limite: ");
            double limite = teclas.nextDouble();
            conta = new ContaExecutiva(limite);
        }

        // mostra o menu até sair
        do{
            System.out.printf("Saldo: %.2f\n",conta.getSaldo());
            System.out.println("Escolha [1] depositar, [2] sacar ou [0] sair:");
            opcao = teclas.nextInt();

            if(opcao == 1){                         // depositar
                System.out.print("Valor: ");
                valor = teclas.nextDouble();
                conta.depositar(valor);
            } else if(opcao == 2){                  // sacar
                System.out.print("Valor: ");
                valor = teclas.nextDouble();
                try{
                    conta.sacar(valor);
                }
                catch (SaldoInsuficienteException e){  // saldo insuficiente?
                    System.out.println(e.getMessage());
                }
                catch (Exception e){ // caso ocorra outra exceção qualquer
                    System.out.println("Erro inesperado: "+e.getMessage());
                }
            } else if (opcao != 0) { // mané não sabe digitar
                System.out.println("Opção inválida.");
            }

        }while(opcao != 0); // cabô!
    }
}