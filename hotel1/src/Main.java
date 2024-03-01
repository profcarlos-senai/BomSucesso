public class Main {
    public static void main(String[] args) {
        Hotel california = new Hotel(10);
        california.registrar("Juca");
        california.registrar("Maria");
        california.registrar("Ana");

        System.out.printf("Quartos vagos: %d\n", california.getVagos());

        california.listar();
    }
}