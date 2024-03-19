public class Quarto {
    private int numero;
    private String hospede;

    public Quarto(int n, String h){
        this.numero = n;
        this.hospede = h;
    }

    public Quarto(){
        this.numero = 0;
        this.hospede = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHospede() {
        return hospede;
    }

    public void setHospede(String hospede) {
        this.hospede = hospede;
    }

    @Override // avisa o java que estou escrevendo por cima do toString padrão dele
    public String toString(){
        return this.getNumero() + " - " + this.getHospede();
    }
}
