package org.example.telas;

import org.example.banco.CidadeSQL;
import org.example.entidades.Cidade;

import java.util.List;

public class TelaCidade {

    public static void listaCidades(){
        try {
            // puxar a lista de cidades do CidadesSQL
            List<Cidade> lista = CidadeSQL.listaTodos();
            // imprime um cabeçalho
            System.out.println("LISTA DE CIDADES:");
            System.out.println("---------------------------------------------------------------");
            System.out.println("ID    CIDADE                                             UF");
            // vasculha a lista
            for (Cidade cid : lista) {
                // imprime um cidade
                System.out.printf("%-5d %-50s %s\n", cid.getId(), cid.getCidade(), cid.getUf());
            }
        } catch (Exception e){
            System.out.println("Erro ao listar cidades: "+e.getMessage());
        }

    }
}
