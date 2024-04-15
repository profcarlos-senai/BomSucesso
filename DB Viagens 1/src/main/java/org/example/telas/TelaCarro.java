package org.example.telas;

import org.example.banco.CarroSQL;
import org.example.entidades.Carro;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TelaCarro {

    public static void listaCarros(){
        try {
            // puxar a lista de carros do CarrosSQL
            List<Carro> lista = CarroSQL.listaTodos();
            // imprime um cabeçalho
            System.out.println("LISTA DE CARROS:");
            System.out.println("---------------------------------------------------------------");
            System.out.println("id    placa      modelo");
            // vasculha a lista
            for (Carro car : lista) {
                // imprime um carro
                System.out.printf("%-5d %-10s %-30s\n", car.getId(), car.getPlaca(), car.getModelo());
            }
        } catch (Exception e){
            System.out.println("Erro ao listar carros: "+e.getMessage());
        }

    }

    // testa a gravação de carros
    public static void testaSalvar(){
        try {
            Carro carro = CarroSQL.buscaPorId(10);
            carro.setModelo("Jamanta cor-de-rosa");
            carro.setPlaca("BBB9999");
            CarroSQL.salvar(carro);
        } catch (Exception e) {
            e.printStackTrace(); // mostra o erro
        }
    }

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
