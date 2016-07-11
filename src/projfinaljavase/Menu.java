/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.util.Scanner;

/**
 *
 * @author João
 */
public class Menu {

    private int escolha;
    private GesStock gs;
    private Scanner in = new Scanner(System.in);

    public void menu() {

        gs = new GesStock();
        
        do {

            System.out.println("\n");
            System.out.println("Menu\n");
            System.out.println("1. Registo de Produto");
            System.out.println("2. Registo de Cliente");
            System.out.println("3. Consultas");
            System.out.println("4. Vendas de Produtos");
            System.out.println("5. Sair do Programa");

            escolha = Integer.parseInt(in.next());

            switch (escolha) {

                case 1:

                    ResgProd();
                    break;
                case 2:

                    ResgCli();
                    break;

                case 3:

                    Consulta();
                    break;

                case 4:

                    break;

                case 5:

                    System.out.println("Até à próxima");
                    System.exit(0);

                    break;

            }

        } while (true);

    }

    public void ResgProd() {

        String desig;
        int stock;
        float prc;

        System.out.println("Insira o nome de um Produto:");
        desig = in.next();
        System.out.println("Insira o Stock do Produto:");
        stock = Integer.parseInt(in.next());
        System.out.println("Insira o PVP:");
        prc = Float.parseFloat(in.next());

        if (gs.registaProducto(desig, stock, prc)) {

            System.out.println("Produto registado com sucesso!!!");

        } else {
            System.out.println("As nossas desculpas!!");
            System.out.println("Houve um erro ao resgitar o Produto");
            System.out.println("Insira novamente!!!");
        }

    }

    public void ResgCli() {

        String nome;
        String morada;
        int telf;
        String mail;

        System.out.println("Insira o nome do Cliente:");
        nome = in.next();
        System.out.println("Insira uma Morada:");
        morada = in.next();
        System.out.println("Insira um E-Mail:");
        mail = in.next();
        System.out.println("Insira um contacto telefónico");
        telf = Integer.parseInt(in.next());

        if (gs.registaCliente(nome, morada, telf, mail)) {

            System.out.println("Cliente registado com sucesso!!!");

        } else {
            System.out.println("As nossas desculpas!!");
            System.out.println("Houve um erro ao resgitar o Cliente");
            System.out.println("Insira novamente!!!");
        }

    }
//______SUB-MENU CONSULTA_____OPÇÃO 3 DO MENU PRINCIPAL_____________________//________________________________________

    private void Consulta() {

        do {

            System.out.println("\n");
            System.out.println("Menu\n");
            System.out.println("1. Listar Stock de Produtos");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Histórico Clientes");
            System.out.println("4. Procurar Produtos ");
            System.out.println("5. Guarda dados para ficheiro");
            System.out.println("6. Menu Anterior");

            escolha = Integer.parseInt(in.next());

            switch (escolha) {

                case 1:
                    gs.getProdutos();

                    break;
                case 2:
                    gs.getClientes();

                    break;
                case 3:

                    HistCliente();

                    break;
                case 4:

                    ProcuraProdutos();
                    break;
                case 5:

                    //criar metodo para menu!!!3
                    break;
                case 6:

                    return;

            }

        } while (true);

    }

    public void HistCliente() {

        System.out.println(gs.getIdNomeClientes());//primeiro lista os clientes para poder escolher
        System.out.println("Insira o ID do Cliente que pretende:");
        int i;
        i = Integer.parseInt(in.next());
        gs.getEncomendasCliente(i);

    }

    //_______SUB-MENU PROCURA PRODUTO_______OPÇÃO 4 DO SUB-MENU CONSULTA______________//________________________________________
    public void ProcuraProdutos() {

        do {

            System.out.println("\n");
            System.out.println("Menu\n");
            System.out.println("1. Procura por Preco");
            System.out.println("2. Procura por ID");
            System.out.println("3. Procura por Designacao");
            System.out.println("4. Procura por Stock a Zero");
            System.out.println("5. Menu Anterior");
            escolha = Integer.parseInt(in.next());

            switch (escolha) {

                case 1:

                    System.out.println("Insira o preco que pretende:");
                    float i;
                    i = Float.parseFloat(in.next());
                    System.out.println(gs.getProdutoPreco(i));
                    break;

                case 2:
                    System.out.println(gs.getProdutos());
                    System.out.println("Insira o ID do produto:");
                    int q;
                    q = Integer.parseInt(in.next());
                    System.out.println(gs.getProdutoPreco(q));
                    break;

                case 3:

                    System.out.println("Insira o nome do produto");
                    String n;
                    n = in.next();
                    System.out.println(gs.getProdutoNome(n));
                    break;

                case 4:

                    gs.getProdutosStockZero();

                    break;

                case 5:

                    return;

            }
        } while (true);

    }

}
