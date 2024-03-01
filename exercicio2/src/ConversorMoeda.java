public class ConversorMoeda {
    private double cotacaoDolar;

    public ConversorMoeda(double cotacao){
        this.cotacaoDolar = cotacao;
    }

    public double DolarParaReais(double dolar){
        return dolar * cotacaoDolar;
    }

    public double ReaisParaDolar(double reais){
        return reais / cotacaoDolar;
    }

    public double getCotacaoDolar() {
        return cotacaoDolar;
    }

    public void setCotacaoDolar(double cotacaoDolar) {
        this.cotacaoDolar = cotacaoDolar;
    }
}
