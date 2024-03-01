public class Main {
    public static void main(String[] args) {
        ConversorMoeda conv = new ConversorMoeda(4.97);
        double dolar = conv.ReaisParaDolar(1000);
        System.out.printf("R$ 1000,00 = US$ %.2f\n", dolar);

        double reais = conv.DolarParaReais(250);
        System.out.printf("US$ 250,00 = R$ %.2f\n", reais);

        double[] xuxu = new double[3];
        xuxu.

    }
}