import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try {
            Scanner scn = new Scanner(new File("C:\\temp\\dados.txt"));
            scn.useDelimiter("[\t|\n]");
            while (scn.hasNext()){
                String nome = scn.next();
                int idade = scn.nextInt();
                float peso = scn.nextFloat();
                float altura = scn.nextFloat();
                char sexo = scn.next().charAt(0);
                String salario = scn.next();

                System.out.printf("%-20s\t%3.1f\t%1.2f\t%c\tR$ %s\n", nome, peso, altura, sexo, salario);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }
}