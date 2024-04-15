package org.example.banco;

import org.example.entidades.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Faz o meio-de-campo entre o Postgresql e a entidade Carro
public class CarroSQL {

    // retorna uma lista com todos os carros
    public static List<Carro> listaTodos() throws SQLException {
        // pegar a conexão
        Connection con = ConnectionFactory.getConnection();
        // fazer um select all
        PreparedStatement pre = con.prepareStatement("select * from carros order by id;");
        // catar cada carro e socar na lista
        ArrayList<Carro> listaCarro = new ArrayList<>();
        ResultSet res = pre.executeQuery();
        while(res.next()){ // enquanto tiver linhas no resultado
            Carro carro = new Carro();
            carro.setId( res.getInt("id") );
            carro.setModelo( res.getString("modelo") );
            carro.setPlaca( res.getString("placa"));
            listaCarro.add(carro); // yay
        }
        // retornar a lista
        return listaCarro;
    }

    // busca um carro no banco de dados pela ID
    public static Carro buscaPorId(int id) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pre = con.prepareStatement("select * from carros where id=?;");
        pre.setInt(1, id); // prepara a query passando parâmetros para substituir o ?
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

    // grava um carro no banco de dados
    public static void salvar(Carro carro) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        // primeiro, descobrir se eu preciso INSERIR um registro novo ou ALTERAR um velho
        if(carro.getId() != null){ // se já tem ID quer dizer que veio do banco de dados
            String sql = "update carros set modelo=?, placa=? where id=?;";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, carro.getModelo()); // o 1º "?" é o modelo
            pre.setString(2, carro.getPlaca()); // o 2º "?" é a placa
            pre.setInt(3, carro.getId()); // o 3º "?" é a id
            pre.execute(); // não precisa puxar resultado
        }
        else { // inclui um registro novo
            String sql = "insert into carros(modelo, placa) values (?,?);";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, carro.getModelo()); // o 1º "?" é o modelo
            pre.setString(2, carro.getPlaca()); // o 2º "?" é a placa
            pre.execute(); // não precisa puxar resultado
        }
    }

}
