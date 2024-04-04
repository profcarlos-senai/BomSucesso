package org.example.telas;

import org.example.banco.CarroSQL;
import org.example.entidades.Carro;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TelaCarro {

    // pede um id de carro e imprime os dados, repete até teclar 0
    public static void ProcuraCarro(){
        Scanner teclas = new Scanner(System.in);
        int idCarro = 0;
        do {
            System.out.print("Digite o numero do carro a procurar (0=fim): ");
            idCarro = teclas.nextInt();

            CarroSQL carroSQL = new CarroSQL();
            Carro carro = null;
            try {
                carro = carroSQL.buscaPorId(idCarro);
            } catch (SQLException e) {
                e.printStackTrace(); // pra saber que raios aconteceu
                System.out.println("Erro de banco de dados.");
            }
            if(carro != null){
                System.out.println(carro);
            }
            else {
                System.out.println("Não existe carro com ID="+idCarro);
            }
        } while(idCarro !=0);
    }

    public static void teste(){
        try {
            Carro car = new Carro();
            car.setModelo("Fumbeca velha");
            car.setPlaca("XXX9998");
            CarroSQL carroSql = new CarroSQL();
            carroSql.gravar(car);
            car.setPlaca("AAA01B01");
            carroSql.gravar(car);
            System.out.println(car);
            carroSql.deletaPorId(car.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void testeLista(){
        try {
            CarroSQL carroSQL = new CarroSQL();
            List<Carro> lista = carroSQL.listaTodos();
            for(Carro carro: lista){
                System.out.println(carro);
            }

            System.out.println("");
            lista = carroSQL.listaFiltrados("where mod(id, 3)=0 order by modelo");
            for(Carro carro: lista){
                System.out.println(carro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
