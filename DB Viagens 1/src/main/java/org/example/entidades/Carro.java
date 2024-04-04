package org.example.entidades;

public class Carro extends Entidade {
    // id tá no ancestral
    private String modelo;
    private String placa;

    // gerar Getter e Setter e toString() com ALT+INSERT

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
