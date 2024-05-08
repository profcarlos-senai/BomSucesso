public class ContaExecutiva extends ContaBancaria {
    private double limite = 0;

    public ContaExecutiva(double limite){
        super();
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if(valor > getSaldo()+getLimite()){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        setSaldo(getSaldo() - valor);
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
