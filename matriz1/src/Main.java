import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // exemplos de matrizes em java
        int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] nomeMes = {"Jan","Fev","Mar","Abr","Mai","Jun",
        "Jul", "Ago", "Set", "Out", "Nov", "Dez"};

        for(int i=0; i<12; i++){
            System.out.printf("O mes de %s tem %d dias\n", nomeMes[i], diasMes[i]);
        }

        // Peça para digitar o nome de um mês e diga qual o número dele e quantos dias tem
        // para comparar strings vc faz if(xuxu.equals(outro)){ ... }
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite um mês: ");
        String mes = scan.next();

        // procura um por um até achar
        boolean achou = false;
        for(int i=0; i<12; i++){
            if(mes.equalsIgnoreCase(nomeMes[i])){ // equalsIgnoreCase
                System.out.printf("O mes %d tem %d dias\n", i+1, diasMes[i]); // dá o resultado
                achou = true;
            }
        }
       if(!achou){
            System.out.println("Esse mês não existe:"+mes);
        }



        // agora pedir o número do dia e dizer quantos dias se passaram desde o começo do ano
        // Ex: maio 20 - 140º dia do ano


    }
}








