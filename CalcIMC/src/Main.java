public class Main {
    public static void main(String[] args) {
        CalcIMC xuxu = new CalcIMC(100, 2);
        System.out.printf("Uma pessoa de 100kg e 2m de altura tem IMC=%.1f\n", xuxu.calcular() );
    }
}