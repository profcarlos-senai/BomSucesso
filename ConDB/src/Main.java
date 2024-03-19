import Entities.Quarto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        String descricao;
        long tipo;
        while(opcao != 1 && opcao != 2 && opcao !=3) {
            System.out.println("Escolha a opção desejada:\n" +
                    "1 - Listar Quartos\n" +
                    "2 - Cadastrar novo quarto\n" +
                    "3 - Encerrar programa");
            opcao = sc.nextInt();
            if(opcao != 1 && opcao != 2 && opcao !=3){
                System.out.println("Opção Inválida Selecione uma das opções abaixo");
            }
        }
        while(opcao == 1 || opcao == 2) {
            switch (opcao){
                case 1:
                    Quarto.listarQuarto();
                    break;
                case 2:
                    System.out.println("Informe a descricao do quarto");
                    descricao = sc.next();
                    System.out.println("Informe o tipo do quarto");
                    tipo = sc.nextLong();

                    Quarto quarto = new Quarto();
                    quarto.setDescricao(descricao);
                    quarto.setTipo(tipo);

                    if(quarto.salvarQuarto()){
                        System.out.println("Quarto Salvo com sucesso!");
                    }else{
                        System.out.println("Falha ao Salvar o quarto!");
                    }
                    break;
            }

            System.out.println("Deseja fazer outra operação?\n" +
                    "Escolha opção desejada:\n" +
                    "1 - Listar Quartos\n" +
                    "2 - Cadastrar novo quarto\n" +
                    "3 - Encerrar programa");
            opcao = sc.nextInt();
            while(opcao != 1 && opcao !=2 && opcao != 3){
                System.out.println("opção inválida!");
                System.out.println("Escolha uma das opções abaixo:\n" +
                        "1 - Listar Quartos\n" +
                        "2 - Cadastrar novo quarto\n" +
                        "3 - Encerrar programa");
                opcao = sc.nextInt();
            }
        }
    }
}
