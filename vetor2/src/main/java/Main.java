import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // declara o vetor
            Pessoa[] linhas = new Pessoa[10];

            // abrir o arquivo
            String arquivo = "C:\\prog\\BomSucesso\\vetor2\\src\\main\\java\\dados.txt";
            Scanner leitor = new Scanner(new File(arquivo));
            // ler as linhas numa string
            int conta = 0;
            while(leitor.hasNextLine()){
                // cria uma pessoa
                Pessoa p = new Pessoa();
                p.nome = leitor.next();
                p.sexo = leitor.next().charAt(0);
                p.altura = leitor.nextDouble();
                p.peso = leitor.nextDouble();
                p.ano_nasc = leitor.nextInt();
                // joga a linha no vetor
                linhas[conta] = p;
                conta++;
            }

            // imprime o vetor
            for(conta=9; conta >= 0; conta--){
                System.out.println(linhas[conta]);
            }

            // fechar
            leitor.close();
        } catch (Exception e){
            System.out.println("Deu uns pobrema aqui");
            e.printStackTrace();
        }
    }
}