import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclas = new Scanner(System.in);
        double num1, num2;
        double result = Double.NaN; // NaN = "not a number"

        System.out.print("Digite um numero: ");
        num1 = teclas.nextDouble();

        System.out.print("Operação (+,-,/,*):");
        String op = teclas.next();

        System.out.print("Digite outro numero: ");
        num2 = teclas.nextDouble();

        Calculadora calc = new Calculadora(num1, num2);
        if(op.equals("+")){
            result = calc.soma();
        }
        else if(op.equals("-")){
            result = calc.subtrai();
        }
        else if(op.equals("*")){
            result = calc.multiplica();
        }
        else if(op.equals("/")){
            result = calc.soma();
        }
        else{
            System.out.println("Operação inválida.");
            result = Double.NaN;
        }

        System.out.printf("Resultado: %.3f\n", result);
    }
}