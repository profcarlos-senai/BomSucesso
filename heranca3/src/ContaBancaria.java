public class ContaBancaria {
    private double saldo;

    public ContaBancaria(){
        saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if(valor > saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        this.saldo -= valor;
    }

    public void depositar(double valor){
        saldo += valor;
    }
}
