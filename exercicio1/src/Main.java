public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Juca");
        p.setSobrenome("da Silva");
        System.out.println( p.getNomeCompleto() );

        Pessoa outro = p;
        System.out.println( outro.getNomeCompleto() );
        outro.setNome("Maria");

        System.out.println( outro.getNomeCompleto() );
        System.out.println( p.getNomeCompleto() );
    }
}