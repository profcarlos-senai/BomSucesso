package org.example.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection conexao = null;

    // Configurações do banco de dados
    private static final String URL = "jdbc:postgresql://192.168.10.82:5432/viagens";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() {
        // se já passou por aqui antes retorna a conexão pronta
        if (conexao != null) return conexao;

        // se chegou aqui é a primeira vez
        try {
            // lembra a conexão pra não precisar conectar na próxima vez que chamar
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        } catch (SQLException e) {
            // Trata exceções
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void closeConnection() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null; // como fechou, anula para forçar conectar na próxima vez
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão com o banco de dados", e);
            }
        }
    }
}