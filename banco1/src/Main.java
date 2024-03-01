public class Main {
    public static void main(String[] args) {

        ContaBancaria jurema = new ContaBancaria();
        jurema.depositar(1000);
        jurema.sacar(300);
        jurema.depositar(20);
        jurema.sacar(70);

        System.out.printf("Saldo: %.2f\n", jurema.getSaldo());
    }
}