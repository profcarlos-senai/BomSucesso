public class Pessoa {
    String nome;
    char sexo;
    double peso;
    double altura;
    int ano_nasc;

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                ", ano_nasc=" + ano_nasc +
                '}';
    }
}
