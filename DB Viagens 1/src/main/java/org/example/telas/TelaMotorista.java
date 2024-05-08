package org.example.telas;

import org.example.banco.MotoristaSQL;
import org.example.entidades.Motorista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelaMotorista {

    public static void procura(){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("O que procurar?");
            String nome = scan.next();
            ArrayList<Motorista> motoristas = (ArrayList<Motorista>) MotoristaSQL.procuraNome(nome);
            for (Motorista motora : motoristas) {
                System.out.println(motora.getNome());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void listaMotoristas(){
        try {
            // puxar a lista de motoristas do MotoristasSQL
            List<Motorista> lista = MotoristaSQL.listaTodos();
            // imprime um cabeçalho
            System.out.println("LISTA DE MOTORISTAS:");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("ID    MOTORISTA                                         IDADE SEXO CIDADE");
            // vasculha a lista
            for (Motorista cid : lista) {
                // imprime um motorista
                System.out.printf("%-5d %-50s %-5d %c    %s\n", cid.getId(), cid.getNome(), cid.getIdade(), cid.getSexo(), cid.getId_cidade());
            }
        } catch (Exception e){
            System.out.println("Erro ao listar motoristas: "+e.getMessage());
        }

    }
}
