import java.util.Random;

public class Main {

    public static void exercicio1(){
        // criar um vetor de 10 inteiros
        int[] vetor1 = new int[10];
        int[] vetor2 = new int[10];

        // encha com números aleatórios
        Random random = new Random();
        for (int i = 0; i < vetor1.length; i++) {
            vetor1[i] = random.nextInt(100);
            vetor2[9-i] = vetor1[i];
        }

        // imprima a lista
        System.out.println("Vetor original");
        imprimeVetor(vetor1);

        // imprime o inverso
        System.out.println("Vetor invertido");
        imprimeVetor(vetor2);
    }

    public static void imprimeVetor(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void exercicio2(){
        // cria um vetor de 6 nomes
        String[] vetor = {"Jo", "Ana", "Pindamonhangaba",
                "Juarez","Hipopótamo","Marieta"};

        int menor = 0;
        int maior = 0;

        // imprimir qual o mais comprido e qual o mais curto
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i].length() > vetor[maior].length()) maior = i;
            if(vetor[i].length() < vetor[menor].length()) menor = i;
        }

        System.out.println("+comprido: "+vetor[maior]);
        System.out.println("+curto   : "+vetor[menor]);

        // pedir um nome (questão 5)

        // dizer em que posição do vetor está (ou se não está)

    }

    public static void main(String[] args) {
        exercicio1();
        exercicio2();
    }
}