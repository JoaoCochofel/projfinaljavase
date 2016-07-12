/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.util.Scanner;

/**
 *
 * @author Vitor Filipe
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

            boolean excep = false;
            do {
                try {
                    escolha = Integer.parseInt(in.nextLine());
                    excep = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Introduza um valor de 1 a 5.");
                }
            } while (!excep);

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

    public void vendeProduto() {
        int inc = -1, inp = -1, qtd = -1;
        float ret;
        boolean test = true;
        System.out.println(gs.getIdNomeClientes());
        System.out.println("Escolha o ID do cliente Comprador: ");
        do {
            try {
                inc = Integer.parseInt(in.nextLine());
                if (gs.getIdNomeClientes().contains("" + inc)) {
                    test = true;
                } else {
                    test = false;
                    System.out.println("Introduza um valor inteiro válido");
                }
            } catch (NumberFormatException ex) {
                test = false;
                System.out.println("Introduza um valor inteiro válido");
            }
        } while (!test);
        System.out.println(gs.getIdDesigProduto());
        System.out.println("Escolha o ID do produto: ");
        do {
            try {
                inp = Integer.parseInt(in.nextLine());
                if (gs.getIdDesigProduto().contains("" + inp)) {
                    test = true;
                } else {
                    test = false;
                    System.out.println("Introduza um valor inteiro válido");
                }
            } catch (NumberFormatException ex) {
                test = false;
                System.out.println("Introduza um valor inteiro válido");
            }
        } while (!test);
        System.out.println("Quantidade pretendida: ");
        do {
            try {
                qtd = Integer.parseInt(in.nextLine());
                test = true;
            } catch (NumberFormatException ex) {
                test = false;
                System.out.println("Introduza um valor inteiro válido");
            }
        } while (!test);
        ret = gs.registaEncomenda(inc, inp, qtd);
        if (ret == -1) {
            System.out.println("erro a registar encomenda, por favor tente novamente.");
        } else {
            System.out.println("Encomenda registada com sucesso");
        }
    }

    public void ResgProd() {
        boolean test = true;
        String desig;
        int stock = -1;
        float prc = -1;

        System.out.println("Insira o nome de um Produto:");
        desig = in.nextLine();
        System.out.println("Insira o Stock do Produto:");
        do {
            try {
                stock = Integer.parseInt(in.nextLine());
                test = true;
            } catch (NumberFormatException ex) {
                test = false;
                System.out.println("Introduza um valor inteiro válido");
            }
        } while (!test);
        System.out.println("Insira o PVP:");
        do {
            try {
                prc = Float.parseFloat(in.nextLine());
            } catch (NumberFormatException ex) {
                test = false;
                System.out.println("Introduza um valor válido");
            }
        } while (!test);
        if (gs.registaProducto(desig, stock, prc)) {
            System.out.println("Produto registado com sucesso!!!");
        } else {
            System.out.println("As nossas desculpas!!");
            System.out.println("Houve um erro ao resgitar o Produto");
            System.out.println("Insira novamente!!!");
        }

    }

    public void ResgCli() {
        boolean test = true;
        String nome;
        String morada;
        int telf = -1;
        String mail;

        System.out.println("Insira o nome do Cliente:");
        nome = in.nextLine();
        System.out.println("Insira uma Morada:");
        morada = in.nextLine();
        System.out.println("Insira um E-Mail:");
        mail = in.nextLine();
        System.out.println("Insira um contacto telefónico");
        do {
            try {
                telf = Integer.parseInt(in.nextLine());
                if (gs.testNumTel(telf)) {
                    test = true;
                } else {
                    test = false;
                }

            } catch (NumberFormatException ex) {
                test = false;
                System.out.println("Introduza um Contacto telefónico válido (nacional)");
            }
        } while (!test);
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

            boolean excep = false;
            do {
                try {
                    escolha = Integer.parseInt(in.nextLine());
                    excep = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Introduza um valor de 1 a 6.");
                }
            } while (!excep);

            switch (escolha) {

                case 1:
                    System.out.println(gs.getProdutos());

                    break;
                case 2:
                    System.out.println(gs.getClientes());

                    break;
                case 3:

                    HistCliente();

                    break;
                case 4:

                    ProcuraProdutos();
                    break;
                case 5:

                    gs.guardaFicheiroBin();
                    break;
                case 6:

                    return;

            }

        } while (true);

    }

    public void HistCliente() {
        boolean test = true;
        System.out.println(gs.getIdNomeClientes());//primeiro lista os clientes para poder escolher
        System.out.println("Insira o ID do Cliente que pretende:");
        int i = -1;
        do {
            try {
                i = Integer.parseInt(in.nextLine());
                if (gs.getIdNomeClientes().contains("" + i)) {
                    test = true;
                } else {
                    test = false;
                    System.out.println("Introduza um valor inteiro válido");
                }
            } catch (NumberFormatException ex) {
                test = false;
                System.out.println("Introduza um valor inteiro válido");
            }
        } while (!test);
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
            System.out.println("5. Elimina produto por ID");
            System.out.println("6. Menu Anterior");

            boolean excep = false;
            do {
                try {
                    escolha = Integer.parseInt(in.nextLine());
                    excep = true;
                } catch (NumberFormatException ex) {
                    System.out.println("Introduza um valor de 1 a 5.");
                }
            } while (!excep);

            switch (escolha) {
                case 1:

                    System.out.println("Insira o preco que pretende:");
                    float i = -1;
                    excep = true;
                    do {
                        try {
                            i = Float.parseFloat(in.nextLine());
                            excep = true;
                        } catch (NumberFormatException ex) {
                            excep = false;
                            System.out.println("Introduza um valor inteiro válido");
                        }
                    } while (!excep);

                    System.out.println(gs.getProdutoPreco(i));
                    break;

                case 2:
                    System.out.println(gs.getIdDesigProduto());
                    System.out.println("Insira o ID do produto:");
                    int q=-1;
                    do {
                        try {
                            q = Integer.parseInt(in.nextLine());
                            if (gs.getIdDesigProduto().contains("" + q)) {
                                excep = true;
                            } else {
                                excep = false;
                                System.out.println("Introduza um ID válido");
                            }
                        } catch (NumberFormatException ex) {
                            excep = false;
                            System.out.println("Introduza um ID válido");
                        }
                    } while (!excep);
                    System.out.println(gs.getProdutoID(q));
                    break;

                case 3:

                    System.out.println("Insira o nome do produto");
                    String n;
                    n = in.nextLine();
                    System.out.println(gs.getProdutoNome(n));
                    break;

                case 4:

                    System.out.println(gs.getProdutosStockZero());

                    break;

                case 6:

                    return;

                case 5:
                    System.out.println(gs.getIdDesigProduto());
                    System.out.println("Insira o ID do produto que deseja eliminar: ");
                    int id=-1;
                    do {
                        try {
                            id = Integer.parseInt(in.nextLine());
                            if (gs.getIdDesigProduto().contains("" + id)) {
                                excep = true;
                            } else {
                                excep = false;
                                System.out.println("Introduza um ID válido");
                            }
                        } catch (NumberFormatException ex) {
                            excep = false;
                            System.out.println("Introduza um ID válido");
                        }
                    } while (!excep);
                    if (!gs.eliminaProdPorId(id)) {
                        System.out.println("erro ao eliminar produto, por favor tente novamente");
                    }
            }
        } while (true);

    }

}
