public class Main {
    public static void main(String[] args) {
        Quarto[] hotel = new Quarto[5];

        hotel[2] = new Quarto(101, "Juca da Silva");

        Quarto q = new Quarto();
        q.setNumero(206);
        q.setHospede("Maria dos Santos");
        hotel[0] = q;

        q = new Quarto(301, "Joaquim Silvério dos Reis");
        hotel[3] = q;

        for (int i = 0; i < hotel.length; i++) {
            q = hotel[i];
            if (q != null) {
                System.out.println(q); // tô imprimindo direto quarto pra usar o toString() dele
            }
        }

    }
}