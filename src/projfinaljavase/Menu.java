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

    public void menu() {
        
        gs = new GesStock();
        do {

            System.out.println("Main Menu");
            System.out.println("1. Registo de Produto");
            System.out.println("2. Registo de Cliente");
            System.out.println("3. Consultas");
            System.out.println("4. Vendas de Produtos");
            System.out.println("5. Sair do Programa");

            switch (escolha) {

                case 1:

                    ResgProd();

                    break;
                case 2:

                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 0:
                    System.out.println("Até à próxima");
                    System.exit(0);

                    break;

                default:

            }

        } while (true);

    }

    public void ResgProd() {

        String desig;
        int stock;
        float prc;

        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome de um Produto");
        desig = in.next();
        System.out.println("Insira o Stock do Produto");
        stock = Integer.parseInt(in.next());
        System.out.println("Insira o PVP");
        prc = Integer.parseInt(in.next());
        gs.registaProducto(desig, stock, prc);

    }

}
