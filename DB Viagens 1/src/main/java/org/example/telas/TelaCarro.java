package org.example.telas;

import org.example.banco.CarroSQL;
import org.example.entidades.Carro;

import java.sql.SQLException;
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
}
