package org.example.banco;

import org.example.entidades.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeSQL {

    // retorna uma lista com todos os cidades
    public static List<Cidade> listaTodos() throws SQLException {
        // pegar a conexão
        Connection con = ConnectionFactory.getConnection();
        // fazer um select all
        PreparedStatement pre = con.prepareStatement("select * from cidades order by id;");
        // catar cada cidade e socar na lista
        ArrayList<Cidade> listaCidade = new ArrayList<>();
        ResultSet res = pre.executeQuery();
        while(res.next()){ // enquanto tiver linhas no resultado
            Cidade cidade = new Cidade();
            cidade.setId( res.getInt("id") );
            cidade.setCidade( res.getString("cidade") );
            cidade.setUf( res.getString("uf"));
            listaCidade.add(cidade); // yay
        }
        // retornar a lista
        return listaCidade;
    }
}
