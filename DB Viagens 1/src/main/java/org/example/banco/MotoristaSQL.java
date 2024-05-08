package org.example.banco;

import org.example.entidades.Carro;
import org.example.entidades.Motorista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaSQL {

    // retorna uma lista com todos os carros
    public static List<Motorista> listaTodos() throws SQLException {
        // pegar a conexão
        Connection con = ConnectionFactory.getConnection();
        // fazer um select all
        PreparedStatement pre = con.prepareStatement("select * from motoristas order by id;");
        // catar cada motorista e socar na lista
        ArrayList<Motorista> listaMotorista = new ArrayList<>();
        ResultSet res = pre.executeQuery();
        while(res.next()){ // enquanto tiver linhas no resultado
            Motorista motorista = new Motorista();
            motorista.setId( res.getInt("id") );
            motorista.setNome( res.getString("nome") );
            motorista.setIdade( res.getInt("idade") );
            motorista.setSexo( res.getString("sexo").charAt(0));
            motorista.setId_cidade( res.getInt("id_cidade") );
            listaMotorista.add(motorista); // yay
        }
        // retornar a lista
        return listaMotorista;
    }

    // retorna todos os motoristas com o nome parecido com o da procura
    public static List<Motorista> procuraNome(String nome) throws SQLException {
        // pegar a conexão
        Connection con = ConnectionFactory.getConnection();
        // fazer um select all
        PreparedStatement pre = con.prepareStatement("select * from motoristas where upper(nome) like ? order by nome;");
        String procura = '%'+nome.toUpperCase().replace(" ","%")+'%';
        pre.setString(1, procura);
        // catar cada motorista e socar na lista
        ArrayList<Motorista> listaMotorista = new ArrayList<>();
        ResultSet res = pre.executeQuery();
        while(res.next()){ // enquanto tiver linhas no resultado
            Motorista motorista = new Motorista();
            motorista.setId( res.getInt("id") );
            motorista.setNome( res.getString("nome") );
            motorista.setIdade( res.getInt("idade") );
            motorista.setSexo( res.getString("sexo").charAt(0));
            motorista.setId_cidade( res.getInt("id_cidade") );
            listaMotorista.add(motorista); // yay
        }
        // retornar a lista
        return listaMotorista;
    }


}
