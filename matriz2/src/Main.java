package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] semana = {"seg", "ter", "qua", "qui", "sex"};
        String[][] agenda = new String[5][4];
        String diaSem; //literalmente o dia da semana
        int dia; //transforma o dia em string p int indiretamente
        String name; //nome da pessoa
        boolean contDia = false; //conta se o dia nao existe para exibir a msg
        int diaExiste = 0; //conforme os numeros o if vai saber se esse dia esta livre
        String continuar = "s"; //pra continuar ou não
        int[] horariolivre = new int[4]; //pra saber se tem alguma vaga livre
        int auxDiaLivre = 1;
        int escolha =1 ;

        Scanner leia = new Scanner(System.in);

        //pra deixar o vetor bonitinho
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                agenda[i][j] = "livre";
            }
        }
        //pra deixar o vetor bonitinho

        while (continuar != "nao"){ //loop while - inicio

            System.out.println("o que deseja fazer?");
            System.out.println("ver a agenda = 1");
            System.out.println("reservar um horário = 2");
            escolha = leia.nextInt();

            //esse vai ser pra imprimir a lista
            if (escolha == 1) {
                System.out.println("segue a agenda: ");
                for (int i = 0; i < 5; i++) {
                    System.out.print(semana[i] + ": ");
                    for (int j = 0; j < 4; j++) {
                        System.out.print(agenda[i][j] + "\t"); //resolver, fiz so 1 horario dos 4 aparecer
                    }
                    System.out.println(" ");
                }
            }

            //vai iniciar o processo de reserva de horario - inicio
            if (escolha == 2) {

                System.out.println("escolha um dia da semana: ");
                diaSem = leia.next();

                for (int i = 0; i < 5; i++) {
                    if (diaSem.equalsIgnoreCase(semana[i])) {
                        diaExiste = i;
                        contDia = true;
                        break;
                    }else{
                        contDia = false;
                    }
                }

                if (contDia) { //se contDia = true ent faz a reserva - inicio

                    for (int h = 0; h < 4; h++) { //confere se tem horario livre - inicio
                        if (agenda[diaExiste][h].equalsIgnoreCase("livre")) {
                            if(horariolivre[diaExiste] == 0) {
                                horariolivre[diaExiste] = h;
                            }
                            else{
                                break;
                            }
                        }
                    } //confere se tem horario livre - fim

                    if (horariolivre[diaExiste] < 5) { //inf. nome e poe na ag - inicio
                        System.out.println("informe seu nome: ");
                        name = leia.next();
                        agenda[diaExiste][horariolivre[diaExiste]-1] = name;
                        auxDiaLivre = auxDiaLivre+1;
                        horariolivre[diaExiste] = + auxDiaLivre;
                    } //inf nome e poe na ag - fim

                    else { //se n tiver vaga - inicio
                        System.out.println("na " + semana[diaExiste] + " não tem vaga!");
                    } //se n tiver vaga - fim

                }//if pra cadastra - fim

                else { //dia nao existe - inicio
                    System.out.println("esse dia não existe...");
                } //dia nao existe - fim

            }//escolha 2 - fim

            System.out.println("deseja continuar?");
            continuar = leia.next();
        }//loop while - fim


    }//main
}//clas main