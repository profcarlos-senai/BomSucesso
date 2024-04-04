package org.example;

import org.example.banco.CarroSQL;
import org.example.banco.ConnectionFactory;
import org.example.telas.TelaCarro;


public class Main {
    public static void main(String[] args) {
        // tenta conectar com o banco
        try {
            ConnectionFactory.getConnection(); // não precisa guardar pq a Factory lembra a conexão        }
        } catch(RuntimeException e){
            System.out.println( e.getMessage() );
            return; // cai fora pq não tem conexão
        }

        // se chegou aqui tem conexão
        TelaCarro.teste();

        // apaga a luz antes de sair
        ConnectionFactory.closeConnection();
    }
}