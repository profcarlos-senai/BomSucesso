public abstract class Pet extends Bicho {
    String nome;

    public Pet(){
        super(100); // assim que eu chamo o construtor do ancestral
        setNome("");
    }

    public abstract void falar();

    public Pet(String nome){
        this(); // chama o construtor sem parâmetro de eu mesmo
        setNome(nome);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
