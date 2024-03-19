package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Quarto {
    private Long id;
    private String descricao;
    private Long tipo;

    public Quarto() {
    }

    public Quarto(Long id, String descricao, Long tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    //READ
    public static void listarQuarto(){
        Connection con = null;
        try{
            con = ConnectionFactory.getConnection();
            if(con == null){
                System.out.println("Falha ao conectar o banco");
            }else{
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                try{
                    pstmt = con.prepareStatement("SELECT descricao, nome FROM quarto " +
                            "INNER JOIN tipo_quarto on quarto.tipo = tipo_quarto.id");
                    rs = pstmt.executeQuery();

                    while(rs.next()){
                        System.out.println("Quarto: "+rs.getString("descricao")+
                                " Tipo: "+ rs.getString("nome"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con);
        }
    }

    //CREATE
    public boolean salvarQuarto(){
        boolean salvoComSucesso = false;
        Connection con = null;
        try{
            con = ConnectionFactory.getConnection();
            if(con == null){
                System.out.println("Falha ao conectar o banco de dados!");
            }else{
                try {
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO quarto " +
                            "(descricao,tipo) VALUES('" + this.descricao + "'," + this.tipo + ")");
                    pstmt.execute();
                    salvoComSucesso = true;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(con);
        }


        return salvoComSucesso;
    }
}
