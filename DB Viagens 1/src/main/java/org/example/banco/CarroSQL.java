package org.example.banco;

import org.example.entidades.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Faz o meio-de-campo entre o Postgresql e a entidade Carro
public class CarroSQL {

    // busca um carro no banco de dados pela ID
    public Carro buscaPorId(int id) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pre = con.prepareStatement("select * from carros where id="+id);
        ResultSet res = pre.executeQuery();
        // descobre se veio alguma coisa
        if(res.next()){ // .next() retorna TRUE se tem uma linha e ao mesmo tempo puxa ela
            Carro carro = new Carro();
            carro.setId( res.getInt("id") );
            carro.setModelo( res.getString("modelo") );
            carro.setPlaca( res.getString("placa"));
            return carro;
        } else { // se o .next() retornou FALSE quer dizer que não existe um carro com essa ID
            return null;
        }
    }
}
