package org.example.banco;

import org.example.entidades.Entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Ancestral de todos os objetos de acesso a dados (DAO)
// É uma classe ABSTRATA, portanto é impossível criar objetos dela
public abstract class TabelaSQL<E extends Entidade> {

    // um método ABSTRATO precisa ser reescrito pelos filhos
    // um método protected só pode ser visto pelos filhos ou
    // por classes do mesmo pacote

    // esse método serve para o descendente dizer para o ancestral
    // qual é o nome da tabela pra o ancestral construir as queries
    abstract protected String getNomeTabela();

    // esse método serve para o descendente retornar o SQL UPDATE para atualizar um registro
    abstract protected String getUpdateSQL(E dados);

    // esse método serve para o descendente retornar o SQL INSERT para criar um registro novo
    abstract protected String getInsertSQL(E dados);

    // esse método serve para o ancestral passar o ResultSet para o
    // descendente e receber em troca um objeto cheio de dados
    abstract protected E carregaEntidade(ResultSet rs) throws SQLException;

    // retorna uma entidade baseado na ID
    public E buscaPorId(int id) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        // olha o "getNomeTabela()" aí! Esse método foi implementado no descendente
        PreparedStatement pre = con.prepareStatement("select * from "+getNomeTabela()+" where id="+id+";");
        ResultSet res = pre.executeQuery();
        // descobre se veio alguma coisa
        if(res.next()){ // .next() retorna TRUE se tem uma linha e ao mesmo tempo puxa ela
            return carregaEntidade(res); // chama o método do descendente
        } else { // se o .next() retornou FALSE quer dizer que não existe um carro com essa ID
            return null;
        }
    }

    // apaga um registro pela id
    public void deletaPorId(int id) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        // olha o "getNomeTabela()" aí! Esse método foi implementado no descendente
        PreparedStatement pre = con.prepareStatement("delete from "+getNomeTabela()+" where id="+id+";");
        pre.execute();
    }

    // grava um objeto no banco de dados
    public void gravar(E dados) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        // pra não gravar um objeto nulo
        if (dados==null) throw new SQLException("Tentativa de gravar um objeto nulo!");
        // se o ID está nulo é pra inserir, cheio é pra atualizar
        if(dados.getId()==null){
            // remove o ";" caso exista
            String insert = getInsertSQL(dados).replace(";"," ");
            // RETURNING ID faz com que eu descubra o ID do novo registro
            PreparedStatement pre = con.prepareStatement(insert + " returning id;");
            ResultSet res = pre.executeQuery();
            // recupera o ID e coloca no objeto
            res.next();
            dados.setId(res.getInt("id"));
        } else {
            // pega o sql do update
            String update = getUpdateSQL(dados);
            // roda a query
            con.prepareStatement(update).execute(); // não precisa de resultset
        }
    }

    // lista todos os registros
    public List<E> listaTodos() throws SQLException{
        return listaFiltrados(""); // é uma lista filtrada só que sem filtro kkkk
    }

    // lista registros filtrados por um "where"
    public List<E> listaFiltrados(String where) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        // monta a query
        String sql = "select * from "+getNomeTabela()+" "+where;
        ResultSet res = con.prepareStatement(sql).executeQuery();
        // gira os registros e enche a lista
        ArrayList<E> lista = new ArrayList<>();
        while(res.next()){
            E dados = carregaEntidade(res); // "E" é o tipo do descendente
            lista.add(dados);
        }
        return lista;
    }

}
