import java.sql.ResultSet;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private float peso;
    private float altura;
    private  char sexo;
    private double salario;

    public Pessoa(){
        // construtor vazio para poder criar um objeto vazio
    }

    // AVISO: ISSO É UMA GAMBIARRA HORRÍVEL! NUNCA FAÇA ISSO KKKKK
    public Pessoa(ResultSet rs){
        try {
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.idade = rs.getInt("idade");
            this.peso = rs.getFloat("peso");
            this.altura = rs.getFloat("altura");
            this.salario = rs.getDouble("salario");
            this.sexo = (" " + rs.getString("sexo")).charAt(0);
        }
        catch(Exception e){ // faz nada kkkkkk
        }
    }
    @Override
    public String toString() {
        return id+" "+nome+" "+idade+" "+peso+" "+altura+" "+sexo+" "+salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


}
