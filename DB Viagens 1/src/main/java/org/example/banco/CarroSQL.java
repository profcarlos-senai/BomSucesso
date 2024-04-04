package org.example.banco;

import org.example.entidades.Carro;
import org.example.entidades.Entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Faz o meio-de-campo entre o Postgresql e a entidade Carro
public class CarroSQL extends TabelaSQL<Carro>{

    @Override
    protected String getNomeTabela() {
        // assim que o TabelaSQL sabe o nome da tabela pra usar nas queries
        return "carros";
    }

    @Override
    protected String getUpdateSQL(Carro dados) {
        if (dados == null) return ""; // vai dar erro lá dentro
        // monta o update e devolve para o ancestral usar
        return String.format("update carros set modelo='%s', placa='%s' where id=%d;",
                dados.getModelo(), dados.getPlaca(), dados.getId());
    }

    @Override
    protected String getInsertSQL(Carro dados) {
        if (dados == null) return ""; // vai dar erro lá dentro
        // monta o insert e devolve para o ancestral usar
        return String.format("insert into carros(modelo, placa) values('%s','%s')",
                dados.getModelo(), dados.getPlaca());
    }

    @Override
    protected Carro carregaEntidade(ResultSet res) throws SQLException {
        // assim que o TabelaSQL consegue encher um carro com dados
        // mesmo sem saber que o descendente é um carro
        Carro carro = new Carro();
        carro.setId( res.getInt("id") );
        carro.setModelo( res.getString("modelo") );
        carro.setPlaca( res.getString("placa"));
        return carro;
    }
}
